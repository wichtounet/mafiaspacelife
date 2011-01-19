package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Asteroid implements Element {
    private final Icon ICON = new ImageIcon(getClass().getResource("/res/asteroid.png"));

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
        return false;  //TODO Implement that !
    }

    @Override
    public Command getCommand(World world, Collection<Case> aNeighbors) {
        return null;
    }
}