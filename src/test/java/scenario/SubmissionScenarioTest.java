package scenario;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.submissionapi.model.ResponseCreateNewPet;
import com.submissionapi.model.ResponseGetPetByPid;
import com.submissionapi.model.request.RequestItem;

import apiengine.Assertions;
import apiengine.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.data.StaticProvider;
import resources.payload.PayloadTemplate;

public class SubmissionScenarioTest{
    public Endpoints endpoints;
    public Response response;
    public ResponseCreateNewPet responseAddNewPet;
    public ResponseGetPetByPid responseGetPetByPid;
    public PayloadTemplate payloadTemplate;
    public String requestPet;
    public ObjectMapper objectMapper;
    public Assertions assertion;
    private long pidPet;

    @BeforeMethod
    public void setUp(){
        endpoints = new Endpoints();
        responseAddNewPet = new ResponseCreateNewPet();
        payloadTemplate = new PayloadTemplate();
        objectMapper = new ObjectMapper();
        assertion = new Assertions();
        responseGetPetByPid = new ResponseGetPetByPid();
    }

    @Test(dataProvider  = "dataTest", dataProviderClass = StaticProvider.class)
    public void addNewPetCat(String namePet, int idCategory, String nameCategory, String url) throws InterruptedException, IOException{
       
        //Prepare data test
        requestPet = payloadTemplate.addNewPet(namePet, idCategory, nameCategory, url);
        RequestItem petData = objectMapper.readValue(requestPet, RequestItem.class);
        
        // Hit endpoint
        response = endpoints.addNewPet(requestPet);
        JsonPath addNewPet = response.jsonPath();

        //Validation Response
        responseAddNewPet = addNewPet.getObject("", ResponseCreateNewPet.class);
        Assert.assertEquals(response.statusCode(), 200);
        assertion.AssertionCreateNewPet(responseAddNewPet, petData);

        Thread.sleep(2000);
        // Validation getPetByPID
        pidPet = responseAddNewPet.id;
        JsonPath getPetByPID = endpoints.getPetById(pidPet).jsonPath();
        responseGetPetByPid = getPetByPID.getObject("", ResponseGetPetByPid.class);
        assertion.AssertionGetPetByPid(responseGetPetByPid, petData);
    }

    @Test(dataProvider  = "dataStatus", dataProviderClass = StaticProvider.class)
    public void validateStatusPet(String status){
        // String status = "available";
        response = endpoints.findPetsByStatus(status);
        JsonPath addJsonPath = response.jsonPath();
        //Validation
        List<ResponseCreateNewPet> responseItems =  addJsonPath.getList("", ResponseCreateNewPet.class);
        assertion.AssertionStatusPet(responseItems, status);

    }

    @Test
    public void validateSchemaAPI(){
        long pid = 1;
        Response response = endpoints.getPetById(pid);
        assertion.AsserstionSchema(response, "pet-schema.json");
    }
}
