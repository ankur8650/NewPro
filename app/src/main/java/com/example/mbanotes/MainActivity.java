package com.example.mbanotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mbanotes.Adapters.CustomAdapter;
import com.example.mbanotes.Models.DataModel;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataModel dataModel = new DataModel();

        listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),dataModel.subName,dataModel.ImgData);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            startActivity(new Intent(getApplicationContext(),TopicActivity.class).putExtra("ankur",position));
        });
    }
}
