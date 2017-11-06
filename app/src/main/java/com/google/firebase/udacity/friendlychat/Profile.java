package com.google.firebase.udacity.friendlychat;

/**
 * Created by Mohammad Faisal on 11/5/2017.
 */

public class Profile {
    String userName;
    String userID;
    public Profile()
    {
        this.userID = "";
        this.userName = "";
    }
    public Profile(String userID , String userName) {
        this.userID = userID;
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
}