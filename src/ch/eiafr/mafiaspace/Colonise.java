package ch.eiafr.mafiaspace;

public class Colonise extends Command {
    private Element dst;
	
	public Colonise(Element src, Element dst) {
		super(src);
		this.dst = dst;
	}
	
	@Override
    public void make() {
		if(src instanceof Kryptonian) {
			
		}
		else if (src instanceof Martian) {
			
		}
    }
}