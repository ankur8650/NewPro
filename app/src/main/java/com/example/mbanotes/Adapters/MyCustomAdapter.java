package com.example.mbanotes.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mbanotes.Models.DataModel;
import com.example.mbanotes.R;

public class MyCustomAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] topName;

    public MyCustomAdapter(@NonNull Context context, String[] topName) {
        super(context, R.layout.row_topic_design,topName);
        this.context = context;
        this.topName = topName;
    }
    public View getView(int position, View view, ViewGroup parent){

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view1 = layoutInflater.inflate(R.layout.row_topic_design, parent, false);

            TextView textView = view1.findViewById(R.id.textView);

            textView.setText(topName[position]);

            DataModel dataModel = new DataModel();
            String[] newData = dataModel.getTopicColor();
            String[] unitName = dataModel.getUnitColor();
            for (int i = 0;i<unitName.length;i++){
                if (topName[position].equals(unitName[i])){
                    view1.setBackgroundColor(Color.parseColor("#FF6F00"));
                    textView.setTextColor(Color.parseColor("#FF6F00"));
                    textView.setTextSize(20);
                }

        }

        return view1;
    }
}
