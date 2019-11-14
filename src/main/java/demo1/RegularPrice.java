package demo1;

public class RegularPrice implements Price {

    public double getPrice(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }

    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
