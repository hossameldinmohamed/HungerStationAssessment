package TestCases;
import TestData.PetsDataProviders;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TC01_FindPetsByStatus extends TestBase{

	



	@Test(description = "search for Pets by status available,pending and sold",dataProvider = "Status",dataProviderClass = PetsDataProviders.class)
	void FindPetsBystatus(String status){

		logger = report.createTest("Test with status = "+status);
		logger.assignCategory("Positive Scenario");
		logger.info("Test Case Started" );

       given()
	   .param("status",status)
	   .when()
       .get("findByStatus")
	   .then()
	   .log()
	   .all();


		logger.info("Test Case Ended" );


	}
	
	

	
	

}
