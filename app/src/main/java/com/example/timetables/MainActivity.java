package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myTimeTable;

    public void generateTimeTableContent(int timeTableNumber) {
        ArrayList<String> timeTableContent = new ArrayList<String>();

        for (int j = 1; j<=10; j++) {
            timeTableContent.add(Integer.toString(j * timeTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timeTableContent);
        myTimeTable.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeSeekBar = findViewById(R.id.timeSeekBar);
        myTimeTable = findViewById(R.id.myTimeTable);

        int max = 20;
        int startingPosition = 10;

        timeSeekBar.setMax(max);
        timeSeekBar.setProgress(startingPosition);

        generateTimeTableContent(startingPosition);

        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timeTableNumber;

                if (i < min) {
                    timeTableNumber = min;
                    timeSeekBar.setProgress(min);
                } else {
                    timeTableNumber = i;
                }

                Log.i("SeekBar Number", Integer.toString(timeTableNumber));
                generateTimeTableContent(timeTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
