package com.howeloh.www.cncbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Milling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milling);

        final EditText millDia = (EditText) findViewById(R.id.millDiameter);
        final EditText millSFM = (EditText) findViewById(R.id.millSurfaceFootage);
        final EditText millRPM = (EditText) findViewById(R.id.millRotationalSpeed);
        final EditText millIPT = (EditText) findViewById(R.id.millPerTooth);
        final EditText millTeeth = (EditText) findViewById(R.id.millTeeth);
        final EditText millFeed = (EditText) findViewById(R.id.millFeed);
        Button clearBtn = (Button) findViewById(R.id.millClearButton);
        Button toDrillingBtn = (Button) findViewById(R.id.toDrillingButton);

        final Calculator calculator = new Calculator();

        View.OnFocusChangeListener bigFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v.getId() == R.id.millDiameter && !hasFocus) {
                    calculator.diaLostFocus(millDia, millSFM, millRPM, millIPT, millFeed, millTeeth);

                } else if (v.getId() == R.id.millSurfaceFootage && !hasFocus) {
                    calculator.SFMLostFocus(millDia, millSFM, millRPM, millIPT, millFeed, millTeeth);

                } else if (v.getId() == R.id.millRotationalSpeed && !hasFocus) {
                    calculator.RPMLostFocus(millDia, millSFM, millRPM, millIPT, millFeed, millTeeth);

                } else if (v.getId() == R.id.millPerTooth && !hasFocus) {
                    calculator.IPRLostFocus(millDia, millSFM, millRPM, millIPT, millFeed, millTeeth);

                } else if (v.getId() == R.id.millFeed && !hasFocus) {
                    calculator.IPMLostFocus(millDia, millSFM, millRPM, millIPT, millFeed, millTeeth);

                } else if (v.getId() == R.id.millTeeth && !hasFocus) {
                    calculator.teethLostFocus(millDia, millSFM, millRPM, millIPT, millFeed, millTeeth);
                }
            }
        };

        millDia.setOnFocusChangeListener(bigFocusChangeListener);
        millSFM.setOnFocusChangeListener(bigFocusChangeListener);
        millRPM.setOnFocusChangeListener(bigFocusChangeListener);
        millIPT.setOnFocusChangeListener(bigFocusChangeListener);
        millFeed.setOnFocusChangeListener(bigFocusChangeListener);
        millTeeth.setOnFocusChangeListener(bigFocusChangeListener);

        toDrillingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Milling.this, Drilling.class));
                finish();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                millDia.setText("");
                millSFM.setText("");
                millRPM.setText("");
                millIPT.setText("");
                millTeeth.setText("");
                millFeed.setText("");
            }
        });
    }
}
