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

    public void setEnded(boolean aEnded) {
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

        onlyNotEmptyCase(neighbours);

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

    public boolean addElement(Element e){
        return false;
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
            if(iterator.next().getElement() != null){
                iterator.remove();
            }
        }
    }

    private static void onlyNotEmptyCase(Collection<Case> cases) {
        Iterator<Case> iterator = cases.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getElement() == null) {
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
        System.out.printf("Move %s to %s\n", getPosition(start), getPosition(end));
        System.out.printf("-> %s to %s\n", start, end);

        swap(getPosition(start), getPosition(end));
    }

    public void removeElement(Element element) {
        Case c = getCase(element);

        System.out.printf("Remove element at %s \n", getPosition(c));

        c.setElement(null);
    }

    private Case getCase(Element element) {
        for (Case[] column : cases) {
            for (Case row : column) {
                if (row.getElement() == element) {
                    return row;
                }
            }
        }

        return null;
    }

    private void swap(Point first, Point second) {
        Case tmp = cases[first.x][first.y];
        cases[first.x][first.y] = cases[second.x][second.y];
        cases[second.x][second.y] = tmp;
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

    public void moveElement(Element element, Case c) {
        moveElement(getCase(element), c);
    }

    public Collection<Case> getNeighbours(Element element) {
        return getNeighbours(getCase(element));
    }

    public static class Park {
        private final Element element;
        private int time;
        private final int flag;

        private Park(Element element, int time, int flag) {
            super();

            this.element = element;
            this.time = time;
            this.flag = flag;
        }

        public Element getElement() {
            return element;
        }

        public int getTime() {
            return time;
        }

        public int getFlag() {
            return flag;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}