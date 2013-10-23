package subject;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;

import observer.IObserver;

public class WeatherStation implements ISubject {

	HashSet<IObserver> observers;
	Random randomizer;
	float temperature;
	float humidity;
	float airPressure;
	
	public WeatherStation() {
		observers = new HashSet<IObserver>();
		randomizer = new Random();
	}
	
	private float getTemperature() {
		return 0.0f;
	}
	
	private float getHumidity() {
		return 0.0f;
	}
	
	private float getAirPressure(){
		return 0.0f;
	}
	
	public void updateData() {
		getHumidity();
		getTemperature();
		getAirPressure();
		
		notifyObersvers();
	}
	
	private float getRandomFloat(float min, float max) {
		float returnValue = randomizer.nextFloat();
		
		float range = max - min;
		float offset = min;
		
		returnValue = offset + range*returnValue;
		
		return returnValue;
	}

	@Override
	public void addObserver(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObersvers() {
		for (IObserver observer : observers) {
			observer.updateWeatherData(temperature, humidity, airPressure);
		}
	}

}
