package com.example.dimasfauzi.dimasmodul5;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.dimasfauzi.dimasmodul5.R;
import com.example.dimasfauzi.dimasmodul5.database.model.Todo;

/**
 * Created by Dimas Fauzi on 25/03/2018.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MyViewHolder>{

    private Context context;
    private List<Todo> notesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView todoName;
        public TextView description;
        public TextView priority;
        public TextView dot;
        public TextView timestamp;

        public MyViewHolder(View view) {
            super(view);
            todoName = view.findViewById(R.id.todoName);
            description = view.findViewById(R.id.description);
            priority = view.findViewById(R.id.priority);

            dot = view.findViewById(R.id.dot);
            timestamp = view.findViewById(R.id.timestamp);
        }
    }


    public TodoAdapter(Context context, List<Todo> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Todo note = notesList.get(position);

        holder.todoName.setText(note.getTodoName());
        //holder.description.setText(note.getDescription());
        //holder.priority.setText(note.getPriority());

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(note.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }


    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }
}