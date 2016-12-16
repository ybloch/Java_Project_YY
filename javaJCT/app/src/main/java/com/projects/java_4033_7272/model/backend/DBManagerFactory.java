package com.projects.java_4033_7272.model.backend;

import com.projects.java_4033_7272.model.datasource.ListDsManager;

/**
 * FactoryBackEnd
 * return the implemention for the "DBManager"
 */
public class DBManagerFactory {
    static DBManager manager = null;

    public static DBManager getManger(){
        if (manager == null)
            manager = new ListDsManager();
        return manager;
    }
}
