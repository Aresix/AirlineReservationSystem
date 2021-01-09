package singleton;

import myClass.Flight;

import java.util.ArrayList;

public class FlightSingleton extends ArrayList<Flight> {
    // 用户当前浏览的票——购买的票一定在这个列表中
    private static FlightSingleton flightsT;

    private FlightSingleton() {
    }

    public static void setFlightsT(Flight flight) {
        if (flightsT == null) flightsT = new FlightSingleton();
        flightsT.add(flight);
    }

    public static void clearFlightsT() {
        flightsT.clear();
    }

    public static synchronized ArrayList<Flight> getFlightsT() {
        return flightsT;
    }
}
