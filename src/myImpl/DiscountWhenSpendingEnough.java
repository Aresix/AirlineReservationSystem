package myImpl;

import myInterface.IPromotion;

public class DiscountWhenSpendingEnough implements IPromotion {
    private int initial_price;
    private int kickback;

    public DiscountWhenSpendingEnough() {
        this.initial_price = 2000;
        this.kickback = 300;
    }

    public DiscountWhenSpendingEnough(int initial_price, int kickback) {
        this.initial_price = initial_price;
        this.kickback = kickback;
    }


    @Override
    public int recalculate(int origin_price) {
        int turn = origin_price / initial_price;
        return origin_price - turn * kickback;
    }
}
