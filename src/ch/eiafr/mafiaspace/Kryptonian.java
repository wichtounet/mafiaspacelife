package ch.eiafr.mafiaspace;

import javax.swing.Icon;

import java.util.List;

public class Kryptonian implements Element {

    @Override
    public String getName() {
        return "Kryptonian";
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