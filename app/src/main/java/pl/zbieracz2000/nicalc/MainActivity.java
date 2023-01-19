package pl.zbieracz2000.nicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float iloscpremixu = 0,
            mocpremixu = 0,
            iloscbazy = 0,
            mocbazy = 0,
            mocwynikowa = 0,
            moctemp1 = 0,
            moctemp2 = 0,
            iloscwynikowa = 0;
    String mocshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.oblicz);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final EditText editiloscPremixu =  (EditText) findViewById(R.id.iloscPremixu);
                if(editiloscPremixu.getText().toString().isEmpty()) {
                    iloscpremixu = 0;
                } else {
                    iloscpremixu =  Float.valueOf(editiloscPremixu.getText().toString());
                    Log.d("Ilość premixu:",Float.toString(iloscpremixu));
                }
                final EditText editmocPremixu =  (EditText) findViewById(R.id.mocPremixu);
                if(editmocPremixu.getText().toString().isEmpty()) {
                    mocpremixu = 0;
                } else {
                    mocpremixu = Float.valueOf(editmocPremixu.getText().toString());
                    Log.d("Moc premixu:", Float.toString(mocpremixu));
                }
                final EditText editiloscBazy =  (EditText) findViewById(R.id.iloscBazy);
                if(editiloscBazy.getText().toString().isEmpty()) {
                    iloscbazy = 0;
                } else {
                    iloscbazy = Float.valueOf(editiloscBazy.getText().toString());
                    Log.d("Ilość bazy:", Float.toString(iloscbazy));
                }
                final EditText editmocBazy =  (EditText) findViewById(R.id.mocBazy);
                if(editmocBazy.getText().toString().isEmpty()) {
                    mocbazy = 0;
                } else {
                    mocbazy = Float.valueOf(editmocBazy.getText().toString());
                    Log.d("Moc bazy:", Float.toString(mocbazy));
                }
                iloscwynikowa = iloscpremixu+iloscbazy;
                moctemp1 = mocpremixu*iloscpremixu;
                moctemp2 = mocbazy*iloscbazy;
                mocwynikowa = moctemp1+moctemp2;
                mocwynikowa = mocwynikowa/iloscwynikowa;
                Log.d("Moc wynikowa:",Float.toString(mocwynikowa));
                Log.d("Ilosc wynikowa:",Float.toString(iloscwynikowa));
                TextView moc = (TextView) findViewById(R.id.pokazMoc);
                TextView ilosc = (TextView) findViewById(R.id.pokazIlosc);
                String cMoc, cIlosc;
                cMoc = String.format("%.1f", mocwynikowa);
                cIlosc = String.format("%.0f",iloscwynikowa);
                moc.setText(cMoc);
                ilosc.setText(cIlosc);
            }
        });
    }
}