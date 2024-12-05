package models;

import lombok.Data;

@Data
public class AuthorizationRequestModel {
    private String userName,
            password;
}
