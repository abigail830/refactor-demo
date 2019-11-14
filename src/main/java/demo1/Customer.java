package demo1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentalList;

    public Customer(String name) {
        this.name = name;
        rentalList = new ArrayList<Rental>();
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

    public String getStatement() {

        double totalAmount = 0; // 总消费金。
        int frequentRenterPoints = 0; // 常客积点

        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : getRentalList()) {

            frequentRenterPoints += rental.calculateFrequentRenterPoints();

            double thisAmount = rental.calculateAmount();
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
