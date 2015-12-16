package com.srinivas.javvaji;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import loginAction.DueDetails;
import loginAction.GenerateObjectsList;

/**
 * Created by Srinivas Javvaji on 12/15/2015.
 */
public class IndividualDetailsView extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Gson gson = new Gson();
        Intent individualObj = getIntent();

        String jsonString = individualObj.getStringExtra("DueDetailsObj");


        DueDetails dueDetails = gson.fromJson(jsonString, DueDetails.class);

//        GenerateObjectsList.objectToMap(dueDetails);
//        HashMap<String,String> objMap = (HashMap<String,String>) GenerateObjectsList.jsonToMap(jsonString);

        Map<String,Object> map=new HashMap<String,Object>();
        HashMap<String,Object> objMap =(HashMap<String,Object>) gson.fromJson(jsonString, map.getClass());


        KeyValueAdapter adapter = new KeyValueAdapter(objMap);
        ListView listView = getListView();
        setListAdapter(adapter);

        Toast.makeText(this, dueDetails.getCompany_name() + "<-hello->" + dueDetails.getParty_name() + " selected", Toast.LENGTH_SHORT).show();

    }
}
