package ch.eiafr.mafiaspace;

public class Create extends Command {
    Case c;	
	
	public Create(Element element, Case c) {
		super(element);
		this.c = c;
	}
	
	@Override
    public void make() {
		if(src instanceof Martian || src instanceof Kryptonian) {
			world.get
			
		}
		else {
			c.setElement(src);
		}
    }
}