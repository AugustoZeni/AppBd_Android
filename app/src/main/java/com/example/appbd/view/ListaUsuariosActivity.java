package com.example.appbd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListaUsuariosActivity extends AppCompatActivity {

    ListView ltvUsuarios;
    FloatingActionButton btnAddUsuario;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        ltvUsuarios = findViewById(R.id.ltvUsuarios_listaUsuarios);
        btnAddUsuario = findViewById(R.id.btnAddUsuario_lista_usario);

        context = ListaUsuariosActivity.this;

        atualizarLista();

        btnAddUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globais.abrirActivity(context, UsuarioActivity.class, false);
            }
        });
    }

    private void atualizarLista(){
        try{

            UsuarioController controller = new UsuarioController(context);
            ArrayList<Usuario> lista = controller.lista();
            if(lista != null){
                //ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(context, android.R.layout.simple_list_item_1, lista);
                ArrayAdapter adapter = new UsuarioAdapter(context, lista);

                ltvUsuarios.setAdapter(adapter);
            }

        }catch (Exception ex){
            Globais.exibirMensagem(context, ex.getMessage());
        }
    }
}