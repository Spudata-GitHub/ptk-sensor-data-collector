package com.spudata.ptk_sensor_data_collector.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimeUtilities {

	public static ZonedDateTime nowZdtUtc() {
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC")).truncatedTo(ChronoUnit.MILLIS);
		return now;
	}
}
