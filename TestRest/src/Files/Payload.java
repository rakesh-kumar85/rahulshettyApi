package Files;

import org.apache.commons.lang3.RandomStringUtils;

public class Payload {
	
	public static String getData()
	{
		String res = "{\r\n" +
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
		return res;
	}
	
	public static String addBook(String isbn, String aisle)
	{
		String addisbn = RandomStringUtils.randomAlphanumeric(10);
		      // isbn=isbn+addisbn;
		//String ad = RandomStringUtils.randomAlphanumeric(10);
		String dataJson="{\r\n" + 
	     		"\r\n" + 
	     		"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
	     		"\"isbn\":\""+isbn+"\",\r\n" + 
	     		"\"aisle\":\""+aisle+"\",\r\n" + 
	     		"\"author\":\"John foe\"\r\n" + 
	     		"}";
		
		return dataJson;
		
	}
	public static String deletebook(String isbn, String aisle)
	{
		/*String addisbn = RandomStringUtils.randomAlphanumeric(10);*/
		      // isbn=isbn+addisbn;
		//String ad = RandomStringUtils.randomAlphanumeric(10);
		String dataJson="{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+isbn.concat(aisle)+"\"\r\n" + 
				" \r\n" + 
				"}";
		
		return dataJson;
		
	}

}
