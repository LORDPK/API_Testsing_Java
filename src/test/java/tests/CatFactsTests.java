package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FactPage;
import utilitys.API;

/**
 * CatFactsTests have the testcases for "/facts" and "/fact", currently on development
 */
public class CatFactsTests extends BaseTest {
    FactPage factPage;

    /**
     * Instance API class before test executions
     * @param URI: API url
     */
    @BeforeTest
    @Parameters("URI")
    public void beforeSuite(String URI) {
        api = API.getInstance(URI);
    }

    @BeforeMethod
    public void beforeTest() {
        factPage =  new FactPage(api);
    }

    /**
     * T0001_GetListFacts_WithoutParameters: Evaluate GET /facts call to the API without parameters
     * Expected Response code = OK
     */
    @Test
    public void T0001_GetListFacts_WithoutParameters() {
        factPage.sendRequestListCatsFacts();
        factPage.assertResponseCode();
    }

    /**
     * T0002_GetListFacts_SetLimit: Evaluate GET /facts call to the API with limit informed
     *      * Expected Response code = OK
     *      * Expected recover a list of facts less or equal than limit
     * @param limit: the maximum number of facts allowed
     */
    @Test
    @Parameters("limit")
    public void T0002_GetListFacts_SetLimit(int limit) {
        factPage.setLimit(limit);
        factPage.sendRequestListCatsFacts();
        factPage.assertResponseCode();
        factPage.assertCorrectLimitValue(limit);
    }
}