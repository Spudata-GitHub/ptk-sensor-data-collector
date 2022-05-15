package com.spudata.ptk_sensor_data_collector.features.send_data;

import org.json.JSONObject;

public class SendDataAmoSendResponse {

	// TODO Create real data structure
	private JSONObject responseJson;

	public SendDataAmoSendResponse(JSONObject responseJson) {
		this.responseJson = responseJson;
	}

	public JSONObject getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(JSONObject responseJson) {
		this.responseJson = responseJson;
	}

}
