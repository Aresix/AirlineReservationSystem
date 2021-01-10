package functionClass;

import myClass.*;
import singleton.AllOrderSingleton;
import singleton.FlightSingleton;
import singleton.ReservationSingleton;
import singleton.TicketManagementSingleton;

import java.util.Scanner;

import static generatorClass.DataGenerator.planes;
import static util.RandomNumber.randomNumber;

public class BookClass {
    public void BookTicket(Reservation r) {
        while (true) {
            System.out.println("请输入你想预定的航班编号：(输入0进行结算，输入-1退出)");
            Scanner scanner = new Scanner(System.in);
            int fID = Integer.parseInt(scanner.next());
            if (fID == 0) {
                if (!r.getReservationItems().isEmpty()) {
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
                        // TODO: 也要写进订单记录里面
                        // 未支付
                        for (ReservationItem ri : r.getReservationItems()) {
                            ri.getTicket().setTicketState(AirlineTicket.TicketState.UNPAID);
                            AllOrderSingleton.addOrderRecord(new OrderRecord(ri));
                        }
                    }
                    FlightSingleton.clearFlightsT();
                    break;
                }
            } else if (fID > 0) {
                Flight curFlight = FlightSingleton.getFlightsT().get(fID - 1);
                AirlineTicket airlineTicket = new AirlineTicket(curFlight,
                        curFlight.getPlane());
//                AirlineTicket airlineTicket = new AirlineTicket(
//                        FlightSingleton.getFlightsT().get(fID - 1),
//                        planes.get((fID * 1115 + 1220) % 5),
//                        randomNumber(11, 30) * 100);
                System.out.println("请完善乘坐人信息：");
                System.out.println("请输入乘坐人的名字：");
                scanner = new Scanner(System.in);
                String name = scanner.next();
                System.out.println("请输入乘坐人的身份证号：");
                scanner = new Scanner(System.in);
                String IDCard = scanner.next();
                System.out.println("请输入乘坐人的联系方式：");
                scanner = new Scanner(System.in);
                String telephone = scanner.next();
                Passenger passenger = new Passenger(name, IDCard, telephone);
                r.makeReservationItem(airlineTicket, passenger);
            } else {
                break;
            }
        }
    }
}
