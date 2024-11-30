package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    public static String adminLoginPageUrl = "https://app.klasio.dev/login";
    public static String ownerFirstName = "Ashraf";
    public static String ownerLastName = "Ali";
    public static String ownerEmailAddress = "testaccount09@gmail.com";
    public static String ownerPassword = "123456789";

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

    @DataProvider(name = "adminRegistrationWithExistingAccountEmail")
    public static Object validCredentials() {
        Object[][] signUpDataSet = {
                {"Ashraf","Ali","instructor@wedevs.com","123456789","123456789"}
        };
        return signUpDataSet;
    }
}
