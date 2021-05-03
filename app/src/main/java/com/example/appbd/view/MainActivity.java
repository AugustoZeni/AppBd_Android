package com.example.appbd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appbd.R;

public class MainActivity extends AppCompatActivity {

    Button btnUsuarios;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUsuarios = findViewById(R.id.btnMenuUsuarios_menu);

        context = MainActivity.this;

        btnUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ir para tela de listagem de usuarios
                Intent tela = new Intent(context, ListaUsuariosActivity.class);
                startActivity(tela);

            }
        });
    }
}