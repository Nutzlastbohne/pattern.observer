package observer;

import subject.ISubject;

public class ForecastDisplay implements IObserver, IViewer {

	String forecast = "";


	public ForecastDisplay(ISubject subject) {
		subject.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Forecast: " + forecast);
	}

	@Override
	public void updateWeatherData(float temperature, float humidity, float airPressure) {
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

}
