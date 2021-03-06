package ch.eiafr.mafiaspace;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class WorldManager {
    private World world;
    
    public void nextTurn(){
        Element nextCase = world.getNextElement();
        
        System.out.println("nextCase: "+nextCase.getName());
        
        Collection<Case> neighbours = world.getNeighbours(nextCase);
        Collections.shuffle((List<Case>)neighbours);
        
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

        if(isWorldEnded()){
            world.setEnded();
        }
    }

    public void setWorld(World aWorld) {
        world = aWorld;
    }

    public World getWorld() {
        return world;
    }

    protected abstract boolean isWorldEnded();
}