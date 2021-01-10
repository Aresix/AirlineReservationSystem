package myImpl;

import myInterface.IPromotion;
import util.RandomNumber;

public class DiscountWithCoupon implements IPromotion {
    float threshold;
    float discount_amount;

    public DiscountWithCoupon() {
        this.threshold = 0;
        this.discount_amount = RandomNumber.randomNumber(18, 88);
    }

    public DiscountWithCoupon(float threshold, float discount_amount) {
        this.threshold = threshold;
        this.discount_amount = discount_amount;
    }

    public float getThreshold() {
        return threshold;
    }

    public float getDiscount_amount() {
        return discount_amount;
    }

    @Override
    public int recalculate(int origin_price) {
//        System.out.println("【优惠券活动】现有1张优惠券：满" + threshold + "元减" + discount_amount + "元待使用");
//        System.out.println("\t原价为："+origin_price+"。此轮共省" + discount_amount + "元");

        return (int) (origin_price - discount_amount);
    }
}
