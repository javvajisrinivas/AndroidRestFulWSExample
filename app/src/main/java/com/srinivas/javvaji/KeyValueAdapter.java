package com.srinivas.javvaji;

/**
 * Created by Srinivas Javvaji on 12/16/2015.
 */

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;


public class KeyValueAdapter extends BaseAdapter {
    private final ArrayList mData;

    public KeyValueAdapter(Map<String, Object> map) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, Object> getItem(int position) {
        return (Map.Entry) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO implement you own logic with ID
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;
//        Map<String,Object> curentMap = (Map<String,Object>)mData.get(position);

        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_details_view, parent, false);
        } else {
            result = convertView;
        }

        Map.Entry<String, Object> item = getItem(position);

        //check for odd or even to set alternate colors to the row background
        if(position % 2 == 0){
            result.setBackgroundColor(Color.rgb(238, 233, 233));
        }
        else {
            result.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        String value = "";

        if(item.getValue() instanceof  Double)
        {
            value = ((Double) item.getValue()).toString();

        }else if(item.getValue() instanceof Float)
        {
            value = ((Float) item.getValue()).toString();

        }else if(item.getValue() instanceof Long)
        {
            value = ((Long) item.getValue()).toString();

        }else if(item.getValue() instanceof Integer)
        {
            value = ((Integer) item.getValue()).toString();

        }else if (item.getValue() instanceof String)
        {
            value = ((String) item.getValue()).toString();
        }



//        String value = curentMap.get(item.getKey())+ "";
        // TODO replace findViewById by ViewHolder
        ((TextView) result.findViewById(R.id.individual_key)).setText(item.getKey());
        ((TextView) result.findViewById(R.id.individual_value)).setText(value);

        return result;
    }
}