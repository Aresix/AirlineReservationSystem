package myClass;

import java.util.ArrayList;

public class Airline {
    String airlineID = "";
    String name = "";
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public void getAirline() {
        System.out.println("当前航空公司： " + name + "\t编号为： " + airlineID);
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID=airlineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void createFlight(Flight flight) {
        flights.add(flight);
    }

    public ArrayList<Flight> getFlightsList() {
        return flights;
    }

    // TODO:未完待续 还要增加 observer模式、strategy模式等

}
