package ch.eiafr.mafiaspace;

import javax.swing.SwingUtilities;

/**
 * Main class containing the entry point
 * Start the simulation 
 */
public class Game {
    
    /** Unique instance */
    private static Game instance;
    
    private Game() {
        super();
    }
    
    public static Game getInstance() {
        if(instance == null)
            instance = new Game();
        
        return instance;
    }
    
    public void start() {
        WorldManagerFactory managerFactory = new WorldManagerFactory();
        ReaderFactory readerFactory = new ReaderFactory();
        
        Reader worldReader = readerFactory.createReader("mafiaworld.txt");
        WorldManager worldManager = managerFactory.createWorldManager(WorldManagerFactory.MAFIA_WORLD_NAME);
        
        worldManager.setWorld(worldReader.readWorld("mafiaworld.txt"));
        
        new GraphicUI(worldManager);
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