public class Reservation {
    private Movie movie;
    private Seat seat;
    private String userName;

    public Reservation(Movie movie, Seat seat, String userName) {
        this.movie = movie;
        this.seat = seat;
        this.userName = userName;
    }

    public Movie getMovie() {
        return movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public String getUserName() {
        return userName;
    }
}
