package com.hoobleooble.onedayatatime.Model;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public interface DataContract {
    public String GetCreationString();
    public String GetDeletionString();
    public void populate(SQLiteDatabase db);
}
