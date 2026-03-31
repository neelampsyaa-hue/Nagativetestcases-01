package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name ="loginData")
	public Object[][] getData() {
        return new Object[][] {
        	 {"8296574063", "8296574063", true} , 
            {" ", "8296574063", false},
            {"8296574063", " ", false},
            {"verylongusername1234567890", "8296574063", false},
            {"admin' OR '1'='1", "pass", false},
            {"829657406", "82965740631", false},
           // valid
        };
    }
}
