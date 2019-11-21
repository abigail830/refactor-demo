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

        String result = "Rental Record for " + name + "\n";

        // 打印明细
        for (Rental rental : rentalList) {
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.calculateAmount()) + "\n";
        }

        // 打印总金额
        result += "Amount owed is " + String.valueOf(calculateTotalAmt()) + "\n";

        //打印总积分
        result += "You earned " + String.valueOf(calculateTotalFrequentRenterPoints())
                + " frequent renter points";

        return result;
    }

    private int calculateTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentalList) {
            // add frequent renter points （累计常客积点。
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double calculateTotalAmt() {
        double totalAmount = 0;

        for (Rental rental : rentalList) {
            totalAmount += rental.calculateAmount();
        }

        return totalAmount;
    }
}
