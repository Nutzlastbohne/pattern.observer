package observer;

import java.util.Observable;
import java.util.Observer;

import subject.WeatherStation;

public class CurrentWeatherDisplay implements Observer, IViewer {

	float temperature;
	float humidity;
	float airPressure;
	Observable observable;


	public CurrentWeatherDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("-= Current Weather =-");
		System.out.printf("%2.1f°C | %3.1f%% | %1.2f pa\n", temperature, humidity, airPressure);
	}

	@Override
	public void update(Observable obs, Object dataStructure) {
		if (obs instanceof WeatherStation) {
			WeatherStation station = (WeatherStation) obs;
			temperature = station.getTemperature();
			humidity = station.getHumidity();
			airPressure = station.getAirPressure();

			display();
		}
	}

}
