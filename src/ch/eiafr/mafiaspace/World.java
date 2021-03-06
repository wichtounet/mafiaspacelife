package ch.eiafr.mafiaspace;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Defines the world, aka a matrix of cases and other
 * global informations about the world
 */
public class World {
    
    private final Case[][] cases;
    private final String type;
    private final Collection<WorldObserver> worldObservers = new ArrayList<WorldObserver>(5);

    private final LinkedList<Element> elementQueue = new LinkedList<Element>();

    private final Collection<Park> parking = new ArrayList<Park>(5);

    public World(Case[][] cases, String type) {
        super();

        this.cases = cases; //TODO COPY
        this.type = type;

        for(Case[] column : cases){
            for(Case row : column){
                if(row.getElement() != null){
                    elementQueue.add(row.getElement());
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

    public void setEnded() {
        for(WorldObserver observer : worldObservers){
            observer.worldEnded();
        }
    }

    public Element getNextElement() {
        Element next = elementQueue.pop();

        elementQueue.add(next);

        return next;
    }

    public Collection<Case> getPossibleMoves(Element element) {
        return getPossibleMoves(getCase(element));
    }

    public Collection<Case> getPossibleMoves(Case c) {
        Collection<Case> neighbours = getAllNeighbours(getPosition(c));

        onlyEmptyCase(neighbours);

        return neighbours;
    }

    public Collection<Case> getNeighbours(Case c){
        Collection<Case> neighbours = getAllNeighbours(getPosition(c));

        return neighbours;
    }

    public void park(Element e, int time, int flag){
        System.out.printf("Park %s for %s turns\n", e, time);

        parking.add(new Park(e, time, flag));

        removeElement(e);
    }

    public Collection<Park> getParking() {
        return parking;
    }

    public boolean addElement(Element e, Case c){
    	if(!c.isEmpty())
    		return false;
    	c.setElement(e);
    	elementQueue.add(e);
        return true;
    }
    
    public boolean addElement(Element e){
        for (Case[] row : cases) {
            for (Case cell : row) {
                if (cell.getElement() == null) {
                    cell.setElement(e);

                    System.out.println("Add element %s" + e.getName());

                    elementQueue.add(e);
                    
                    return true;
                }
            }
        }

        return false;
    }

    private Collection<Case> getAllNeighbours(Point position) {
        Collection<Case> neighbours = new ArrayList<Case>(8);

        if(position.x - 1 >= 0){
            neighbours.add(cases[position.x - 1][position.y]);

            if (position.y - 1 >= 0) {
                neighbours.add(cases[position.x - 1][position.y - 1]);
            }

            if (position.y + 1 < cases[0].length) {
                neighbours.add(cases[position.x - 1][position.y + 1]);
            }
        }

        if (position.x + 1 < cases.length) {
            neighbours.add(cases[position.x + 1][position.y]);

            if (position.y - 1 >= 0) {
                neighbours.add(cases[position.x + 1][position.y - 1]);
            }

            if (position.y + 1 < cases[0].length) {
                neighbours.add(cases[position.x + 1][position.y + 1]);
            }
        }

        if (position.y - 1 >= 0) {
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
            if(iterator.next().getElement() != null){
                iterator.remove();
            }
        }
    }

    /*private static void onlyNotEmptyCase(Collection<Case> cases) {
        Iterator<Case> iterator = cases.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getElement() == null) {
                iterator.remove();
            }
        }
    }*/

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

    public void removeElement(Element element) {
        Case c = getCase(element);

        System.out.printf("Remove element (%s) at %s \n", element.getName(), getPosition(c));

        c.setElement(null);

        elementQueue.remove(element);
    }

    public Case getCase(Element element) {
        for (Case[] column : cases) {
            for (Case row : column) {
                if (row.getElement() == element) {
                    return row;
                }
            }
        }

        return null;
    }


    public void endTurn() {
        for(WorldObserver observer : worldObservers){
            observer.worldChanged();
        }
    }

    public boolean isFull() {
        for (Case[] column : cases) {
            for (Case row : column) {
                if (row.getElement() == null) {
                    return false;
                }
            }
        }

        return true;
    }

    public void moveElement(Element element, Case end) {
        Case start = getCase(element);

        System.out.printf("Move %s (%s) to %s (%s)\n", start, getPosition(start), end, getPosition(end));

        if(!end.isEmpty()){
            removeElement(end.getElement());
        }

        end.setElement(start.getElement());
        start.setElement(null);
    }

    public Collection<Case> getNeighbours(Element element) {
        return getNeighbours(getCase(element));
    }

}