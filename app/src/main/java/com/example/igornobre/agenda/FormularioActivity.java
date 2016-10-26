package com.example.igornobre.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.igornobre.agenda.dao.ContatoDAO;
import com.example.igornobre.agenda.model.Contato;

/**
 * Created by igornobre on 19/10/16.
 */

public class FormularioActivity extends AppCompatActivity {

    private EditText formulario_nome, formulario_telefone;
    private Button formulario_btnSalvar;
    private ProgressBar formulario_progressBar;
    private Contato contato;
    private ContatoDAO dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        formulario_nome = (EditText) findViewById(R.id.formulario_nome);
        formulario_telefone = (EditText) findViewById(R.id.formulario_telefone);
        formulario_btnSalvar = (Button) findViewById(R.id.formulario_btnSalvar);
        formulario_progressBar = (ProgressBar) findViewById(R.id.formulario_progressBar);

        formulario_btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                acionaProgress(View.VISIBLE, false);

                String nome = formulario_nome.getText().toString();
                String telefone = formulario_telefone.getText().toString();

                if (TextUtils.isEmpty(nome)){
                    Toast.makeText(getApplicationContext(), R.string.digite_nome, Toast.LENGTH_LONG).show();
                    acionaProgress(View.GONE, true);
                    return;
                }

                if (TextUtils.isEmpty(telefone)){
                    Toast.makeText(getApplicationContext(), R.string.digite_telefone, Toast.LENGTH_LONG).show();
                    acionaProgress(View.GONE, true);
                    return;
                }

                contato = new Contato();
                contato.setNome(nome);
                contato.setTelefone(telefone);


                dao = new ContatoDAO(getApplicationContext());
                dao.insere(contato);

                startActivity(new Intent(getApplicationContext(), MainActivity.class));




            }
        });


    }

    private void acionaProgress(int visible, boolean btnClickable) {
        formulario_progressBar.setVisibility(visible);
        formulario_btnSalvar.setClickable(btnClickable);
    }
}
