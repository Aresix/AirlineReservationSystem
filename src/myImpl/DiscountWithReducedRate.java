package myImpl;

import myInterface.IPromotion;

public class DiscountWithReducedRate implements IPromotion {

    float rate;

    public DiscountWithReducedRate() {
        // 默认全场85折
        this.rate = (float) 0.85;
    }

    public DiscountWithReducedRate(float rate) {
        this.rate = rate;
    }

    @Override
    public int recalculate(int origin_price) {
        float price = (float) (rate * 10.0);
//        System.out.println("【打折活动】一共购买" + cnt + "件商品，总价享受" +  String.format("%.1f", price) + "折优惠");
        float dec = origin_price * (1 - rate);
//        System.out.println("\t原价为："+String.format("%.2f", origin_price)+"。此轮共省" + String.format("%.2f", dec) + "元");
        return (int) (origin_price - dec);
    }
}
