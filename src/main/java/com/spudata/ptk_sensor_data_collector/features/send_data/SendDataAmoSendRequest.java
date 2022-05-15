package com.spudata.ptk_sensor_data_collector.features.send_data;

import java.time.ZonedDateTime;

public class SendDataAmoSendRequest {

	private String sensorId;
	private ZonedDateTime collectedAt;
	private String dataValue;

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
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
