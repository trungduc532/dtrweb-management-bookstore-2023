package dtr.web.management.bookshop.webapi.common;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpCommon {
	
	private String inputValue;
	
	/**
	 * Constructor
	 * @param inputValue
	 */
	public HttpCommon(String inputValue) {
		this.inputValue = inputValue;
	}
	
	/**
	 * Get A BufferedReder from the client. Read the received data and convert to string
	 * 
	 * @param reader
	 * @return
	 */
	public static HttpCommon readerInputDataFromRequest(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return new HttpCommon(sb.toString());
	}
	
	/**
	 * Mapping the received data from client to my model
	 * @param <T>
	 * @param tClass
	 * @return
	 * @throws Exception
	 */
	public <T> T toModel(Class<T> tClass) throws Exception {
			return new ObjectMapper().readValue(inputValue, tClass);
	}
}
