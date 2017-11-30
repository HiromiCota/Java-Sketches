package Movie;

import Movie.Film.Rating;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * File: Parse.java Contains methods to parse XML files If files are unreadable,
 * these methods will return empty ArrayLists They should not throw unhandled
 * exceptions.
 *
 * @author Hiromi Cota
 */
public class ReadFile {
    public final String[] FILM_TAGS = {
        "Film",             //0
        "FilmID",           //1
        "Title",            //2
        "Length",           //3
        "Rating" };         //4
    public final String[] SHOW_TIME_TAGS = {
        "Showtime",         //0
        "ShowID",           //1
        "Hour",             //2
        "Minute",           //3
        "Tickets"};         //4
    public final String[] TICKET_TAGS = {
        "Ticket",           //0
        "TicketID",         //1
        "Quantity",         //2
        "TicketHour",       //3
        "TicketMinute",     //4
        "Price",            //5
        "TicketTitle",      //6
        "TicketFilmID"};    //7
    
 
    
    public ArrayList<Film> parseFilm(File input) {
        //Declare return value
        ArrayList<Film> output = new ArrayList();
        
        try{
            // Convert the file to a DOM document
            Document doc = FileUtilities.parseXmlToDoc(input);
            
            // Scan for Film tags
            NodeList filmList = doc.getElementsByTagName(FILM_TAGS[0]);            
            
            for (int i = 0; i < filmList.getLength();i++)
            {
                // Scope to the Ith node with a Film tag.
                Node thisNode = filmList.item(i);
                Element data = (Element) thisNode;
                Film thisFilm = new Film();
                
                //This block is ugly, but actually pretty simple:
                //Find the element for the property, parse it, set it
                thisFilm.setFilmID(readIntTag(data,(FILM_TAGS[1])));
                thisFilm.setTitle(readStringTag(data,(FILM_TAGS[2])));
                thisFilm.setMinutesLong(readIntTag(data,FILM_TAGS[3]));
                thisFilm.setMPAARating(Film.stringToRating(readStringTag(data,(FILM_TAGS[4]))));
                
                // Start parsing show times
                NodeList showList = data.getElementsByTagName(SHOW_TIME_TAGS[0]);
                
                for (int j = 0; j < showList.getLength();j++)
                {
                    // Scope to the Jth node with a ShowTime tag.
                    Node showNode = showList.item(j);
                    Element showData = (Element) showNode;
                    ShowTime thisShowing = new ShowTime();
                    
                    //This block is even uglier than the outside loop's
                    //Same idea, though. Find the tag, read its contents, set the appropriate property
                    //The big difference here is that we need a time object, so we parse two tags
                    //and add a 0, because we don't care about seconds.
                    thisShowing.setShowTimeID(readIntTag(data,SHOW_TIME_TAGS[1]));
                    thisShowing.setShowTimeTime(new Time(
                            (readIntTag(data,(SHOW_TIME_TAGS[2]))),
                            (readIntTag(data,(SHOW_TIME_TAGS[3]))),
                            0));
                    thisShowing.setTicketsRemaining((readIntTag(data,(SHOW_TIME_TAGS[4]))));
                    thisFilm.addShowTime(thisShowing);
                } // End for loop for showTimes                
            } // End for loop for Films
         }// End try block
        catch(Exception ex )
        {
            
        }// End Catch block
        return output;
    } //End parseFilm()
    
    public ArrayList<Ticket> parseTickets(File input) {
        //Declare return value
        ArrayList<Ticket> output = new ArrayList();
        
        try{
            // Convert the file to a DOM document
            Document doc = FileUtilities.parseXmlToDoc(input);
            
            // Scan for Film tags
            NodeList ticketList = doc.getElementsByTagName(TICKET_TAGS[0]);            
            
            for (int i = 0; i < ticketList.getLength();i++)
            {
                // Scope to the Ith node with a Ticket tag.
                Node thisNode = ticketList.item(i);
                Element data = (Element) thisNode;
                Ticket thisTicket = new Ticket();
                
                //This block is ugly, but actually pretty simple:
                //Find the element for the property, parse it, set it
                thisTicket.setTicketID(readIntTag(data,(TICKET_TAGS[1])));
                thisTicket.setQuantity(readArrayTag(data,(TICKET_TAGS[2])));
                thisTicket.setThisTime(new Time(
                        readIntTag(data,(TICKET_TAGS[3])),
                        readIntTag(data,(TICKET_TAGS[4])),
                        0));
                thisTicket.setThisPrice(Ticket.stringToPrice(readStringTag(data,(TICKET_TAGS[5]))));
                thisTicket.setThisFilm(readStringTag(data,(TICKET_TAGS[6])));
                thisTicket.setFilmID(readIntTag(data,(TICKET_TAGS[7])));
                     
            } // End for loop for Tickets
         }// End try block
        catch(Exception ex )
        {
            
        }// End Catch block
        //Parse file
        return output;
    }
    public String readStringTag(Element data, String tag){
        return data.getElementsByTagName(tag).item(0).getTextContent();
    }
    
    public int readIntTag(Element data, String tag){
        return Integer.parseInt(readStringTag(data,tag));
    }
    
    public int[] readArrayTag(Element data, String tag){
        String raw = readStringTag(data, tag);
        int[] output = new int[Ticket.TYPES_OF_TICKETS];
        for (int i = 0; i < Ticket.TYPES_OF_TICKETS; i++)
        {
            output[i] = Integer.parseInt(raw.substring(0, raw.indexOf(" ")));
            raw = raw.substring(raw.indexOf(" "));
        }
        return output;
    }

    


    
}
