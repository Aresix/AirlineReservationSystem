package facade_functionClass;

import generatorClass.DataGenerator;
import generatorClass.FlightGenerator;
import myClass.*;
import singleton.AllOrderSingleton;
import singleton.FlightSingleton;
import singleton.ReservationSingleton;
import singleton.TicketManagementSingleton;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickBookClass {
    public void book(Customer customer, Reservation r) {
        FlightSingleton.clearFlightsT();
        ArrayList<Flight> flightsT = FlightSingleton.getFlightsT();

        System.out.println("欢迎使用一键购票功能！");
        System.out.println("==============================");
        System.out.println("考虑到功能特殊性，您仅能为自己购票，且仅能选择如从下的（出发地，目的地）中进行选择：");

        int i = 0;
        for (Flight flight : DataGenerator.flights) {
            System.out.print(++i);
            System.out.println(". 【出发地】：\t" + flight.getDeparture().getName() +
                    "\t\t【目的地】：\t" + flight.getDestination().getName());
        }

        Scanner scanner = new Scanner(System.in);
        int fID = Integer.parseInt(scanner.next());
        if (fID >= 0 && fID < DataGenerator.flights.size()) {
            Flight flight = DataGenerator.flights.get(fID);
            AirlineTicket airlineTicket = new AirlineTicket(flight, flight.getPlane());
            Passenger passenger = new Passenger(customer.getName(), customer.getIDcard(), customer.getTelephone());
            r.makeReservationItem(airlineTicket, passenger);

            r.printReservationInfo();
            System.out.println("订单创建成功！\t请确认订单，然后完成支付。");
            System.out.println("若确认并支付，请输入1；若输入其他字符，则丢弃该订单");
            scanner = new Scanner(System.in);
            if (scanner.next().equals("1")) {
                System.out.println("您已确认订单，准备扣款");
                for (ReservationItem ri : r.getReservationItems()) {
                    boolean book = TicketManagementSingleton.bookTicket(ri.getTicket().getFlight());
                    if (book) {
                        ri.getTicket().setTicketState(AirlineTicket.TicketState.UNUSED);
                        ReservationSingleton.addReservationItems(ri);
                        AllOrderSingleton.addOrderRecord(new OrderRecord(ri));
                    } else {
                        System.out.println("**************************************");
                        System.out.println("【购票失败】");
                        System.out.println("编号为:\t【" + ri.getTicket().getTicketID() + "】的机票已售罄。");
                        System.out.println("**************************************");
                    }
                }
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r.makePayment();
            } else {
                System.out.println("放弃支付，订单已取消。");
                // TODO: 也要写进订单记录里面
                // 未支付
                for (ReservationItem ri : r.getReservationItems()) {
                    ri.getTicket().setTicketState(AirlineTicket.TicketState.UNPAID);
                    AllOrderSingleton.addOrderRecord(new OrderRecord(ri));
                }
            }
            FlightSingleton.clearFlightsT();
        } else {
            System.out.print("输入无效，bye~");
        }
    }
}
