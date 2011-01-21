package ch.eiafr.mafiaspace;

public class Create extends Command {
    Case c;	
	
	public Create(Element element, Case c) {
		super(element);
		this.c = c;
	}
	
	@Override
    public void make() {
		if(!c.isEmpty())
			world.removeElement(c.getElement());
		world.addElement(src, c);
    }
}


