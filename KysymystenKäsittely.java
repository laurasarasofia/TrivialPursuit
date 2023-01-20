import java.io.*;
import java.util.ArrayList;
import java.util.Random;

//import javax.xml.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
//import java.lang.*;
import org.w3c.dom.NodeList;

public class KysymystenKäsittely {
    File file;
    String vari;
    int indeksi;
    //ArrayList<NodeList> nList;

    public KysymystenKäsittely(File file) {
        this.file = file;
    }

    public ArrayList<NodeList> tiedostonKäsittely() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList siniset = doc.getElementsByTagName("siniset");
        NodeList pinkit = doc.getElementsByTagName("pinkit");
        NodeList violetit = doc.getElementsByTagName("violetit");
        NodeList keltaiset = doc.getElementsByTagName("keltaiset");
        NodeList vihreat = doc.getElementsByTagName("vihreat");
        NodeList punaiset = doc.getElementsByTagName("punaiset");
        // NamedNodeMap siniset = doc.getElementsByTagName("siniset");

        ArrayList<NodeList> nList = new ArrayList<NodeList>();
        nList.add(siniset);
        nList.add(pinkit);
        nList.add(violetit);
        nList.add(keltaiset);
        nList.add(vihreat);
        nList.add(punaiset);

        return nList;
    }


    public String getKysymys(String vari) throws ParserConfigurationException, SAXException, IOException {
        this.vari = vari;
        ArrayList<NodeList> kysymykset = tiedostonKäsittely();

        if (vari.equals("siniset")) {
            Random random = new Random();
            NodeList lista = kysymykset.get(0);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            //System.out.println(element.getElementsByTagName("kysymys").item(0).getTextContent());
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;
        }

        if (vari.equals("pinkit")) {
            Random random = new Random();
            NodeList lista = kysymykset.get(1);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;

        }
        if (vari.equals("keltaiset")) {
            Random random = new Random();
            NodeList lista = kysymykset.get(2);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;

        }
        if (vari.equals("violetit")) {
            Random random = new Random();
            NodeList lista = kysymykset.get(3);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;

        }
        if (vari.equals("vihreat")) {
            Random random = new Random();
            NodeList lista = kysymykset.get(4);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;

        }
        else {
            Random random = new Random();
            NodeList lista = kysymykset.get(5);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;
        }

        // return kysymykset.get(indeksi);

    }
    public String getVastaus() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<NodeList> vastaukset = tiedostonKäsittely();

        if (vari.equals("siniset")) {
            NodeList lista = vastaukset.get(0);
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
            
        }
        if (vari.equals("pinkit")) {
            NodeList lista = vastaukset.get(1);
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        if (vari.equals("keltaiset")) {
            NodeList lista = vastaukset.get(2);
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        if (vari.equals("violetit")) {
            NodeList lista = vastaukset.get(3);
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        if (vari.equals("vihreat")) {
            NodeList lista = vastaukset.get(4);
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        else{
            NodeList lista = vastaukset.get(5);
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        
        
        //return vastaukset.get(indeksi);
    }

}
