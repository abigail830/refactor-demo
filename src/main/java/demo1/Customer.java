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
}
