package demo1;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
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

    public int calPoints(int daysRented) {
        int result = 0;
        switch (priceCode) {
            // 普通片
            case REGULAR:
                result = new RegularCalculator().calPoints(daysRented);
                break;
            // 新片
            case NEW_RELEASE:
                result = new NewReleaseCalculator().calPoints(daysRented);
                break;
            // 儿童
            case CHILDRENS:
                result = new ChildrenCalculator().calPoints(daysRented);
                break;
        }
        return result;
    }

    public double calAmount(int daysRented) {
        double result = 0;
        switch (priceCode) {
            // 普通片
            case REGULAR:
                result = new RegularCalculator().calAmt(daysRented);
                break;
            // 新片
            case NEW_RELEASE:
                result = new NewReleaseCalculator().calAmt(daysRented);
                break;
            // 儿童
            case CHILDRENS:
                result = new ChildrenCalculator().calAmt(daysRented);
                break;
        }
        return result;
    }

}
