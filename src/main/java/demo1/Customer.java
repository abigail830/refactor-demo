package demo1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentalList;

    public Customer(String name) {
        this.name = name;
        rentalList = new ArrayList<>();
    }

    public void addRental(Rental rental){
        this.rentalList.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", rentalList=" + rentalList +
                '}';
    }

    public String printStatement() {

        double totalAmount = 0; // 总消费金。
        int frequentRenterPoints = 0; // 常客积点

        String result = "Rental Record for " + name + "\n";

        for (Rental rental : rentalList) {

            // add frequent renter points （累计常客积点。
            frequentRenterPoints += rental.calculateFrequentRenterPoints();

            // 取得影片出租价格
            double thisAmount = rental.calculateAmount();

            // show figures for this rental（显示此笔租借记录）
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }

        // add footer lines（结尾打印）
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";

        return result;
    }
}
