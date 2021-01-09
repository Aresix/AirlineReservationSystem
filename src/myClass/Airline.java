package myClass;

import java.util.ArrayList;

public interface Airline {
    String airlineID = "";
    String name = "";
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public void getAirline();
//    {
//        System.out.println("当前航空公司： " + name + "\t编号为： " + airlineID);
//    }

    public String getAirlineID();

    public void setAirlineID(String airlineID);

    public String getName();

    public void setName(String name);

    public void createFlight(Flight flight);

    public ArrayList<Flight> getFlightsList();

    // TODO:未完待续 还要增加 observer模式、strategy模式等

}
