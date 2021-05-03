package com.example.appbd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appbd.R;
import com.example.appbd.adapters.UsuarioAdapter;
import com.example.appbd.config.Globais;
import com.example.appbd.controller.UsuarioController;
import com.example.appbd.model.Usuario;

import java.util.ArrayList;

public class ListaUsuariosActivity extends AppCompatActivity {

    ListView ltvUsuarios;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        ltvUsuarios = findViewById(R.id.ltvUsuarios_listaUsuarios);

        context = ListaUsuariosActivity.this;

        atualizarLista();
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