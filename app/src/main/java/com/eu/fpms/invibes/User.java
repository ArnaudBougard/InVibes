package com.eu.fpms.invibes;

/**
 * Created by Arnaud on 14-05-18.
 */

public class User {

    private int id;
    private String name;
    private String username;
    private String password;
    private String tmin;
    private String tmax;
    private String hmin;
    private String hmax;
    private String bmin;
    private String bmax;
    private String phone;

    public User() {

        this.name ="null";
        this.username ="null";
        this.password ="null";
        this.tmin="0";
        this.tmax="0";
        this.hmin="0";
        this.hmax="0";
        this.bmin="0";
        this.bmax="0";
        this.phone="0";

    }

    public User(String name, String username, String password) {

        this.name = name;
        this.username = username;
        this.password = password;
        this.tmin="0";
        this.tmax="0";
        this.hmin="0";
        this.hmax="0";
        this.bmin="0";
        this.bmax="0";
        this.phone="0";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTmin() {
        return tmin;
    }

    public void setTmin(String tmin) {
        this.tmin = tmin;
    }

    public String getTmax() {
        return tmax;
    }

    public void setTmax(String tmax) {
        this.tmax = tmax;
    }

    public String getHmin() {
        return hmin;
    }

    public void setHmin(String hmin) {
        this.hmin = hmin;
    }

    public String getHmax() {
        return hmax;
    }

    public void setHmax(String hmax) {
        this.hmax = hmax;
    }

    public String getBmin() {
        return bmin;
    }

    public void setBmin(String bmin) {
        this.bmin = bmin;
    }

    public String getBmax() {
        return bmax;
    }

    public void setBmax(String bmax) {
        this.bmax = bmax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
