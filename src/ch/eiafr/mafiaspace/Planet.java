package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Planet implements Element {
    private final Icon ICON = new ImageIcon(getClass().getResource("/res/planet.png"));

    protected enum Elements {NOTHING, ASTEROID, PLANET, BLACKHOLE, MARTIAN, KRYPTONIAN};
    protected Elements movedOnElement = Elements.NOTHING;
    protected boolean isTimeToMove = true;
    
    @Override
    public String getName() {
        return "Planet";
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
    		return new Create(new Asteroid(), world.getCase(this));
    	case BLACKHOLE:
    		return new Create(new Blackhole(), world.getCase(this));
    	case MARTIAN:
    		return new Colonise(this, new PlanetMartian());
    	case KRYPTONIAN:
    		return new Colonise(this, new PlanetKryptonian());
    	}
    	
        return null;
    }
}