package rentalstore;

import java.util.Vector;

public class TextStatement extends Statement {


    public TextStatement(String name, Vector rentals) {
        super(name, rentals);
    }

    protected String getHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    protected String getFooter() {
        String footer = "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        footer += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return footer;
    }
}
