package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Asteroid implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/asteroide.png");

    private boolean isTimeToMove = true;
    private boolean hasMovedOnBlackhole = false;
    
    private Case myCase = null;
    
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
    	System.out.println("called asteroid isAbleToMove");
    	if(isTimeToMove) {
    		if(c.getElement() instanceof Blackhole)
    			hasMovedOnBlackhole = true;
    		else
    			hasMovedOnBlackhole = false;
    		
    		myCase = c;
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    @Override
    public Command getCommand(World world, Collection<Case> aNeighbors) {
    	if(!isTimeToMove) {
    		isTimeToMove = true;
    		return null;
    	}
    	
    	isTimeToMove = false;
    	if(!hasMovedOnBlackhole)
    		return null;
    	
    	return new Create(new Blackhole(), myCase);
    }
}