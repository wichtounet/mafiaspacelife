package ch.eiafr.mafiaspace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Reader to read a world saved in a text file
 * 
 * @author Jérémy Singy
 */
public class TextReader implements Reader {
    
    private static final char   COMMENT_DELIMITER  = '#';
    private static final String KEYVALUE_DELIMITER = "=";
    
    private Map<String, String> properties;
    private BufferedReader reader;

    @Override
    public World readWorld(String filename) throws Exception {
        properties = new HashMap<String, String>();
        reader     = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename)));
        
        // Parse the header to get the type of the file and properties like width/height
        parseHeader();
        
        int width  = Integer.parseInt(properties.get(KEY_WIDTH));
        int height = Integer.parseInt(properties.get(KEY_HEIGHT));
        Case[][] cases = new Case[height][width];
        
        // Parse the file to create the matrix of cases 
        parseMatrix(cases);
        
        reader.close();
        
        // Create the new world with his cases and his type
        return new World(cases, properties.get(KEY_TYPE));
    }
    
    private void parseHeader() throws IOException {
        String line;
        
        // Add the 3 headers (type, width and height)
        line = nextLine();
        addHeaderElement(line);
        line = nextLine();
        addHeaderElement(line);
        line = nextLine();
        addHeaderElement(line);
    }
    
    private void addHeaderElement(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(KEYVALUE_DELIMITER);
        
        properties.put(scanner.next().trim(), scanner.next().trim());
    }
    
    private void parseMatrix(Case[][] cases) throws IOException {
        CaseFactory caseFactory = CaseFactory.getFactory(properties.get(KEY_TYPE));
        String line = nextLine();
        
        for(int i = 0; i < cases.length; i++) {
            Scanner scanner = new Scanner(line);
            
            for(int j = 0; j < cases[0].length; j++)
                cases[i][j] = caseFactory.createElement(Integer.parseInt(scanner.next()));
            
            line = nextLine();
        }
    }
    
    private String nextLine() throws IOException {
        String line = reader.readLine();
        
        while(line != null && (line.length() == 0 || line.charAt(0) == COMMENT_DELIMITER))
            line = reader.readLine();
        
        return line;
    }
}