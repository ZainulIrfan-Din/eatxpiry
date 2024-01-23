package com.example.ocr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity
{
    private static  final  String TAG = "CalendarActivity";

    private CalendarView mCalendarView;
    private TextView theDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);

        mCalendarView = (CalendarView)findViewById(R.id.calendarView);
        theDate = (TextView)findViewById(R.id.idDate);

        /*mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i2 + "/" + (i1 + 1) +"/" + i;
                Log.d(TAG, "OnSelectedDayChange: dd//mm//yyyy " + date);

                Intent intent = new Intent(CalendarActivity.this, CalendarActivity.class);
                intent.putExtra("date", date);

                theDate.setText(date);
            }
        });*/

    }
}
