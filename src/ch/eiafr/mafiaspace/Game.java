package ch.eiafr.mafiaspace;

import javax.swing.SwingUtilities;

/**
 * Main class containing the entry point
 * Start the simulation 
 */
public class Game {
    
    /** Unique instance */
    private static Game instance;
    
    /** Cannot be used externally */
    private Game() {
        super();
    }
    
    /** Get the unique instance of the class */
    public static Game getInstance() {
        if(instance == null)
            instance = new Game();
        
        return instance;
    }
    
    public void start() {
        new StartFrame();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Game.getInstance().start();
            }
        });
    }
}