package com.example.dbconnectivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int Database_Version = 1;
    private static final String Database_Name = "myDB.db";
    private static final String Table_Name = "Student";
    private static final String Column_Id = "SID";
    private static final String Column_Name = "SNAME";

    public MyDBHandler(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context,Database_Name , factory, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "CREATE TABLE "+Table_Name+" ("+Column_Id+" Integer Primary Key,"+Column_Name+" Varchar(20) Not Null);";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addHandler(Student student) {
        ContentValues values = new ContentValues();
        values.put(Column_Id,student.getId());
        values.put(Column_Name,student.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(Table_Name,null,values);
        db.close();
    }

    public Student searchHandler(int sid) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(Table_Name, new String[] { Column_Id,
                        Column_Name }, Column_Id + "=?",
                new String[] { String.valueOf(sid) }, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
            Student student = new Student(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
            return student;
        }
        return null;
    }
}