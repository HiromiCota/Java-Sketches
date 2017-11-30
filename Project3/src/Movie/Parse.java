package Movie;

import java.io.File;
import java.io.IOException;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * File: Parse.java Contains methods to parse XML files If files are unreadable,
 * these methods will return empty ArrayLists They should not throw unhandled
 * exceptions.
 *
 * @author Hiromi Cota
 */
public class Parse {

    public ArrayList<Film> parseFilm(File input) {
        //Declare return value
        ArrayList<Film> output = new ArrayList();

        //Parse file
        return output;
    }

    public ArrayList<ShowTime> parseShowTimes(File input) {
        //Declare return value
        ArrayList<ShowTime> output = new ArrayList();

        //Parse file
        return output;
    }

    public ArrayList<Ticket> parseTickets(File input) {
        //Declare return value
        ArrayList<Ticket> output = new ArrayList();

        //Parse file
        return output;
    }

    public Boolean writeTransaction(Cart cart, File file)
            throws ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException, IOException {
        if (!file.canWrite()) {
            return false;
        }
        Document doc;
        if (!file.exists()) {
            doc = buildRootNode(cart, 0);
        } else {
            doc = parseXML(file);
        }

        int validation = validateDoc(doc);
        switch (validation) {
            case -1:
                return false;
            case 0:
                doc = buildRootNode(cart, validation); //Overwriting. Hope it's blank.
                break;
            default:
                appendTransaction(cart, doc, validation);
                break;
        }
        //Let's hit the disk and write
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);

        return true;
    }

    public Boolean appendTransaction(Cart cart, Document doc, int startIndex) {
        //Start traversing the ArrayList
        for (int i = 0; i < cart.size(); i++) {
            Ticket temp = cart.get(i);
            // Create a node and subnodes
            Element newNode = doc.createElement("Transaction #");
            newNode.setNodeValue(Integer.toString(startIndex + i));
            Element showTime = doc.createElement("ShowTime");
            showTime.appendChild(doc.createTextNode(temp.getTime().toString()));
            Element filmID = doc.createElement("Film");
            filmID.appendChild(doc.createTextNode(temp.getTitle()));
            Element price = doc.createElement("Price per");
            price.appendChild(doc.createTextNode(Double.toString(temp.getPrice())));
            Element quantity = doc.createElement("Quantity");
            quantity.appendChild(doc.createTextNode(Integer.toString(cart.getQuantity(i))));
            Element subTotal = doc.createElement("Subtotal");
            subTotal.appendChild(doc.createTextNode(Double.toString(temp.getPrice() * cart.getQuantity(i))));

            //Write the node
            doc.getDocumentElement().appendChild(newNode);
            //Populate the node
            newNode.appendChild(showTime);
            newNode.appendChild(filmID);
            newNode.appendChild(price);
            newNode.appendChild(quantity);
            newNode.appendChild(subTotal);
        }//End of node generating for loop
        return true;
    }

    public int validateDoc(Document doc) {
        // If it's not XML, return -1
        if (doc.getXmlVersion() == null) {
            return -1;
        } else if (doc.hasChildNodes()) {
            //If there are Transaction elements, count them and return that.
            NodeList list = doc.getElementsByTagName("Transaction #");
            return list.getLength();
        }
        //If there are no child elements, return 0
        return 0;
    } //The version of XML shouldn't matter. But, if it's not XML, we need to stop.

    public Boolean validateTransactions(Cart cart) {
        return !cart.isEmpty();
    }

    public Document parseXML(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        return documentBuilder.parse(file);
    }

    public Document buildRootNode(Cart cart, int startIndex) throws ParserConfigurationException {
        //Need the factory and the builder to generator DOM XML
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        //Build the root node
        Document doc = documentBuilder.newDocument();
        Element rootElement = doc.createElement("Transactions");
        doc.appendChild(rootElement);

        //Build the child nodes
        if (appendTransaction(cart, doc, startIndex)) {
            return doc;
        } else //I donno. Fail and cry, I guess.
        {
            return doc;
        }
    }
}
