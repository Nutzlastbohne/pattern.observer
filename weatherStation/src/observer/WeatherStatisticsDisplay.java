package observer;

import java.util.ArrayList;

import subject.ISubject;

public class WeatherStatisticsDisplay implements IObserver, IViewer {

	ArrayList<Float> temperatureList = new ArrayList<Float>();

	public float minTemp = Float.MIN_VALUE;
	public float maxTemp = Float.MAX_VALUE;
	public float avgTemp = 0.0f;


	public WeatherStatisticsDisplay(ISubject subject) {
		subject.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.printf("Min/Max/Avg: %2.1f, %2.1f, %2.1f\n", minTemp, maxTemp, avgTemp);
	}

	@Override
	public void updateWeatherData(float temperature, float humidity, float airPressure) {
		temperatureList.add(new Float(temperature));
		updateStatistics();
		display();
	}

	private void updateStatistics() {
		float tempSum = 0.0f;

		if (temperatureList.size() == 1) {
			minTemp = temperatureList.get(0);
			maxTemp = temperatureList.get(0);
			avgTemp = temperatureList.get(0);
			return;
		}

		for (float tempItem : temperatureList) {
			if (tempItem < minTemp) {
				minTemp = tempItem;
			} else if (tempItem > maxTemp) {
				maxTemp = tempItem;
			}

			tempSum += tempItem;
		}

		avgTemp = tempSum / temperatureList.size();
	}

}
