package com.example.dimasfauzi.dimasmodul5.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import com.example.dimasfauzi.dimasmodul5.database.model.Todo;
/**
 * Created by Dimas Fauzi on 25/03/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "notes_db_1";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Todo.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Todo.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
    public long insertTodo(String todoName,String description,String priority) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Todo.COLUMN_todoName, todoName);
        values.put(Todo.COLUMN_description, description);
        values.put(Todo.COLUMN_priority, priority);

        // insert row
        long id = db.insert(Todo.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }



    public List<Todo> getAllNotes() {
        List<Todo> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Todo.TABLE_NAME + " ORDER BY " +
                Todo.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Todo note = new Todo();
                note.setId(cursor.getInt(cursor.getColumnIndex(Todo.COLUMN_ID)));
                note.setTodoName(cursor.getString(cursor.getColumnIndex(Todo.COLUMN_todoName)));
                note.setDescription(cursor.getString(cursor.getColumnIndex(Todo.COLUMN_description)));
                note.setPriority(cursor.getString(cursor.getColumnIndex(Todo.COLUMN_priority)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Todo.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Todo.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public void deleteNote(Todo note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Todo.TABLE_NAME, Todo.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }
}
