import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Test12 {
	/*@Test
	public void test123()
	{
		String b = "{\r\n" +
                "    \"location\":{\r\n" +
                "        \"lat\" : -38.383494,\r\n" +
                "        \"lng\" : 33.427362\r\n" +
                "    },\r\n" +
                "    \"accuracy\":50,\r\n" +
                "    \"name\":\"Frontline house\",\r\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\r\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\r\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\r\n" +
                "    \"website\" : \"http://google.com\",\r\n" +
                "    \"language\" : \"French-IN\"\r\n" +
                "}";
		
		String b ="{\r\n" + 
				"\r\n" + 
				"    \"location\":{\r\n" + 
				"\r\n" + 
				"        \"lat\" : -38.383494,\r\n" + 
				"\r\n" + 
				"        \"lng\" : 33.427362\r\n" + 
				"\r\n" + 
				"    },\r\n" + 
				"\r\n" + 
				"    \"accuracy\":50,\r\n" + 
				"\r\n" + 
				"    \"name\":\"Frontline house\",\r\n" + 
				"\r\n" + 
				"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
				"\r\n" + 
				"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
				"\r\n" + 
				"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
				"\r\n" + 
				"    \"website\" : \"http://google.com\",\r\n" + 
				"\r\n" + 
				"    \"language\" : \"French-IN\"\r\n" + 
				"\r\n" + 
				"}";

	RestAssured.baseURI="http://216.10.245.166";
	Response res=given().
	queryParam("key","qaclick123").
	body(b).
	when().
	post("/maps/api/place/add/json").
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	extract().response();
	String responseString = res.asString();
    System.out.println(responseString);
    
    JsonPath js = new JsonPath(responseString);
    String place_id = js.get("place_id");
    System.out.println("============================================");
    System.out.println("Place id=>"+place_id);
	.and().contentType(ContentType.JSON).and()
	.body("status",equalTo("ok")).
	extract().response();
	String responseString = res.asString();
    System.out.println(responseString);
    JsonPath js = new JsonPath(responseString);
    js.get("place_id");

    String place_id = js.get("place_id");
    System.out.println(place_id);
	


	
	}*/
	
	@Test
	public void test1235()
	{
		/*String b = "{\r\n" +
                "    \"location\":{\r\n" +
                "        \"lat\" : -38.383494,\r\n" +
                "        \"lng\" : 33.427362\r\n" +
                "    },\r\n" +
                "    \"accuracy\":50,\r\n" +
                "    \"name\":\"Frontline house\",\r\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\r\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\r\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\r\n" +
                "    \"website\" : \"http://google.com\",\r\n" +
                "    \"language\" : \"French-IN\"\r\n" +
                "}";*/
		
		String b ="{\r\n" + 
				"\"place_id\":\"63b8be82275a496cbda63eb365ad1b2a\"          \r\n" + 
				"}";

	RestAssured.baseURI="http://216.10.245.166";
	Response res=given().
	queryParam("key","qaclick123").
	body(b).
	when().
	post("/maps/api/place/delete/json").
	then()./*assertThat().statusCode(200).*/and().contentType(ContentType.JSON).and()./*body("status",equalTo("ok")).*/
	extract().response();
	String responseString = res.asString();
    System.out.println(responseString);
    
    JsonPath js = new JsonPath(responseString);
    String sts = js.get("status");
    System.out.println("============================================");
    System.out.println("status"+sts);
	/*.and().contentType(ContentType.JSON).and()
	.body("status",equalTo("ok")).
	extract().response();
	String responseString = res.asString();
    System.out.println(responseString);
    JsonPath js = new JsonPath(responseString);
    js.get("place_id");

    String place_id = js.get("place_id");
    System.out.println(place_id);
	
*/

	
	}
	

}
