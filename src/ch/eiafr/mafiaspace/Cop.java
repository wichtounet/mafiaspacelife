package ch.eiafr.mafiaspace;

import java.util.List;

public class Cop implements Element {

    @Override
    public void getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getIcon() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAbleToMove() {
        throw new UnsupportedOperationException();
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