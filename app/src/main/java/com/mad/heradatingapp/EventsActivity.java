package com.mad.heradatingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {
    ArrayList<Event> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        data = new ArrayList<>();
        for(int i = 1; i <= 100; i++){
            Event ev = new Event();
            ev.setTitle("Event " + i);
            ev.setType("Type " + i);
            ev.setHost("Host " + i);
            ev.setDescription("Lorem ipsum " + i);
            data.add(ev);
        }

        EventsAdapter adapter = new EventsAdapter(this, R.layout.layout_event, data);

        ListView list = findViewById(R.id.lvEventList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent intent = new Intent(EventsActivity.this, HomePageActivity.class);
                Event selectedItem = (Event) adapterView.getItemAtPosition(i);
                intent.putExtra("Title", selectedItem.getTitle());
                startActivity(intent);
            }
        });
    }
}
