package facade_functionClass;

import singleton.AllOrderSingleton;

public class ShowOrderClass {
    public void ShowOrder(/*Reservation r*/) {
//        if (r.getReservationItems().isEmpty()) System.out.println("呀，这里空空如也，快去下单试试吧~");
//        else {
        System.out.println("以下是您的全部订单：");
//        r.printReservationInfo(ReservationSingleton.getReservationItems());
        AllOrderSingleton.printRecord();
        System.out.println("============================================================");
//        }
    }
}
