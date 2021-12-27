package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class TwitterPoll {
    private final UUID id;

    private final String question;
    private final String result;
    private final String options;

    public TwitterPoll(@JsonProperty("id") UUID id, @JsonProperty("question") String question,
                       @JsonProperty("result") String result, @JsonProperty("options") String options) {
        this.id = id;
        this.question = question;
        this.result = result;
        this.options = options;
    }

    public UUID getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getResult() {
        return result;
    }

    public String getOptions() {
        return options;
    }
}
