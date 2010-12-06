package ch.eiafr.mafiaspace;

import javax.swing.Icon;

import java.util.List;

public class Asteroide implements Element {

    @Override
    public String getName() {
        return "Asteroide";
    }

    @Override
    public Icon getIcon() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAbleToMove() {
        return false;
    }

    @Override
    public int getPriority() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Command getCommand(List<Element> aNeighbors) {
        return null;
    }
}