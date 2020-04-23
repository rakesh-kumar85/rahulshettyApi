import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class StaticJson {

	@Test

	public void addBook() throws IOException

	{

		RestAssured.baseURI = "http://216.10.245.166";

		Response resp = given().

				header("Content-Type", "application/json").

				body(GenerateStringFromResource("C:\\Users\\rakeshkumar.brindlal\\Documents\\Addbookdetails.json")).

				when().

				post("/Library/Addbook.php").

				then().assertThat().statusCode(200).

				extract().response();
		
		String responseinstringform=resp.asString();
		
		System.out.println("*****************Response of /Library/Addbook.php *************************");
		System.out.println(responseinstringform);
		
		System.out.println("******************************************");

		JsonPath js = ReUsableMethods.rawToJson(resp);

		String id = js.get("ID");

		System.out.println(id);

		// deleteBOok

	}

	public static String GenerateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}

}
