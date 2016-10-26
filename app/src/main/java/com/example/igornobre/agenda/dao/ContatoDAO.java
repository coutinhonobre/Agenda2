package com.example.igornobre.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.igornobre.agenda.model.Contato;

/**
 * Created by igornobre on 19/10/16.
 */

public class ContatoDAO extends SQLiteOpenHelper {
    public ContatoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Contato (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, telefone TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Contato";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoContato(contato);

        long inserir = db.insert("Contato", null, dados);

        Log.i("inserir: ", inserir + "");

    }

    private ContentValues pegaDadosDoContato(Contato contato) {

        ContentValues dados = new ContentValues();
        dados.put("nome", contato.getNome());
        dados.put("telefone", contato.getTelefone());

        return dados;
    }

    public void alterar(Contato contato){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoContato(contato);

        String[] params = {String.valueOf(contato.getId())};
        db.update("Contato", dados, "id=?", params);
    }

}
