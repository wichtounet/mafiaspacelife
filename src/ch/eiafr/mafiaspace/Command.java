package ch.eiafr.mafiaspace;

public abstract class Command {
    public Element element;
    public World world;

    public abstract void make();
    public abstract void undo();
}