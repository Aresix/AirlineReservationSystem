package functionClass;

import myClass.*;
import singleton.AllOrderSingleton;
import singleton.ReservationSingleton;

import java.util.ArrayList;
import java.util.Scanner;


public class RefundClass {
    public void Refund(Reservation r) {
        System.out.println("以下是您的订单：");
        ArrayList<ReservationItem> reservationItems = ReservationSingleton.getReservationItems();
        r.printSimpleReservationInfo(reservationItems);
        System.out.println("============================================================");
        System.out.println("输入要退的订单编号：(若输入数字不在范围内，则视为放弃退票，回到主界面)");
        Scanner scanner = new Scanner(System.in);
        int fundTicketId = Integer.parseInt(scanner.next());
        if (fundTicketId <= reservationItems.size() && fundTicketId >= 1) {
            AirlineTicket airlineTicket = reservationItems.get(fundTicketId - 1).getTicket();
            System.out.println("您要退票的订单信息：");
            airlineTicket.printTicket(reservationItems.get(fundTicketId - 1).getPassenger());
            System.out.println("是否确认要退票？若是，选择1；若输入其他字符，则视为放弃。");
            scanner = new Scanner(System.in);
            int confirmRefund = Integer.parseInt(scanner.next());
            if (confirmRefund == 1) {
                airlineTicket.setTicketState(AirlineTicket.TicketState.CANCELED);
                AllOrderSingleton.addOrderRecord(new OrderRecord(reservationItems.get(fundTicketId - 1)));
                airlineTicket.setTicketState(AirlineTicket.TicketState.UNSOLD);
                Refund refund = new Refund();
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refund.refund(airlineTicket);
                reservationItems.remove(fundTicketId - 1);
            }
        }
    }
}
