package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Asteroid implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/asteroide.png");

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
    public Command getCommand(Collection<Case> aNeighbors) {
        return null;
    }
}