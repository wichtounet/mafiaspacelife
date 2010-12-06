package ch.eiafr.mafiaspace;

import java.util.ArrayList;
import java.util.Collection;

public class World {
    private final Case[][] cases;
    private final Collection<WorldObserver> worldObservers = new ArrayList<WorldObserver>(5);

    public World(Case[][] cases) {
        super();

        this.cases = cases;
    }

    public Case[][] getCases() {
        return cases;
    }

    public void addObserver(WorldObserver observer) {
        worldObservers.add(observer);
    }

    public void removeObserver(WorldObserver observer) {
        worldObservers.remove(observer);
    }

    public void setEnded(boolean aEnded) {
        for(WorldObserver observer : worldObservers){
            observer.worldEnded();
        }
    }
}