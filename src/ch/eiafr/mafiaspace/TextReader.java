package ch.eiafr.mafiaspace;

import java.io.*;

public class TextReader implements Reader {

    @Override
    public World readWorld(String filename) {
        File file = new File(filename);
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            
            // TODO: parse file
            
            reader.close();
        } catch (IOException e) {
            System.err.println("Error while parsing text file: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
}