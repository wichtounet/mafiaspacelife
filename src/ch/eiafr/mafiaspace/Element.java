package ch.eiafr.mafiaspace;

import java.util.Collection;

import javax.swing.Icon;

public interface Element {
    String getName();

    Icon getIcon();

    boolean isAbleToMove(Case c);

    Command getCommand(World world, Collection<Case> aNeighbors);
}