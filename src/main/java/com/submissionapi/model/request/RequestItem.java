package com.submissionapi.model.request;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestItem {
    @JsonProperty("id")
    public long id;

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
