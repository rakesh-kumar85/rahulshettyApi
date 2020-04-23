import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Files.Payload;
import Files.ReUsableMethods;
import Files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test3 {
	
	Properties prop=new Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("./src/Files/env.properties");
		prop.load(fis);
		//prop.get("HOST");
	}
   
	@Test
	public void test124()
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

	RestAssured.baseURI=prop.getProperty("HOSTDELETE");
	Response res=given().
	queryParam("key",prop.getProperty("KEYDELETE")).
	body(Payload.getData()).
	when().
	post(Resources.postData()).
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	extract().response();
	String responseString = res.asString();
    System.out.println(" Add response "+responseString);
    
    //JsonPath js = new JsonPath(responseString);
    JsonPath js=ReUsableMethods.rawToJson(res);
    String placeid = js.get("place_id");
    System.out.println("============================================");
    System.out.println("Place id=>"+placeid);
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
    String deljson="{"+ 
    		"\"place_id\":\""+placeid+"\"" + 
    		"}";
    
   Response res1= given().
    queryParam("key",prop.getProperty("KEYDELETE")).
	body(deljson).
	when().
	post(Resources.postDeleteData()).
	then().assertThat().statusCode(200).
	extract().response();
   String resdelete=res1.asString();
   System.out.println(" Response of delete request->>>>>>>>>"+resdelete);
	}
	

}
