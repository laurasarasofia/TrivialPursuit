import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.NodeList;

public class KysymystenKäsittely {
    File file;
    String vari;
    int indeksi;

    //konstruktori saa tiedoston, josta kysymykset ja vastaukset haetaan
    public KysymystenKäsittely(File file) {
        this.file = file;
    }

    public ArrayList<NodeList> tiedostonKäsittely() throws ParserConfigurationException, SAXException, IOException {
        //xml-tiedoston käsittely
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList siniset = doc.getElementsByTagName("siniset"); //haetaan sinisen kategorian elementit, joista luodaan NodeList
        NodeList pinkit = doc.getElementsByTagName("pinkit"); //haetaan pinkin kategorian elementit, joista luodaan NodeList
        NodeList violetit = doc.getElementsByTagName("violetit"); //jne.
        NodeList keltaiset = doc.getElementsByTagName("keltaiset");
        NodeList vihreat = doc.getElementsByTagName("vihreat");
        NodeList punaiset = doc.getElementsByTagName("punaiset");
        // NamedNodeMap siniset = doc.getElementsByTagName("siniset");

        ArrayList<NodeList> nList = new ArrayList<NodeList>(); //lisätään kaikki NodeListit ArrayListiin
        nList.add(siniset);
        nList.add(pinkit);
        nList.add(keltaiset);
        nList.add(violetit);
        nList.add(vihreat);
        nList.add(punaiset);

        return nList; //luokka palauttaa arraylistin
    }

    //metodilla palautetaan halutun värin kysymys
    public String getKysymys(String vari) throws ParserConfigurationException, SAXException, IOException {
        this.vari = vari;
        ArrayList<NodeList> kysymykset = tiedostonKäsittely(); //kutsuu tiedostonKäsittely-metodia, joka palauttaa arraylistin
        Random random = new Random();

        if (vari.equals("siniset")) {
            NodeList lista = kysymykset.get(0);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus; //palauttaa satunnaisen kysymyksen
        }

        if (vari.equals("pinkit")) {
            NodeList lista = kysymykset.get(1);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;

        }
        if (vari.equals("keltaiset")) {
            NodeList lista = kysymykset.get(2);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;

        }
        if (vari.equals("violetit")) {
            NodeList lista = kysymykset.get(3);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;

        }
        if (vari.equals("vihreat")) {
            NodeList lista = kysymykset.get(4);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;

        }
        else {
            NodeList lista = kysymykset.get(5);
            indeksi = random.nextInt(lista.getLength());
            Node node = lista.item(indeksi);
            Element element = (Element) node;
            String palautus = element.getElementsByTagName("kysymys").item(0).getTextContent();
            return palautus;
        }

        // return kysymykset.get(indeksi);

    }
    //metodilla palautetaan vastaus kysyttyyn kysymykseen, toimii this.vari-muuttujan avulla
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
        
    }
    public String satunnainenVastaus(String vari) throws ParserConfigurationException, SAXException, IOException{
        ArrayList<NodeList> vastaukset = tiedostonKäsittely();
        Random random = new Random();

        if (vari.equals("siniset")) {
            NodeList lista = vastaukset.get(0);
            Node node = lista.item(random.nextInt(lista.getLength()));
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
            
        }
        if (vari.equals("pinkit")) {
            NodeList lista = vastaukset.get(1);
            Node node = lista.item(random.nextInt(lista.getLength()));
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        if (vari.equals("keltaiset")) {
            NodeList lista = vastaukset.get(2);
            Node node = lista.item(random.nextInt(lista.getLength()));
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        if (vari.equals("violetit")) {
            NodeList lista = vastaukset.get(3);
            Node node = lista.item(random.nextInt(lista.getLength()));
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        if (vari.equals("vihreat")) {
            NodeList lista = vastaukset.get(4);
            Node node = lista.item(random.nextInt(lista.getLength()));
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        else{
            NodeList lista = vastaukset.get(5);
            Node node = lista.item(random.nextInt(lista.getLength()));
            Element element = (Element) node;
            String palautus=element.getElementsByTagName("vastaus").item(0).getTextContent();
            return palautus;
        }
        
    
    }

}
