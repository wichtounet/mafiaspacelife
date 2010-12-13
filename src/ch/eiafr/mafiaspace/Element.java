package ch.eiafr.mafiaspace;

import javax.swing.Icon;

import java.util.List;

public interface Element {
    String getName();

    Icon getIcon();

    boolean isAbleToMove(Case c);

    Command getCommand(List<Element> aNeighbors);
}