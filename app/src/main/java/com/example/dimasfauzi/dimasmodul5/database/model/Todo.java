package com.example.dimasfauzi.dimasmodul5.database.model;

/**
 * Created by Dimas Fauzi on 25/03/2018.
 */

public class Todo {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_todoName = "todoName";
    public static final String COLUMN_description = "description";
    public static final String COLUMN_priority = "priority";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String todoName;
    private String description;
    private String priority;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_todoName + " TEXT,"
                    + COLUMN_description + " TEXT,"
                    + COLUMN_priority + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Todo() {

    }

    public Todo(int id, String todoName, String description, String priority, String timestamp) {
        this.id = id;
        this.todoName = todoName;
        this.description = description;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTodoName() {
        return todoName;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
