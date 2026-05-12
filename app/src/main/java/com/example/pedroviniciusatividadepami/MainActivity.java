package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtBloco;
    Button btnSalvar, btnLer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBloco = findViewById(R.id.txtBloco);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLer = findViewById(R.id.btnLer);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs =
                        getSharedPreferences("anotacoes", MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();

                editor.putString(
                        "texto",
                        txtBloco.getText().toString()
                );

                editor.commit();

                Toast.makeText(
                        MainActivity.this,
                        "Anotação salva com sucesso",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        btnLer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs =
                        getSharedPreferences("anotacoes", MODE_PRIVATE);

                String texto =
                        prefs.getString("texto", "");

                txtBloco.setText(texto);

                Toast.makeText(
                        MainActivity.this,
                        "Dados recuperados",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}