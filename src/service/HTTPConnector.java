package service;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HTTPConnector {

	public String doPost(File audioFile){
		String responseBody="";
		OkHttpClient client = new OkHttpClient();
		try {
			Request request = new Request.Builder()
			.url(Constants.WATSON_POST_ENDPOINT)
			.post(RequestBody.create(MediaType.parse("audio/wav"),audioFile))		  
			.addHeader("authorization", Constants.WATSON_CREDENTIALS)
			.addHeader("cache-control", "no-cache")		  
			.build();

			Response response = client.newCall(request).execute();
			responseBody = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseBody;
	}
}
