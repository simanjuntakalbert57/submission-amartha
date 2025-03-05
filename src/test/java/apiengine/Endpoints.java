package apiengine;

import com.submissionapi.constants.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Endpoints {

    public RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .log().all();  // Log request details
    }

    public Response addNewPet(String jsonRequest ){
        Response response = getRequestSpec()
                            .pathParam("path","pet")
                            .body(jsonRequest)
                            .contentType("application/json")
                            .when()
                                .post("{path}");
        return response;
    }

    public Response findPetsByStatus(String queryMap){
        Response response = getRequestSpec()
                            .pathParam("pet","pet")
                            .pathParam("findBy","findByStatus")
                            .queryParam("status", queryMap)
                            .contentType("application/json")
                            .when()
                                .get("{pet}/{findBy}");
        return response;
    }

    public Response getPetById(long pid){
        Response response = getRequestSpec()
                            .pathParam("pet","pet")
                            .pathParam("pid",pid)
                            .contentType("application/json")
                            .when()
                                .get("{pet}/{pid}");
        return response;
    }
}