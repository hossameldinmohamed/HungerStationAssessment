package TestCases;

import TestData.PetsDataProviders;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;

public class TC04_DeletePet extends TestBase {

	

	
	@Test(description = "Enter correct Pet id ,verify 200 response", dataProvider = "PetId",dataProviderClass = PetsDataProviders.class)
	void DeletePet(String id){
		logger = report.createTest("DeletePet with correct pet id");
		logger.assignCategory("Positive Scenario");
		logger.info("Test Case Started" );

		        given()
				.accept("application/json")
				.when()
				.delete(id)
				.then()
				.assertThat()
				.statusCode(200);
		   logger.info("Test Case Ended" );

	}


	@Test(description = "Enter wrong Pet id ,verify 404 response",dataProvider = "WrongPetId",dataProviderClass = PetsDataProviders.class)
	void TryDeletePetWithWrongId(String id){

		logger = report.createTest("Delete Pet with wrong pet id");
		logger.assignCategory("Negative Scenario");
		logger.info("Test Case Started" );

	        	given()
				.accept("application/json")
				.when()
				.delete(id)
				.then()
				.assertThat()
				.statusCode(404);

		logger.info("Test Case Ended" );

	}

}
