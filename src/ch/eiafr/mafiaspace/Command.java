package ch.eiafr.mafiaspace;

public abstract class Command {
    protected Element src;
    protected World world;
    
    public Command(Element src) {
    	this.src = src;
    }
    
    public void setWorld(World world) { this.world = world; }
    
    public abstract void make();
}
