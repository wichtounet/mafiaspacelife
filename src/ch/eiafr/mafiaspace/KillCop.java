package ch.eiafr.mafiaspace;

public class KillCop extends Command {
    private final Cop c;

    public KillCop(Element element, Cop c) {
		super(element);

        this.c = c;
    }
	
	@Override
    public void make() {
        world.removeElement(c);
	}

    @Override
    public String toString() {
        return src.getName() + " killed cop";
    }
}