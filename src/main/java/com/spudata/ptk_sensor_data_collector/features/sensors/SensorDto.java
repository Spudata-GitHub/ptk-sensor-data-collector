package com.spudata.ptk_sensor_data_collector.features.sensors;

public class SensorDto {

	private String id;
	private String name;
	private String bluetoothMac;

	public SensorDto(String id, String name, String bluetoothMac) {
		super();
		this.id = id;
		this.name = name;
		this.bluetoothMac = bluetoothMac;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBluetoothMac() {
		return bluetoothMac;
	}

	public void setBluetoothMac(String bluetoothMac) {
		this.bluetoothMac = bluetoothMac;
	}

	public String getBluetoothUrl() {
		return "btspp://" + bluetoothMac + ":1;authenticate=true;encrypt=true;master=false";
	}

}
