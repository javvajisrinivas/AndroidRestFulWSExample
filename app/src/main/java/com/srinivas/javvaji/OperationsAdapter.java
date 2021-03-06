package com.srinivas.javvaji;

/**
 * Created by Srinivas Javvaji on 12/14/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class OperationsAdapter extends BaseAdapter {
    private Context context;
    private final String[] opeationNames;

    public OperationsAdapter(Context context, String[] opeationNames) {
        this.context = context;
        this.opeationNames = opeationNames;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.emp_home, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(opeationNames[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String operation = opeationNames[position];

            if (operation.equals("DueList")) {
                imageView.setImageResource(R.drawable.due_list_128);
            } else if (operation.equals("Daily Transaction")) {
                imageView.setImageResource(R.drawable.transaction_details_128);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return opeationNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}