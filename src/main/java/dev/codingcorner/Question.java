package dev.codingcorner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

    @JsonProperty("q")
    public String question;

    @JsonProperty("a")
    public String answer;
}
