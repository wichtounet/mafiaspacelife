package ch.eiafr.mafiaspace;

public class KillGodFather extends Command {
    private final Godfather c;
    
	public KillGodFather(Element element, Godfather c) {
        super(element);

        this.c = c;
	}

    @Override
    public void make() {
        world.removeElement(c);
    }

    @Override
    public String toString() {
        return src.getName() + " killed godfather";
    }
}