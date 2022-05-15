package com.spudata.ptk_sensor_data_collector.features.sensor_data;

import java.time.ZonedDateTime;

public class SensorDataDto {

	private ZonedDateTime collectedAt;
	private String dataValue;

	public SensorDataDto() {
	}

	public SensorDataDto(ZonedDateTime collectedAt, String dataValue) {
		super();
		this.collectedAt = collectedAt;
		this.dataValue = dataValue;
	}

	public ZonedDateTime getCollectedAt() {
		return collectedAt;
	}

	public void setCollectedAt(ZonedDateTime collectedAt) {
		this.collectedAt = collectedAt;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

}
