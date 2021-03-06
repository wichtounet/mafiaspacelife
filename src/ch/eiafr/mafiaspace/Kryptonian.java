package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Kryptonian implements Element {
    private final Icon ICON = new ImageIcon(getClass().getResource("/res/kryptonien.png"));
    
    protected enum Elements {NOTHING, ASTEROID, PLANET, BLACKHOLE, MARTIAN, KRYPTONIAN};
    protected Elements movedOnElement = Elements.NOTHING;

    @Override
    public String getName() {
        return "Kryptonian";
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }

    @Override
    public boolean isAbleToMove(Case c) {
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
        else if(c.getElement() instanceof PlanetKryptonian) {
        	return false;
        }
        else if(c.getElement() instanceof Planet) {
        	movedOnElement = Elements.PLANET;
        	return true;
        }
        
        return false;
    }

    @Override
    public Command getCommand(World world, Collection<Case> aNeighbors) {
    	switch(movedOnElement) {
    	case ASTEROID:
    		return new Create(new Asteroid(), world.getCase(this));
    	case BLACKHOLE:
    		return new Create(new Blackhole(), world.getCase(this));
    	case PLANET:
    		return new Colonise(this, new PlanetKryptonian());
    	}
    	
        return new Colonise(this, new Kryptonian());
    }
}