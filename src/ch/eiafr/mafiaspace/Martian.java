package ch.eiafr.mafiaspace;

import javax.swing.Icon;

import java.util.List;

public class Martian implements Element {
    @Override
    public String getName() {
        return "Martian";
    }

    @Override
    public Icon getIcon() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAbleToMove() {
        return true;
    }

    @Override
    public int getPriority() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Command getCommand(List<Element> aNeighbors) {
        throw new UnsupportedOperationException();
    }
}