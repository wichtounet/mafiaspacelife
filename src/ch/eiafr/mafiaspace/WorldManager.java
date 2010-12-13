package ch.eiafr.mafiaspace;

import java.util.Collection;

public abstract class WorldManager {
    private World world;
    
    public void nextTurn(){
        Case nextElement = world.getNextElement();

        Collection<Case> neighbours = world.getPossibleMoves(nextElement);
    }

    public void setWorld(World aWorld) {
        world = aWorld;
    }

    public World getWorld() {
        return world;
    }

    protected abstract boolean isWorldEnded();
}