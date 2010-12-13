package ch.eiafr.mafiaspace;

public abstract class Command {
    private Element element;
    private World world;
    
    public Command(Element element, World world) {
    	this.element = element;
    	this.world = world;
    }
    public abstract void make();
}