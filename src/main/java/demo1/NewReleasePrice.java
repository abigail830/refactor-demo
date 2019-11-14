package demo1;

public class NewReleasePrice implements Price {

    public double getPrice(int daysRented) {
        return daysRented * 3;
    }
}
