package com.projects.java_4033_7272.model.utilities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;

import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.projects.java_4033_7272.controller.ActivitytListActivity;
import com.projects.java_4033_7272.model.entities.*;
import com.projects.java_4033_7272.model.backend.*;

/**
 * Created by yinon on 12/9/2016.
 */

public class Tools {

    public static Float validPrice(Float myPrice)throws Exception{
        if(myPrice != (double)myPrice||myPrice<0)
            throw new Exception("invalid input - activity price must be positive number");
        return  myPrice;
    }
    public static Integer validEntityId(Integer myIdNumber)throws Exception{
        if(myIdNumber.toString().length()!=4 || myIdNumber != (int)myIdNumber )
            throw new Exception("invalid input - Business ID must be 4 digits");
        return myIdNumber;
    }

    public static myEnums.ActivityType validActivityType(String myEnum) throws Exception {
        if(!(myEnum.contains("HotelVacation")|| myEnum.contains("TravelAgency")|| myEnum.contains("Entertainment")||myEnum.contains("Airline")))
               throw new Exception("invalid input - wrong activity name");
        return myEnums.ActivityType.valueOf(myEnum);
    }
    public static Calendar validCalender(String myDate) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse(myDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
        }
        catch (Exception e){
            throw new Exception("invalid input - wrong date format, format should be: dd-MM-yyyy");
        }
    }
    public static String validSringNoNumbers(String myString) throws Exception {
        Pattern numberPat = Pattern.compile("\\d+");
        Matcher m = numberPat.matcher(myString);
        if(m.find())
            throw new Exception("invalid input - wrong string, string cannot contains numbers");
        return myString;
    }
    public static String validSring(String myString) throws Exception {
        if(myString.isEmpty())
            throw new Exception("invalid input - wrong string, string cannot be empty");
        return myString;
    }
    public static String[] validAddress(String[] myAddress) throws Exception {
        if(myAddress.length != 3)
            throw new Exception("invalid input - wrong address, address nust have: state, city and street");
        for (String addr:myAddress) {
            if(addr.isEmpty())
                throw new Exception("invalid input - wrong address, address nust have: state, city and street");
        }
        return myAddress;
    }
    public static String validPhone(String myPhone) throws Exception {
        if(myPhone.length()<7 || myPhone.length()>10)
            throw new Exception("invalid input - wrong phone, must be 7-10 digits");
        Integer.parseInt(myPhone); // if not number throw excption
        return myPhone;
    }
    public static String validEmail(String myEmail) throws Exception {
        if(myEmail.isEmpty() || !myEmail.contains("@") || myEmail.contains(" "))
            throw new Exception("invalid input - wrong Email format, must contains @ and not contains spaces");
        return myEmail;
    }
    public static URL validURL(String myEmail) throws Exception {
        if(myEmail.isEmpty() || myEmail.contains(" "))
            throw new Exception("invalid input - wrong Email format, must contains @ and not contains spaces");
        URI uri = new URI(myEmail);
        URL url = uri.toURL();
        return url;
    }
    public static PasswordAuthentication validPasswordandUserName(String myPassword , String myUserName) throws Exception {
        Pattern numberPat = Pattern.compile("\\d+");
        Matcher m = numberPat.matcher(myPassword);
        if(!m.find())
            throw new Exception("invalid input - wrong password, password must contains numbers");
        Pattern charPat = Pattern.compile("[a-zA-Z]");
        m = charPat.matcher(myPassword);
        if(!m.find())
            throw new Exception("invalid input - wrong password, password must contains charcters");
        if(myPassword.length()< 6)
            throw new Exception("invalid input - wrong password, password must at least contains 6 charcters and digits");
        if(myUserName.isEmpty())
            throw new Exception("invalid input - wrong user name, cannot be empty");
        PasswordAuthentication temp = new PasswordAuthentication(myUserName, myPassword.toCharArray());
        return temp;
    }

    public static User ContentValuesToUser(ContentValues values) throws Exception {
        String tempPass = values.getAsString(AppContract.User.USER_PASSWORD);
        String tempName =   values.getAsString(AppContract.User.USER_NAME);
        User myUser = new User(
               validEntityId(values.getAsInteger(AppContract.User.USER_NUMBER)),
                validPasswordandUserName(tempPass,tempName)
        );
        return  myUser;
    }
    public static ContentValues UserListToCursor(User user){
        PasswordAuthentication passName = user.getPassAndUserName();
        String name = passName.getUserName();
        String password = passName.getPassword().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppContract.User.USER_NUMBER, user.getUserNumber());
        contentValues.put(AppContract.User.USER_PASSWORD, password);
        contentValues.put(AppContract.User.USER_NAME, name);
        return contentValues;
    }
    public static Cursor UserListToCursor(List<User> userList) {
        String[] columns = new String[]
                {
                        AppContract.User.USER_NUMBER,
                        AppContract.User.USER_PASSWORD,
                        AppContract.User.USER_NAME,
                };

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        for (User u : userList) {
            matrixCursor.addRow(new Object[]{u.getUserNumber(),u.getPassAndUserName()});
        }

        return matrixCursor;
    }

    public static Business ContentValuesToBusiness(ContentValues values) throws Exception {
        String[] stringsAddr = new String[3];
        stringsAddr[0] = values.getAsString(AppContract.Business.BUSINESS_STATE);
        stringsAddr[1] = values.getAsString(AppContract.Business.BUSINESS_CITY);
        stringsAddr[2] = values.getAsString(AppContract.Business.BUSINESS_STREET);
        Business myBusiness = new Business(
                validEntityId(values.getAsInteger(AppContract.Business.BUSINESS_ID)),
                validSring(values.getAsString(AppContract.Business.BUSINESS_NAME)),
                validAddress(stringsAddr),
                validPhone(values.getAsString(AppContract.Business.BUSINESS_PHONE)),
                validEmail(values.getAsString(AppContract.Business.BUSINESS_MAIL)),
                validURL(values.getAsString(AppContract.Business.BUSINESS_LINK.toString()))
        );
        return myBusiness;
    }
    public static ContentValues BusinessesListToCursor(Business business){
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppContract.Business.BUSINESS_ID, business.getId());
        contentValues.put(AppContract.Business.BUSINESS_NAME, business.getName());
        contentValues.put(AppContract.Business.BUSINESS_STATE, business.getAddressByIndex(0));
        contentValues.put(AppContract.Business.BUSINESS_CITY, business.getAddressByIndex(1));
        contentValues.put(AppContract.Business.BUSINESS_STREET, business.getAddressByIndex(2));
        contentValues.put(AppContract.Business.BUSINESS_PHONE, business.getPhone());
        contentValues.put(AppContract.Business.BUSINESS_MAIL, business.getMail());
        contentValues.put(AppContract.Business.BUSINESS_LINK, business.getWebsisteLink().toString());
        return contentValues;
    }
    public static Cursor BusinessesListToCursor(List<Business> businesses) {
        String[] columns = new String[]
                {
                        AppContract.Business.BUSINESS_ID,
                        AppContract.Business.BUSINESS_NAME,
                        AppContract.Business.BUSINESS_STATE,
                        AppContract.Business.BUSINESS_CITY,
                        AppContract.Business.BUSINESS_STREET,
                        AppContract.Business.BUSINESS_PHONE,
                        AppContract.Business.BUSINESS_MAIL,
                        AppContract.Business.BUSINESS_LINK,
                };

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        for (Business b : businesses) {
            matrixCursor.addRow(new Object[]{b.getId(),b.getName(),b.getAddress(),b.getPhone(),b.getMail(),b.getWebsisteLink()});
        }

        return matrixCursor;
    }
    public static Activity ContentValuesToActivity(ContentValues values) throws Exception {
        Activity myActivity = new Activity(
                validActivityType(values.getAsString(AppContract.Activity.ACTIVITY_TYPE)),     // activiType
                validSring(values.getAsString(AppContract.Activity.ACTIVITY_STATE)),           // state
                validCalender(values.getAsString(AppContract.Activity.ACTIVITY_STARE_DATE)),        // dateStartActivity
                validCalender(values.getAsString(AppContract.Activity.ACTIVITY_END_DATE)),        // dateEndActivity
                validPrice(values.getAsFloat(AppContract.Activity.ACTIVITY_PRICE)),           // price
                validSring(values.getAsString(AppContract.Activity.ACTIVITY_SUMMARY)),           // activitySummery
                validEntityId(values.getAsInteger(AppContract.Activity.ACTIVITY_ID))       // activityId
            );
        return myActivity;
    }

    public static ContentValues ActivityListToCursor(Activity activity){
        SimpleDateFormat formatter=new SimpleDateFormat("DD-MM-yyyy");
        String dateStartActivity = formatter.format(activity.getDateStartActivity());
        String dateEndActivity = formatter.format(activity.getDateEndActivity());
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppContract.Activity.ACTIVITY_TYPE, activity.getActivityType().name());
        contentValues.put(AppContract.Activity.ACTIVITY_STATE, activity.getState());
        contentValues.put(AppContract.Activity.ACTIVITY_STARE_DATE, dateStartActivity);
        contentValues.put(AppContract.Activity.ACTIVITY_END_DATE, dateEndActivity);
        contentValues.put(AppContract.Activity.ACTIVITY_PRICE, activity.getPrice());
        contentValues.put(AppContract.Activity.ACTIVITY_SUMMARY, activity.getActivitySummary());
        contentValues.put(AppContract.Activity.ACTIVITY_ID, activity.getID());
        return contentValues;

    }

    public static Cursor ActivityListToCursor(List<Activity> activityList) {
        String[] columns = new String[]
                {
                        AppContract.Activity.ACTIVITY_TYPE,
                        AppContract.Activity.ACTIVITY_STATE,
                        AppContract.Activity.ACTIVITY_STARE_DATE,
                        AppContract.Activity.ACTIVITY_END_DATE,
                        AppContract.Activity.ACTIVITY_PRICE,
                        AppContract.Activity.ACTIVITY_SUMMARY,
                        AppContract.Activity.ACTIVITY_ID,
                };

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        for (Activity a : activityList) {
            matrixCursor.addRow(new Object[]{a.getActivityType(),a.getState(),a.getDateStartActivity(),
                    a.getDateEndActivity(),a.getPrice(),a.getActivitySummary(),a.getBusinessId()});
        }

        return matrixCursor;
    }



}
