package com.projects.java_4033_7272.model.entities;

import com.projects.java_4033_7272.model.utilities.Tools;

import java.net.URL;

/**
 * business entity.
 * this entity represent a business.
 * Access Level: public
 */
public class Business {
    //***************************************************
    //                     fields
    /**
     * name: id
     * type: int
     * Access Level: private
     * purpose: unique number to identify the business with four digits
     *          the first digit need to be grater then 0
     */
    private int id;
    /**
     * name: name
     * type String
     * Access Level: private
     * purpose: the name of the business
     * exception: must have 4 digits
     */
    private String name;
    /**
     * name: address
     * type: String array
     * size: 3
     * Access Level: private
     * purpose:
     *      the first cell store the state name
     *      the second cell store the city name
     *      the third cell store the street name
     * exception: must have 3 strings not empty
     */
    private String[] address = new String[3];
    /**
     * name: phone
     * type String
     * Access Level: private
     * purpose: the phone number of the business
     * exception: must have 7-10 digits
     */
    private String phone;
    /**
     * name: mail
     * type String
     * Access Level: private
     * purpose: the mail address of the business
     * exception: must contain @ and cannot contains any space
     */
    private String mail;
    /**
     * name: websisteLink
     * type URL
     * Access Level: private
     * purpose: contains a link to the business web site
     * exception: cannot contains any space
     */
    private URL websisteLink;

    /**
     * name: getId
     * type: function
     * Access Level: public
     * return type: int
     * purpose: return id field
     * exception: cannot be empty  (note for techer - in real life we check if can connect to website...)
     */

    //                   fields end
    //***************************************************


    //***************************************************
    //                   functions

    /**
     * name: c-tor
     * type: function
     * Access Level: public
     * purpose: Initialize all the business fields
     */
    public Business(int id, String name, String[] address, String phone, String mail, URL websisteLink) throws Exception {
        setId(id);
        setName(name);
        setAddress(address);
        setPhone(phone);
        setWebsisteLink(websisteLink);
        setMail(mail);
    }

    /**
     * name: getId
     * type: function
     * Access Level: public
     * return type: int
     * purpose: return id field
     */
    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        this.id = Tools.validEntityId(id);
    }

    /**
     * name: getName
     * type: function
     * Access Level: public
     * return type: String
     * purpose: return name field
     */
    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        this.name = Tools.validSring(name);
    }

    /**
     * name: getAddress
     * type: function
     * Access Level: public
     * return type: String
     * purpose: return address in the next format: "State: [cell 1]
     *                                              City [cell 2]
     *                                              Street [Cell 3]"
     */
    public String getAddress() {
        String temp = "State: " + address[0] + "\nCity: " + address[1] + "\nStreet: " + address[0] + "\n";
        return temp;
    }

    /**
     * name: getAddressByIndex
     * type: function
     * Access Level: public
     * return type: String
     * purpose: return the specific address by index
     */
    public String getAddressByIndex(int index) {
        return address[index];
    }


    public void setAddress(String[] address) throws Exception {
        this.address = Tools.validAddress(address);
    }

    /**
     * name: getPhone
     * type: function
     * Access Level: public
     * return type: String
     * purpose: return the phone field
     */
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        this.phone = Tools.validPhone(phone);
    }

    /**
     * name: getMail
     * type: function
     * Access Level: public
     * return type: String
     * purpose: return the mail field
     */
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) throws Exception {
        this.mail = Tools.validEmail(mail);
    }

    /**
     * name: getWebsisteLink
     * type: function
     * Access Level: public
     * return type: URL
     * purpose: return the WebsisteLink field
     */
    public URL getWebsisteLink() {
        return websisteLink;
    }

    public void setWebsisteLink(URL websisteLink) {
        this.websisteLink = websisteLink;
    }

    //                  functions end
    //***************************************************
}
