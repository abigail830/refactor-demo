package demo1;

public class NewReleasePrice implements Price {

    public double getPrice(int daysRented) {
        return daysRented * 3;
    }

    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
