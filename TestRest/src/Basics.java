import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class Basics {
    
	@Test
	public void test1() {
		// TODO Auto-generated method stub
	// Base Url or Host	
		
	 String s="044785c67d3ee62545861361f8173af6c02f4fae";
     RestAssured.baseURI="https://maps.googleapis.com";
     
     // All the resources that we have
     
     Response res=given().log().params().
          param("location","-33.8670522,151.1957362").
          param("radius","1500").
          param("key","AIzaSyDSNiWYH2IYvkiP9cVyhOWj_Db36rdc3Zw").
          when().
          get("/maps/api/place/nearbysearch/json").
          then().extract().response();
          
         /* assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
          header("server","scaffolding on HTTPServer2");*/
         /* body("results[0].geometry.location.lng",equalTo("151.2092955"));*/
          /*body("results[0].id",equalTo("044785c67d3ee62545861361f8173af6c02f4fae"));*/
          /* body("results[0].name",equalTo("Sydney"));*/
         /* body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
          header("x-frame-options","SAMEORIGIN");*/
          
	}

}
