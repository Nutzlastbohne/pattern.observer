package subject;

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
		return temperature;
	}
	
	private float getHumidity() {
		return humidity;
	}
	
	private float getAirPressure(){
		return airPressure;
	}
	
	public void dataChanged() {
		notifyObersvers();
	}
	
	public void setData(float temperature, float humidity, float airPressure){
		
		this.temperature = temperature;
		this.humidity = humidity;
		this.airPressure = airPressure;
		
		dataChanged();
	}
	
	public void setRandomData(){
		setData(getRandomFloat(-20.3f, 43.8f), 
				getRandomFloat(0.0f, 150.4f), 
				getRandomFloat(0.5f, 1.9f));
		
	}
	
	private float getRandomFloat(float min, float max) {
		float randomFloat = randomizer.nextFloat();
		float range = max - min;
		float offset = min;
		
		return offset + range*randomFloat;
	}

	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void deregisterObserver(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObersvers() {
		for (IObserver observer : observers) {
			observer.updateWeatherData(getTemperature(), getHumidity(), getAirPressure());
		}
	}
}
