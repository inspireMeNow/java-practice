package com.ray.pojo;

public class user {
    String id;
    String email;
    String password;
    int idtype;

    public user(){

    }
    public user(String id, String email, String password, int idtype) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.idtype = idtype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", idtype=" + idtype +
                '}';
    }
}
