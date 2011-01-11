package ch.eiafr.mafiaspace;

import java.util.Collection;
import java.util.Iterator;

public class Create extends Command {
    Case c;	
	
	public Create(Element element, Case c) {
		super(element);
		this.c = c;
	}
	
	@Override
    public void make() {
		if(src instanceof Martian) {
			Case martianCase = getAroundSafeCaseForMartian(c);
			martianCase.setElement(src);			
		}
		else if(src instanceof Kryptonian) {
			Case kryptonianCase = getAroundSafeCaseForKryptonian(c);
			kryptonianCase.setElement(src);
		}
		else {
			c.setElement(src);
		}
    }
	
	private Case getAroundSafeCaseForMartian(Case c) {
		Collection<Case> aroundEmptyCases = world.getPossibleMoves(c);
		Iterator<Case> itr = aroundEmptyCases.iterator();
		boolean caseIsSafe = false;;
		
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
		boolean caseIsSafe = false;;
		
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


