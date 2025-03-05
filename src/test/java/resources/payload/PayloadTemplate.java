package resources.payload;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public class PayloadTemplate {
    String jsonRequest;

    public String addNewPet(String name, int idCategory, String nameCategory, String url ) throws StreamReadException, DatabindException, IOException{
                jsonRequest = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": " + idCategory + ",\n" +  // Dynamically inserting category id
                "    \"name\": \"" + nameCategory + "\"\n" +  // Dynamically inserting category name
                "  },\n" +
                "  \"name\": \"" + name + "\",\n" +  // Dynamically inserting pet name
                "  \"photoUrls\": [\n" +
                "    \"" + url + "\"\n" +  // Dynamically inserting URL as a photo URL
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +  // Static status as "available"
                "}";
            return jsonRequest;
    } 
}      
