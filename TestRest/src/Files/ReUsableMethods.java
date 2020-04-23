package Files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReUsableMethods {
	
	public static JsonPath rawToJson(Response res)
	{
		String resopon=res.asString();
		JsonPath x=new JsonPath(resopon);
		return x;
	}

}
