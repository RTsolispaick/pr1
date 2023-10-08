package com.robokosta;

public class User {
    private String username;
    private String emai;
    private byte [] passwordHash;

    public User(String _username, String _email, byte[] _pass) {
        this.username = _username;
        this.emai = _email;
        this.passwordHash = _pass;
    }
}
