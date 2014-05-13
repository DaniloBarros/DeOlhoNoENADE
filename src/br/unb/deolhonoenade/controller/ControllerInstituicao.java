package br.unb.deolhonoenade.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.unb.deolhonoenade.DAO.ImportarBancoDeDados;
import br.unb.deolhonoenade.DAO.OperacoesBancoDeDados;
import br.unb.deolhonoenade.model.*;

public class ControllerInstituicao {
	
private Instituicao instituicoes;
	
	private SQLiteDatabase db;
	private OperacoesBancoDeDados opBD;

	public ControllerInstituicao(Context context) {
		ImportarBancoDeDados bdados = new ImportarBancoDeDados(context);
		
		SQLiteDatabase database = bdados.openDataBase();
		
		this.opBD = new OperacoesBancoDeDados(database);
		
		this.db=database;
	}
	
	public Instituicao buscaInstituicao(int codIES){
		
		this.instituicoes = this.opBD.getIES(codIES);
		
		return instituicoes;
	}
/*
	private SQLiteDatabase openDatabase(Context context) {
		ImportarBancoDeDados db = new ImportarBancoDeDados(context);
        return db.openDataBase();
	}
*/
	
}
