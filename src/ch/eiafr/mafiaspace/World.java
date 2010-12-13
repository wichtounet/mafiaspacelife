package ch.eiafr.mafiaspace;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class World {
    private final Case[][] cases;
    private final Collection<WorldObserver> worldObservers = new ArrayList<WorldObserver>(5);

    private final LinkedList<Case> elementQueue = new LinkedList<Case>();

    public World(Case[][] cases) {
        super();

        this.cases = cases; //TODO COPY

        for(Case[] column : cases){
            for(Case row : column){
                if(row.getElement() != null){
                    elementQueue.add(row);
                }
            }
        }
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

    public Case getNextElement() {
        Case next = elementQueue.pop();

        elementQueue.add(next);

        return next;
    }

    public Collection<Case> getPossibleMoves(Case c) {
        Point position = getPosition(c);

        Collection<Case> neighbours = new ArrayList<Case>(8);

        if(position.x - 1 > 0){
            neighbours.add(cases[position.x - 1][position.y]);
        }

        if (position.x + 1 < cases.length) {
            neighbours.add(cases[position.x + 1][position.y]);
        }

        if (position.y - 1 > 0) {
            neighbours.add(cases[position.x - 1][position.y - 1]);
        }

        if (position.y + 1 < cases[0].length) {
            neighbours.add(cases[position.x + 1][position.y + 1]);
        }

        return neighbours;
    }

    private Point getPosition(Case c) {
        for(int i = 0; i < cases.length; i++){
            for(int j = 0; j < cases[i].length; j++){
                if(cases[i][j] == c){
                    return new Point(i, j);
                }
            }
        }

        return null;
    }
}