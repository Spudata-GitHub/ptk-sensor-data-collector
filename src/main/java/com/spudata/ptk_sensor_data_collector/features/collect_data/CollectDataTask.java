package com.spudata.ptk_sensor_data_collector.features.collect_data;

import java.time.ZonedDateTime;

import com.spudata.ptk_sensor_data_collector.features.send_data.SendDataService;
import com.spudata.ptk_sensor_data_collector.features.sensor_data.SensorDataDto;
import com.spudata.ptk_sensor_data_collector.features.sensors.SensorDto;
import com.spudata.ptk_sensor_data_collector.utils.TimeUtilities;

public class CollectDataTask implements Runnable {
	private SensorDto sensor;

	private CollectDataService collectDataService;
	private SendDataService sendDataService;

	public CollectDataTask(SensorDto sensor) {
		this.sensor = sensor;

		this.collectDataService = new CollectDataService();
		this.sendDataService = new SendDataService();
	}

	public String getSensorId() {
		return sensor.getId();
	}

	public void run() {
		try {
			ZonedDateTime nowZdt = TimeUtilities.nowZdtUtc();
			System.out.println("Collecting data for : " + sensor.getId() + " - Time - " + nowZdt.toString());

			SensorDataDto sensorData = collectDataService.collectData(sensor.getBluetoothUrl());

			sendDataService.send(sensor, sensorData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
