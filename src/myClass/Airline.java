package myClass;

import myInterface.IPromotion;
import myInterface.ISubject;

import java.util.ArrayList;

public class Airline implements ISubject {

    private IPromotion promotion;

    private String airlineID = "";
    private String name = "";
    private ArrayList<Flight> flights = new ArrayList<Flight>();

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
        flights.add(flight);
    }

    public ArrayList<Flight> getFlightsList() {
        return flights;
    }

    // TODO:未完待续 还要增加 observer模式、strategy模式等

    // 打折 策略
    public int showPromotion(int totalPrice) {
        // TODO: 打折策略实现
        return promotion.recalculate(totalPrice);
    }

    public void makePromotion() {

    }

    @Override
    public void AttachCustomer(Customer customer) {

    }

    @Override
    public void DetachCustomer(Customer customer) {

    }

    @Override
    public void notifyCustomer() {

    }
}
