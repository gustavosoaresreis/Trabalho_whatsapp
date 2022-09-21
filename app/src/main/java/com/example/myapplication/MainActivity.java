package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout Input_layout_num;
    private TextInputLayout Input_layout_texto;

    private TextInputEditText Input_text_num;
    private TextInputEditText Input_text_texto;

    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Input_layout_num = findViewById(R.id.Input_layout_num);
        Input_layout_texto = findViewById(R.id.input_layout_texto);

        Input_text_num = findViewById(R.id.input_text_num);
        Input_text_texto = findViewById(R.id.input_text_texto);



        enviar = findViewById(R.id.Enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telefone = Input_text_num.getText().toString();
                String texto = Input_text_texto.getText().toString();

                String url = formatoUrl(telefone, texto);

                enviar(url);
            }

            public String formatoUrl(String telefone, String texto) {
                texto = texto.replace(" ", " %20");

                String link = "https://wa.me/" + telefone + "?text=" + texto;
                return link;
            }

            public void enviar(String url) {
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }

        });

    }
}
