package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.List;

public class Planet implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/planet.png");

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
        return false;  //TODO Implement that !
    }

    @Override
    public Command getCommand(List<Element> aNeighbors) {
        return null;
    }
}