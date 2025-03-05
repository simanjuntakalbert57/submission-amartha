package apiengine;

import java.io.File;
import java.util.List;

import org.testng.Assert;

import com.submissionapi.model.ResponseCreateNewPet;
import com.submissionapi.model.ResponseGetPetByPid;
import com.submissionapi.model.request.RequestItem;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class Assertions {
    public void AssertionCreateNewPet(ResponseCreateNewPet responseItem, RequestItem requestItem){
        Assert.assertEquals(responseItem.name, requestItem.name, "Response body does not match the name");
        Assert.assertNotNull(responseItem.id,"Response body doesn't contain Id");
        Assert.assertEquals(responseItem.status, requestItem.status, "Response body does not match");
       
    }

    public void AssertionGetPetByPid(ResponseGetPetByPid responseItem, RequestItem requestItem){
        Assert.assertEquals(responseItem.name, requestItem.name, "Response body does not match the name");
        Assert.assertNotNull(responseItem.id,"Response body doesn't contain Id");
    }

    public void AssertionStatusPet(List<ResponseCreateNewPet> responseItems, String status){
        for (ResponseCreateNewPet responseItem : responseItems) {
            Assert.assertEquals(responseItem.status, status,"Response body does not match the status");
        }
    }

    public void AsserstionSchema(Response responseItem, String schema){
        File schemaFile = new File("src/test/java/resources/data",schema);
        boolean isValid = JsonSchemaValidator.matchesJsonSchema(schemaFile)
            .matches(responseItem.asString()); // Apply the validation

        // Assert that the response body is valid according to the schema
        Assert.assertTrue(isValid, "Response body does not match the schema.");
    }
}
