package com.example.mbanotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mbanotes.Adapters.MyCustomAdapter;
import com.example.mbanotes.Models.DataModel;

public class TopicActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        listView = findViewById(R.id.listView2);

        int myDataPosition = getIntent().getIntExtra("ankur", 0);

        DataModel dataModel = new DataModel();

        switch (myDataPosition) {
            case 0:
                MyCustomAdapter myCustomAdapter = new MyCustomAdapter(this,dataModel.getEmergingTechnologiesInGlobalBusinessEnvironment());
                listView.setAdapter(myCustomAdapter);

                break;
            case 1:
                MyCustomAdapter myCustomAdapter1 = new MyCustomAdapter(this,dataModel.getB2bandServiceMarketing());
                listView.setAdapter(myCustomAdapter1);
                break;
            case 2:
                MyCustomAdapter myCustomAdapter2 = new MyCustomAdapter(this,dataModel.getSalesandRetailManagement());
                listView.setAdapter(myCustomAdapter2);
                break;
            case 3:
                MyCustomAdapter myCustomAdapter3 = new MyCustomAdapter(this,dataModel.getSocialMedialandWebAnalytics());
                listView.setAdapter(myCustomAdapter3);
                break;
            case 4:
                MyCustomAdapter myCustomAdapter4 = new MyCustomAdapter(this,dataModel.getDataBaseManagementSystem());
                listView.setAdapter(myCustomAdapter4);

                listView.setOnItemClickListener((AdapterView<?> adapterView, View view, int position, long l) -> {
                    startActivity(new Intent(getApplicationContext(), LastActivity.class).putExtra("data", position).putExtra("position",myDataPosition));
                });
                break;
            case 5:
                MyCustomAdapter myCustomAdapter5 = new MyCustomAdapter(this,dataModel.getCloudComputingForBusiness());
                listView.setAdapter(myCustomAdapter5);
                break;
            case 6:
                MyCustomAdapter myCustomAdapter6 = new MyCustomAdapter(this,dataModel.getBusinessDataWarehousingAndDataMining());
                listView.setAdapter(myCustomAdapter6);
                break;
            case 7:
                MyCustomAdapter myCustomAdapter7 = new MyCustomAdapter(this,dataModel.getHrAnalytics());
                listView.setAdapter(myCustomAdapter7);
                break;
            case 8:
                MyCustomAdapter myCustomAdapter8 = new MyCustomAdapter(this,dataModel.getHrAnalytics());
                listView.setAdapter(myCustomAdapter8);
                break;
            case 9:
                MyCustomAdapter myCustomAdapter9 = new MyCustomAdapter(this,dataModel.getB2bandServiceMarketing());
                listView.setAdapter(myCustomAdapter9);
                break;
            case 10:
                MyCustomAdapter myCustomAdapter10 = new MyCustomAdapter(this,dataModel.getEmergingTechnologiesInGlobalBusinessEnvironment());
                listView.setAdapter(myCustomAdapter10);
                break;
            case 11:
                MyCustomAdapter myCustomAdapter11 = new MyCustomAdapter(this,dataModel.getB2bandServiceMarketing());
                listView.setAdapter(myCustomAdapter11);
                break;
            case 12:
                MyCustomAdapter myCustomAdapter12 = new MyCustomAdapter(this,dataModel.getB2bandServiceMarketing());
                listView.setAdapter(myCustomAdapter12);
                break;
            default:
                Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_SHORT).show();
        }





    }}
