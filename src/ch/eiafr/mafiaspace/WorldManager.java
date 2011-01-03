package ch.eiafr.mafiaspace;

import java.util.Collection;
import java.util.Iterator;

import ch.eiafr.mafiaspace.World.Park;

public abstract class WorldManager {
    private World world;
    
    public void nextTurn(){
        Element nextCase = world.getNextElement();

        Collection<Case> neighbours = world.getPossibleMoves(nextCase);

        for(Case c : neighbours){
            if(nextCase.isAbleToMove(c)){
                world.moveElement(nextCase, c);

                break;
            }
        }

        Command command = nextCase.getCommand(world, world.getNeighbours(nextCase));

        if(command != null){
            command.setWorld(world);

            System.out.println(command);

            command.make();
        }

        //Manage parking

        Iterator<Park> parking = world.getParking().iterator();

        while(parking.hasNext()){
            Park park = parking.next();

            park.setTime(park.getTime() - 1);

            if(park.getTime() <= 0){
                if(world.addElement(park.getElement())){
                    System.out.println("Remove mobster from jail");

                    parking.remove();
                }
            }
        }
        
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