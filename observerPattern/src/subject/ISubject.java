package subject;

import observer.IObserver;

public interface ISubject {
	public void addObserver(IObserver observer);
	public void removeObserver(IObserver observer);
	public void notifyObersvers();
}
