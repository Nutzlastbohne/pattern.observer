package main;

import java.util.concurrent.CountDownLatch;

import observer.CurrentWeatherDisplay;
import subject.WeatherStation;

public class Main {

	public static void main(String[] args) {
		WeatherStation station = new WeatherStation();
		CurrentWeatherDisplay currentWeather = new CurrentWeatherDisplay(station);
		
		station.setRandomData();
		sleep(1000);
		station.setRandomData();
		sleep(1000);
		station.setRandomData();
		sleep(1000);
	}
	
	private static void sleep(long millis){		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
