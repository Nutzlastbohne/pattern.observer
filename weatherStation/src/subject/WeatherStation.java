package subject;

import java.util.HashSet;
import java.util.Observable;
import java.util.Random;

import observer.IObserver;

public class WeatherStation extends Observable {

	HashSet<IObserver> observers;
	Random randomizer;
	float temperature;
	float humidity;
	float airPressure;
	
	public WeatherStation() {
		randomizer = new Random();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getAirPressure(){
		return airPressure;
	}
	
	public void dataChanged() {
		setChanged();
		notifyObservers();
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
}
