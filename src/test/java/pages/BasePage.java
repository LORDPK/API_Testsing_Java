package pages;

import org.testng.Assert;
import utilitys.API;

import java.util.HashMap;
import java.util.Map;

public abstract class BasePage {
    protected API api;
    protected Map<String, Object> GETParameters = new HashMap<>();

    public BasePage(API api) {
        this.api = api;
    }

    /**
     * Assert that the Response Code from the API call is 200
     */
    public void assertResponseCode() {
        this.assertResponseCode(200);
    }

    /**
     * Assert that the Response Code from the API call is equal to expectedResCode
     * @param expectedResCode: The response code expected returned from the API call
     */
    public void assertResponseCode(int expectedResCode) {
        Assert.assertEquals(api.getResponseCode(), expectedResCode, "Error, Response Code different from expected");
    }

}
