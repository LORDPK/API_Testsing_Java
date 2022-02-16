package data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListFacts {
    @JsonProperty("current_page")
    public int current_page;
    @JsonProperty("data")
    public Fact[] data;
    @JsonProperty("first_page_url")
    public String first_page_url;
    @JsonProperty("from")
    public int from;
    @JsonProperty("last_page")
    public String last_page;
    @JsonProperty("last_page_url")
    public String last_page_url;
    @JsonProperty("links")
    public Link[] links;
    @JsonProperty("next_page_url")
    public String next_page_url;
    @JsonProperty("path")
    public String path;
    @JsonProperty("per_page")
    public int per_page;
    @JsonProperty("prev_page_url")
    public String prev_page_url;
    @JsonProperty("to")
    public int to;
    @JsonProperty("total")
    public int total;

    public static class Fact
    {
        @JsonProperty("fact")
        public String fact;
        @JsonProperty("length")
        public int length;
    }

    public static class Link
    {
        @JsonProperty("url")
        public String url;
        @JsonProperty("label")
        public String label;
        @JsonProperty("active")
        public boolean active;
    }
}
