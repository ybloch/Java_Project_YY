package com.projects.java_4033_7272.model.entities;

import com.projects.java_4033_7272.model.utilities.Tools;
import com.projects.java_4033_7272.model.utilities.myEnums;
import com.projects.java_4033_7272.model.utilities.myEnums.ActivityType;

import java.util.Calendar;
import java.util.Date;

/**
 * Activity entity.
 * this entity represent an Activity.
 * Access Level: public
 */
public class Activity {
    //***************************************************
    //                     fields
    /**
     * name: StaticID
     * type: int
     * Access Level: private
     * purpose: number that identifies the activity
     * exception: must be 4 digits
     */
    private static int StaticID = 1000;
    /**
     * name: activityID
     * type: int
     * Access Level: private
     * purpose: number that identifies the activity
     * exception: must be 4 digits
     */
    private int activityID;
    /**
     * name: activityType
     * type: myEnums
     * Access Level: private
     * purpose: the activity type, one of the follows:
     *      1) Vacation package at hotel
     *      2) Travel agency
     *      3) Entertainment
     *      4) Airline
     * exception: must have only theright value
     */
    private myEnums.ActivityType activityType;
    /**
     * name: state
     * type: String
     * Access Level: private
     * purpose: the name of the country where the activity will take place
     * exception: cannot contains any space
     */
    private String state;
    /**
     * name: dateStartActivity
     * type: Date
     * Access Level: private
     * purpose: the start date of the activity
     * exception: only in format: "dd-MM-yyyy"
     */
    private Calendar dateStartActivity;
    /**
     * name: dateEndActivity
     * type: Date
     * Access Level: private
     * purpose: the end date of the activity
     * exception: only in format: "yyyy-mm-dd"
     */
    private Calendar dateEndActivity;
    /**
     * name: price
     * type: float
     * Access Level: private
     * purpose: the price of the activity
     * exception: only real number
     */
    private float price;
    /**
     * name: activitySummary
     * type: String
     * Access Level: private
     * purpose: a short summary on the activity
     * exception: cannot be empty
     */
    private String activitySummary;
    /**
     * name: businessId
     * type: int
     * Access Level: private
     * purpose: number that identifies the activity with the business operates her
     * exception: must be 4 digits
     */
    private int businessId;

    //                   fields end
    //***************************************************


    //***************************************************
    //                   functions

    /**
     * name: c-tor
     * type: function
     * Access Level: public
     * purpose: Initialize all the activity fields
     */
    public Activity(ActivityType activityType, String state, Calendar dateStartActivity, Calendar dateEndActivity, float price, String activitySummary, int businessId) throws Exception {
        setBusinessId(businessId);
        setActivityType(activityType);
        setState(state);
        setDateStartActivity(dateStartActivity);
        setDateEndActivity(dateEndActivity);
        setPrice(price);
        setActivitySummary(activitySummary);
        activityID = StaticID;
        StaticID++;
    }

    /**
     * name: getActivityType
     * type: function
     * Access Level: public
     * return type: ActivityType (enum)
     * purpose: return the activity type field
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    /**
     * name: getState
     * type: function
     * Access Level: public
     * return type: String
     * purpose: return the activity state field
     */
    public String getState() {
        return state;
    }

    public void setState(String state) throws Exception {
        this.state = Tools.validSring(state);
    }

    /**
     * name: getDateStartActivity
     * type: function
     * Access Level: public
     * return type: Date
     * purpose: return the dateStartActivity field
     */
    public Calendar getDateStartActivity() {
        return dateStartActivity;
    }

    public void setDateStartActivity(Calendar dateStartActivity) {
        this.dateStartActivity = dateStartActivity;
    }

    /**
     * name: getDateEndActivity
     * type: function
     * Access Level: public
     * return type: Date
     * purpose: return the dateEndActivity field
     */
    public Calendar getDateEndActivity() {
        return dateEndActivity;
    }

    public void setDateEndActivity(Calendar dateEndActivity) {
        this.dateEndActivity = dateEndActivity;
    }

    /**
     * name: getPrice
     * type: function
     * Access Level: public
     * return type: float
     * purpose: return the price field
     */
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) throws Exception {
        this.price = Tools.validPrice(price);
    }

    /**
     * name: getActivitySummary
     * type: function
     * Access Level: public
     * return type: String
     * purpose: return the activitySummary field
     */
    public String getActivitySummary() {
        return activitySummary;
    }

    public void setActivitySummary(String activitySummary) throws Exception {
        this.activitySummary = Tools.validSring(activitySummary);
    }

    /**
     * name: getBusinessId
     * type: function
     * Access Level: public
     * return type: int
     * purpose: return the businessId field
     */
    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) throws Exception {
        this.businessId = Tools.validEntityId(businessId);
    }

    /**
     * name: getActivityId
     * type: function
     * Access Level: public
     * return type: String
     * purpose: return the activity state field
     */
    public int getID() {
        return activityID;
    }

    //                  functions end
    //***************************************************


}
