package ch.eiafr.mafiaspace;

public class SpaceWorldManager extends WorldManager {
    @Override
    protected boolean isWorldEnded() {
        return	isOnlyBlackHoles();
    }

    private boolean isEmpty() {
    	for (Case[] cases : getWorld().getCases()) {
            for (Case c : cases) {
                if (!c.isEmpty()) {
                	return false;
                }
            }
        }
    	return true;
    }
    
    private boolean isOnlyBlackHoles() {
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

    private boolean isOnlyAsteroid() {
        boolean asteroid = false;

        for (Case[] cases : getWorld().getCases()) {
            for (Case c : cases) {
                if (c.getElement() != null) {
                    if (c.getElement() instanceof Asteroid) {
                    	asteroid = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return asteroid;
    }
    
    private boolean isOnlyPlanetsAndMartians() {
        boolean planetsAndMartians = false;

        for (Case[] cases : getWorld().getCases()) {
            for (Case c : cases) {
                if (c.getElement() != null) {
                    if (	c.getElement() instanceof Martian ||
                    		c.getElement() instanceof PlanetMartian ||
                    		(c.getElement() instanceof Planet &&
                    		!(c.getElement() instanceof PlanetKryptonian)) ) {
                    	planetsAndMartians = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return planetsAndMartians;
    }
    
    private boolean isOnlyPlanetsAndKryptonians() {
        boolean planetsAndKryptonians = false;

        for (Case[] cases : getWorld().getCases()) {
            for (Case c : cases) {
                if (c.getElement() != null) {
                    if (	c.getElement() instanceof Kryptonian ||
                    		c.getElement() instanceof PlanetKryptonian ||
                    		(c.getElement() instanceof Planet &&
                    		!(c.getElement() instanceof PlanetMartian)) ) {
                    	planetsAndKryptonians = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return planetsAndKryptonians;
    }
    
    private boolean isOnlyPlanets() {
    	boolean planets = false;

        for (Case[] cases : getWorld().getCases()) {
            for (Case c : cases) {
                if (c.getElement() != null) {
                    if ((c.getElement() instanceof Planet &&
                    	!(c.getElement() instanceof PlanetMartian)) &&
                    	!(c.getElement() instanceof PlanetKryptonian)) {
                    	planets = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return planets;
    }
}

