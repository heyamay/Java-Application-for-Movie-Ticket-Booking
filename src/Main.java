import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        Scanner scanner = new Scanner(System.in);

        // Populate theaters and movies
        Theater theater1 = new Theater("Cinema Hall 1", 5, 10);
        Movie movie1 = new Movie("Inception", "Sci-Fi", 148);
        Movie movie2 = new Movie("Interstellar", "Sci-Fi", 169);
        theater1.addMovie(movie1);
        theater1.addMovie(movie2);
        bookingSystem.addTheater(theater1);

        // User interaction loop
        while (true) {
            System.out.println("1. Browse Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    List<Movie> movies = bookingSystem.browseMovies();
                    for (Movie movie : movies) {
                        System.out.println(movie.getTitle() + " - " + movie.getGenre() + " - " + movie.getDuration() + " mins");
                    }
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    User user = new User(name);

                    System.out.print("Enter movie title: ");
                    String title = scanner.next();
                    Movie selectedMovie = null;
                    for (Movie movie : bookingSystem.browseMovies()) {
                        if (movie.getTitle().equals(title)) {
                            selectedMovie = movie;
                            break;
                        }
                    }
                    if (selectedMovie == null) {
                        System.out.println("Movie not found!");
                        break;
                    }

                    System.out.print("Enter row number: ");
                    int row = scanner.nextInt();
                    System.out.print("Enter seat number: ");
                    int number = scanner.nextInt();

                    if (bookingSystem.bookSeat(user, selectedMovie, row, number)) {
                        System.out.println("Booking successful!");
                    } else {
                        System.out.println("Seat already booked or invalid seat number!");
                    }
                    break;
                case 3:
                    System.out.print("Enter your name: ");
                    name = scanner.next();
                    List<Reservation> reservations = bookingSystem.getUserReservations(name);
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found!");
                    } else {
                        for (Reservation reservation : reservations) {
                            System.out.println("Movie: " + reservation.getMovie().getTitle() + ", Seat: Row " + reservation.getSeat().getRow() + " Seat " + reservation.getSeat().getNumber());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
