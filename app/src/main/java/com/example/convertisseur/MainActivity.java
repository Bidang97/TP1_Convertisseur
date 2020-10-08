package com.example.convertisseur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    TextView txt;
    Button btnEtoL;
    Button btnLtoE;
    Button btnEtoVND;
    Button btnVNDtoE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ref();

        convertisseur(btnEtoL,0.91);
        convertisseur(btnLtoE,1.10);
        convertisseur(btnEtoVND, 27.35);
        convertisseur(btnVNDtoE, 0.000037);
    }

    void Ref () {
        edt = (EditText) findViewById(R.id.edt);
        txt = (TextView) findViewById(R.id.textView);
        btnEtoL = (Button) findViewById(R.id.btn1);
        btnLtoE = (Button) findViewById(R.id.btn2);
        btnEtoVND = (Button) findViewById(R.id.btn3);
        btnVNDtoE = (Button) findViewById(R.id.btn4);
    }

    void convertisseur (Button btn, final double calc) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt.getText().toString().isEmpty()) {
                    Snackbar.make(v, "Ecrire un nombre pour convertir!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    Toast.makeText(MainActivity.this, "Ecrire un nombre", Toast.LENGTH_SHORT).show();
                } else {
                    double EL = Double.parseDouble(edt.getText().toString());
                    txt.setText(EL*calc + "");
                }
            }
        });
    }
}