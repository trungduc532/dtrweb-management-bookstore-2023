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
	 * Reader data input from json file
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
	
	public <T> T toModel(Class<T> tClass) throws Exception {
			return new ObjectMapper().readValue(inputValue, tClass);
	}
}
