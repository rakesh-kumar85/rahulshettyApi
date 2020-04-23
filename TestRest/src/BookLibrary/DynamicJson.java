package BookLibrary;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/*\\ Get data through  f=ststic function*/

public class DynamicJson {
	
	@Test(priority = 1,dataProvider="BooksData")
	public void addBook(String isbn, String aisel)
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		Response resp=given().
			     header("Content-Type","application/json").
			    /* body(Payload.addBook("bczd1ddd4567","227")) using when requured static data that need to chnaged with random value in Payload data */   
			     body(Payload.addBook(isbn,aisel)).
			     when().
			     post("/Library/Addbook.php").
			     then().assertThat().statusCode(200).extract().response();
	             JsonPath js=ReUsableMethods.rawToJson(resp);
	             String inString=resp.asString();
	             System.out.println(" Response"+inString);
	             String Id=js.get("ID");
	             
	             System.out.println(Id);
	             
	             
	}
	
	@Test(priority =2,dataProvider="BooksData")
	public void deletebook(String isbn, String aisel)
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		Response resp=given().
			     header("Content-Type","application/json").
			     /*body(Payload.addBook("bczd1ddd4567","227")) using when requured static data that need to chnaged with random value in Payload data    */
			     body(Payload.deletebook(isbn,aisel)).log().all().
			     when().
			     post("/Library/DeleteBook.php").
			     then().assertThat().statusCode(200).extract().response();
	             JsonPath js=ReUsableMethods.rawToJson(resp);
	             String inString=resp.asString();
	             System.out.println(" Response"+inString);
	             String deletemsg=js.get("msg");
	             System.out.println(deletemsg);
	             
	             
	}

@DataProvider(name="BooksData")
public Object[][] getData()
{

	return new Object[][] { {"abcd","346028"},{"sdfr","785029"},{"wert","39780120"}};
	
}

}
