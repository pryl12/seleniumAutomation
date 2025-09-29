import java.util.Arrays;
import java.util.List;

public class MoviesSearch {

    public static void main(String[] args) {
        Movie Inception = new Movie("Inception", "2010-07-16", 8.8, "Christopher Nolan",
                new String[]{"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"}, 148);
        Movie Interstellar = new Movie("Interstellar", "2014-11-07", 8.6, "Christopher Nolan",
                new String[]{"Matthew McConaughey", "Anne Hathaway", "Jessica Chastain"}, 169);
        Movie TheDarkKnight = new Movie("The Dark Knight", "2008-07-18", 9.0, "Christopher Nolan",
                new String[]{"Christian Bale", "Heath Ledger", "Aaron Eckhart"}, 152);
        Movie PulpFiction = new Movie("Pulp Fiction", "1994-10-14", 8.9, "Quentin Tarantino",
                new String[]{"John Travolta", "Uma Thurman", "Samuel L. Jackson"}, 154);

        List<Movie> movies = Arrays.asList(Inception, Interstellar, TheDarkKnight, PulpFiction);
        boolean nolan = movies.stream().anyMatch(m -> m.searchByKeyword("Nolan"));
        System.out.println("Nolan movie found: " + nolan);

        sortByAttribute(movies, "duration", false);
        System.out.println("Movies sorted by title ascending:");
        for (Movie m : movies) {
            System.out.println(m.title + " - " + m.duration);
        }
    }

    public static List<Movie> sortByAttribute(List<Movie> items, String attribute, boolean ascending) {
        items.sort((a, b) -> {
            int comparison = 0;
            switch (attribute.toLowerCase()) {
                case "title":
                    comparison = a.title.compareTo(b.title);
                    break;
                case "releasedate":
                    comparison = a.releaseDate.compareTo(b.releaseDate);
                    break;
                case "director":
                    comparison = Double.compare(a.rating, b.rating);
                    break;
                case "duration":
                    if (a instanceof Movie && b instanceof Movie) {
                        comparison = Integer.compare(((Movie) a).duration, ((Movie) b).duration);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown attribute: " + attribute);
            }
            return ascending ? comparison : -comparison;
        });
        return items;
    }
}

interface Searchable {
    boolean searchByKeyword(String keyword);
}

abstract class MediaItem implements Searchable {
    String title;
    String releaseDate;
    double rating;
}

class Movie extends MediaItem {
    String director;
    String[] cast;
    int duration;

    public Movie(String title, String releaseDate, double rating, String director, String[] cast, int duration) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.director = director;
        this.cast = cast;
        this.duration = duration;
    }

    @Override
    public boolean searchByKeyword(String keyword) {
        // Simple case-sensitive search
        return this.title.contains(keyword) || this.director.contains(keyword) || Arrays.asList(cast).contains(keyword);
    }
}