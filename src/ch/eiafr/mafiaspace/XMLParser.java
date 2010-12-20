package ch.eiafr.mafiaspace;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {

    private Map<String, String> properties;

    private CaseFactory caseFactory;
    private Case[][] cases;

    private int crtRow;
    private int crtCol;

    public XMLParser() {
        properties = new HashMap<String, String>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if(qName.equals("world")) {
            for(int i = 0; i < atts.getLength(); i++) {
                properties.put(atts.getQName(i), atts.getValue(i));
            }

            int width  = Integer.parseInt(properties.get(XMLReader.KEY_WIDTH));
            int height = Integer.parseInt(properties.get(XMLReader.KEY_HEIGHT));

            caseFactory = CaseFactory.getFactory(properties.get(XMLReader.KEY_TYPE));
            cases = new Case[height][width];
        }

        else if(qName.equals("elt")) {
            cases[crtRow][crtCol] = caseFactory.createElement(Integer.parseInt(atts.getValue("type")));
            crtCol++;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(qName.equals("row")) {
            crtRow++;
            crtCol = 0;
        }
    }

    public Case[][] getCases() {
        return cases;
    }

    public String getProperty(String name) {
        return properties.get(name);
    }
}
