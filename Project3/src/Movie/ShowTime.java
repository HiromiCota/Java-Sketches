package Movie;

import java.sql.Time;

/**
 * File: ShowTime.java This is a wrapper class.
 *
 * @author Hiromi Cota
 */
public class ShowTime {

    int ShowTimeID;
    Time ShowTimeTime;    
    int TicketsRemaining;

    ShowTime(int ID, int hour, int minutes) {
        ShowTimeID = ID;
        ShowTimeTime = new Time(hour, minutes, 0);    
        TicketsRemaining = 100;
    }
    
    Boolean sellTicket(int ticketsSold){
        if (TicketsRemaining - ticketsSold >= 0)
        {
            TicketsRemaining -= ticketsSold;
            return true;
        }
        return false;
    }
    public int getFilmID(){
        return ShowTimeID;
    }
    public Time getTime(){
        return ShowTimeTime;
    }

}
