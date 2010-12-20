package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Godfather implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/godfather.png");

    @Override
    public String getName() {
        return "Godfather";
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

        return !((MafiaCase) c).isCasino();
    }

    @Override
    public Command getCommand(Collection<Case> aNeighbors) {
        return null;
    }
}