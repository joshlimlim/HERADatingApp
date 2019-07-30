package com.mad.heradatingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsAdapter extends ArrayAdapter<Event> {
    Context c;
    int layout;
    ArrayList<Event> data;

    public EventsAdapter(Context c, int layout, ArrayList<Event> data){
        super(c, layout, data);
        this.c = c;
        this.layout = layout;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(c).inflate(layout, parent, false);
        }

        TextView title = v.findViewById(R.id.tvTitle);
        TextView typeHost = v.findViewById(R.id.tvTypeHost);
        TextView description = v.findViewById(R.id.tvDescription);

        Event ev = data.get(position);
        title.setText(ev.getTitle());
        String finalTypeHost = ev.getType() + " by " + ev.getHost();
        typeHost.setText(finalTypeHost);
        description.setText(ev.getDescription());

        return v;
    }
}
