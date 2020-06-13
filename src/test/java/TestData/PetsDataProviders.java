package TestData;

import org.testng.annotations.DataProvider;

public class PetsDataProviders {


    @DataProvider
    private Object[][] Status(){
        return new Object[][]{
                {"available"},
                {"pending"},
                {"sold"}
        };
    }



    @DataProvider
    private Object[][] PetId(){
        return new Object[][]{
                {"12"},
                {"10"},
        };
    }


    @DataProvider
    private Object[][] WrongPetId(){
        return new Object[][]{
                {"76565656"},
                {"9870234"},
                {"876655552"}
        };
    }
}
