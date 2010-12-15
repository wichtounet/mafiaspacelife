package ch.eiafr.mafiaspace;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class World {
    
    private final Case[][] cases;
    private final String type;
    private final Collection<WorldObserver> worldObservers = new ArrayList<WorldObserver>(5);

    private final LinkedList<Case> elementQueue = new LinkedList<Case>();

    public World(Case[][] cases, String type) {
        super();

        this.cases = cases; //TODO COPY
        this.type = type;

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
    
    public String getType() {
        return type;
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
        Collection<Case> neighbours = getAllNeighbours(getPosition(c));

        onlyEmptyCase(neighbours);

        return neighbours;
    }

    public Collection<Case> getNeighbours(Case c){
        Collection<Case> neighbours = getAllNeighbours(getPosition(c));

        onlyNotEmptyCase(neighbours);

        return neighbours;
    }

    private Collection<Case> getAllNeighbours(Point position) {
        Collection<Case> neighbours = new ArrayList<Case>(8);

        if(position.x - 1 > 0){
            neighbours.add(cases[position.x - 1][position.y]);

            if (position.y - 1 > 0) {
                neighbours.add(cases[position.x - 1][position.y - 1]);
            }

            if (position.y + 1 < cases[0].length) {
                neighbours.add(cases[position.x - 1][position.y + 1]);
            }
        }

        if (position.x + 1 < cases.length) {
            neighbours.add(cases[position.x + 1][position.y]);

            if (position.y - 1 > 0) {
                neighbours.add(cases[position.x + 1][position.y - 1]);
            }

            if (position.y + 1 < cases[0].length) {
                neighbours.add(cases[position.x + 1][position.y + 1]);
            }
        }

        if (position.y - 1 > 0) {
            neighbours.add(cases[position.x][position.y - 1]);
        }

        if (position.y + 1 < cases[0].length) {
            neighbours.add(cases[position.x][position.y + 1]);
        }

        return neighbours;
    }

    private static void onlyEmptyCase(Collection<Case> cases) {
        Iterator<Case> iterator = cases.iterator();

        while (iterator.hasNext()) {
            if(iterator.next().getElement() == null){
                iterator.remove();
            }
        }
    }

    private static void onlyNotEmptyCase(Collection<Case> cases) {
        Iterator<Case> iterator = cases.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getElement() != null) {
                iterator.remove();
            }
        }
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

    public void moveElement(Case start, Case end) {
        //TODO Move element from start to end
    }

    public void endTurn() {
        for(WorldObserver observer : worldObservers){
            observer.worldChanged();
        }
    }
}