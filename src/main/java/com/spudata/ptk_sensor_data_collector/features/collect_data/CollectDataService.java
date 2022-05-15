package com.spudata.ptk_sensor_data_collector.features.collect_data;

import com.spudata.ptk_sensor_data_collector.features.sensor_data.SensorDataDto;
import com.spudata.ptk_sensor_data_collector.utils.TimeUtilities;

public class CollectDataService {

	public SensorDataDto collectData(String bluetoothUrl) {
		// TODO Actually collect data
		
		SensorDataDto collectedData = new SensorDataDto();
		collectedData.setCollectedAt(TimeUtilities.nowZdtUtc());
		collectedData.setDataValue("fakeDataValue");
		
		return collectedData;
	}

}
