package models;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String fname;
    private String lname;

    public User(String userId, String fname,String lname) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return fname;
    }

    public void setName(String name) {
        this.fname = name;
    }

    public void showUser() {
        System.out.println(userId + "\t" + fname + "\t" + lname);
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
