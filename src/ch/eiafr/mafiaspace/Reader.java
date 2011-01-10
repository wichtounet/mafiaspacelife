package ch.eiafr.mafiaspace;

public interface Reader {
    
    public static final String KEY_TYPE   = "type";
    public static final String KEY_WIDTH  = "width";
    public static final String KEY_HEIGHT = "height";
    
    public World readWorld(String filename) throws Exception;
}