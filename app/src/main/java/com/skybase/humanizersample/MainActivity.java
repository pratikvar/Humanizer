package com.skybase.humanizersample;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.skybase.humanizersample.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private ActivityMainBinding mBinding;

    private DatePickerDialog mDatePickerDialog;
    private TimePickerDialog mTimePickerDialog;

    private Calendar mSelectedCalendarTime = Calendar.getInstance();

    public final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
        setupListeners();
    }

    private void init() {
        Calendar calendar = Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(MainActivity.this,
                MainActivity.this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE));

        mTimePickerDialog = new TimePickerDialog(MainActivity.this,
                MainActivity.this,
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                false);
    }

    private void setupListeners() {
        mBinding.tvDateSelection.setOnClickListener(v -> {
            mDatePickerDialog.show();
        });

        mBinding.tvTimeSelection.setOnClickListener(v -> {
            mTimePickerDialog.show();
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mSelectedCalendarTime.set(Calendar.YEAR, year);
        mSelectedCalendarTime.set(Calendar.MONTH, month);
        mSelectedCalendarTime.set(Calendar.DATE, dayOfMonth);
        mDatePickerDialog.dismiss();
        mBinding.setValue(getISOFormattedDate(mSelectedCalendarTime.getTime()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mSelectedCalendarTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        mSelectedCalendarTime.set(Calendar.MINUTE, minute);
        mTimePickerDialog.dismiss();
        mBinding.setValue(getISOFormattedDate(mSelectedCalendarTime.getTime()));
    }

    public String getISOFormattedDate(Date dateNonFormat) {
        SimpleDateFormat ISO_FORMATTER = new SimpleDateFormat(ISO_FORMAT, Locale.getDefault());
        return ISO_FORMATTER.format(dateNonFormat);

    }
}
