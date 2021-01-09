package functionClass;

import myClass.Reservation;

import static util.ReservationBuffer.reservationItems;

public class SearchOrderClass {
    public void SearchOrder(Reservation r){
        java.lang.System.out.println("以下是您的订单：");
        r.printReservationInfo(reservationItems);
        java.lang.System.out.println("============================================================");
    }
}
