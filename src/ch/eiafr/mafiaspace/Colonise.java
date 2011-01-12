package ch.eiafr.mafiaspace;

import java.util.Collection;
import java.util.Iterator;

public class Colonise extends Command {
    private Element dst;

    public Colonise(Element src, Element dst) {
        super(src);
        this.dst = dst;
    }

    @Override
    public void make() {
    	if(	src instanceof PlanetMartian &&	// PlanetMartian colonises empty case
    		dst instanceof PlanetMartian) {
			if(engagedFightWithKryptonian(world, world.getCase(src))) {	// Planet got destroyed
				world.removeElement(src);
			}
		}
		else if(src instanceof PlanetKryptonian	&&	// PlanetKryptonian colonises empty case
				dst instanceof PlanetKryptonian) {
			if(engagedFightWithMartian(world, world.getCase(src))) {	// Planet got destroyed
				world.removeElement(src);
			}
		}
    	
    	
		else if(src instanceof Martian &&	// Martian colonises empty position
				dst instanceof Martian) {
			if(engagedFightWithKryptonian(world, world.getCase(src))) {	//Extraterrestrials die
				world.removeElement(src);
			}
		}
		else if(src instanceof Kryptonian &&	// Kryptonian colonises empty position
				dst instanceof Kryptonian) {
			if(engagedFightWithMartian(world, world.getCase(src))) {	//Extraterrestrials die
				world.removeElement(src);
			}
		}
    	
    	
		else if(	(src instanceof Martian || src instanceof Planet) &&	// Martian colonises planet
					dst instanceof PlanetMartian) {
			if(engagedFightWithKryptonian(world, world.getCase(src))) {
				world.removeElement(src);
			}
			else {
				Case martianCase = getAroundSafeCaseForMartian(world.getCase(src));
				if(martianCase!=null)
					world.addElement(new Martian(), martianCase);
				Case planetMartianCase = world.getCase(src);
				world.removeElement(src);
				world.addElement(new PlanetMartian(), planetMartianCase);
			}
		}
		else if(	(src instanceof Kryptonian || src instanceof Planet) &&	// Kryptonian colonises planet
					dst instanceof PlanetKryptonian) {
			if(engagedFightWithMartian(world, world.getCase(src))) {
				world.removeElement(src);
			}
			else {
				Case kryptonianCase = getAroundSafeCaseForKryptonian(world.getCase(src));
				if(kryptonianCase!=null)
					world.addElement(new Kryptonian(), kryptonianCase);
				Case planetKryptonianCase = world.getCase(src);
				world.addElement(new PlanetKryptonian(), planetKryptonianCase);
			}
		}
    }
    
    private boolean engagedFightWithKryptonian(World w, Case c) {
		Collection<Case> aroundNotEmptyCases = world.getNeighbours(c);
		Iterator<Case> itr = aroundNotEmptyCases.iterator();
		boolean engagedFight = false;
		
		while(itr.hasNext()) {	// iters every not empty case around c
			Case crtCase = itr.next();
			if(	crtCase.getElement() instanceof Kryptonian ||
				crtCase.getElement() instanceof PlanetKryptonian) {
				world.removeElement(crtCase.getElement());
				engagedFight = true;
			}
		}
		return engagedFight;
	}
	
	private boolean engagedFightWithMartian(World w, Case c) {
		Collection<Case> aroundNotEmptyCases = world.getNeighbours(c);
		Iterator<Case> itr = aroundNotEmptyCases.iterator();
		boolean engagedFight = false;
		
		while(itr.hasNext()) {	// iters every not empty case around c
			Case crtCase = itr.next();
			if(	crtCase.getElement() instanceof Martian ||
				crtCase.getElement() instanceof PlanetMartian) {
				world.removeElement(crtCase.getElement());
				engagedFight = true;
			}
		}
		return engagedFight;
	}

	private Case getAroundSafeCaseForMartian(Case c) {
		Collection<Case> aroundEmptyCases = world.getPossibleMoves(c);
		Iterator<Case> itr = aroundEmptyCases.iterator();
		boolean caseIsSafe = false;
		
		while(itr.hasNext()) {	// iters every empty case around c
			Case crtCase = itr.next();
			caseIsSafe = true;
			for(Case n : world.getNeighbours(crtCase)) {	// iters every neighbour of the case
				if(	n.getElement() instanceof Kryptonian ||
					n.getElement() instanceof PlanetKryptonian) {
					caseIsSafe = false;
					break;
				}
			}
			if(caseIsSafe)
				return crtCase;
		}
		return null;
	}
	
	private Case getAroundSafeCaseForKryptonian(Case c) {
		Collection<Case> aroundEmptyCases = world.getPossibleMoves(c);
		Iterator<Case> itr = aroundEmptyCases.iterator();
		boolean caseIsSafe = false;
		
		while(itr.hasNext()) {	// iters every empty case around c
			Case crtCase = itr.next();
			caseIsSafe = true;
			for(Case n : world.getNeighbours(crtCase)) {	// iters every neighbour of the case
				if(	n.getElement() instanceof Martian ||
					n.getElement() instanceof PlanetMartian) {
					caseIsSafe = false;
					break;
				}
			}
			if(caseIsSafe)
				return crtCase;
		}
		return null;
	}
}