package AirlineInstance;

import myClass.Airline;
import myClass.Flight;

import java.util.ArrayList;

public class JiXiangAirline extends Airline {

    private String airlineID;
    private String name;
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public JiXiangAirline() {
        this.airlineID = "A0003";
        this.name = "吉祥航空";
    }

    @Override
    public void getAirline() {
        System.out.println("当前航空公司： " + name + "\t编号为： " + airlineID);
    }

    @Override
    public String getAirlineID() {
        return airlineID;
    }

    @Override
    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void createFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public ArrayList<Flight> getFlightsList() {
        return flights;
    }
}
