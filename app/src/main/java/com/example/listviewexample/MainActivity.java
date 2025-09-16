package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

import model.Pet;

public class MainActivity extends AppCompatActivity {
    ListView petListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        petListView = findViewById(R.id.petListView);

        int selection = 2;
        populateListView(selection);
    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String[] content = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, content);
        petListView.setAdapter(adapter);
    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {
        LinkedList<Pet> content  = new LinkedList<>();
        content.add(new Pet("dog", "Golden Retriever", 5));
        content.add(new Pet("doug", "Beagle", 10));
        content.add(new Pet("god", "Checkoslovaquian Wolf Dog", 15));
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, content);
        petListView.setAdapter(adapter);
    }
}