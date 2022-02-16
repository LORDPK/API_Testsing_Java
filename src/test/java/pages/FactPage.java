package pages;

import com.fasterxml.jackson.core.JsonProcessingException;
import data.ListFacts;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.groovy.json.internal.Exceptions;
import org.testng.Assert;
import utilitys.API;

public class FactPage extends BasePage {
    private int max_length;
    private int limit;
    private boolean has_value_max_length = false;
    private boolean has_value_limit = false;

    public FactPage(API api) {
        super(api);
    }

    public void setMax_length(int max_length) {
        this.max_length = max_length;
        has_value_max_length = true;
    }

    public void setLimit(int limit) {
        this.limit = limit;
        has_value_limit = true;
    }

    /**
     * Make a call to the GET API/facts.
     * Inform the max_length/limit parameters if they have value
     */
    public void sendRequestListCatsFacts() {
        if(has_value_max_length)
            GETParameters.put("max_length", max_length);

        if(has_value_limit)
            GETParameters.put("limit", limit);

        api.getResponse("/facts", GETParameters);
    }

    /**
     * Asserts if the list of facts recover from the API/facts GET call, is less or equals than the limit parameter
     * from the call.
     */
    public void assertCorrectLimitValue(int limit) {
        ListFacts listFacts;

        try {
            listFacts = recoverListFacts();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new Exceptions.JsonInternalException("Error transforming json to java object");
        }

        Assert.assertTrue(listFacts.data.length <= limit, "Error, the numbers of facts should be less or equal than limit");
    }

    /**
     * Transforms the String JSON from the api call to ListFacts Object
     * @return ListFacts
     */
    private ListFacts recoverListFacts() throws JsonProcessingException {
        String Json = api.getResponseBody();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readerFor(ListFacts.class).readValue(Json);
    }
}
