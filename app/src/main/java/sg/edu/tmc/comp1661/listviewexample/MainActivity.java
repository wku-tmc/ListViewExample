package sg.edu.tmc.comp1661.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source
        ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event("TMC Open House", "TMC City Campus",
                "27 Feb 2016 2pm",  "TMC Academy",
                "Annual open house, open to public"));
        events.add(new Event("Ice cream contest", "TMC City Campus",
                "14 Feb 2016 2pm", "TMC Academy",
                "For ice cream lovers only"));

        // Create the adapter to convert the array to views
        EventAdapter adapter = new EventAdapter(this, events);

        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event e = (Event) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected: " + e.getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
