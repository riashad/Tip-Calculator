package com.riashad.crossword.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.riashad.crossword.tipcalculator.R.id.result;

public class MainActivity extends AppCompatActivity {

    private EditText EnteredBill;
    private EditText EnterTip;
    private TextView CalculatedOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Views*/

        EnteredBill = (EditText) findViewById(R.id.BillAmount);
        EnterTip = (EditText) findViewById(R.id.TipPercent);

        EnterTip.requestFocus();

        CalculatedOutput = (TextView) findViewById(result);

        CalculatedOutput.setVisibility(View.GONE);

        /*Set Text Watcher Listener*/

        EnteredBill.addTextChangedListener(TipWatcher);

        //EnterTip.addTextChangedListener(TipWatcher);

    }

    private final TextWatcher TipWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            CalculatedOutput.setVisibility(View.VISIBLE);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length() == 0){
                CalculatedOutput.setVisibility(TextView.GONE);
            }else{

                 /*Calculation*/
                String Val1 = EnteredBill.getText().toString();
                String Val2 = EnterTip.getText().toString();

                double d1 = Double.parseDouble(Val1);
                double d2 = Double.parseDouble(Val2);

                double vatAmt = (d1 * 15) / 100;
                double TipAmt =(d1 * d2) / 100;
                double TotalAmt = d1+vatAmt+TipAmt;

                CalculatedOutput.setText("Vat (15%) :   " + vatAmt+"\n"+
                        "Tip:                 "+TipAmt+"\n"+
                        "Total Bill:      "+TotalAmt+"\n"
                );

            }
        }

    };

}