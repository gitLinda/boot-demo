package ch.juventus.bootdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Item(@JsonProperty("id") long id, @JsonProperty("name") String name) {

}
