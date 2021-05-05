package com.example.appbd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.appbd.R;
import com.example.appbd.adapters.UsuarioAdapter;
import com.example.appbd.config.Globais;
import com.example.appbd.controller.UsuarioController;
import com.example.appbd.model.Usuario;

import java.util.ArrayList;

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