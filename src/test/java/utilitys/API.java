package utilitys;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class API {
    private static API single_api = null;
    private final RequestSpecification httpRequest;
    private Response response = null;

    private API(String URI) {
        httpRequest = RestAssured.given();
        httpRequest.baseUri(URI);
    }

    public static API getInstance(String URI) {
        if(single_api == null)
            single_api = new API(URI);

        return single_api;
    }

    public void getResponse(String get) {
        response = httpRequest.get(get);
    }

    public void getResponse(String get, Map<String, Object> queryParams) {
        if(queryParams.isEmpty())
            this.getResponse(get);
        else
            response = httpRequest.queryParams(queryParams).get(get);
    }

    public int getResponseCode() {
        if(response == null)
            throw new NullPointerException();
        else
            return response.getStatusCode();
    }

    public String getResponseBody() {
        if(response == null)
            throw new NullPointerException();
        else {
            return response.getBody().asString();
        }
    }
}
