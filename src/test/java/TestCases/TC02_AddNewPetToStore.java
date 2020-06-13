package TestCases;


import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class TC02_AddNewPetToStore extends TestBase{

	

	
	@Test(description = "add new pet to the store by adding json file with the required body")
	void AddNewPetToStore() throws FileNotFoundException{



		logger = report.createTest("Add a new pet to the store");
		logger.assignCategory("Positive Scenario");
		logger.info("Test Case Started" );

	  FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir") +"/src/test/java/TestData/PetData.json"));
	

	         	given()
				.contentType("application/json")
				.header("accept","application/json")
				.body(fis)
		    	.when()
				.post()
				.then()
			    .statusCode(200)
				.and()
				.log()
				.all();

		logger.info("Test Case Ended" );


	}
	
	

	
	

}
