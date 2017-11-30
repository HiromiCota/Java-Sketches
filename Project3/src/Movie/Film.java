package Movie;

import java.io.File;
import java.sql.Time;
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

    public Film() {
    }

    public void setFilmID(int FilmID) {
        this.FilmID = FilmID;
    }

    public void setMinutesLong(int MinutesLong) {
        this.MinutesLong = MinutesLong;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setMPAARating(Rating MPAARating) {
        this.MPAARating = MPAARating;
    }

    public void setShowTimes(ArrayList<ShowTime> ShowTimes) {
        this.ShowTimes = ShowTimes;
    }

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
    
    public static Rating stringToRating(String input){
        switch(input)
        {
            case"G":
                return Rating.G;
            case"PG":
                return Rating.PG;
            case"PG13":
                return Rating.PG13;
            default:
                return Rating.R;
        }
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
    
    public Boolean deleteShowTime(ShowTime incoming){
        int index = findShowTime(incoming.getTime());
        if (index == -1)
            return false;
        ShowTimes.remove(index);
        return true;
    }
    
    public int findShowTime(Time time){
        for (int i = 0; i < ShowTimes.size();i++)
            if (ShowTimes.get(i).getTime().equals(time))
                return i;
        return -1;
    }

}
