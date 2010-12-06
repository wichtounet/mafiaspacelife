package ch.eiafr.mafiaspace;

public abstract class Command {
    public Element _unnamed_Element_;
    public World _unnamed_World_;

    public abstract void make();
    public abstract void undo();
}