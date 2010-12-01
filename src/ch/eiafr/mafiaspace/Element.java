package ch.eiafr.mafiaspace;

public interface Element {

	public void getName();

	public void getIcon();

	public boolean isAbleToMove();

	public int getPriority();

	public Command getCommand(List<Person> aNeighbors);
}