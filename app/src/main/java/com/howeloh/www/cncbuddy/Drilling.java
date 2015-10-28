package com.howeloh.www.cncbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Drilling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drilling);


        setFocusChangeListeners();
    }

    private void setFocusChangeListeners (){

        final EditText drillDia = (EditText) findViewById(R.id.drillDiameter);
        final EditText drillSFM = (EditText) findViewById(R.id.drillSurfaceFootage);
        final EditText drillRPM = (EditText) findViewById(R.id.drillRotationalSpeed);
        final EditText drillIPR = (EditText) findViewById(R.id.drillPerRev);
        final EditText drillIPM = (EditText) findViewById(R.id.drillFeed);
        Calculator calc = new Calculator();

        drillDia.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String DiaString = drillDia.getText().toString();
                    String SFMString = drillSFM.getText().toString();
                    String RPMString = drillRPM.getText().toString();
                    String IPRString = drillIPR.getText().toString();
                    String IPMString = drillIPM.getText().toString();

                    if (!DiaString.equals("") && !SFMString.equals("")) {
                        RPMString = calculateRPM_w_Dia_SFM(Double.valueOf(DiaString), Double.valueOf(SFMString));
                        drillRPM.setText(RPMString);

                        if (!IPRString.equals("")) {
                            IPMString = calculateIPM_w_RPM_IPR(Double.valueOf(RPMString), Double.valueOf(IPRString));
                            drillIPM.setText(IPMString);

                        } else if (!IPMString.equals("")){
                            IPRString = calculateIPR_w_RPM_IPM(Double.valueOf(RPMString), Double.valueOf(IPMString));
                            drillIPR.setText(IPRString);
                        }

                    } else if (!DiaString.equals("") && !RPMString.equals("")) {
                        SFMString = calculateSFM_w_Dia_RPM(Double.valueOf(DiaString), Double.valueOf(RPMString));
                        drillSFM.setText(SFMString);
                    }
                }
            }
        });

        drillSFM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String DiaString = drillDia.getText().toString();
                    String SFMString = drillSFM.getText().toString();
                    String RPMString = drillRPM.getText().toString();
                    String IPRString = drillIPR.getText().toString();
                    String IPMString = drillIPM.getText().toString();

                    if (!DiaString.equals("") && !SFMString.equals("")) {
                        RPMString = calculateRPM_w_Dia_SFM(Double.valueOf(DiaString), Double.valueOf(SFMString));
                        drillRPM.setText(RPMString);

                        if (!IPRString.equals("")) {
                            IPMString = calculateIPM_w_RPM_IPR(Double.valueOf(RPMString), Double.valueOf(IPRString));
                            drillIPM.setText(IPMString);

                        } else if (!IPMString.equals("")){
                            IPRString = calculateIPR_w_RPM_IPM(Double.valueOf(RPMString), Double.valueOf(IPMString));
                            drillIPR.setText(IPRString);
                        }

                    } else if (!SFMString.equals("") && !RPMString.equals("")) {
                        DiaString = calculateDia_w_SFM_RPM(Double.valueOf(SFMString), Double.valueOf(RPMString));
                        drillDia.setText(DiaString);

                    }
                }
            }
        });

        drillRPM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String DiaString = drillDia.getText().toString();
                    String SFMString = drillSFM.getText().toString();
                    String RPMString = drillRPM.getText().toString();
                    String IPRString = drillIPR.getText().toString();
                    String IPMString = drillIPM.getText().toString();

                    if (!IPRString.equals("") && !RPMString.equals("")){
                        IPMString = calculateIPM_w_RPM_IPR(Double.valueOf(RPMString), Double.valueOf(IPRString));
                        drillIPM.setText(IPMString);

                    } else if (!IPMString.equals("") && !RPMString.equals("")) {
                        IPRString = calculateIPM_w_RPM_IPR(Double.valueOf(RPMString), Double.valueOf(IPRString));
                        drillIPM.setText(IPRString);

                    }

                    if (!DiaString.equals("") && !RPMString.equals("")){
                        SFMString = calculateSFM_w_Dia_RPM(Double.valueOf(DiaString), Double.valueOf(RPMString));
                        drillSFM.setText(SFMString);

                    } else if(!SFMString.equals("") && !RPMString.equals("")){
                        DiaString = calculateDia_w_SFM_RPM(Double.valueOf(SFMString), Double.valueOf(RPMString));
                        drillDia.setText(DiaString);

                    }
                }
            }
        });
    }

    private String calculateDia_w_SFM_RPM(double SFM, double RPM){
        return String.format("%.4f", SFM / (RPM * (Math.PI / 12d)));
    }

    private String calculateSFM_w_Dia_RPM (double Dia, double RPM){
        return String.format("%.4f", Dia * (RPM * (Math.PI / 12d)));
    }

    private String calculateRPM_w_Dia_SFM(double Dia, double SFM){
        return String.format("%.4f", SFM /(Dia * (Math.PI / 12d)));
    }

    private String calculateRPM_w_IPR_IPM (double IPR, double IPM){
        return String.format("%.4f", IPM/IPR);
    }

    private String calculateIPM_w_RPM_IPR (double RPM, double IPR){
        return String.format("%.4f", RPM * IPR);
    }

    private String calculateIPR_w_RPM_IPM (double RPM, double IPM){
        return String.format("%.4f", IPM / RPM);
    }
}

