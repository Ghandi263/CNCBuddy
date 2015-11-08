package com.howeloh.www.cncbuddy;

import android.widget.EditText;

/** *This Class is used to create reusability across each of the primary calculator activities
 *  *Created by Eric on 10/27/2015.
 */


public class Calculator {

    private String calculateDia_w_SFM_RPM(EditText SFM, EditText RPM) {
        return String.format("%.4f", Double.valueOf(SFM.getText().toString()) / (Double.valueOf(RPM.getText().toString()) * (Math.PI / 12d)));
    }

    private String calculateSFM_w_Dia_RPM(EditText Dia, EditText RPM) {
        return String.format("%.4f", Double.valueOf(Dia.getText().toString()) * (Double.valueOf(RPM.getText().toString()) * (Math.PI / 12d)));
    }

    private String calculateRPM_w_Dia_SFM(EditText Dia, EditText SFM) {
        return String.format("%.4f", Double.valueOf(SFM.getText().toString()) / (Double.valueOf(Dia.getText().toString()) * (Math.PI / 12d)));
    }

    private String calculateRPM_w_IPR_IPM(EditText IPR, EditText IPM) {
        return String.format("%.4f", Double.valueOf(IPM.getText().toString()) / Double.valueOf(IPR.getText().toString()));
    }

    private String calculateRPM_w_IPR_IPM_Cut(EditText IPR, EditText IPM, EditText Cut) {
        return String.format("%.4f", (Double.valueOf(IPM.getText().toString()) / Double.valueOf(Cut.getText().toString())) / Double.valueOf(IPR.getText().toString()));
    }


    private String calculateIPM_w_RPM_IPR(EditText RPM, EditText IPR) {
        return String.format("%.4f", Double.valueOf(RPM.getText().toString()) * Double.valueOf(IPR.getText().toString()));
    }

    private String calculateIPM_w_RPM_IPR_Cut(EditText RPM, EditText IPR, EditText Cut) {
        return String.format("%.4f", Double.valueOf(RPM.getText().toString()) * Double.valueOf(IPR.getText().toString()) * Double.valueOf(Cut.getText().toString()));
    }


    private String calculateIPR_w_RPM_IPM(EditText RPM, EditText IPM) {
        return String.format("%.4f", Double.valueOf(IPM.getText().toString()) / Double.valueOf(RPM.getText().toString()));
    }

    private String calculateIPR_w_RPM_IPM_Cut(EditText RPM, EditText IPM, EditText Cut) {
        return String.format("%.4f", (Double.valueOf(IPM.getText().toString()) / Double.valueOf(Cut.getText().toString())) / Double.valueOf(RPM.getText().toString()));
    }


    private String calculateCut_w_IPM_IPR_RPM(EditText IPM, EditText IPR, EditText RPM) {
        return String.format("%.4f", (Double.valueOf(IPM.getText().toString()) / Double.valueOf(IPR.getText().toString())) / Double.valueOf(RPM.getText().toString()));
    }


    protected void diaLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM) {

        if (!Dia.getText().toString().equals("") && !SFM.getText().toString().equals("")) {
            RPM.setText(calculateRPM_w_Dia_SFM(Dia, SFM));

            if (!IPR.getText().toString().equals("")) {
                IPM.setText(calculateIPM_w_RPM_IPR(RPM, IPR));

            } else if (!IPM.getText().toString().equals("")) {
                IPR.setText(calculateIPR_w_RPM_IPM(RPM, IPM));

            }
        } else if (!Dia.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            SFM.setText(calculateSFM_w_Dia_RPM(Dia, RPM));

        }

    }

    protected void diaLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM, EditText Cut) {
        if (!Dia.getText().toString().equals("") && !SFM.getText().toString().equals("")) {
            RPM.setText(calculateRPM_w_Dia_SFM(Dia, SFM));

            if (!IPR.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
                IPM.setText(calculateIPM_w_RPM_IPR_Cut(RPM, IPR, Cut));

            } else if (!IPM.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
                IPR.setText(calculateIPR_w_RPM_IPM_Cut(RPM, IPM, Cut));

            } else if (!IPM.getText().toString().equals("") && !IPR.getText().toString().equals("")) {
                Cut.setText(calculateCut_w_IPM_IPR_RPM(IPM, IPR, RPM));

            }
        } else if (!Dia.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            SFM.setText(calculateSFM_w_Dia_RPM(Dia, RPM));

        }
    }


    protected void SFMLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM) {
        if (!Dia.getText().toString().equals("") && !SFM.getText().toString().equals("")) {
            RPM.setText(calculateRPM_w_Dia_SFM(Dia, SFM));

            if (!IPR.getText().toString().equals("")) {
                IPM.setText(calculateIPM_w_RPM_IPR(RPM, IPR));

            } else if (!IPM.getText().toString().equals("")) {
                IPR.setText(calculateIPR_w_RPM_IPM(RPM, IPM));

            }
        } else if (!SFM.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            Dia.setText(calculateDia_w_SFM_RPM(SFM, RPM));

        }
    }

    protected void SFMLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM, EditText Cut) {
        if (!Dia.getText().toString().equals("") && !SFM.getText().toString().equals("")) {
            RPM.setText(calculateRPM_w_Dia_SFM(Dia, SFM));

            if (!IPR.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
                IPM.setText(calculateIPM_w_RPM_IPR_Cut(RPM, IPR, Cut));

            } else if (!IPM.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
                IPR.setText(calculateIPR_w_RPM_IPM_Cut(RPM, IPM, Cut));

            } else if (!IPM.getText().toString().equals("") && !IPR.getText().toString().equals("")) {
                Cut.setText(calculateCut_w_IPM_IPR_RPM(IPM, IPR, RPM));

            }
        } else if (!SFM.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            Dia.setText(calculateDia_w_SFM_RPM(SFM, RPM));

        }
    }


    protected void RPMLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM) {
        if (!IPR.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            IPM.setText(calculateIPM_w_RPM_IPR(RPM, IPR));

        } else if (!IPM.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            IPR.setText(calculateIPR_w_RPM_IPM(RPM, IPM));

        }

        if (!Dia.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            SFM.setText(calculateSFM_w_Dia_RPM(Dia, RPM));

        } else if (!SFM.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            Dia.setText(calculateDia_w_SFM_RPM(SFM, RPM));

        }
    }

    protected void RPMLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM, EditText Cut) {
        if (!IPR.getText().toString().equals("") && !RPM.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
            IPM.setText(calculateIPM_w_RPM_IPR_Cut(RPM, IPR, Cut));

        } else if (!IPM.getText().toString().equals("") && !RPM.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
            IPR.setText(calculateIPR_w_RPM_IPM_Cut(RPM, IPM, Cut));

        } else if (!IPM.getText().toString().equals("") && !IPR.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            Cut.setText(calculateCut_w_IPM_IPR_RPM(IPM, IPR, RPM));

        }

        if (!Dia.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            SFM.setText(calculateSFM_w_Dia_RPM(Dia, RPM));

        } else if (!SFM.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            Dia.setText(calculateDia_w_SFM_RPM(SFM, RPM));

        }
    }


    protected void IPRLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM) {
        if (!RPM.getText().toString().equals("") && !IPR.getText().toString().equals("")) {
            IPM.setText(calculateIPM_w_RPM_IPR(RPM, IPR));

        } else if (!IPM.getText().toString().equals("") && !IPR.getText().toString().equals("")) {
            RPM.setText(calculateRPM_w_IPR_IPM(IPR, IPM));

            if (!Dia.getText().toString().equals("")) {
                SFM.setText(calculateSFM_w_Dia_RPM(Dia, RPM));

            } else if (!SFM.getText().toString().equals("")) {
                Dia.setText(calculateDia_w_SFM_RPM(SFM, RPM));

            }
        }
    }

    protected void IPRLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM, EditText Cut) {
        if (!RPM.getText().toString().equals("") && !IPR.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
            IPM.setText(calculateIPM_w_RPM_IPR_Cut(RPM, IPR, Cut));

        } else if (!IPM.getText().toString().equals("") && !IPR.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
            RPM.setText(calculateRPM_w_IPR_IPM_Cut(IPR, IPM, Cut));

            if (!Dia.getText().toString().equals("")) {
                SFM.setText(calculateSFM_w_Dia_RPM(Dia, RPM));

            } else if (!SFM.getText().toString().equals("")) {
                Dia.setText(calculateDia_w_SFM_RPM(SFM, RPM));

            }
        } else if (!IPM.getText().toString().equals("") && !IPR.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            Cut.setText(calculateCut_w_IPM_IPR_RPM(IPM, IPR, RPM));

        }
    }


    protected void IPMLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM) {
        if (!RPM.getText().toString().equals("") && !IPM.getText().toString().equals("")) {
            IPR.setText(calculateIPR_w_RPM_IPM(RPM, IPM));

        } else if (!IPR.getText().toString().equals("") && !IPM.getText().toString().equals("")) {
            RPM.setText(calculateRPM_w_IPR_IPM(IPR, IPM));

            if (!Dia.getText().toString().equals("")) {
                SFM.setText(calculateSFM_w_Dia_RPM(Dia, RPM));

            } else if (!SFM.getText().toString().equals("")) {
                Dia.setText(calculateDia_w_SFM_RPM(SFM, RPM));

            }
        }
    }

    protected void IPMLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM, EditText Cut) {
        if (!RPM.getText().toString().equals("") && !IPM.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
            IPR.setText(calculateIPR_w_RPM_IPM_Cut(RPM, IPM, Cut));

        } else if (!IPR.getText().toString().equals("") && !IPM.getText().toString().equals("") && !Cut.getText().toString().equals("")) {
            RPM.setText(calculateRPM_w_IPR_IPM_Cut(IPR, IPM, Cut));

            if (!Dia.getText().toString().equals("")) {
                SFM.setText(calculateSFM_w_Dia_RPM(Dia, RPM));

            } else if (!SFM.getText().toString().equals("")) {
                Dia.setText(calculateDia_w_SFM_RPM(SFM, RPM));

            }
        } else if (!IPM.getText().toString().equals("") && !IPR.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            Cut.setText(calculateCut_w_IPM_IPR_RPM(IPM, IPR, RPM));

        }
    }

    protected void teethLostFocus(EditText Dia, EditText SFM, EditText RPM, EditText IPR, EditText IPM, EditText Cut) {
        if (!IPR.getText().toString().equals("") && !Cut.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            IPM.setText(calculateIPM_w_RPM_IPR_Cut(RPM, IPR, Cut));

        } else if (!Cut.getText().toString().equals("") && !IPM.getText().toString().equals("") && !RPM.getText().toString().equals("")) {
            IPR.setText(calculateIPR_w_RPM_IPM_Cut(RPM, IPM, Cut));

        } else if (!Cut.getText().toString().equals("") && !IPM.getText().toString().equals("") && !IPR.getText().toString().equals("")) {
            RPM.setText(calculateRPM_w_IPR_IPM_Cut(IPR, IPM, Cut));

            if (!Dia.getText().toString().equals("")) {
                SFM.setText(calculateSFM_w_Dia_RPM(Dia, RPM));

            } else if (!SFM.getText().toString().equals("")) {
                Dia.setText(calculateDia_w_SFM_RPM(SFM, RPM));

            }
        } else if (!IPM.getText().toString().equals("") && !RPM.getText().toString().equals("") && !IPR.getText().toString().equals("")) {
            Cut.setText(calculateCut_w_IPM_IPR_RPM(IPM, IPR, RPM));

        }
    }

}
