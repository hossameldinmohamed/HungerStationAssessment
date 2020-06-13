package TestCases;

import TestData.PetsDataProviders;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TC03_FindPetbyId extends TestBase {

	




	
	@Test(description = "search with correct Pet id ,verify 200 response", dataProvider = "PetId",dataProviderClass = PetsDataProviders.class)
	void FindPetById(String id){

		logger = report.createTest("Test with id = "+id);
		logger.assignCategory("Positive Scenario");
		logger.info("Test Case Started" );

		given()
				.when()
				.get(id)
				.then()
				.assertThat()
				.statusCode(200);

		logger.info("Test Case Ended" );

	}



	@Test(description = "search with wrong Pet id ,verify 404 response", dataProvider = "WrongPetId",dataProviderClass = PetsDataProviders.class)
	void TryFindingPetByWrongId(String id){

		logger = report.createTest("Test with id = "+id);
		logger.assignCategory("Negative Scenario");
		logger.info("Test Case Started" );

		        given()
				.when()
	     		.get(id)
				.then()
				.assertThat()
				.statusCode(404);

		logger.info("Test Case Ended" );

	}

	

	
	

}
