package com.howeloh.www.cncbuddy;

import android.widget.EditText;

/**
 * This Class is used to create reusability across each of the primary calculator activities
 * Created by Eric on 10/27/2015.
 */
public class Calculator {

    EditText Dia;
    EditText SFM;
    EditText RPM;
    EditText IPR;
    EditText IPM;

    private String calculateDia_w_SFM_RPM(EditText SFM, EditText RPM){
        return String.format("%.4f", Double.valueOf(SFM.getText().toString()) / (Double.valueOf(RPM.getText().toString()) * (Math.PI / 12d)));
    }

    private String calculateSFM_w_Dia_RPM (EditText Dia, EditText RPM){
        return String.format("%.4f", Double.valueOf(Dia.getText().toString()) * (Double.valueOf(RPM.getText().toString()) * (Math.PI / 12d)));
    }

    private String calculateRPM_w_Dia_SFM(EditText Dia, EditText SFM){
        return String.format("%.4f", Double.valueOf(SFM.getText().toString()) /(Double.valueOf(Dia.getText().toString()) * (Math.PI / 12d)));
    }

    private String calculateRPM_w_IPR_IPM (EditText IPR, EditText IPM){
        return String.format("%.4f", Double.valueOf(IPM.getText().toString()) / Double.valueOf(IPR.getText().toString()));
    }

    private String calculateIPM_w_RPM_IPR (EditText RPM, EditText IPR){
        return String.format("%.4f", Double.valueOf(RPM.getText().toString()) * Double.valueOf(IPR.getText().toString()));
    }

    private String calculateIPR_w_RPM_IPM (EditText RPM, EditText IPM){
        return String.format("%.4f", Double.valueOf(IPM.getText().toString()) / Double.valueOf(RPM.getText().toString()));
    }

    private void diaLostFocus (){

    }
}
