import functionClass.*;
import myClass.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TicketSystem {

    // 装填初始数据


    // 可能的订票航班集合
//    public static ArrayList<Flight> flightsT = new ArrayList<Flight>();
    // 已经预定的订单集合
//    public static ArrayList<ReservationItem> reservationItems = new ArrayList<ReservationItem>();


    private static void initTicket(ArrayList<Flight> flight, ArrayList<Plane> planes) {
        AirlineTicket ticket = new AirlineTicket(flight.get(0), planes.get(2), 800);
//        ticket.printTicket();
        ticket = new AirlineTicket(flight.get(2), planes.get(1), 1200);
//        ticket.printTicket();
    }

    private static void printService() {
        java.lang.System.out.println("1.查询航班/机票信息");
        java.lang.System.out.println("2.预定机票");
        java.lang.System.out.println("3.改签");
        java.lang.System.out.println("4.退订机票");
        java.lang.System.out.println("5.个人中心");
        java.lang.System.out.println("6.一键购票");
        java.lang.System.out.println("7.离开");
        java.lang.System.out.println("--------------------------------------------------");
        java.lang.System.out.println("输入序号（仅数字，如：2），进入相应服务");
    }

    public static void main(String[] args) {



        // 初始化用户信息： 相当于注册的功能
        Customer customer = new RegisterClass().Register();

        // 业务
        java.lang.System.out.println(customer.getName() + ",欢迎你。在本系统内，你可以：");

        printService();
        Scanner scanner = new Scanner(java.lang.System.in);
        while (true) {
            boolean fin=false;

            Reservation r = new Reservation(new Date());

            int sceneID = Integer.parseInt(scanner.next());
            switch (sceneID) {
                case 1: // 查机票
                    new QueryClass().Query();
                    break;
                case 2: // 预定机票
                    new BookClass().BookTicket(r);
                    break;
                case 3: // 改签
                    new ChangeClass().Change(r);
                    break;
                case 4: // 退票
                    new RefundClass().Refund(r);
                    break;
                case 5: // 查询订单
                    new SearchOrderClass().SearchOrder(r);
                    break;
                case 6:
                    // TODO:一键购票
                    break;
                case 7: // 退出
                    java.lang.System.out.println("祝您旅途愉快！再见！");
                    fin=true;
                    break;
                default:
                    break;
            }
            if(fin) break;
            java.lang.System.out.println("\n还可继续选择如下服务：");
            printService();
        }


        //=================尝鲜体验区===================
//        AirlineTicket airlineTicket = new AirlineTicket(flights.get(2), planes.get(2), 1600);
////        AirlineTicket airlineTicket2 = new AirlineTicket(flights.get(2), planes.get(2), 1600);
////        AirlineTicket airlineTicket3 = new AirlineTicket(flights.get(1), planes.get(3), 2000);
////        Passenger passenger = new Passenger("许墨", "恋与打工人", "20181115251");
////        Passenger passenger2 = new Passenger("嵬漪", "卑微ddl人", "20180210251");
////        Passenger passenger3 = new Passenger("周棋洛", "怎么不来帮我写代码呢", "20180409251");
////        Reservation r = new Reservation(new Date());
////        r.makeReservationItem(airlineTicket, passenger);
////        r.makeReservationItem(airlineTicket2, passenger2);
////        r.makeReservationItem(airlineTicket3, passenger3);
////        r.printReservationInfo();
////        TicketSystem.out.println("订单已提交，请尽快支付以免【订单取消】带来不必要的损失。");
////        TicketSystem.out.println();
////        try {
////            Thread.sleep(1200);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        r.makePayment();
////
////        r.printSimpleReservationInfo();
////
////        Refund refund = new Refund();
////        refund.refund(airlineTicket3);

    }
}
