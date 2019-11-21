package demo1;

public class ChildrenCalculator extends Calculator {

    @Override
    public double calAmt(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }

}
