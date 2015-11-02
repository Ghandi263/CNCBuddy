package com.howeloh.www.cncbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Drilling extends AppCompatActivity implements View.OnFocusChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drilling);

        final EditText drillDia = (EditText) findViewById(R.id.drillDiameter);
        final EditText drillSFM = (EditText) findViewById(R.id.drillSurfaceFootage);
        final EditText drillRPM = (EditText) findViewById(R.id.drillRotationalSpeed);
        final EditText drillIPR = (EditText) findViewById(R.id.drillPerRev);
        final EditText drillIPM = (EditText) findViewById(R.id.drillFeed);
        final Button clearButton = (Button) findViewById(R.id.clearButton);

        drillDia.setOnFocusChangeListener(this);
        drillSFM.setOnFocusChangeListener(this);
        drillRPM.setOnFocusChangeListener(this);
        drillIPR.setOnFocusChangeListener(this);
        drillIPM.setOnFocusChangeListener(this);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drillDia.setText("");
                drillSFM.setText("");
                drillRPM.setText("");
                drillRPM.setText("");
                drillIPR.setText("");
                drillIPM.setText("");
            }
        });

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        Calculator calculator = new Calculator();

        if (v.getId() == R.id.drillDiameter && !hasFocus) {
            calculator.diaLostFocus((EditText) findViewById(R.id.drillDiameter),
                    (EditText) findViewById(R.id.drillSurfaceFootage),
                    (EditText) findViewById(R.id.drillRotationalSpeed),
                    (EditText) findViewById(R.id.drillPerRev),
                    (EditText) findViewById(R.id.drillFeed));

        } else if (v.getId() == R.id.drillSurfaceFootage && !hasFocus) {
            calculator.SFMLostFocus((EditText) findViewById(R.id.drillDiameter),
                    (EditText) findViewById(R.id.drillSurfaceFootage),
                    (EditText) findViewById(R.id.drillRotationalSpeed),
                    (EditText) findViewById(R.id.drillPerRev),
                    (EditText) findViewById(R.id.drillFeed));

        } else if (v.getId() == R.id.drillRotationalSpeed && !hasFocus) {
            calculator.RPMLostFocus((EditText) findViewById(R.id.drillDiameter),
                    (EditText) findViewById(R.id.drillSurfaceFootage),
                    (EditText) findViewById(R.id.drillRotationalSpeed),
                    (EditText) findViewById(R.id.drillPerRev),
                    (EditText) findViewById(R.id.drillFeed));

        } else if (v.getId() == R.id.drillPerRev && !hasFocus) {
            calculator.IPRLostFocus((EditText) findViewById(R.id.drillDiameter),
                    (EditText) findViewById(R.id.drillSurfaceFootage),
                    (EditText) findViewById(R.id.drillRotationalSpeed),
                    (EditText) findViewById(R.id.drillPerRev),
                    (EditText) findViewById(R.id.drillFeed));

        } else if (v.getId() == R.id.drillFeed && !hasFocus) {
            calculator.IPMLostFocus((EditText) findViewById(R.id.drillDiameter),
                    (EditText) findViewById(R.id.drillSurfaceFootage),
                    (EditText) findViewById(R.id.drillRotationalSpeed),
                    (EditText) findViewById(R.id.drillPerRev),
                    (EditText) findViewById(R.id.drillFeed));

        }
    }
}

