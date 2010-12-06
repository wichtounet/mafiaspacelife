package ch.eiafr.mafiaspace;

import java.util.List;

public interface Element {
    void getName();

    void getIcon();

    boolean isAbleToMove();

    int getPriority();

    Command getCommand(List<Element> aNeighbors);
}