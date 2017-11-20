package Movie;

/**
 *
 * @author Hiromi Cota
 */
public class Film {

    public enum Rating {
        G, PG, PG13, R
    }
    int FilmID;
    int MinutesLong;
    String Title;
    Rating MPAARating;

    Film(int film, int length, String title, Rating rating) {
        FilmID = film;
        MinutesLong = length;
        Title = title;
        MPAARating = rating;
    }

}
