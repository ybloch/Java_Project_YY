package com.projects.java_4033_7272.model.datasource;

import android.content.ContentValues;
import android.database.Cursor;

import com.projects.java_4033_7272.model.backend.DBManager;
import com.projects.java_4033_7272.model.entities.Activity;
import com.projects.java_4033_7272.model.entities.Business;
import com.projects.java_4033_7272.model.entities.User;
import com.projects.java_4033_7272.model.utilities.Tools;
import com.projects.java_4033_7272.model.utilities.myEnums;

import java.util.ArrayList;

/**
 * List Data Source
 * this class will contain the data base for the APP.
 * Access Level: public
 */
public class ListDsManager implements DBManager{

    //***************************************************
    //                     fields

    /**
     * name: businessList
     * type: ArrayList
     * Access Level: public
     * purpose: array list that contain all the business entities
     */
    static ArrayList<Business> BusinessList = new ArrayList();
    /**
     * name: activityList
     * type: ArrayList
     * Access Level: public
     * purpose: array list that contain all the activities entities
     */
    static ArrayList<Activity> activityList = new ArrayList();
    /**
     * name: accessPermissionList
     * type: ArrayList
     * Access Level: public
     * purpose: array list that contain all the accessPermission objects
     */
    static ArrayList<User> userList = new ArrayList();

    static int activityVersion = 0;
    static int businessVersion = 0;
    static int userVersion = 0;

    //                   fields end
    //***************************************************


    //***************************************************
    //                   functions

    @Override
    public boolean addUser(ContentValues values) throws Exception {
        User userToAdd = Tools.ContentValuesToUser(values);
        for (User tempUser : userList)
            if (userToAdd.getUserNumber() == tempUser.getUserNumber())
                throw new Exception ("This user alertly exists in the data base");
        updateVersion(myEnums.entityType.USER);
        return (userList.add(userToAdd));
    }

    @Override
    public boolean removeUser(int userNumber)throws Exception {
        for (User tempUser : userList)
            if (userNumber == tempUser.getUserNumber())
            {
                updateVersion(myEnums.entityType.USER);
                return (userList.remove(tempUser));
            }
        throw new Exception ("This user don't exists in the data base");
    }

    @Override
    public boolean updateUser(int userNumber, ContentValues values) throws Exception {
        User userToUpdate = Tools.ContentValuesToUser(values);
        if (userToUpdate.getUserNumber() != userNumber)
            throw new Exception ("the ID can't change");
        if (removeUser(userNumber))
        {
            updateVersion(myEnums.entityType.USER);
            return (addUser(values));
        }
        return false;
    }

    @Override
    public boolean addBusiness(ContentValues values) throws Exception  {
        Business BusinessToAdd = Tools.ContentValuesToBusiness(values);
        for (Business tempBusiness : BusinessList)
            if (BusinessToAdd.getId() == tempBusiness.getId())
                throw new Exception ("This business alertly exists in the data base");
        updateVersion(myEnums.entityType.BUSINESS);
        return (BusinessList.add(BusinessToAdd));
    }

    @Override
    public boolean removeBusiness(int businessID) throws Exception {
        for (Business tempBusiness : BusinessList)
            if (businessID == tempBusiness.getId())
            {
                updateVersion(myEnums.entityType.BUSINESS);
                return (BusinessList.remove(tempBusiness));
            }
        throw new Exception ("This business don't exists in the data base");
    }

    @Override
    public boolean updateBusiness(int businessID, ContentValues values) throws Exception {
        Business BusinessToUpdate = Tools.ContentValuesToBusiness(values);
        if (BusinessToUpdate.getId() != businessID)
            throw new Exception ("the ID can't change");
        if (removeBusiness(businessID))
        {
            updateVersion(myEnums.entityType.BUSINESS);
            return addBusiness((values));
        }
        return false;
    }

    @Override
    public boolean addActivity(ContentValues values) throws Exception {
        Activity activityToAdd = Tools.ContentValuesToActivity(values);
        for (Activity tempActivity : activityList)
            if (activityToAdd.getID() == tempActivity.getID())
                throw new Exception ("This activity alertly exists in the data base");
        updateVersion(myEnums.entityType.ACTIVITY);
        return (activityList.add(activityToAdd));
    }

    @Override
    public boolean removeActivity(int id) throws Exception {
        for (Activity tempActivity : activityList)
            if (id == tempActivity.getID())
            {
                updateVersion(myEnums.entityType.ACTIVITY);
                return (activityList.remove(tempActivity));
            }
        throw new Exception ("This Activity don't exists in the data base");
    }

    @Override
    public boolean updateActivity(int id, ContentValues values) throws Exception {
        Activity activityToUpdate = Tools.ContentValuesToActivity(values);
        if (activityToUpdate.getID() != id)
            throw new Exception ("the activity ID can't change");
        if (removeActivity(id))
        {
            updateVersion(myEnums.entityType.ACTIVITY);
            return (addActivity(values));
        }
        return false;
    }

    @Override
    public void updateVersion(myEnums.entityType type) {
        switch (type)
        {
            case ACTIVITY: activityVersion++;
                break;
            case BUSINESS: businessVersion++;
                break;
            case USER: userVersion++;
        }
    }

    @Override
    public int checkAddNewBusiness() {
        return businessVersion;
    }

    @Override
    public int checkAddNewActivity() {
        return activityVersion;
    }

   @Override
    public Cursor getAllBusinesses() {
        return Tools.BusinessesListToCursor(BusinessList);
    }

    @Override
    public Cursor getAllActivities() {
        return Tools.ActivityListToCursor(activityList);
    }

    @Override
    public Cursor getAllUsers() {
        return Tools.UserListToCursor(userList);
    }


    //                  functions end
    //***************************************************
}
