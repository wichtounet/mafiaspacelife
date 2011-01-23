package ch.eiafr.mafiaspace;

/**
 * Abstract reader to read a saved world
 * 
 * @author Jérémy Singy
 */
public interface Reader {
    
    public static final String KEY_TYPE   = "type";
    public static final String KEY_WIDTH  = "width";
    public static final String KEY_HEIGHT = "height";
    
    public World readWorld(String filename) throws Exception;
}