package observer;

import subject.ISubject;

public class CurrentWeatherDisplay implements IObserver, IViewer {

	float temperature;
	float humidity;
	float airPressure;
	
	public CurrentWeatherDisplay(ISubject subject){
		subject.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("-= Current Weather =-");
		System.out.printf("%2.1f°C | %3.1f | %1.2f someUnit\n" , temperature, humidity, airPressure);
	}

	@Override
	public void updateWeatherData(float temperature, float humidity, float airPressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.airPressure = airPressure;
		
		display();
	}

}
