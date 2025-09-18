package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.Pet;

public class MainActivity extends AppCompatActivity {
    ListView petListView;
    LinkedList<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        petListView = findViewById(R.id.petListView);
        petListView.setOnItemSelectedListener(listListener);

        Random rand = new Random();
        pets = new LinkedList<>();
        pets.add(new Pet("dog", "Golden Retriever", rand.nextInt(20)));
        pets.add(new Pet("dog 2", "Beagle", rand.nextInt(20)));
        pets.add(new Pet("dog 3", "Checkoslovaquian Wolf Dog", rand.nextInt(20)));

        int selection = 3;
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
            case 3:
                usingTwoLines();
                break;
        }
    }

    private void useStringResource() {
        String[] content = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, content);
        petListView.setAdapter(adapter);
    }

    private void usingDataArray() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pets);
        petListView.setAdapter(adapter);
    }

    private void usingTwoLines() {
        List<HashMap<String, String>> data = new ArrayList<>();

        for (Pet p : pets) {
            HashMap<String, String> current = new HashMap<>();
            current.put("name", p.getName());
            current.put("breed", p.getBreed());
            data.add(current);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "breed"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );
        petListView.setAdapter(adapter);
    }

    AdapterView.OnItemSelectedListener listListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(getApplicationContext(), view.toString() + " " + i, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
}