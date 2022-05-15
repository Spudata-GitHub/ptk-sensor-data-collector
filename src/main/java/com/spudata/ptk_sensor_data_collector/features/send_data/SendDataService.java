package com.spudata.ptk_sensor_data_collector.features.send_data;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spudata.ptk_sensor_data_collector.features.sensor_data.SensorDataDto;
import com.spudata.ptk_sensor_data_collector.features.sensors.SensorDto;
import com.spudata.ptk_sensor_data_collector.utils.ZonedDateTimeConverter;

public class SendDataService {

	private HttpClient httpClient;
	private Gson gson;

	private final String DOMAIN = "https://ptk.app.spudata.com/api/v1";
	private final String ROUTE = "sensor-data";

	public SendDataService() {
		httpClient = HttpClientBuilder.create().build();
		gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class,
				new ZonedDateTimeConverter(DateTimeFormatter.ISO_OFFSET_DATE_TIME)).create();
	}

	public SendDataAmoSendResponse send(SensorDto sensor, SensorDataDto sensorData) {
		try {

			SendDataAmoSendRequest sendRequest = new SendDataAmoSendRequest();
			sendRequest.setSensorId(sensor.getId());
			sendRequest.setCollectedAt(sensorData.getCollectedAt());
			sendRequest.setDataValue(sensorData.getDataValue());

			String requestJson = gson.toJson(sendRequest);
			System.out.println("[DEBUG] Sending Data: " + requestJson);

			HttpPost request = new HttpPost(DOMAIN + "/" + ROUTE);
			request.addHeader("test-data", "can-be-used-for-authentication");
			request.setEntity(new StringEntity(requestJson));
			HttpResponse response = httpClient.execute(request);

			// handle response here...
			// TODO Convert to object once we have the API defined and documented
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				String responseJsonString = EntityUtils.toString(entity);
				// parsing JSON
				JSONObject responseJson = new JSONObject(responseJsonString); // Convert String to JSON Object

				System.out.println("Posted sensor data with result: " + responseJson);
				return new SendDataAmoSendResponse(responseJson);
			} else {
				System.out.println("[ERROR] Sensor Data Post result is null");
				return null;
			}

		} catch (Exception ex) {
			System.out.println("[ERROR] Sensor Data Post failed");
			ex.printStackTrace();
			return null;
		}
	}

}
