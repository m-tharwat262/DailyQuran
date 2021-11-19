package com.sours.and.ayat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplaySura extends AppCompatActivity {

    TextView titleName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sura);


        LinearLayout linearLayoutContainerForSura = findViewById(R.id.display_sura_container);


        String suraName = getIntent().getStringExtra("sura_name");

        titleName = findViewById(R.id.activity_title);
        titleName.setText(getString(R.string.sura_name_title, suraName));

        View suraView = getView(suraName);


        linearLayoutContainerForSura.addView(suraView);

        setClickingOnBackUpButton();


    }


    private View getView(String suraName) {

        View suraView;


        if (suraName.equals("الدخان")) {

            suraView = LayoutInflater.from(this).inflate(R.layout.sura_dokhan, null);

        } else if(suraName.equals("الواقعة")) {

            suraView = LayoutInflater.from(this).inflate(R.layout.sura_wakaa, null);

        }  else if(suraName.equals("يس")) {

            suraView = LayoutInflater.from(this).inflate(R.layout.sura_ys, null);

        }  else if(suraName.equals("الملك")) {

            suraView = LayoutInflater.from(this).inflate(R.layout.sura_molk, null);

        } else if (suraName.equals("الرحمن")) {

            suraView = LayoutInflater.from(this).inflate(R.layout.sura_rahman, null);

        } else if (suraName.equals("البقرة (آيه الكرسي)")) {

            suraView = LayoutInflater.from(this).inflate(R.layout.aya_krsi, null);
            titleName.setText("البقرة (آيه الكرسي)");

        } else if (suraName.equals("البقرة (آخر آيتين)")) {

            suraView = LayoutInflater.from(this).inflate(R.layout.last_two_aya_in_bakra, null);
            titleName.setText("البقرة (آخر آيتين)");

        } else {

            suraView = LayoutInflater.from(this).inflate(R.layout.sura_fataha, null);

        }

        return suraView;

    }



    private void setClickingOnBackUpButton() {

        ImageView backUpButton = findViewById(R.id.activity_back_up_button);

        backUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


}