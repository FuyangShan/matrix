package com.laioffer.matrix;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml.
        ListView eventListView = (ListView) findViewById(R.id.event_list);
        // Assign adapter to ListView.
        EventAdapter adapter = new EventAdapter(this);
        eventListView.setAdapter(adapter);
    }

    /**
     * A dummy function to get fake event names.
     */
    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"};
        return names;
    }
}
