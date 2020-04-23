import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Basic4 {
	
	Properties prop=new  Properties();
	@BeforeTest
	public void beginTest() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("./src/Files/env.properties");
		prop.load(fis);
		
	}
	
	@Test
	public void test1() {
		// TODO Auto-generated method stub
	// Base Url or Host	
		
	 String s="044785c67d3ee62545861361f8173af6c02f4fae";
     RestAssured.baseURI=prop.getProperty("HOST");
     
     // All the resources that we have
     
     Response res= given().
          param("location","-33.8670522,151.1957362").
          param("radius","1500").
         /* param("key","AIzaSyDSNiWYH2IYvkiP9cVyhOWjDb36rdc3Zw").*/
          param("key",prop.getProperty("KEY")).
          when().
          get("/maps/api/place/nearbysearch/json").
          /*then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
          header("server","scaffolding on HTTPServer2").extract().response();*/
     
          then().extract().response();
     String responseString = res.asString();
     System.out.println(" Add response "+responseString);
         /* body("results[0].geometry.location.lng",equalTo("151.2092955"));*/
          /*body("results[0].id",equalTo("044785c67d3ee62545861361f8173af6c02f4fae"));*/
          /* body("results[0].name",equalTo("Sydney"));*/
         /* body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
          header("x-frame-options","SAMEORIGIN");*/
          
	}

}


