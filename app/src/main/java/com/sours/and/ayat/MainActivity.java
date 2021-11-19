package com.sours.and.ayat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    private ListView listView;
    private MainItemAdapter mainItemAdapter;


    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.activity_settings_toolbar);

        toolbar.setTitle("");

        setSupportActionBar(toolbar);




        listView = findViewById(R.id.main_activity_list_view);

        ArrayList<SuraObject> suraObjectArrayList = getSuraObjectArrayList();

        mainItemAdapter = new MainItemAdapter(this, suraObjectArrayList);

        listView.setAdapter(mainItemAdapter);

//        setClickingOnListViewItems();

    }

    private void setClickingOnListViewItems() {


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i(LOG_TAG, "the method inside the listener is triggered 555555555555555555555500");

                Intent intent = new Intent(MainActivity.this, DisplaySura.class);
                startActivity(intent);

            }
        });











    }


    private ArrayList<SuraObject> getSuraObjectArrayList() {

        ArrayList<SuraObject> suraObjectArrayList = new ArrayList<>();


        String[] names = getSuraNames();
        int[] numbers = getSuraNumbers();
        String[] types = getSuraTypes();


        for (int i = 0 ; i < names.length ; i++) {

            SuraObject singleSuraObject = new SuraObject(names[i], numbers[i], types[i]);

            suraObjectArrayList.add(singleSuraObject);

        }

        return suraObjectArrayList;


    }


    private String[] getSuraNames() {

        String[] names = {"الفاتحة", "الرحمن", "الواقعة", "الدخان", "يس", "الملك", "البقرة (آيه الكرسي)", "البقرة (آخر آيتين)"};


        return names;

    }


    private int[] getSuraNumbers() {

        int[] names = {7, 78, 96, 59, 83, 30, 1, 2};


        return names;

    }


    private String[] getSuraTypes() {

        String[] names = {"مكيه", "مدنيه", "مكيه", "مكيه", "مكيه", "مكيه", "مدنيه", "مدنيه"};


        return names;

    }


    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.click_back_again_to_exit), Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    doubleBackToExitPressedOnce = false; }}, 2000);


    }


}