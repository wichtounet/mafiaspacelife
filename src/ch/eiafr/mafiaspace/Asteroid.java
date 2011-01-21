package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Asteroid implements Element {
    private final Icon ICON = new ImageIcon(getClass().getResource("/res/asteroid.png"));

    protected enum Elements {NOTHING, ASTEROID, PLANET, PLANETMARTIAN, PLANETKRYPTONIAN, BLACKHOLE, MARTIAN, KRYPTONIAN};
    protected Elements movedOnElement = Elements.NOTHING;
    protected boolean isTimeToMove = true;
    
    @Override
    public String getName() {
        return "Asteroid";
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
	    	else if(c.getElement() instanceof PlanetMartian) {
	    		movedOnElement = Elements.PLANETMARTIAN;
	    		return true;
	    	}
	    	else if(c.getElement() instanceof PlanetKryptonian) {
	    		movedOnElement = Elements.PLANETKRYPTONIAN;
	    		return true;
	    	}
	    	else if(c.getElement() instanceof Planet) {
	    		movedOnElement = Elements.PLANET;
	    		return true;
	    	}
	    	else if(c.getElement() instanceof Martian) {
	    		movedOnElement = Elements.MARTIAN;
	    		return true;
	    	}
	    	else if(c.getElement() instanceof Kryptonian) {
	    		movedOnElement = Elements.KRYPTONIAN;
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
    		return new Destroy(this);
    	case BLACKHOLE:
    		return new Create(new Blackhole(), world.getCase(this));
    	}
    	
    	return null;
    }
}