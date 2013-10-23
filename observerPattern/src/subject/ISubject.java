package subject;

import observer.IObserver;

public interface ISubject {
	public void registerObserver(IObserver observer);
	public void deregisterObserver(IObserver observer);
	public void notifyObersvers();
}
