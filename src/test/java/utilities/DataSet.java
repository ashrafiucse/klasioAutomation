package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    public static String adminLoginPageUrl = "https://app.klasio.dev/login";

    @DataProvider(name = "adminRegistrationInvalidDataSet")
    public static Object invalidCredentials() {
        Object[][] signUpDataSet = {
                {" ","ali","email@email.com","123456789","123456789"},
                {"Ashraf"," ","email@email.com","123456789","123456789"},
                {"Ashraf","Ali","","123456789","123456789"},
                {"Ashraf","Ali","email@email.com","","123456789"},
                {"Ashraf","Ali","email@email.com","123456789",""},
                {"Ashraf","Ali","email@email.com","","123456789"},
                {"Ashraf","Ali","email@email.com","1234567890","123456789"},
                {"Ashraf","Ali","@email.com","123456789","123456789"},
                {"Ashraf","Ali","email@e","123456789","123456789"},
        };
        return signUpDataSet;
    }

    @DataProvider(name = "adminRegistrationValidDataSet")
    public static Object validCredentials() {
        Object[][] signUpDataSet = {
                {"Ashraf","Ali","test@academy.com","123456789","123456789"}
        };
        return signUpDataSet;
    }
}
