package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public abstract class Statement {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Statement(String name, Vector rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    protected Vector rentals;

    public String getStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = this.getHeader();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //add footer lines
        result += this.getFooter();
        return result;
    }

    protected abstract String getHeader();

    protected abstract String getFooter();

    protected double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    protected double getTotalFrequentRenterPoints() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRentalPoints();
        }
        return result;

    }
}
