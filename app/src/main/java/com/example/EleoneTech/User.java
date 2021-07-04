package com.example.EleoneTech;

public class User {
    private String id, matricule,username, password;

    public User(String id, String matricule, String username, String password) {
        this.id = id;
        this.matricule = matricule;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

