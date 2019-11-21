package demo1;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;
    private int priceCode;

    private Calculator calculator;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        setCalculator(priceCode);
    }

    private void setCalculator(int priceCode) {
        switch (priceCode) {
            // 普通片
            case REGULAR:
                calculator = new RegularCalculator();
                break;
            // 新片
            case NEW_RELEASE:
                calculator = new NewReleaseCalculator();
                break;
            // 儿童
            case CHILDRENS:
                calculator = new ChildrenCalculator();
                break;
        }
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
        return calculator.calPoints(daysRented);
    }

    public double calAmount(int daysRented) {
        return calculator.calAmt(daysRented);
    }

}
