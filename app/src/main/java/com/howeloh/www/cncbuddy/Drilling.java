package com.howeloh.www.cncbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Drilling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drilling);

        final EditText drillDia = (EditText) findViewById(R.id.drillDiameter);
        final EditText drillSFM = (EditText) findViewById(R.id.drillSurfaceFootage);
        final EditText drillRPM = (EditText) findViewById(R.id.drillRotationalSpeed);
        final EditText drillIPR = (EditText) findViewById(R.id.drillPerRev);
        final EditText drillIPM = (EditText) findViewById(R.id.drillFeed);
        final EditText drillAngle = (EditText) findViewById(R.id.drillTipAngle);
        final EditText drillDepth = (EditText) findViewById(R.id.drillTipDepth);
        Button clearButton = (Button) findViewById(R.id.drillClearButton);
        Button toMillingBtn = (Button) findViewById(R.id.toMillingButton);

        final Calculator calculator = new Calculator();

        View.OnFocusChangeListener bigFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v.getId() == R.id.drillDiameter && !hasFocus) {
                    calculator.diaLostFocus(drillDia, drillSFM, drillRPM, drillIPR, drillIPM, drillAngle, drillDepth);

                } else if (v.getId() == R.id.drillSurfaceFootage && !hasFocus) {
                    calculator.SFMLostFocus(drillDia, drillSFM, drillRPM, drillIPR, drillIPM, drillAngle, drillDepth);

                } else if (v.getId() == R.id.drillRotationalSpeed && !hasFocus) {
                    calculator.RPMLostFocus(drillDia, drillSFM, drillRPM, drillIPR, drillIPM, drillAngle, drillDepth);

                } else if (v.getId() == R.id.drillPerRev && !hasFocus) {
                    calculator.IPRLostFocus(drillDia, drillSFM, drillRPM, drillIPR, drillIPM, drillAngle, drillDepth);

                } else if (v.getId() == R.id.drillFeed && !hasFocus) {
                    calculator.IPMLostFocus(drillDia, drillSFM, drillRPM, drillIPR, drillIPM, drillAngle, drillDepth);

                } else if (v.getId() == R.id.drillTipAngle && !hasFocus) {
                    calculator.angleLostFocus(drillDia, drillSFM, drillRPM, drillIPR, drillIPM, drillAngle, drillDepth);

                } else if (v.getId() == R.id.drillTipDepth && !hasFocus) {
                    calculator.depthLostFocus(drillDia, drillSFM, drillRPM, drillIPR, drillIPM, drillAngle, drillDepth);

                }
            }
        };

        drillDia.setOnFocusChangeListener(bigFocusChangeListener);
        drillSFM.setOnFocusChangeListener(bigFocusChangeListener);
        drillRPM.setOnFocusChangeListener(bigFocusChangeListener);
        drillIPR.setOnFocusChangeListener(bigFocusChangeListener);
        drillIPM.setOnFocusChangeListener(bigFocusChangeListener);
        drillAngle.setOnFocusChangeListener(bigFocusChangeListener);
        drillDepth.setOnFocusChangeListener(bigFocusChangeListener);

        toMillingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Drilling.this, Milling.class));
                finish();
            }
        });

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
}