package com.example.igornobre.agenda;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by igornobre on 19/10/16.
 */

public class FormularioActivity extends AppCompatActivity {

    private EditText formulario_nome, getFormulario_telefone;
    private Button formulario_btnSalvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);


    }
}
