package ch.eiafr.mafiaspace;

public class KillCop extends Command {
    private final Element c;

    public KillCop(Element element, Element c) {
		super(element);

        this.c = c;
    }
	
	@Override
    public void make() {
        world.removeElement(c);
	}

    @Override
    public String toString() {
        return src.toString() + " killed cop";
    }
}