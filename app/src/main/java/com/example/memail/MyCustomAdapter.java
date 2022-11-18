package com.example.memail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> list;
    private Context context;
    private String application;

    public MyCustomAdapter(ArrayList<String> list, Context context,String Application) {
        this.list = list;
        this.context = context;
        this.application = Application;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_layout, null);
        }

        //Handle buttons and add onClickListeners
        Button callbtn= (Button) view.findViewById(R.id.btn);
        callbtn.setText(list.get(position));

        callbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(application.equals("TopicActivity")){
                    Intent myIntent = new Intent(context, FormatActivity.class);
                    context.startActivity(myIntent);
                }
                else if(application.equals("FormatActivity")){
                    Intent myIntent = new Intent(context, DraftActivity.class);
                    context.startActivity(myIntent);
                }
            }
        });

        return view;
    }
}