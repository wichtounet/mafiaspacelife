package ch.eiafr.mafiaspace;

public abstract class WorldManager {

	public void nextTurn() {
		throw new UnsupportedOperationException();
	}

	public static void getInstance() {
		throw new UnsupportedOperationException();
	}

	public void setWorld(World aWorld) {
		throw new UnsupportedOperationException();
	}

	protected abstract boolean isWorldEnded();
}