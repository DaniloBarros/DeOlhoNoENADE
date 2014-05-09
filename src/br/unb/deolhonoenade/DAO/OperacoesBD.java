package br.unb.deolhonoenade.DAO;

import br.unb.deolhonoenade.model.Instituicao;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

public class OperacoesBD {
	
	private SQLiteDatabase bancoDeDados;
	
	private final String IES_TABLE_NAME = "instituicao";
	private final String[] IES_COLUMNS_NAME = new String[]{"cod_ies", 
			"org_academica", "uf", "nome_ies", "tipo"};
	
	private final String WHERE_CLAUSE = "cod_ies = ?";
	
	public OperacoesBD(SQLiteDatabase bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}
	
	/*Retornar dados de Instituicao*/
	public Instituicao getIES(int codIES) {
		String string_codIES = String.valueOf(codIES);
		
		Cursor cursor = bancoDeDados.query(IES_TABLE_NAME, IES_COLUMNS_NAME,
				WHERE_CLAUSE, new String[]{string_codIES}, null, null, null);
		
		if(cursor != null)
			cursor.moveToFirst();		
		else
			return null;
		
		
		
		Instituicao ies = new Instituicao(cursor.getString(3), cursor.getString(1), 
				cursor.getString(2), cursor.getString(4), 
				Integer.parseInt(cursor.getString(0)));
		
		return ies;
	}

}