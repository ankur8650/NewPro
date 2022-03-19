package com.example.mbanotes;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class LastActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        webView = findViewById(R.id.webView);


        int position = getIntent().getIntExtra("position",0);
        int myDataPosition = getIntent().getIntExtra("data", 0);

        switch (position){
            case 4:
                switch (myDataPosition) {
                    case 1:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/databaseOverview.html");
                        break;
                    case 2:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/databaseSystemVsFileSystem.html");
                        break;
                    case 3:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/databaseSystemConceptAndArchitecture.html");
                        break;
                    case 4:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/dataModelSchemaAndInstance.html");
                        break;
                    case 5:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/dataIndependence.html");
                        break;
                    case 6:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/databaseLanguageAndInterfaces.html");
                        break;
                    case 7:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/dataDefinitionLanguage.html");
                        break;
                    case 8:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/dml.html");
                        break;
                    case 9:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/overallDatabaseStructure.html");
                        break;
                    case 10:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/dataModelingUsingTheEntityRelationshipModel.html");
                        break;
                    case 11:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/erModelConcept.html");
                        break;
                    case 12:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/erModelConcept.html");
                        break;
                    case 13:
                        webView.loadUrl("file:///android_asset/databaseManagementSystem/mappingConstraint.html");
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                }
                break;

            case 1:
                switch (myDataPosition) {
                    case 0:
                        Toast.makeText(getApplicationContext(),"Topic One of Subject Two",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Topic Two of Subject Two",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Topic Three of Subject Two",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Topic Four of Subject Two",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"Something wrong",Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }
}