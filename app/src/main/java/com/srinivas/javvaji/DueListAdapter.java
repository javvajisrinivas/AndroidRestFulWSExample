package com.srinivas.javvaji;

/**
 * Created by Srinivas Javvaji on 12/15/2015.
 */

import java.text.NumberFormat;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import loginAction.DueDetails;


public class DueListAdapter extends ArrayAdapter<DueDetails> {

    private Context context;
    private List<DueDetails> items;

    public DueListAdapter(Context context, List<DueDetails> items) {
        super(context, R.layout.due_details_view, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = convertView;
//
//        if(v == null) {
//            LayoutInflater li = LayoutInflater.from(getContext());
//            v = li.inflate(R.layout.due_details_view, null);
//        }
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.due_details_view, parent, false);


        DueDetails dueDetails = items.get(position);

        if(dueDetails != null) {
            ImageView icon = (ImageView)v.findViewById(R.id.genderIcon);
            TextView partyName = (TextView)v.findViewById(R.id.party_name);
            TextView partyId = (TextView)v.findViewById(R.id.party_id);
//            LinearLayout ratingCntr = (LinearLayout)v.findViewById(R.id.ratingCntr);
            TextView dlText = (TextView)v.findViewById(R.id.dlTxt);

            if(icon != null) {
                Resources res = getContext().getResources();
                String sIcon = "com.srinivas.javvaji:drawable/party_details" ;
                icon.setImageDrawable(res.getDrawable(res.getIdentifier(sIcon, null, null)));
            }

            if(partyName != null) partyName.setText(dueDetails.getParty_name());

            if(dlText != null) {
                NumberFormat nf = NumberFormat.getNumberInstance();
                dlText.setText(nf.format(dueDetails.getPending_amt())+" dl");
            }

            if(partyId != null)
            {
                partyId.setText(dueDetails.getParty_id());

            }


        }

        return v;
    }
}
