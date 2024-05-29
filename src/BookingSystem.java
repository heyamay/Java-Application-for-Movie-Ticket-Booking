import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Theater> theaters;
    private List<Reservation> reservations;

    public BookingSystem() {
        theaters = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addTheater(Theater theater) {
        theaters.add(theater);
    }

    public List<Movie> browseMovies() {
        List<Movie> allMovies = new ArrayList<>();
        for (Theater theater : theaters) {
            allMovies.addAll(theater.getMovies());
        }
        return allMovies;
    }

    public boolean bookSeat(User user, Movie movie, int row, int number) {
        for (Theater theater : theaters) {
            if (theater.getMovies().contains(movie)) {
                Seat seat = theater.getSeat(row, number);
                if (seat != null && seat.book()) {
                    reservations.add(new Reservation(movie, seat, user.getName()));
                    return true;
                }
            }
        }
        return false;
    }

    public List<Reservation> getUserReservations(String userName) {
        List<Reservation> userReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getUserName().equals(userName)) {
                userReservations.add(reservation);
            }
        }
        return userReservations;
    }
}
