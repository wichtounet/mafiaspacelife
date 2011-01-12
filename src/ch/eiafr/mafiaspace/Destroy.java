package ch.eiafr.mafiaspace;

public class Destroy extends Command {
	
	public Destroy(Element element) {
		super(element);
	}
	
    @Override
    public void make() {
        world.getCase(src).setElement(null);
    }
}