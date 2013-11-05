package main;

import java.util.concurrent.CountDownLatch;

import observer.CurrentWeatherDisplay;
import observer.ForecastDisplay;
import observer.WeatherStatisticsDisplay;
import subject.WeatherStation;

public class Main {

	public static void main(String[] args) {
		WeatherStation station = new WeatherStation();
		CurrentWeatherDisplay currentWeather = new CurrentWeatherDisplay(station);
		WeatherStatisticsDisplay statistics = new WeatherStatisticsDisplay(station);
		ForecastDisplay forecast = new ForecastDisplay(station);

		station.setRandomData();
		sleep(1000);
		station.setRandomData();
		sleep(1000);
		station.setRandomData();
		sleep(1000);
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
