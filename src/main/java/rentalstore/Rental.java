package rentalstore;

public class Rental {
    private Movie movie;
    private int dayRented;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    public double getCharge() {
        double result = 0;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (this.getDayRented() > 2) {
                    result += (this.getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += this.getDayRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (this.getDayRented() > 3) {
                    result += (this.getDayRented() - 3) * 1.5;
                }
                break;
            case Movie.LITERARY:
                result += 6;
                break;
        }
        return result;
    }

    double getFrequentRentalPoints() {
        double result = 1;
        if(this.getDayRented() > 1){
            switch (this.getMovie().getPriceCode()){
                case Movie.NEW_RELEASE:
                    result = 2;
                    break;
                case Movie.LITERARY:
                    result = 1.5;
            }
        }
        return result;
    }
}