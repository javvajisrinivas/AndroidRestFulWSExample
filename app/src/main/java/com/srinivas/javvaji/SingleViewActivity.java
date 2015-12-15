package com.srinivas.javvaji;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import loginAction.DueDetails;
import loginAction.GenerateObjectsList;

public class SingleViewActivity extends ListActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        long id = intent.getIntExtra("id", 0);
        String operationSelected = intent.getStringExtra("operationSelected");

        System.out.println("id --> "+ id );
        System.out.println("operationSelected --> "+ operationSelected );

        if(operationSelected.equals("DueList"))
        {
            ListView listView = getListView();
            List<DueDetails> dueDetailsList = GenerateObjectsList.getDueDetailsList();

            DueListAdapter adapter = new DueListAdapter(this, dueDetailsList);
            setListAdapter(adapter);
        }
//        else if(operationSelected.equals("Daily Transaction"))
//        {
//            setContentView(R.layout.transaction_details_view);
//
//        }

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        DueDetails item = (DueDetails) getListAdapter().getItem(position);

        Toast.makeText(this, item.getParty_name() + " selected", Toast.LENGTH_SHORT).show();
    }




}
