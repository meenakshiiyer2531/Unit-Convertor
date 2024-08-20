package com.example.conersionapp1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actvFrom, actvTo;
    EditText etInput;
    Button btnConvert;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        actvFrom = findViewById(R.id.actvFrom);
        actvTo = findViewById(R.id.actvTo);
        etInput = findViewById(R.id.etInput);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);

        // Define unit options
        String[] units = getResources().getStringArray(R.array.length_units);

        // Set up the AutoCompleteTextViews
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, units);
        actvFrom.setAdapter(adapter);
        actvTo.setAdapter(adapter);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double input = Double.parseDouble(etInput.getText().toString());
                    String fromUnit = actvFrom.getText().toString();
                    String toUnit = actvTo.getText().toString();

                    double result = convertUnits(input, fromUnit, toUnit);
                    tvResult.setText(String.format("%.2f", result));
                } catch (NumberFormatException e) {
                    tvResult.setText("Invalid input");
                }
            }
        });
    }

    private double convertUnits(double input, String fromUnit, String toUnit) {
        // Convert input units to lower case for case-insensitive comparison
        fromUnit = fromUnit.toLowerCase();
        toUnit = toUnit.toLowerCase();

        // Length conversion logic
        if (fromUnit.equals("meter")) {
            if (toUnit.equals("kilometer")) return input / 1000;
            if (toUnit.equals("centimeter")) return input * 100;
            if (toUnit.equals("millimeter")) return input * 1000;
            if (toUnit.equals("mile")) return input * 0.000621371;
            if (toUnit.equals("yard")) return input * 1.09361;
            if (toUnit.equals("foot")) return input * 3.28084;
            if (toUnit.equals("inch")) return input * 39.3701;
        } else if (fromUnit.equals("kilometer")) {
            if (toUnit.equals("meter")) return input * 1000;
            if (toUnit.equals("centimeter")) return input * 100000;
            if (toUnit.equals("millimeter")) return input * 1000000;
            if (toUnit.equals("mile")) return input * 0.621371;
            if (toUnit.equals("yard")) return input * 1093.61;
            if (toUnit.equals("foot")) return input * 3280.84;
            if (toUnit.equals("inch")) return input * 39370.1;
        } else if (fromUnit.equals("centimeter")) {
            if (toUnit.equals("meter")) return input / 100;
            if (toUnit.equals("kilometer")) return input / 100000;
            if (toUnit.equals("millimeter")) return input * 10;
            if (toUnit.equals("mile")) return input * 0.0000062137;
            if (toUnit.equals("yard")) return input * 0.0109361;
            if (toUnit.equals("foot")) return input * 0.0328084;
            if (toUnit.equals("inch")) return input * 0.393701;
        } else if (fromUnit.equals("millimeter")) {
            if (toUnit.equals("meter")) return input / 1000;
            if (toUnit.equals("kilometer")) return input / 1000000;
            if (toUnit.equals("centimeter")) return input / 10;
            if (toUnit.equals("mile")) return input * 0.000000621371;
            if (toUnit.equals("yard")) return input * 0.00109361;
            if (toUnit.equals("foot")) return input * 0.00328084;
            if (toUnit.equals("inch")) return input * 0.0393701;
        } else if (fromUnit.equals("mile")) {
            if (toUnit.equals("meter")) return input / 0.000621371;
            if (toUnit.equals("kilometer")) return input / 0.621371;
            if (toUnit.equals("centimeter")) return input * 160934;
            if (toUnit.equals("millimeter")) return input * 1609340;
            if (toUnit.equals("yard")) return input * 1760;
            if (toUnit.equals("foot")) return input * 5280;
            if (toUnit.equals("inch")) return input * 63360;
        } else if (fromUnit.equals("yard")) {
            if (toUnit.equals("meter")) return input / 1.09361;
            if (toUnit.equals("kilometer")) return input / 1093.61;
            if (toUnit.equals("centimeter")) return input * 91.44;
            if (toUnit.equals("millimeter")) return input * 914.4;
            if (toUnit.equals("mile")) return input * 0.000568182;
            if (toUnit.equals("foot")) return input * 3;
            if (toUnit.equals("inch")) return input * 36;
        } else if (fromUnit.equals("foot")) {
            if (toUnit.equals("meter")) return input / 3.28084;
            if (toUnit.equals("kilometer")) return input / 3280.84;
            if (toUnit.equals("centimeter")) return input * 30.48;
            if (toUnit.equals("millimeter")) return input * 304.8;
            if (toUnit.equals("mile")) return input * 0.000189394;
            if (toUnit.equals("yard")) return input / 3;
            if (toUnit.equals("inch")) return input * 12;
        } else if (fromUnit.equals("inch")) {
            if (toUnit.equals("meter")) return input / 39.3701;
            if (toUnit.equals("kilometer")) return input / 39370.1;
            if (toUnit.equals("centimeter")) return input * 2.54;
            if (toUnit.equals("millimeter")) return input * 25.4;
            if (toUnit.equals("mile")) return input * 0.000015783;
            if (toUnit.equals("yard")) return input / 36;
            if (toUnit.equals("foot")) return input / 12;
        }

        return 0;
    }
}