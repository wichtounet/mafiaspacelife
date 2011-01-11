package ch.eiafr.mafiaspace;

public class SpaceWorldManager extends WorldManager {
    @Override
    protected boolean isWorldEnded() {
        return isOnlyBlackHole() || getWorld().isFull();
    }

    private boolean isOnlyBlackHole() {
        boolean blackHole = false;

        for (Case[] cases : getWorld().getCases()) {
            for (Case c : cases) {
                if (c.getElement() != null) {
                    if (c.getElement() instanceof Blackhole) {
                        blackHole = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return blackHole;
    }
}