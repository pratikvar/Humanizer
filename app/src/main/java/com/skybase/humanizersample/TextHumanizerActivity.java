package com.skybase.humanizersample;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.skybase.humanizersample.databinding.ActivityTextHumanizerBinding;

public class TextHumanizerActivity extends AppCompatActivity {

    private ActivityTextHumanizerBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_text_humanizer);
        setupListeners();
    }

    private void setupListeners() {
        mBinding.etHumanizeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBinding.setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
