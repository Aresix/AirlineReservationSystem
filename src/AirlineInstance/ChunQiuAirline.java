package AirlineInstance;

import generatorClass.DataGenerator;
import myClass.Airline;
import myClass.Customer;
import myClass.Flight;
import myImpl.DiscountRandomDecrease;
import myImpl.DiscountWhenSpendingEnough;
import myImpl.DiscountWithCoupon;
import myImpl.DiscountWithReducedRate;
import myInterface.IPromotion;
import myInterface.ISubject;
import util.RandomNumber;

import java.util.ArrayList;

public class ChunQiuAirline extends Airline {

    private ArrayList<Customer> Followers = new ArrayList<Customer>();

    private String airlineID;
    private String name;
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    // 打折促销信息
    private IPromotion promotion;
    private int god = 0;

    public ChunQiuAirline() {
        this.airlineID = "A0001";
        this.name = "春秋国旅";
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

    // ========================打折策略============================
    @Override
    public int showPromotion(int totalPrice) {
        return execPro(totalPrice, god);
    }

    @Override
    public void makePromotion() {
        // 抽取促销方式
        god = RandomNumber.randomNumber(0, 255) % 4;
        String proInfo = DataGenerator.promotionSlogan.get(god);
        // UPDATE
        // TODO：这对xx全一到外面去
//        System.out.println("********************************************");
        notifyCustomer();
        System.out.println("********************************************");
        System.out.println("【" + name + "】：\t" + proInfo);
//        System.out.println("********************************************");
    }

    private int execPro(int totalPrice, int god) {
        int res = totalPrice;
        switch (god) {
            case 0:
                DiscountWhenSpendingEnough spendingEnough =
                        new DiscountWhenSpendingEnough(2000, 50);
                res = spendingEnough.recalculate(totalPrice);
                break;
            case 1:
                DiscountWithCoupon coupon = new DiscountWithCoupon(2500, 200);
                res = coupon.recalculate(totalPrice);
                break;
            case 2:
                res = (int) new DiscountWithReducedRate().recalculate(totalPrice);
                break;
            case 3:
                DiscountRandomDecrease randomDecrease = new DiscountRandomDecrease();
                res = randomDecrease.recalculate(totalPrice);
                break;
        }
        return res;
    }

    // ================打折策略=============END====================

    // ========================发布/订阅============================

    @Override
    public void AttachCustomer(Customer customer) {
        Followers.add(customer);
    }

    @Override
    public void DetachCustomer(Customer customer) {
        Followers.remove(customer);
    }

    @Override
    public void notifyCustomer() {
        for (Customer c : Followers) {
            c.updateMiracle();
            System.out.println("狩猎禁区狩猎禁区狩猎禁区狩猎禁区狩猎禁区狩猎禁区");
        }
    }

    // ================发布/订阅=============END====================
}
