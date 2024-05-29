import java.util.ArrayList;
import java.util.List;

public class Theater {
    private String name;
    private List<Movie> movies;
    private Seat[][] seats;

    public Theater(String name, int rows, int seatsPerRow) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.seats = new Seat[rows][seatsPerRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seats[i][j] = new Seat(i + 1, j + 1);
            }
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Seat getSeat(int row, int number) {
        if (row <= seats.length && number <= seats[0].length) {
            return seats[row - 1][number - 1];
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
