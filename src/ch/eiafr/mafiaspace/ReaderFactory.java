package ch.eiafr.mafiaspace;

public class ReaderFactory {
    
    public static final String TEXT_FILE_EXT = ".txt";
    public static final String XML_FILE_EXT  = ".xml";
    
    public Reader createReader(String filename) {
        if(filename.endsWith(TEXT_FILE_EXT))
            return new TextReader();
        else if(filename.endsWith(XML_FILE_EXT))
            return new XMLReader();
        else
            throw new IllegalArgumentException("bad filename");
    }
}