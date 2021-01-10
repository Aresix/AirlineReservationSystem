package myImpl;

import myInterface.IPromotion;
import util.RandomNumber;

public class DiscountRandomDecrease implements IPromotion {
    private int mmin;
    private int mmax;

    public DiscountRandomDecrease() {
        this.mmin = 18;
        this.mmax = 88;
    }

    public int getMmin() {
        return mmin;
    }

    public void setMmin(int mmin) {
        this.mmin = mmin;
    }

    public int getMmax() {
        return mmax;
    }

    public void setMmax(int mmax) {
        this.mmax = mmax;
    }

    @Override
    public int recalculate(int origin_price) {
        return origin_price - RandomNumber.randomNumber(mmin, mmax);
    }
}
