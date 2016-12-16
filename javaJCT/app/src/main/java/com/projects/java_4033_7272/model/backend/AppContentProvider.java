package com.projects.java_4033_7272.model.backend;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.projects.java_4033_7272.model.utilities.myEnums;

public class AppContentProvider extends ContentProvider {
    DBManager manager = DBManagerFactory.getManger();

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        String listName = uri.getLastPathSegment();
        switch (listName) {
            case "activities":
                return manager.getAllActivities();

            case "businesses":
                return manager.getAllBusinesses();

            case "users":
                return manager.getAllUsers();
        }
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return uri.toString();
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        String listName = uri.getLastPathSegment();
        boolean id = false;
        try {
            switch (listName) {
                case "activities":
                    id = manager.addActivity(contentValues);
                    return ContentUris.withAppendedId(uri, 1);

                case "businesses":
                    id = manager.addBusiness(contentValues);
                    return ContentUris.withAppendedId(uri, 1);

                case "users":
                    id = manager.addUser(contentValues);
                    return ContentUris.withAppendedId(uri, 1);
            }
        }
        catch (Exception e) {
            throw (IllegalArgumentException)e;
        }

        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        String listName = uri.getLastPathSegment();
        long id = ContentUris.parseId(uri);

        try {
            switch (listName) {
                case "businesses":
                    if(manager.removeBusiness((int)id))
                        return 1;
                case "users":
                    if(manager.removeUser((int)id))
                        return 1;
                case "activity":
                    if(manager.removeActivity((int)id))
                        return 1;
            }
        }
        catch (Exception e) {
            throw (IllegalArgumentException)e;
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        String listName = uri.getLastPathSegment();
        long id = ContentUris.parseId(uri);

        try {
            switch (listName) {
                case "businesses":
                    if (manager.updateBusiness((int) id, contentValues))
                        return 1;
                case "users":
                    if (manager.updateUser((int) id, contentValues))
                        return 1;
                case "activity":
                    if (manager.updateActivity((int) id, contentValues))
                        return 1;
            }
        } catch (Exception e) {
            throw (IllegalArgumentException) e;
        }
        return 0;
    }

}
