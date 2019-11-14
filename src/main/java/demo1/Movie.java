package demo1;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;
    private int priceCode;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        setPrice(priceCode);
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(int priceCode) {
        if (priceCode == REGULAR) price = new RegularPrice();

        if (priceCode == NEW_RELEASE) price = new NewReleasePrice();

        if (priceCode == CHILDRENS) price = new ChildrenPrice();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", priceCode=" + priceCode +
                '}';
    }

    public double calAmount(int daysRented) {
        return price.getPrice(daysRented);

    }

    public int calFrequentRenterPoints(int daysRented) {
        if ((priceCode == NEW_RELEASE) && daysRented > 1)
            return 2;
        else {
            return 1;
        }
    }

}
