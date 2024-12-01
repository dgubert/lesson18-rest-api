package models;

import lombok.Data;

@Data
public class AuthorizationModel {
    private String userName,
            password;
}
