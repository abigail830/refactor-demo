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
        return rentalList.stream()
                .map(Rental::calculateFrequentRenterPoints)
                .reduce(0, Integer::sum);
    }

    private double calculateTotalAmt() {
        return rentalList.stream()
                .map(Rental::calculateAmount)
                .reduce(0d, Double::sum);
    }
}
