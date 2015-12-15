package com.srinivas.javvaji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Intent intent = getIntent();

        long id = intent.getIntExtra("id", 0);
        String operationSelected = intent.getStringExtra("operationSelected");

        System.out.println("id --> "+ id );
        System.out.println("operationSelected --> "+ operationSelected );

//        setListAdapter(new ListAct(this, Android));


        if(operationSelected.equals("DueList"))
        {
            setContentView(R.layout.due_details_view);


            ImageView genderIcon = (ImageView) findViewById(R.id.genderIcon);

            TextView party_name = (TextView) findViewById(R.id.party_name);

            TextView party_id = (TextView) findViewById(R.id.party_id);





        }else if(operationSelected.equals("Daily Transaction"))
        {
            setContentView(R.layout.transaction_details_view);

        }

    }





}
