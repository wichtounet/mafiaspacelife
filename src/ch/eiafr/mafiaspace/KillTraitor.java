package ch.eiafr.mafiaspace;

public class KillTraitor extends Command {
    private final Mobster mobster;

    public KillTraitor(Element element, Mobster mobster) {
		super(element);

        this.mobster = mobster;
    }
	
	@Override
    public void make() {
        world.removeElement(mobster);
    }

    @Override
    public String toString() {
        return src.toString() + " killed traitor";
    }
}