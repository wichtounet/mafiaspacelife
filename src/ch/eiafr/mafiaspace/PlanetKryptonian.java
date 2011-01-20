package ch.eiafr.mafiaspace;

import java.util.Collection;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PlanetKryptonian extends Planet {
	private final Icon ICON = new ImageIcon(getClass().getResource("/res/pkryptonien.png"));

    @Override
    public String getName() {
        return "PlanetKryptonian";
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }
    
    @Override
    public boolean isAbleToMove(Case c) {
    	if(isTimeToMove) {
    		if(c.isEmpty()) {
    			movedOnElement = Elements.NOTHING;
    			return true;
    		}
    		else if(c.getElement() instanceof Asteroid) {
    			movedOnElement = Elements.ASTEROID;
    			return true;
    		}
    		else if(c.getElement() instanceof Blackhole) {
    			movedOnElement = Elements.BLACKHOLE;
    			return true;
    		}
    	}
    	return false;
    }
    
    @Override
    public Command getCommand(World world, Collection<Case> aNeighbors) {
    	if(!isTimeToMove) {
    		isTimeToMove = true;
    		return null;
    	}
    	
    	isTimeToMove = false;
    	
    	switch(movedOnElement) {
    	case ASTEROID:
    		return new Create(new Asteroid(), world.getCase(this));
    	case BLACKHOLE:
    		return new Create(new Blackhole(), world.getCase(this));
    	}
    	
    	return new Colonise(this, new PlanetKryptonian());
    }
}
