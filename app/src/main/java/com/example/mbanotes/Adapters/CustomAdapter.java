package com.example.mbanotes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mbanotes.R;

public class CustomAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] subName;
    private final Integer[] imgData;

    public CustomAdapter(@NonNull Context context, String[] subName, Integer[] imgData) {
        super(context, R.layout.row_design,subName);
        this.context = context;
        this.subName = subName;
        this.imgData = imgData;
    }
    public View getView(int position, View view, ViewGroup parent){

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.row_design,parent,false);

        TextView textView = view1.findViewById(R.id.textView);
        ImageView imageView = view1.findViewById(R.id.imageView);

        textView.setText(subName[position]);
        imageView.setImageResource(imgData[position]);

        return view1;
    }
}
