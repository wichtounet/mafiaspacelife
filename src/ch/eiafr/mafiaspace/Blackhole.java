package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Blackhole implements Element {
    private final Icon ICON = new ImageIcon(getClass().getResource("/res/blackhole.png"));

    @Override
    public String getName() {
        return "Blackhole";
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }

    @Override
    public boolean isAbleToMove(Case c) {
        return false;	// it doesn't move
    }

    @Override
    public Command getCommand(World world, Collection<Case> aNeighbors) {
        return null;
    }
}