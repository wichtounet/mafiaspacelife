package ch.eiafr.mafiaspace;

import java.util.Collection;

public abstract class WorldManager {
    private World world;
    
    public void nextTurn(){
        Case nextCase = world.getNextElement();

        Collection<Case> neighbours = world.getPossibleMoves(nextCase);

        for(Case c : neighbours){
            if(nextCase.getElement().isAbleToMove(c)){
                world.moveElement(nextCase, c);

                break;
            }
        }

        Command command = nextCase.getElement().getCommand(world.getNeighbours(nextCase));

        //Execute command

        world.endTurn();
    }

    public void setWorld(World aWorld) {
        world = aWorld;
    }

    public World getWorld() {
        return world;
    }

    protected abstract boolean isWorldEnded();
}