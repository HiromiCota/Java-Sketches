package Movie;

import java.io.File;
import java.util.ArrayList;

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
    public ArrayList<ShowTime> ShowTimes; 


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
    
    public Boolean addShowTime(ShowTime incoming){
        ShowTimes.add(incoming);
        return true;
    }
    public Boolean addShowTime(int hour, int minute){
        if (hour >= 0 && hour < 23 && minute >= 0 && minute < 59){
        int index = ShowTimes.size();
        ShowTime incoming = new ShowTime(index, hour, minute);
        return addShowTime(incoming);
        }
        return false;
    }

}
