package facade_functionClass;

import generatorClass.DataGenerator;
import myClass.Airline;
import myClass.Flight;
import singleton.FlightSingleton;
import singleton.TicketManagementSingleton;
import util.RandomNumber;

import java.util.ArrayList;
import java.util.Scanner;

import static generatorClass.DataGenerator.cities;
import static generatorClass.DataGenerator.flights;

public class QueryClass {

    private void promote() {
        for (Airline a : DataGenerator.airlines) {
            int tp = RandomNumber.randomNumber(1, 36);
            if (tp % 3 == 2) {
                System.out.println("********************************************");
                a.makePromotion();
                System.out.println("********************************************");
            }
        }
    }

    public void Query() {
        FlightSingleton.clearFlightsT();

        ArrayList<Flight> flightsT = FlightSingleton.getFlightsT();
//        FlightSingleton.clearFlightsT();
        System.out.println("本系统仅提供【1】上海【2】北京【3】广州三地之间的机票。");
        System.out.println("请输入你的出发地。输入数字即可，如输入2，即代表北京。" +
                "若输入0，则代表出发地包含所有三个城市。");
        Scanner scanner = new Scanner(System.in);
        int departureID = Integer.parseInt(scanner.next());
        System.out.println("请输入你的目的地。输入数字即可，如输入2，即代表北京。" +
                "若输入0，则代表出发地包含所有三个城市。");
        scanner = new Scanner(System.in);
        int destinationID = Integer.parseInt(scanner.next());

        System.out.println("为您检索到如下航班信息：");
        System.out.println("若您想要购买某一航班的机票，请记住它的编号，以便后续购票。");
        // 怂恿商家搞活动
        promote();
        int i = 0;
        if (departureID == 0 && destinationID == 0) {
            for (Flight f : flights) {
                i++;
                System.out.println("\n>>> 第\t" + i + "\t条 <<<");
                f.printAirline();
                System.out.println("当前剩余机票数量为：\t" + TicketManagementSingleton.getTicketCnt(f));
                FlightSingleton.setFlightsT(f);
            }
        } else if (departureID == 0) {
            for (Flight f : flights) {
                if (f.getDestination().getCity().equals(cities.get(destinationID - 1))) {
                    i++;
                    System.out.println("\n>>> 第\t" + i + "\t条 <<<");
                    f.printAirline();
                    System.out.println("当前剩余机票数量为：\t" + TicketManagementSingleton.getTicketCnt(f));
                    FlightSingleton.setFlightsT(f);
                }
            }
        } else if (destinationID == 0) {
            for (Flight f : flights) {
                if (f.getDeparture().getCity().equals(cities.get(departureID - 1))) {
                    i++;
                    System.out.println("\n>>> 第\t" + i + "\t条 <<<");
                    f.printAirline();
                    System.out.println("当前剩余机票数量为：\t" + TicketManagementSingleton.getTicketCnt(f));
                    FlightSingleton.setFlightsT(f);
                }
            }
        } else {
            for (Flight f : flights) {
                if (f.getDeparture().getCity().equals(cities.get(departureID - 1))
                        && f.getDestination().getCity().equals(cities.get(destinationID - 1))) {
                    i++;
                    System.out.println("\n>>> 第\t" + i + "\t条 <<<");
                    f.printAirline();
                    System.out.println("当前剩余机票数量为：\t" + TicketManagementSingleton.getTicketCnt(f));
                    FlightSingleton.setFlightsT(f);
                }
            }
        }
    }
}
