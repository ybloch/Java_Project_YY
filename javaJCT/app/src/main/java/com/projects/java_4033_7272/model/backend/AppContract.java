package com.projects.java_4033_7272.model.backend;

import android.net.Uri;

public class AppContract {
    /**
     * The authority for the contacts provider
     */
    public static final String AUTHORITY = "com.JCT.AppDataBase";
    /**
     * A content:// style uri to the authority for the contacts provider
     */
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    public static class Activity {
        public static final String ACTIVITY_TYPE = "type";
        public static final String ACTIVITY_STATE = "state";
        public static final String ACTIVITY_STARE_DATE = "dateStart";
        public static final String ACTIVITY_END_DATE = "dateEnd";
        public static final String ACTIVITY_PRICE = "price";
        public static final String ACTIVITY_SUMMARY = "summary";
        public static final String ACTIVITY_ID = "_id";
        public static final String ACTIVITY_BusinessID = "BuissnesID";

        /**
         * The content:// style URI for this table
         */
        public static final Uri ACTIVITY_URI = Uri.withAppendedPath(AUTHORITY_URI, "activities");
    }

    public static class Business {
        public static final String BUSINESS_NAME = "name";
        public static final String BUSINESS_STATE = "state";
        public static final String BUSINESS_CITY = "city";
        public static final String BUSINESS_STREET = "street";
        public static final String BUSINESS_PHONE = "phone";
        public static final String BUSINESS_MAIL = "mail";
        public static final String BUSINESS_LINK = "Link";
        public static final String BUSINESS_ID = "_id";
        /**
         * The content:// style URI for this table
         */
        public static final Uri BUSINESS_URI = Uri.withAppendedPath(AUTHORITY_URI, "businesses");
    }

    public static class User {
        public static final String USER_NUMBER = "number";
        public static final String USER_PASSWORD = "password";
        public static final String USER_NAME = "name";
        /**
         * The content:// style URI for this table
         */
        public static final Uri USER_URI = Uri.withAppendedPath(AUTHORITY_URI, "users");
    }

}
