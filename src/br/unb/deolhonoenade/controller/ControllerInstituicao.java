package br.unb.deolhonoenade.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.unb.deolhonoenade.DAO.ImportarBancoDeDados;
import br.unb.deolhonoenade.DAO.OperacoesBancoDeDados;
import br.unb.deolhonoenade.model.*;

public class ControllerInstituicao {
	
private Instituicao instituicao;
	
	private SQLiteDatabase db;
	private OperacoesBancoDeDados opBD;

	public ControllerInstituicao(Context context) {
		ImportarBancoDeDados bdados = new ImportarBancoDeDados(context);
		
		SQLiteDatabase database = bdados.openDataBase();
		
		this.opBD = new OperacoesBancoDeDados(database);
		
		this.db=database;
	}
	
	public Instituicao buscaInstituicao(int codIES){
		
		this.instituicao = this.opBD.getIES(codIES);
		
		return instituicao;
	}
	
/*	public List<String> getDadosIES (int codIES) {
		List<String> dados = new ArrayList<String>();
		Instituicao IES;
		
		IES = this.buscaInstituicao(codIES);
		
		dados.add(IES.getNome());
		dados.add(IES.getOrganizacaoAcademica());
		dados.add(IES.getTipo());

		return dados;
		
	}	*/
	
	
	public SQLiteDatabase getDatabase(){
		return this.db;
	}
		
}
