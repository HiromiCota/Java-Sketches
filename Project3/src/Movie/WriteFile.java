/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie;

import java.io.File;
import java.io.IOException;
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
import org.xml.sax.SAXException;


/**
 *
 * @author Hiromi
 */
public class WriteFile {
    public Boolean writeTicketSales(Cart cart, File file)
            throws ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException, IOException {
        if (!file.canWrite()) {
            return false;
        }
        Document doc;
        if (!file.exists()) {
            doc = buildRootNode(cart, 0);
        } else {
            doc = FileUtilities.parseXmlToDoc(file);
        }

        int validation = FileUtilities.validateDoc(doc,ReadFile.TICKET_TAGS[0]);
        switch (validation) {   
            case -1:
                return false;
            case 0: //Couldn't find any nodes. 
                doc = buildRootNode(cart, validation); //Overwriting. Hope it's blank.
                break;
            default:
                appendTicketSales(cart, doc, validation);
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


    public Boolean appendTicketSales(Cart cart, Document doc, int startIndex) {
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
            Element quantity = doc.createElement("Quantity");
            quantity.appendChild(doc.createTextNode(temp.quantityToString()));
            Element subTotal = doc.createElement("Subtotal");
            subTotal.appendChild(doc.createTextNode(Double.toString(temp.getSubtotal())));

            //Write the node
            doc.getDocumentElement().appendChild(newNode);
            //Populate the node
            newNode.appendChild(showTime);
            newNode.appendChild(filmID);            
            newNode.appendChild(quantity);
            newNode.appendChild(subTotal);
        }//End of node generating for loop
        return true;
    }

    public Document buildRootNode(Cart cart, int startIndex) throws ParserConfigurationException {
        //Build new document
        Document doc = FileUtilities.getDoc();
        
        //Build the root node        
        Element rootElement = doc.createElement("Transactions");
        doc.appendChild(rootElement);

        //Build the child nodes
        if (appendTicketSales(cart, doc, startIndex)) {
            return doc;
        } else //I donno. Fail and cry, I guess.
        {
            return doc;
        }
    }
}
