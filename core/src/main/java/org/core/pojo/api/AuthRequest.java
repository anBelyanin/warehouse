package org.core.pojo.api;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({
    "username",
    "password"
    })
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthRequest {

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "password")
    private String password;

    public String getLogin() {
        return username;
    }

    public void setLogin(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
