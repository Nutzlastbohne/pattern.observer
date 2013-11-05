package observer;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, IViewer {

	String forecast = "";


	public ForecastDisplay(Observable observable) {
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		generateForecast();
		display();
	}

	private void generateForecast() {
		Double randomNumber = Math.random();

		if (randomNumber <= 0.33) {
			forecast = "Sunny days be upon us!";
		} else if (randomNumber < 0.66) {
			forecast = "Plants be happy 'bout som rain";
		} else {
			forecast = "Goat guts where unavailable during the creation of this forecast";
		}
	}

	@Override
	public void display() {
		System.out.println("Forecast: " + forecast);
	}
}
