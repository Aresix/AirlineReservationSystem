package singleton;

import myClass.Reservation;
import myClass.ReservationItem;

import java.util.ArrayList;

public class ReservationSingleton extends ArrayList<ReservationItem> {
    // 每个用户当前预定的订单
    private static ReservationSingleton reservationItems;

    private ReservationSingleton() {
    }

    public static void addReservationItems(ReservationItem reservationItem) {
        if (reservationItems == null) reservationItems = new ReservationSingleton();
        reservationItems.add(reservationItem);
    }

    public static synchronized ArrayList<ReservationItem> getReservationItems() {
        return reservationItems;
    }
}
