package com.company.menu;

import com.company.data.PathDatabase;

public abstract class Path {
    static String FULL_PATH_TO_DATABASE = null;

    Path(PathDatabase pathDatabase) {
        FULL_PATH_TO_DATABASE = pathDatabase.toString();
    }
}
