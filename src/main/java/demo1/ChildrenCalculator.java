package demo1;

public class ChildrenCalculator {

    public double calAmt(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }

    public int calPoints(int daysRented) {
        return 1;
    }
}
