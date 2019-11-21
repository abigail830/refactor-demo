package demo1;

public class RegularCalculator {

    public double calAmt(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }

    public int calPoints(int daysRented) {
        return 1;
    }
}
