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
        System.out.println(statement);
        // Then
        String expected = "Rental Record for Neo\n" +
                "\tRoman Holiday\t3.5\n" +
                "Amount owed is3.5\n" +
                "You earned1 frequent renter points";
        Assert.assertEquals(expected, statement);
    }
}
