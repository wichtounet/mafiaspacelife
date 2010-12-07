package ch.eiafr.mafiaspace;

public abstract class WorldManager {
    
//    /** Unique instance */
//    private static Game instance;
//    
//    /** Cannot be used externally */
//    private WorldManager() {
//        super();
//    }
//    
//    /** Get the unique instance of the class */
//    public static WorldManager getInstance() {
//        if(instance == null)
//            instance = new WorldManager();
//        
//        return instance;
//    }
    
    World world;
    
    public void nextTurn() {
        
    }

    public void setWorld(World aWorld) {
        world = aWorld;
    }

    protected abstract boolean isWorldEnded();
}