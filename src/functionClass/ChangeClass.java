package functionClass;

import myClass.*;

import java.util.ArrayList;
import java.util.Scanner;

import static generatorClass.DataGenerator.flights;
import static util.FlightBuffer.flightsT;
import static util.ReservationBuffer.reservationItems;

public class ChangeClass {
    public ArrayList<Flight> Change(Reservation r){
        java.lang.System.out.println("以下是您的订单：");
        r.printSimpleReservationInfo(reservationItems);
        java.lang.System.out.println("============================================================");
        java.lang.System.out.println("输入要改签的订单编号：(若输入数字不在范围内，则视为放弃退票，回到主界面)");
        java.lang.System.out.println("改签仅支持改航班，不支持改出发地（机场）和目的地（机场）！！！");
        Scanner scanner = new Scanner(java.lang.System.in);
        int changeTicketId = Integer.parseInt(scanner.next());
        if (changeTicketId <= reservationItems.size() && changeTicketId >= 1) {
            ReservationItem ri=reservationItems.get(changeTicketId-1);
            AirlineTicket airlineTicket = ri.getTicket();
            flightsT.clear();
            Airport departure = airlineTicket.getFlight().getDeparture();
            Airport destination = airlineTicket.getFlight().getDestination();
            Flight curF=airlineTicket.getFlight();
            int i=0;
            for (Flight f : flights) {
                if (f!=curF && f.getDeparture() == departure && f.getDestination() == destination) {
                    ++i;
                    java.lang.System.out.println("第\t" + i + "\t条");
                    f.printAirline();
                    flightsT.add(f);
                }
            }
            if(flightsT.isEmpty()) {
                java.lang.System.out.println("没有合适的可供改签的航班，请移步退票操作。");
            }else {
                java.lang.System.out.println("请输入你想改签的航班编号：(输入0可以退出)");
                scanner = new Scanner(java.lang.System.in);
                int nfID = Integer.parseInt(scanner.next());
                Flight newFlight = flightsT.get(nfID-1);
                airlineTicket.setFlight(newFlight);
                r.makeReservationItem(airlineTicket,ri.getPassenger());
                java.lang.System.out.println("改签成功，以下为改签后的订单：");
                r.printReservationInfo();
            }
        }
        return flightsT;
    }
}
