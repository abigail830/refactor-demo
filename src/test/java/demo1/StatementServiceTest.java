package demo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatementServiceTest {

    @Test
    void printStatement_REGULAR_1day() {
        //given
        final Customer customer1 = new Customer("customer1");
        final Movie movie1 = new Movie("movie1", Movie.REGULAR);
        customer1.addRental(new Rental(movie1, 1));

        //when
        final String s = customer1.getStatement();
        //then
        String expect = "Rental Record for customer1\n" +
                "\tmovie1\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expect, s);
    }

    @Test
    void printStatement_REGULAR_3day() {
        //given
        final Customer customer1 = new Customer("customer1");
        final Movie movie1 = new Movie("movie1", Movie.REGULAR);
        customer1.addRental(new Rental(movie1, 3));

        //when
        final String s = customer1.getStatement();
        //then
        String expect = "Rental Record for customer1\n" +
                "\tmovie1\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expect, s);
    }

    @Test
    void printStatement_NEW_1day() {
        //given
        final Customer customer1 = new Customer("customer1");
        final Movie movie1 = new Movie("movie1", Movie.NEW_RELEASE);
        customer1.addRental(new Rental(movie1, 1));

        //when
        final String s = customer1.getStatement();
        //then
        String expect = "Rental Record for customer1\n" +
                "\tmovie1\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expect, s);
    }

    @Test
    void printStatement_NEW_2day() {
        //given
        final Customer customer1 = new Customer("customer1");
        final Movie movie1 = new Movie("movie1", Movie.NEW_RELEASE);
        customer1.addRental(new Rental(movie1, 2));

        //when
        final String s = customer1.getStatement();
        //then
        String expect = "Rental Record for customer1\n" +
                "\tmovie1\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expect, s);
    }

    @Test
    void printStatement_CHILDREN_1day() {
        //given
        final Customer customer1 = new Customer("customer1");
        final Movie movie1 = new Movie("movie1", Movie.CHILDRENS);
        customer1.addRental(new Rental(movie1, 2));

        //when
        final String s = customer1.getStatement();
        //then
        String expect = "Rental Record for customer1\n" +
                "\tmovie1\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expect, s);
    }

    @Test
    void printStatement_CHILDREN_4day() {
        //given
        final Customer customer1 = new Customer("customer1");
        final Movie movie1 = new Movie("movie1", Movie.CHILDRENS);
        customer1.addRental(new Rental(movie1, 4));

        //when
        final String s = customer1.getStatement();
        //then
        String expect = "Rental Record for customer1\n" +
                "\tmovie1\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expect, s);
    }
}