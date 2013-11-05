package observer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import subject.WeatherStation;

public class WeatherStatisticsDisplay implements Observer, IViewer {

	ArrayList<Float> temperatureList = new ArrayList<Float>();
	public float minTemp = Float.MIN_VALUE;
	public float maxTemp = Float.MAX_VALUE;
	public float avgTemp = 0.0f;


	public WeatherStatisticsDisplay(Observable observable) {
		observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object dataStructure) {
		if (obs instanceof WeatherStation) {
			WeatherStation station = (WeatherStation) obs;
			temperatureList.add(new Float(station.getTemperature()));
			updateStatistics();
			display();
		}
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

	@Override
	public void display() {
		System.out.printf("Statistics - Min/Max/Avg: %2.1f, %2.1f, %2.1f\n", minTemp, maxTemp, avgTemp);
	}
}
