package com.spudata.ptk_sensor_data_collector.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.spudata.ptk_sensor_data_collector.features.collect_data.CollectDataTask;
import com.spudata.ptk_sensor_data_collector.features.sensors.SensorDto;

public class PtkSensorDataCollectorApplication {

	/**
	 * Starts the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Started app");

		List<SensorDto> sensors = getSensors();
		List<CollectDataTask> tasks = getCollectDataTasks(sensors);

		// Timer
		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		for (CollectDataTask collectDataTask : tasks) {
//			executorService.scheduleAtFixedRate(collectDataTask, 0, 600, TimeUnit.SECONDS);
			executorService.scheduleAtFixedRate(collectDataTask, 0, 5, TimeUnit.SECONDS);
		}

		try { // Shutdown after stop or 7 days for docker to restart
//			executorService.awaitTermination(7, TimeUnit.DAYS);
			executorService.awaitTermination(30, TimeUnit.SECONDS);
			System.out.println("All threads stopped or time limit has been reached. Shutting down.");
		} catch (InterruptedException e) {
			System.out.println("An error occured awaiting termination.");
			e.printStackTrace();
		}

		executorService.shutdown();
	}

	private static List<SensorDto> getSensors() {
		List<SensorDto> sensors = new ArrayList<SensorDto>();

		/**
		 * Node URLs are initialized to create a Node URL copy: "btspp://<YOUR BT
		 * MAC>:1;authenticate=true;encrypt=true;master=false" and replace <YOUR BT MAC>
		 * with the MAC address of your Bluetooth module minus the dashes or spaces
		 * Refrence the code below to double check your work
		 */

//		sensors.add(new SensorDto("rp01-01", "humidity", ""));
//		sensors.add(new SensorDto("rp01-01", "carbon-dioxide", ""));
//		sensors.add(new SensorDto("rp01-01", "ph-level", ""));
//		sensors.add(new SensorDto("rp01-01", "water", ""));
//		sensors.add(new SensorDto("rp01-01", "heat-index", ""));
		sensors.add(new SensorDto("a01-01", "temperature", "000666D0E48B"));
		sensors.add(new SensorDto("a02-01", "temperature", "000666D0E8C4"));
		sensors.add(new SensorDto("a03-01", "temperature", "000666D0E433"));

		return sensors;
	}

	private static List<CollectDataTask> getCollectDataTasks(List<SensorDto> sensors) {
		List<CollectDataTask> tasks = new ArrayList<CollectDataTask>();

		for (SensorDto sensor : sensors) {
			tasks.add(new CollectDataTask(sensor));
		}
		return tasks;
	}
}
