package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.List;

public class Cop implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/cop.png");

    @Override
    public String getName() {
        return "Cop";
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