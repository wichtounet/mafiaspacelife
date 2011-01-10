package ch.eiafr.mafiaspace;

public class ReproduceMobster extends Command {
    public ReproduceMobster(Element src) {
        super(src);
    }

    @Override
    public void make() {
        world.addElement(new Mobster());
    }

    @Override
    public String toString() {
        return "Two mobsters reproduce";
    }
}