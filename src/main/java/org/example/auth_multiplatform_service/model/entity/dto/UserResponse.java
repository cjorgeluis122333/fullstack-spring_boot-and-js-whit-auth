package org.example.auth_multiplatform_service.model.entity.dto;

public class UserResponse {
    String token;
    String username;
    String message;



    public UserResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
