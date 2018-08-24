package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    private String initHeader(){
        return "Rental Record for " + getName() + "\n";
    }

    private String initFooter(){
        String footer = "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        footer += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return footer;
    }

    public String statement() {
        Enumeration rentals = this.rentals.elements();
        String result = this.initHeader();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //add footer lines
        result += this.initFooter();
        return result;
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

    int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRentalPoints();
        }
        return result;

    }
}
