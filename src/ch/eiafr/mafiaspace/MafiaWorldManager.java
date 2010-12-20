package ch.eiafr.mafiaspace;

public class MafiaWorldManager extends WorldManager {
    @Override
    protected boolean isWorldEnded() {
       return !isGodFatherAlive() || getWorld().isFull();
    }

    private boolean isGodFatherAlive() {
        for(Case[] cases : getWorld().getCases()){
            for(Case c : cases){
                if(c.getElement() instanceof Godfather){
                    return true;
                }
            }
        }

        return false;
    }
}