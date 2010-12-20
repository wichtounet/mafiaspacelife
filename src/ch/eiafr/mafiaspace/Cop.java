package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;
import java.util.Random;

public class Cop implements Element {
    private static final Icon ICON = new ImageIcon("ch/eiafr/mafiaspace/icons/cop.png");

    @Override
    public String getName() {
        return "Cop";
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }

    @Override
    public boolean isAbleToMove(Case c) {
        if(!(c instanceof MafiaCase)){
            throw new IllegalArgumentException("Case not of good type");
        }

        return !((MafiaCase) c).isCasino();
    }

    @Override
    public Command getCommand(World world, Collection<Case> neighbors) {
        for (Case c : neighbors) {
            if (c.getElement() instanceof Mobster) {
                Mobster mobster = (Mobster) c.getElement();

                if (!mobster.isTraitor()) {
                    return new Random().nextBoolean() ? new PutInJail(this, mobster) : new Pact(this, mobster);
                }
            }

            //TODO Manage godfather
        }

        return null;
    }
}