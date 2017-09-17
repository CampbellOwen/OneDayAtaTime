package com.hoobleooble.onedayatatime.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public class Category implements Model {
    private int cid;
    private String name;

    public int getCid(){
        return cid;
    }

    public String getName(){
        return name;
    }

    public Category(SQLiteDatabase db, int cid)
    {
        populate(db, cid);
    }

    private Category( int cid, String name )
    {
        this.cid = cid;
        this.name = name;
    }

    private void populate(SQLiteDatabase db, int cid)
    {
        this.cid = cid;

        String[] projection = {
                CategoryContract.CategoryEntry.COLUMN_NAME_NAME
        };

        String selection = CategoryContract.CategoryEntry.COLUMN_NAME_CID + " = ?";
        String[] selectionArgs = {
                Integer.toString(cid)
        };

        Cursor cursor = db.query(
                CategoryContract.CategoryEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        Log.d("DB", "Category query count: " + cursor.getCount());

        cursor.moveToFirst();
        int nameIndex = cursor.getColumnIndexOrThrow(CategoryContract.CategoryEntry.COLUMN_NAME_NAME);

        this.name = cursor.getString(nameIndex);
    }

    public long store(SQLiteDatabase db)
    {
        Log.d("DB", "Inserting new category with cid: " + this.cid);
        ContentValues values = new ContentValues();
        values.put(CategoryContract.CategoryEntry.COLUMN_NAME_CID, this.cid);
        values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAME, this.name);

        return db.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, values);
    }

    public static Category Create(SQLiteDatabase db, int cid, String name)
    {
        Category newCategory = new Category(cid, name);
        newCategory.store(db);

        return newCategory;
    }
}
