package com.sours.and.ayat;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.ArrayList;

public class MainItemAdapter extends ArrayAdapter<SuraObject> {

    private static final String LOG_TAG = MainItemAdapter.class.getSimpleName();
    private Context mContext;

    public MainItemAdapter(Context context, ArrayList<SuraObject> suraObjectArrayAdapter) {
        super(context, 0, suraObjectArrayAdapter);

        mContext = context;



    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View itemView = convertView;

        if (convertView == null) {


            itemView = LayoutInflater.from(mContext).inflate(R.layout.item_for_main_activity, parent, false);

        }


        LinearLayout linearLayoutContainer = itemView.findViewById(R.id.item_containter);
        TextView nameTextView = itemView.findViewById(R.id.item_name);
        TextView numberTextView = itemView.findViewById(R.id.item_number);
        TextView typeTextView = itemView.findViewById(R.id.item_type);



        SuraObject suraObject = getItem(position);



        nameTextView.setText(suraObject.getName());


        int numberOfAya = suraObject.getNumber();

        String ayHaga = mContext.getString(R.string.number_of_aya, numberOfAya);

        numberTextView.setText(ayHaga);
        typeTextView.setText(suraObject.getType());



        linearLayoutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(LOG_TAG, "the method inside the listener is triggered 555555555555555555555500");

                Intent intent = new Intent(mContext, DisplaySura.class);
                intent.putExtra("sura_name", suraObject.getName());
                mContext.startActivity(intent);



            }
        });




        return itemView;



    }




}
