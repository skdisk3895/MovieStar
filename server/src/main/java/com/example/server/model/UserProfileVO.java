package com.example.server.model;

public class UserProfileVO {
    private int id;
    private String username;
    private String password;
    private String email;
    private String salt;

    public UserProfileVO(int id, String username, String password, String email, String salt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
