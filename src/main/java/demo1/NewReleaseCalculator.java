package demo1;

public class NewReleaseCalculator {

    public double calAmt(int daysRented) {
        return daysRented * 3;
    }

    public int calPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
