package myClass;

import java.util.ArrayList;

public class Customer {
    // Personal Information
    private String name;
    private String IDcard;
    private String telephone;

    // liked airline
    private ArrayList<Airline> airlinesLike = new ArrayList<Airline>();

    // Account Balance
    private float balance;

    // 该用户的所有订单记录
    // TODO:单例模式？？
//    private ArrayList<Reservation> reservations;

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

    public ArrayList<Airline> getAirlinesLike() {
        return airlinesLike;
    }

    public void setAirlinesLike(ArrayList<Airline> airlinesLike) {
        this.airlinesLike = airlinesLike;
    }

    public void addAirlinesLike(Airline air) {
        this.airlinesLike.add(air);
    }

    public void removeAirlinesLike(Airline air) {
        this.airlinesLike.remove(air);
    }

    public void updateMiracle() { // 致敬《恋与》
        System.out.println("亲爱的" + name + ",您好！你关注的公司有优惠啦！");
    }
}
