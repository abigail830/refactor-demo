package demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        result += getRentailDetailList();
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";

        return result;
    }

    private String getRentailDetailList() {
        return rentalList.stream()
                .map(this::getDetailStatement)
                .collect(Collectors.joining());

    }

    private String getDetailStatement(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.calculateAmount()) + "\n";

    }

    private double getTotalAmount() {
        return rentalList.stream()
                .map(Rental::calculateAmount)
                .reduce(0d, Double::sum);
    }

    private int getTotalFrequentRenterPoints() {
        return rentalList.stream()
                .map(Rental::calculateFrequentRenterPoints)
                .reduce(0, Integer::sum);

    }
}
