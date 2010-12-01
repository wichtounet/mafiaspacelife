package ch.eiafr.mafiaspace;

public class Blackhole extends Element {

	public void getName() {
		throw new UnsupportedOperationException();
	}

	public void getIcon() {
		throw new UnsupportedOperationException();
	}

	public boolean isAbleToMove() {
		throw new UnsupportedOperationException();
	}

	public int getPriority() {
		throw new UnsupportedOperationException();
	}

	public Command getCommand(List<Person> aNeighbors) {
		throw new UnsupportedOperationException();
	}
}