package ch.eiafr.mafiaspace;

import java.util.Random;

public class PutInJail extends Command {
    private final Mobster mobster;

    public PutInJail(Element element, Mobster mobster) {
		super(element);

        this.mobster = mobster;
    }
	
	@Override
    public void make() {
        world.park(mobster, new Random().nextInt(20) + 5, 0);
    }

    @Override
    public String toString() {
        return src.getName() + " put " + mobster.getName() + " in jail";
    }
}