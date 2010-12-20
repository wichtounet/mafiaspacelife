package ch.eiafr.mafiaspace;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLReader implements Reader {
    
    private Document document;
    
    @Override
    public World readWorld(String filename) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder        builder = factory.newDocumentBuilder();
        
        document = builder.parse(new File(filename));
        Element eltRoot = document.getDocumentElement();
        
        eltRoot.getClass();
        
        return null;
    }
}