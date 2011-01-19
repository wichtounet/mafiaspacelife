package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;
import java.util.Random;

public class Cop implements Element {
    private final Icon ICON = new ImageIcon(getClass().getResource("/res/cop.png"));

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

        return c.isEmpty() && !((MafiaCase) c).isCasino();
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

            if(c.getElement() instanceof Godfather){
                Godfather godfather = (Godfather) c.getElement();

                int count = countMobster(world);

                if(count == 0){
                    return new KillGodFather(this, godfather);
                }
            }
        }

        return null;
    }

    private static int countMobster(World world) {
        int count = 0;

        for (Case[] column : world.getCases()) {
            for (Case row : column) {
                if (row.getElement() instanceof Mobster) {
                    count++;
                }
            }
        }

        return count;
    }
}