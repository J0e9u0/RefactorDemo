package rentalstore;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void should_return_correct_statement_given_customer_rent_one_regular_movie_for_3_day(){
        // Given
        Movie movie = new Movie("Roman Holiday",Movie.REGULAR);
        Customer customer = new Customer("Neo");
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);
        // When
        String statement = customer.statement();
        //System.out.println(statement);
        // Then
        String expected = "Rental Record for Neo\n" +
                "\tRoman Holiday\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1.0 frequent renter points";
        Assert.assertEquals(expected, statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_rent_one_regular_movie_for_3_day(){
        // Given
        Movie movie = new Movie("Roman Holiday",Movie.REGULAR);
        Customer customer = new Customer("Neo");
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);
        // When
        String statement = customer.htmlStatement();
        //System.out.println(statement);
        // Then
        String expected = "<H1>Rentals for <EM>Neo</EM></H1><P>\n" +
                "Roman Holiday: 3.5<BR>\n" +
                "<P>You owe<EM>3.5</EM><P>\n" +
                "On this rental you earned <EM>1.0</EM> frequent renter points<P>";
        Assert.assertEquals(expected, statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_rent_one_literary_movie_for_2_day(){
        // Given
        Movie movie = new Movie("Roman Holiday",Movie.LITERARY);
        Customer customer = new Customer("Neo");
        Rental rental = new Rental(movie, 2);
        customer.addRental(rental);
        // When
        String statement = customer.htmlStatement();
        //System.out.println(statement);
        // Then
        String expected = "<H1>Rentals for <EM>Neo</EM></H1><P>\n" +
                "Roman Holiday: 6.0<BR>\n" +
                "<P>You owe<EM>6.0</EM><P>\n" +
                "On this rental you earned <EM>1.5</EM> frequent renter points<P>";
        Assert.assertEquals(expected, statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_rent_three_literary_movie_for_4_day(){
        // Given
        Movie movie = new Movie("Roman Holiday",Movie.LITERARY);
        Movie movie2 = new Movie("The Bridge of Madison County",Movie.LITERARY);
        Movie movie3 = new Movie("Fly",Movie.LITERARY);
        Rental rental = new Rental(movie, 4);
        Rental rental2 = new Rental(movie2, 4);
        Rental rental3 = new Rental(movie3, 4);
        Customer customer = new Customer("Neo");
        customer.addRental(rental);
        customer.addRental(rental2);
        customer.addRental(rental3);
        // When
        String statement = customer.htmlStatement();
        //System.out.println(statement);
        // Then
        String expected = "<H1>Rentals for <EM>Neo</EM></H1><P>\n" +
                "Roman Holiday: 6.0<BR>\n" +
                "The Bridge of Madison County: 6.0<BR>\n" +
                "Fly: 6.0<BR>\n" +
                "<P>You owe<EM>18.0</EM><P>\n" +
                "On this rental you earned <EM>4.5</EM> frequent renter points<P>";
        Assert.assertEquals(expected, statement);
    }
}
