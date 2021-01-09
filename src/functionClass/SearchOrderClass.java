package functionClass;

import myClass.Reservation;
import singleton.ReservationSingleton;

public class SearchOrderClass {
    public void SearchOrder(Reservation r) {
        java.lang.System.out.println("以下是您的订单：");
        r.printReservationInfo(ReservationSingleton.getReservationItems());
        java.lang.System.out.println("============================================================");
    }
}
