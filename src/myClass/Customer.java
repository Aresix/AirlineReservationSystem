package myClass;

import java.util.ArrayList;

public class Customer {
    // Personal Information
    private String name;
    private String IDcard;
    private String telephone;

    // Account Balance
    private float balance;

    // 该用户的所有订单记录
    // TODO:单例模式？？
    private ArrayList<Reservation> reservations;

    public Customer(String name, String IDcard, String telephone) {
        this.name = name;
        this.IDcard = IDcard;
        this.telephone = telephone;
        this.balance = 100000;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
