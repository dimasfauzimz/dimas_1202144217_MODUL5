package com.example.dimasfauzi.dimasmodul5;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.dimasfauzi.dimasmodul5.R;
import com.example.dimasfauzi.dimasmodul5.database.DatabaseHelper;
import com.example.dimasfauzi.dimasmodul5.database.model.Todo;
import com.example.dimasfauzi.dimasmodul5.utils.MyDividerItemDecoration;
import com.example.dimasfauzi.dimasmodul5.utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class AddTodo extends AppCompatActivity {
    //private TodoAdapter mAdapter;
    EditText todoName,description,priority;
    private List<Todo> notesList = new ArrayList<>();
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        db = new DatabaseHelper(this);
        Button btnTodo = (Button) findViewById(R.id.addTodo);
        todoName = (EditText) findViewById(R.id.todoName);
        description = (EditText) findViewById(R.id.description);
        priority = (EditText) findViewById(R.id.priority);

        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertTodo(todoName.getText().toString(),description.getText().toString(),priority.getText().toString());
                //db.insertTodo("nametodo","Description","Priority");
                Intent i = new Intent(getApplication(), MainActivity.class);
                startActivity(i);
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                */
            }
        });
    }
}


