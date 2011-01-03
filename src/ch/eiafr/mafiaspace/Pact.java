package ch.eiafr.mafiaspace;

public class Pact extends Command {
    private final Mobster mobster;

    public Pact(Element element, Mobster mobster) {
		super(element);
        this.mobster = mobster;
    }
	
	@Override
    public void make() {
        mobster.setTraitor(true);
    }

    @Override
    public String toString() {
        return src.getName() + " made a pact with " + mobster.getName();
    }
}