package com.hoobleooble.onedayatatime.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "database.db";

    private List<DataContract> dataContracts;

    public DbHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        dataContracts = new ArrayList<DataContract>();
        dataContracts.add(new AnswerContract.AnswerEntry());
        dataContracts.add(new QuestionContract.QuestionEntry());
        dataContracts.add(new CategoryContract.CategoryEntry());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for ( DataContract contract : dataContracts ) {
            String creationString = contract.GetCreationString();
            Log.d("DB", "Creating table with: " + creationString);
            sqLiteDatabase.execSQL(creationString);
            contract.populate(sqLiteDatabase);
        }

    }

    public void deleteTables(SQLiteDatabase db)
    {
        for ( DataContract contract: dataContracts ) {
            db.execSQL(contract.GetDeletionString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        deleteTables(sqLiteDatabase);
        onCreate(sqLiteDatabase);
    }
}
