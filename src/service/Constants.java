package service;

public class Constants {
	public static final String MONGO_URI = "mongodb://crime_UCI:nocrime123@ds025439.mlab.com:25439/speech_db";
	public static final String MONGO_DB = "speech_db";
	public static final String SPEECH_COLLECTION = "speech_data";

	//Server Response Codes
	public static final String SUCCESS = "200";
	public static final String SERVER_ERROR = "500";
	public static final String CLIENT_ERROR = "600";
	public static final String JSON_PARSE_ERROR = "610";

	public static final String WATSON_ENDPOINT = "https://stream.watsonplatform.net/speech-to-text/api";
	public static final String WATSON_POST_ENDPOINT = "https://stream.watsonplatform.net/speech-to-text/api/v1/recognize?timestamps=true&word_alternatives_threshold=0.9&continuous=true";
	public static final String WATSON_USERNAME = "302e0357-3b91-4163-b84f-6173974b30ce";
	public static final String WATSON_PASSWD = "bttnEhrXL5Qj";
	public static final String WATSON_CREDENTIALS = "Basic MzAyZTAzNTctM2I5MS00MTYzLWI4NGYtNjE3Mzk3NGIzMGNlOmJ0dG5FaHJYTDVRag==";
	public static final String AUDIO_FILE = "sample.wav";
}
