package com.srinivas.javvaji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


public class EmployeeActivity extends Activity {

    static final String[] EMP_OPERATIONS = new String[] {
            "DueList", "Daily Transaction" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new OperationsAdapter(this,EMP_OPERATIONS ));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Toast.makeText(getApplicationContext(), ((TextView) v.findViewById(R.id.grid_item_label)).getText(), Toast.LENGTH_SHORT).show();
                // Send intent to SingleViewActivity
                Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);

                // Pass image index
                i.putExtra("id", position);
                i.putExtra("operationSelected", ((TextView) v.findViewById(R.id.grid_item_label)).getText());
                startActivity(i);
            }
        });
    }


}
