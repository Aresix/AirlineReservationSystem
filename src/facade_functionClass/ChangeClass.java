package facade_functionClass;

import myClass.*;
import singleton.AllOrderSingleton;
import singleton.FlightSingleton;
import singleton.ReservationSingleton;
import singleton.TicketManagementSingleton;

import java.util.ArrayList;
import java.util.Scanner;

import static generatorClass.DataGenerator.flights;

public class ChangeClass {
    private int curPrice = 0;

    public void Change(Reservation r) {
        System.out.println("以下是您的订单：");
        ArrayList<ReservationItem> reservationItems = ReservationSingleton.getReservationItems();
        ArrayList<Flight> flightsT = FlightSingleton.getFlightsT();
        r.printSimpleReservationInfo(reservationItems);
        System.out.println("============================================================");
        System.out.println("输入要改签的订单编号：(若输入数字不在范围内，则视为放弃退票，回到主界面)");
        System.out.println("改签仅支持改航班，不支持改出发地（机场）和目的地（机场）！！！");
        Scanner scanner = new Scanner(System.in);
        int changeTicketId = Integer.parseInt(scanner.next());
        if (changeTicketId <= reservationItems.size() && changeTicketId >= 1) {
            ReservationItem ri = reservationItems.get(changeTicketId - 1);
            if (ri.getTicket().getTicketState() == AirlineTicket.TicketState.UNUSED) {
                curPrice = ri.getTicket().getNewPrice();
//                System.out.println("\t"+curPrice);
                AirlineTicket airlineTicket = ri.getTicket();
                FlightSingleton.clearFlightsT();
                Airport departure = airlineTicket.getFlight().getDeparture();
                Airport destination = airlineTicket.getFlight().getDestination();
                Flight curF = airlineTicket.getFlight();
                int i = 0;
                for (Flight f : flights) {
                    if (f != curF && f.getDeparture() == departure && f.getDestination() == destination) {
                        ++i;
                        System.out.println("第\t" + i + "\t条");
                        f.printAirline();
                        FlightSingleton.setFlightsT(f);
                    }
                }
                if (flightsT.isEmpty()) {
                    System.out.println("没有合适的可供改签的航班，请移步退票操作。");
                } else {
                    System.out.println("请输入你想改签的航班编号：(输入0可以退出)");
                    scanner = new Scanner(System.in);
                    int nfID = Integer.parseInt(scanner.next());
                    Flight newFlight = flightsT.get(nfID - 1);
                    airlineTicket.setFlight(newFlight);
                    // 记录改签状态
                    ri.getTicket().setTicketState(AirlineTicket.TicketState.CANCELED);
                    AllOrderSingleton.addOrderRecord(new OrderRecord(ri));
                    // 让他继续卖
                    TicketManagementSingleton.refundTicket(ri.getTicket().getFlight());
                    ri.getTicket().setTicketState(AirlineTicket.TicketState.UNSOLD);
                    reservationItems.remove(ri);
                    // 改签
                    TicketManagementSingleton.bookTicket(newFlight);
                    ReservationItem reservationItem =
                            new ReservationItem(new AirlineTicket(newFlight, newFlight.getPlane()),
                                    ri.getPassenger());
//                    System.out.println("怎么能是负的呢？？\t"+reservationItem.getTicket().getPrice());
                    reservationItem.getTicket().setTicketState(AirlineTicket.TicketState.UNUSED);

                    r.makeReservationItem(reservationItem.getTicket(), reservationItem.getPassenger());
//                    System.out.println("烦死了\t"+airlineTicket.getPrice());
                    curPrice = reservationItem.getTicket().getPrice() - curPrice;
//                    System.out.println("什么玩意\t"+curPrice);
                    System.out.println("改签成功，以下为改签后的订单：");

                    r.printReservationInfo();
                    // 记录改签后订单
                    AllOrderSingleton.addOrderRecord(new OrderRecord(r.getReservationItems().get(0)));
                    ReservationSingleton.addReservationItems(r.getReservationItems().get(0));

                    System.out.print("改签后，价格发生变动。");
                    if (curPrice > 0) System.out.println("您还需支付\t" + curPrice + " 元。\n\n支付完成！");
                    else System.out.println("您将收到退款\t" + (-1 * curPrice) + " 元。\n\n退款成功！");
                }
            } else {
                System.out.println("该机票无法改签，具体原因为：\t【" +
                        ri.getTicket().getState(ri.getTicket().getTicketState()) + "】");
            }
        }
    }
}
