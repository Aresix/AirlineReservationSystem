package myClass;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private static int rid = 0;
    private String reservationID;
    private ArrayList<ReservationItem> reservationItems = new ArrayList<ReservationItem>();
    private Date time;
    private int totalPrice;
    private boolean isCompleted;

    public Reservation(Date time) {
        totalPrice = 0;
        String reservationIDRoot = "R111507292012";
        this.reservationID = reservationIDRoot + rid;
        rid++;
        this.time = time;
    }

    public int getTotalPrice() {
        for (ReservationItem r : reservationItems) {
            totalPrice += r.getSubtotal();
        }
        return totalPrice;
    }

    public void makeReservationItem(AirlineTicket airlineTicket, Passenger passenger) {
        reservationItems.add(new ReservationItem(airlineTicket, passenger));
    }

    public void makePayment() {
        Payment payment = new Payment();
        payment.makePayment(totalPrice);
    }

    public ArrayList<ReservationItem> getReservationItems() {
        return reservationItems;
    }

    public ReservationItem getReservationItemsAt(int x) {
        return reservationItems.get(x);
    }

    public void printSimpleReservationInfo() {
        int i = 0;
        System.out.println("序号\t航班号\t\t\t飞机\t\t\t原价\t\t\t实付\t\t\t乘坐人");
        for (ReservationItem r : reservationItems) {
            ++i;
            System.out.println(i + ".\t\t" + r.getTicket().getFlight().getFlightID() + "\t\t\t"
                    + r.getTicket().getPlane().getPlaneID() + "\t\t\t" + r.getTicket().getPrice()
                    + "\t\t\t" + r.getTicket().getNewPrice() + "\t\t\t" + r.getPassenger().getName());
        }
    }

    public void printSimpleReservationInfo(ArrayList<ReservationItem> items) {
        if (items != null) {
            int i = 0;
            System.out.println("序号\t航班号\t\t\t飞机\t\t\t原价\t\t\t实付\t\t\t乘坐人");
            for (ReservationItem r : items) {
                if (r.getTicket().getTicketState() == AirlineTicket.TicketState.UNUSED) {
                    ++i;
                    System.out.println(i + ".\t\t" + r.getTicket().getFlight().getFlightID() + "\t\t\t"
                            + r.getTicket().getPlane().getPlaneID() + "\t\t\t" + r.getTicket().getPrice()
                            + "\t\t\t" + r.getTicket().getNewPrice() + "\t\t\t" + r.getPassenger().getName());
                }
            }
            if (i == 0) System.out.print("（空）");
        }
    }

    public void printReservationInfo() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("您成功在【" + time.toString() + "】创建预定订单，订单编号为：" + reservationID);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        printSimpleReservationInfo();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("总价为：\t" + getTotalPrice() + "\t元");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println();
        System.out.println("*以下为详细订票信息。");
        int i = 0;
        for (ReservationItem r : reservationItems) {
            ++i;
            System.out.println("第\t" + i + "\t条");

            r.printTicket(r.getPassenger());
            System.out.println();
        }
    }

    public void printReservationInfo(ArrayList<ReservationItem> items) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("您成功在【" + time.toString() + "】创建预定订单，订单编号为：" + reservationID);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        printSimpleReservationInfo(items);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("总价为：\t" + getTotalPrice() + "\t元");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println();
        System.out.println("*以下为详细订票信息。");
        int i = 0;
        for (ReservationItem r : items) {
            ++i;
            System.out.println("第\t" + i + "\t条");

            r.printTicket(r.getPassenger());
            System.out.println();
        }
    }
}
