
/*
 * Name: Samuel Hernandez
 * Date: 05/07/2021
 * Course Number:CSC-112
 * Course Name: Intermediate Java 
 * Email:sguzmanhernandez0001@student.stcc.edu
 * Short Description of the Problem: A GEOLocationApp using JSON and API
 */
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.scene.control.TextArea;

public class APIConnection {
	private static final String API_KEY = "7fd9ad0c81b24bba9ddff4084f2c21fb";
	private final static String BASE_URL = "https://api.ipgeolocation.io/ipgeo?apiKey=";

	public APIConnection(TextArea tfStatus, String Ip) throws IOException, ParseException {

		String url = BASE_URL + API_KEY + "&ip=" + Ip;
		var connection = new URL(url).openConnection();
		String data = "";

		try (Scanner in = new Scanner((connection.getInputStream()));) {
			data = in.nextLine();
		} catch (Exception e) {

		}

		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(data);
		var city = object.get("city");
		var state_prov = object.get("state_prov");
		var country_name = object.get("country_name");
		var zipcode = object.get("zipcode");
		var longitude = object.get("longitude");
		var latitude = object.get("latitude");

		JSONObject time_zoneObject = (JSONObject) object.get("time_zone");
		var time_zone_name = time_zoneObject.get("name");
		var time_zone_offset = time_zoneObject.get("offset");
		tfStatus.appendText("city=" + city + "\n");
		tfStatus.appendText("state_prov=" + state_prov + "\n");
		tfStatus.appendText("country_name=" + country_name + "\n");
		tfStatus.appendText("zipcode=" + zipcode + "\n");
		tfStatus.appendText("longitude=" + longitude + "\n");
		tfStatus.appendText("latitude=" + latitude + "\n");
		tfStatus.appendText("time_zone_name=" + time_zone_name + "\n");
		tfStatus.appendText("time_zone_offset=" + time_zone_offset + "\n");

	}
}
