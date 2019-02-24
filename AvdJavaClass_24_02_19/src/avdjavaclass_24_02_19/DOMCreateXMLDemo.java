package avdjavaclass_24_02_19;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMCreateXMLDemo {

    public static void main(String[] args) throws TransformerException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            // Staff elements
            Element staff = doc.createElement("staff");
            rootElement.appendChild(staff);

            // Set attribute to staff element
            Attr attr = doc.createAttribute("id");
            attr.setValue("1000");
            staff.setAttributeNode(attr);

            // Shorten way
            // staff.setAttribute("id","1");
            // firstname elements
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("Asaduzzaman"));
            staff.appendChild(firstname);

            // lastname elements
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("Rony"));
            staff.appendChild(lastname);

            // nickname elements
            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("Rony"));
            staff.appendChild(nickname);

            // salary elements
            Element salary = doc.createElement("salary");
            salary.appendChild(doc.createTextNode("1000000"));
            staff.appendChild(salary);

            // country elements
            Element country = doc.createElement("country");
            country.appendChild(doc.createTextNode("Bangladesh"));
            staff.appendChild(country);

            // Write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("D:\\git\\Adv-javaClass\\AvdJavaClass_24_02_19\\src\\avdjavaclass_24_02_19\\example.xml"));

            // Output to consol for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved");
        } catch (ParserConfigurationException pec) {
            pec.printStackTrace();
        }
    }

}
