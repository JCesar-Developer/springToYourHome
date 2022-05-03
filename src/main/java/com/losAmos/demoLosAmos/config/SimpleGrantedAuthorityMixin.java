package com.losAmos.demoLosAmos.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGrantedAuthorityMixin {

    @JsonCreator
    public SimpleGrantedAuthorityMixin(@JsonProperty("authority") String role) {}

}
