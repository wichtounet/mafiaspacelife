package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Blackhole implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/blackhole.png");

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
        return false;  //TODO Implement that !
    }

    @Override
    public Command getCommand(World world, Collection<Case> aNeighbors) {
        return null;
    }
}