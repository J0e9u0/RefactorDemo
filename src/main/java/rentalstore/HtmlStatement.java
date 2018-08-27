package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class HtmlStatement extends Statement{

    public HtmlStatement(String name, Vector rentals) {
        super(name, rentals);
    }

    protected String getHeader() {
        return "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
    }

    protected String getFooter() {
        String footer = "<P>You owe<EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        footer += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return footer;
    }

    @Override
    public String getStatement() {
        Enumeration rentals = super.rentals.elements();
        String result = this.getHeader();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        //add footer lines
        result += this.getFooter();
        return result;
    }
}
