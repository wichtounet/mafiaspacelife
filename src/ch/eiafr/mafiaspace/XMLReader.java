package ch.eiafr.mafiaspace;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

public class XMLReader implements Reader {
    
    @Override
    public World readWorld(String filename) throws Exception {
        XMLParser xmlParser = new XMLParser();
        
        SAXParserFactory      factory = SAXParserFactory.newInstance();
        SAXParser             parser  = factory.newSAXParser();
        org.xml.sax.XMLReader reader  = parser.getXMLReader();
        
        reader.setContentHandler(xmlParser);
        
        reader.parse(new InputSource(filename));
        
        // Create the new world with his cases and his type
        return new World(xmlParser.getCases(), xmlParser.getProperty(KEY_TYPE));
    }
}