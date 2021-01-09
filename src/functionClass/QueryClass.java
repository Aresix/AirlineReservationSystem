package functionClass;

import myClass.Flight;

import java.util.Scanner;

import static generatorClass.DataGenerator.cities;
import static generatorClass.DataGenerator.flights;
import static util.FlightBuffer.flightsT;

public class QueryClass {
    public void Query(){
//        ArrayList<Flight> flightsT=new ArrayList<Flight>();
        flightsT.clear();
        java.lang.System.out.println("本系统仅提供【1】上海【2】北京【3】广州三地之间的机票。");
        java.lang.System.out.println("请输入你的出发地。输入数字即可，如输入2，即代表北京。" +
                "若输入0，则代表出发地包含所有三个城市。");
        Scanner scanner = new Scanner(java.lang.System.in);
        int departureID = Integer.parseInt(scanner.next());
        java.lang.System.out.println("请输入你的目的地。输入数字即可，如输入2，即代表北京。" +
                "若输入0，则代表出发地包含所有三个城市。");
        scanner = new Scanner(java.lang.System.in);
        int destinationID = Integer.parseInt(scanner.next());

        java.lang.System.out.println("为您检索到如下航班信息：");
        java.lang.System.out.println("若您想要购买某一航班的机票，请记住它的编号，以便后续购票。");
        int i = 0;
        if (departureID == 0 && destinationID == 0) {
            for (Flight f : flights) {
                i++;
                java.lang.System.out.println("\n>>> 第\t" + i + "\t条 <<<");
                f.printAirline();
                flightsT.add(f);
            }
        } else if (departureID == 0) {
            for (Flight f : flights) {
                if (f.getDestination().getCity().equals(cities.get(destinationID - 1))) {
                    i++;
                    java.lang.System.out.println("\n>>> 第\t" + i + "\t条 <<<");
                    f.printAirline();
                    flightsT.add(f);
                }
            }
        } else if (destinationID == 0) {
            for (Flight f : flights) {
                if (f.getDeparture().getCity().equals(cities.get(departureID - 1))) {
                    i++;
                    java.lang.System.out.println("\n>>> 第\t" + i + "\t条 <<<");
                    f.printAirline();
                    flightsT.add(f);
                }
            }
        } else {
            for (Flight f : flights) {
                if (f.getDeparture().getCity().equals(cities.get(departureID - 1))
                        && f.getDestination().getCity().equals(cities.get(destinationID - 1))) {
                    i++;
                    java.lang.System.out.println("\n>>> 第\t" + i + "\t条 <<<");
                    f.printAirline();
                    flightsT.add(f);
                }
            }
        }
    }
}
