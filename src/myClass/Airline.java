package myClass;

import java.util.ArrayList;

public class Airline {
    private String airlineID;
    private String name;
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public Airline(String airlineID, String name) {
        this.airlineID = airlineID;
        this.name = name;
    }

    public void getAirline() {
        System.out.println("当前航空公司： " + name + "\t编号为： " + airlineID);
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createFlight(Flight flight) {
        flight.setAirline(this);
        flights.add(flight);
    }

    public ArrayList<Flight> getFlightsList() {
        return flights;
    }

}
