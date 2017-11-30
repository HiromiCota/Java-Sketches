package Movie;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * This class contains all the parsers and document methods for I/O
 *
 * @author Hiromi
 */
public class FileUtilities {

    /**
     * Checks to make sure the Document is actually XML and is for the requested
     * tag type
     *
     * @param doc
     * @param tag
     * @return
     */
    public static int validateDoc(Document doc, String tag) {
        // If it's not XML, return -1
        if (doc.getXmlVersion() == null) {
            return -1;
        } else if (doc.hasChildNodes()) {
            //If there are Transaction elements, count them and return that.
            NodeList list = doc.getElementsByTagName(tag);
            return list.getLength();
        }
        //If there are no child elements, return 0
        return 0;
    } //The version of XML shouldn't matter. But, if it's not XML, we need to stop.

    /**
     * Makes sure the Cart isn't empty
     *
     * @param cart
     * @return
     */
    public Boolean validateTransactions(Cart cart) {
        return !cart.isEmpty();
    }

    /**
     * Generates a new Document for writing
     *
     * @return
     * @throws ParserConfigurationException
     */
    public static Document getDoc() throws ParserConfigurationException {
        //Need the factory and the builder to generator DOM XML
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        return documentBuilder.newDocument();
    }

    /**
     * Parses an XML file to a Document
     *
     * @param file
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static Document parseXmlToDoc(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        return documentBuilder.parse(file);
    }

}
