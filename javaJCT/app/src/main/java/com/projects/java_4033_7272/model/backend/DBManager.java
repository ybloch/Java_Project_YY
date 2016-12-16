package com.projects.java_4033_7272.model.backend;

import android.content.ContentValues;
import android.database.Cursor;

import com.projects.java_4033_7272.model.utilities.myEnums;

/**
 * BackEnd
 * this class will be the business logic layer in the APP
 * Access Level: public
 */
public interface DBManager {
    /**
     * purpose: add user to the data base
     * @param values of type ContentValues
     * @return boolean - indication if the User was add successfully
     */
    boolean addUser(ContentValues values) throws Exception;
    /**
     * purpose: remove user from the data base
     * @param userNumber of type int
     * @return boolean - indication if the User was remove successfully
     */
    boolean removeUser(int userNumber) throws Exception;
    /**
     * purpose: update user to the data base
     * @param userNumber of type int
     * @param values of type ContentValues
     * @return boolean - indication if the User was updated successfully
     */
    boolean updateUser(int userNumber, ContentValues values) throws Exception;
    /**
     * purpose: add Business to the data base
     * @param values of type ContentValues
     * @return boolean - indication if the Business was add successfully
     */
    boolean addBusiness(ContentValues values) throws Exception;
    /**
     * purpose: remove Business from the data base
     * @param businessID of type int
     * @return boolean - indication if the Business was remove successfully
     */
    boolean removeBusiness(int businessID) throws Exception;
    /**
     * purpose: update Business to the data base
     * @param businessID of type int
     * @param values of type ContentValues
     * @return boolean - indication if the Business was updated successfully
     */
    boolean updateBusiness(int businessID, ContentValues values) throws Exception;
    /**
     * purpose: add Activity to the data base
     * @param values of type ContentValues
     * @return boolean - indication if the Activity was add successfully
     */
    boolean addActivity(ContentValues values) throws Exception;
    /**
     * purpose: remove Activity from the data base
     * @param ID of type int
     * @return boolean - indication if the Activity was remove successfully
     */
    boolean removeActivity(int ID) throws Exception;
    /**
     * purpose: update Activity to the data base
     * @param ID of type int
     * @param values of type ContentValues
     * @return boolean - indication if the Activity was updated successfully
     */
    boolean updateActivity(int ID, ContentValues values) throws Exception;

    void updateVersion(myEnums.entityType type);
    int checkAddNewBusiness();
    int checkAddNewActivity();
    Cursor getAllBusinesses();
    Cursor getAllActivities();
    Cursor getAllUsers();
}
