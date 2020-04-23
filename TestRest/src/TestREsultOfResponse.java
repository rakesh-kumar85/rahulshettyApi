import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import Files.ReUsableMethods;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestREsultOfResponse {

@Test

public void testjsonsize()
{
	RestAssured.baseURI="https://maps.googleapis.com";
    
    // All the resources that we have
    
    Response res= (Response) given().
         param("location","-33.8670522,151.1957362").
         param("radius","1500").
         param("key","AIzaSyDSNiWYH2IYvkiP9cVyhOWj_Db36rdc3Zw").log().all().
         when().
         get("/maps/api/place/nearbysearch/json").
         then().extract().response();
    
    JsonPath js= ReUsableMethods.rawToJson(res);
	   
	   int count=js.get("results.size()");
	   for(int i=0;i<count;i++)
	   {
		  String s=js.get("results["+i+"].name");
		   System.out.println(s);
	   }
	   System.out.println(count);
         
         /*assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
         header("server","scaffolding on HTTPServer2");*/
        /* body("results[0].geometry.location.lng",equalTo("151.2092955"));*/
         /*body("results[0].id",equalTo("044785c67d3ee62545861361f8173af6c02f4fae"));*/
         /* body("results[0].name",equalTo("Sydney"));*/
        /* body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
         header("x-frame-options","SAMEORIGIN");*/
}
}