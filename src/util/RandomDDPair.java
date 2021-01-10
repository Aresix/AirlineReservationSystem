package util;

public class RandomDDPair {
    private int departure;
    private int destination;

    private int auxCal(int x) {
        return (x == 2) ? RandomNumber.randomNumber(1, 2) : x;
    }

    public RandomDDPair() {
        int temp = RandomNumber.randomNumber(2, 4);
        departure = auxCal(temp);
        if (temp == 2) {
            destination = RandomNumber.randomNumber(3, 4);
        } else if (temp == 3) {
            int tp2 = RandomNumber.randomNumber(1, 2);
            if (tp2 == 1) destination = auxCal(2);
            else destination = 4;
        } else {
            int tp2 = RandomNumber.randomNumber(1, 2);
            if (tp2 == 1) destination = auxCal(2);
            else destination = 3;
        }

    }

    public int getDeparture() {
        return departure;
    }

    public int getDestination() {
        return destination;
    }
}
