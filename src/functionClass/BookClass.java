package functionClass;

import myClass.*;
import singleton.FlightSingleton;
import singleton.ReservationSingleton;

import java.util.Scanner;

import static generatorClass.DataGenerator.planes;
import static util.RandomNumber.randomNumber;

public class BookClass {
    public void BookTicket(Reservation r){
        while (true) {
            java.lang.System.out.println("请输入你想预定的航班编号：(输入0可以退出)");
            Scanner scanner = new Scanner(java.lang.System.in);
            int fID = Integer.parseInt(scanner.next());
            if (fID == 0) {
                r.printReservationInfo();
                java.lang.System.out.println("请确认订单，然后完成支付。");
                java.lang.System.out.println("若确认并支付，请输入1；若输入其他字符，则丢弃该订单");
                scanner = new Scanner(java.lang.System.in);
                if (scanner.next().equals("1")) {
                    java.lang.System.out.println("您已确认订单，准备扣款");
                    for (ReservationItem ri : r.getReservationItems()) ReservationSingleton.addReservationItems(ri);
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    r.makePayment();
                }
                FlightSingleton.clearFlightsT();
                break;
            } else {
                AirlineTicket airlineTicket = new AirlineTicket(
                        FlightSingleton.getFlightsT().get(fID - 1),
                        planes.get((fID * 1115 + 1220) % 5),
                        randomNumber(11, 30) * 100);
                java.lang.System.out.println("请完善乘坐人信息：");
                java.lang.System.out.println("请输入乘坐人的名字：");
                scanner = new Scanner(java.lang.System.in);
                String name = scanner.next();
                java.lang.System.out.println("请输入乘坐人的身份证号：");
                scanner = new Scanner(java.lang.System.in);
                String IDCard = scanner.next();
                java.lang.System.out.println("请输入乘坐人的联系方式：");
                scanner = new Scanner(java.lang.System.in);
                String telephone = scanner.next();
                Passenger passenger = new Passenger(name, IDCard, telephone);
                r.makeReservationItem(airlineTicket, passenger);
            }
        }
    }
}
