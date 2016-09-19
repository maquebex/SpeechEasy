package service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class WebService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(){
		return "hello";
	}

	@GET @Path("/text_to_speech")
	@Produces(MediaType.TEXT_PLAIN)
	public String testEndPoint(){
		System.out.println("call made");
		ClassLoader classLoader = getClass().getClassLoader();
		File audio = new File(classLoader.getResource(Constants.AUDIO_FILE).getFile());
		String jsonResponse = new HTTPConnector().doPost(audio);
		return jsonResponse;
	}

	/*@POST
	@Path("/speech_recog")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String textToSpeech(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail){
		String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();
		writeToFile(uploadedInputStream, uploadedFileLocation);
		File audio = new File(uploadedFileLocation);
		String jsonResponse = new HTTPConnector().doPost(audio);
		return jsonResponse;
	}
*/
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			//out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
