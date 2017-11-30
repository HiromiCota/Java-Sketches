/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Hiromi
 */
public class FileUtilities {
    
    public static int validateDoc(Document doc) {
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
    
    public static Document getDoc() throws ParserConfigurationException{
        
        //Need the factory and the builder to generator DOM XML
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        return documentBuilder.newDocument();        
    }
    
    public static Document parseXmlToDoc(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        return documentBuilder.parse(file);
    }

}
