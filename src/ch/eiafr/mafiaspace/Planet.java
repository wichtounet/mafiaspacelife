package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Planet implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/planet.png");

    private enum Elements {NOTHING, ASTEROID, PLANET, BLACKHOLE, MARTIAN, KRYPTONIAN};
    private Elements movedOnElement = Elements.NOTHING;
    private Case myCase;
    private boolean isTimeToMove = true;
    
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
    		if(c.getElement() == null) {
    			movedOnElement = Elements.NOTHING;
    			myCase = c;
    			return true;
    		}
    		else if(c.getElement() instanceof Asteroid) {
	    		movedOnElement = Elements.ASTEROID;
	    		myCase = c;
	    		return true;
	    	}
	    	else if(c.getElement() instanceof Blackhole) {
	    		movedOnElement = Elements.BLACKHOLE;
	    		myCase = c;
	    		return true;
	    	}
	    	else if(c.getElement() instanceof Martian) {
	    		movedOnElement = Elements.MARTIAN;
	    		myCase = c;
	    		return true;
	    	}
	    	else if(c.getElement() instanceof Kryptonian) {
	    		movedOnElement = Elements.KRYPTONIAN;
	    		myCase = c;
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
    		return new Create(new Asteroid(), myCase);
    	case BLACKHOLE:
    		return new Create(new Blackhole(), myCase);
    	case MARTIAN:
    		myCase.setElement(new PlanetMartian());
    		return new Create(new Martian(), myCase);
    	case KRYPTONIAN:
    		myCase.setElement(new PlanetKryptonian());
    		return new Create(new Kryptonian(), myCase);
    	}
    	
        return null;
    }
}