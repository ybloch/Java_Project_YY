package com.projects.java_4033_7272.model.entities;

import com.projects.java_4033_7272.model.utilities.Tools;

import java.net.PasswordAuthentication;

/**
 * Activity entity.
 * this entity represent an User object.
 * Access Level: public
 */
public class User {
    //***************************************************
    //                     fields
    /**
     * name: userNumber
     * type: int
     * Access Level: private
     * purpose: the user number, should be a number with four digits
     */
    private int userNumber;
    /**
     * name: passAndUserName
     * type: PasswordAuthentication class
     * Access Level: private
     * purpose: this filed contains the user name and user password
     *          this class have the following functions:
     *              PasswordAuthentication(String userName, char[] password)
     *              getPassword()
     *              getUserName()
     */
    private PasswordAuthentication passAndUserName;

    //                   fields end
    //***************************************************


    //***************************************************
    //                   functions

    /**
     * name: c-tor
     * type: function
     * Access Level: public
     * purpose: Initialize all the AccessPermission fields
     */
    public User(int userNumber, PasswordAuthentication passAndUserName) throws Exception {
        setUserNumber(userNumber);
        //setPassAndUserName(passAndUserName);
        setPassAndUserNameByNameAndPassworod(passAndUserName.getUserName(),passAndUserName.getPassword().toString());
    }

    /**
     * name: getUserNnumber
     * type: function
     * Access Level: public
     * return type: int
     * purpose: return user number
     */
    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNnumber) throws Exception {
        this.userNumber = Tools.validEntityId(userNnumber);
    }

    /**
     * name: getPassAndUserName
     * type: function
     * Access Level: public
     * return type: int
     * purpose: return PasswordAuthentication object that contain the user name and password
     */
    public PasswordAuthentication getPassAndUserName() {
        return passAndUserName;
    }

    public void setPassAndUserName(PasswordAuthentication passAndUserName) {
        this.passAndUserName = passAndUserName;
    }

    public void setPassAndUserNameByNameAndPassworod(String name, String pass) throws Exception {

        this.passAndUserName = Tools.validPasswordandUserName(name, pass);
    }


    //                  functions end
    //***************************************************
}
