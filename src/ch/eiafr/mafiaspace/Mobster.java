package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Mobster implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/mobster.png");

    private boolean traitor;

    public boolean isTraitor() {
        return traitor;
    }

    @Override
    public String getName() {
        return "Mobster";
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }

    @Override
    public boolean isAbleToMove(Case c) {
        if (!(c instanceof MafiaCase)) {
            throw new IllegalArgumentException("Case not of good type");
        }

        return true;
    }

    @Override
    public Command getCommand(World world, Collection<Case> aNeighbors) {
        return null;
    }
}