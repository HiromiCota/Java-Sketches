package Movie;

/**
 *
 * @author Hiromi Cota
 */
public class ShowTime {

    int ShowTimeID;
    int Hour;
    int Minutes;
    int Film;

    ShowTime(int ID, int hour, int minutes, int film) {
        ShowTimeID = ID;
        Hour = hour;
        Minutes = minutes;
        Film = film;
    }
}
