package ch.eiafr.mafiaspace;

public class WorldManagerFactory {
    
    public static final String MAFIA_WORLD_NAME = "mafialife";
    public static final String SPACE_WORLD_NAME = "spacelife";

    public WorldManager createWorldManager(String gameName) {
        if(gameName.equals(MAFIA_WORLD_NAME))
            return new MafiaWorldManager();
        else if(gameName.equals(SPACE_WORLD_NAME))
            return new SpaceWorldManager();
        else
            throw new IllegalArgumentException("bad game name");
    }
}