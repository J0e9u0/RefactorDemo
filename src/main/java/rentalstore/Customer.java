package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    private Statement statement;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        statement = new TextStatement(this.name, this.rentals);
        return statement.getStatement();
    }

    private String initHtmlHeader(){
        return "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
    }

    private String initHtmlFooter(){
        String footer = "<P>You owe<EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        footer += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return footer;
    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = this.initHtmlHeader();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        //add footer lines
        result += this.initHtmlFooter();
        return result;
    }

    double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    double getTotalFrequentRenterPoints() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRentalPoints();
        }
        return result;

    }
}
