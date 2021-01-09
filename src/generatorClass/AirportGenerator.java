package generatorClass;

import myClass.Airline;

import java.util.ArrayList;

public class AirportGenerator {
    public static ArrayList<Airline> initAirline() {
        ArrayList<Airline> airlines = new ArrayList<Airline>();
        airlines.add(new Airline("A0001", "春秋国旅"));
        airlines.add(new Airline("A0002", "东方航空"));
        airlines.add(new Airline("A0003", "吉祥航空"));
        airlines.add(new Airline("A0004", "南方航空"));
//        for (Airline airline : airlines) airline.getAirline();
        return airlines;
    }
}
