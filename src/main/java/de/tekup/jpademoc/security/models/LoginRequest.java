package de.tekup.jpademoc.security.models;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
