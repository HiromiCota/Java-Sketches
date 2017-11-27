package Movie;

import java.io.File;

/**
 *
 * @author Hiromi Cota
 */
public class Film {

    File films = new File("/src/Movie/Films.xml");

    public enum Rating {
        G, PG, PG13, R
    }
    public int FilmID;
    public int MinutesLong;
    public String Title;
    public Rating MPAARating;

    public int getFilmID() {
        return FilmID;
    }

    public int getMinutesLong() {
        return MinutesLong;
    }

    public String getTitle() {
        return Title;
    }

    public Rating getMPAARating() {
        return MPAARating;
    }

    Film(int film, int length, String title, Rating rating) {
        FilmID = film;
        MinutesLong = length;
        Title = title;
        MPAARating = rating;
    }//End Film constructor

}
