package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.List;

public class Kryptonian implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/kryptonian.png");

    @Override
    public String getName() {
        return "Kryptonian";
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }

    @Override
    public boolean isAbleToMove() {
        return true;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public Command getCommand(List<Element> aNeighbors) {
        return null;
    }
}