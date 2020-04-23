import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class datajsonDriven {
	
@Test
public void postDataJson()
{
	
	RestAssured.baseURI="http://216.10.245.166";
    
    // All the resources that we have
	/*Response res=given().log().params().
         param("location","-33.8670522,151.1957362").
         param("radius","1500").
         param("key","AIzaSyDSNiWYH2IYvkiP9cVyhOWj_Db36rdc3Zw").
         when().
         get("/maps/api/place/nearbysearch/json").
         then().extract().response();*/
	
	// Code for post json data through string json
	  
	Response resp=given().
			     header("Content-Type","application/json").
			     body("{\r\n" + 
			     		"\r\n" + 
			     		"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
			     		"\"isbn\":\"bczd12345789AB\",\r\n" + 
			     		"\"aisle\":\"227\",\r\n" + 
			     		"\"author\":\"John foe\"\r\n" + 
			     		"}").
			     when().
			     post("/Library/Addbook.php").
			     then().assertThat().statusCode(200).extract().response();
	
	             JsonPath js=ReUsableMethods.rawToJson(resp);
	             String inString=resp.asString();
	             System.out.println(" Response"+inString);
	             String Id=js.get("ID");
	             System.out.println(Id);
	             
	             
	            
	             
	             
			     
			     
	
         
}

}
