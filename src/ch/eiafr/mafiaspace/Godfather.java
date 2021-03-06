package ch.eiafr.mafiaspace;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.Collection;

public class Godfather implements Element {
    private final Icon ICON = new ImageIcon(getClass().getResource("/res/godfather.png"));

    @Override
    public String getName() {
        return "Godfather";
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }

    @Override
    public boolean isAbleToMove(Case c) {
        if (!(c instanceof MafiaCase)) {
            throw new IllegalArgumentException("Case not of good type");
        }

        return c.isEmpty() && !((MafiaCase) c).isCasino();
    }

    @Override
    public Command getCommand(World world, Collection<Case> neighbors) {
        for(Case c : neighbors){
            if(c.getElement() instanceof Cop){
                return new KillCop(this, (Cop) c.getElement());
            }

            if(c.getElement() instanceof Mobster){
                Mobster mobster = (Mobster) c.getElement();

                if(mobster.isTraitor()){
                    return new KillTraitor(this, mobster);
                }
            }
        }

        return null;
    }
}