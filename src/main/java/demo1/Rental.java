package demo1;

public class Rental {

    Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "movie=" + movie +
                ", daysRented=" + daysRented +
                '}';
    }

    public int calculateFrequentRenterPoints() {
        // add frequent renter points （累计常客积点。
        int frequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }
}
