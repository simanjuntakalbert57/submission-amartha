package com.submissionapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseGetPetByPid {

    @JsonProperty("id")
    public long  id;

    @JsonProperty("code")
    public int code;

    @JsonProperty("type")
    public String type;

    @JsonProperty("message")
    public String message;

    @JsonProperty("category")
    public Category category;

    @JsonProperty("name")
    public String name;

    @JsonProperty("photoUrls")
    public ArrayList<String> photoUrls;

    @JsonProperty("tags")
    public ArrayList<Tag> tags;

    @JsonProperty("status")
    public String status;

    public static class Category {
        @JsonProperty("id")
        public long id;

        @JsonProperty("name")
        public String name;
    }

    public static class Tag {
        @JsonProperty("id")
        public long id;

        @JsonProperty("name")
        public String name;
    }
}
