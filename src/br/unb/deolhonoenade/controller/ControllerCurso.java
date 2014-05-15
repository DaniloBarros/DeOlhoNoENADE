package br.unb.deolhonoenade.controller;

import java.util.ArrayList;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;
import br.unb.deolhonoenade.DAO.ImportarBancoDeDados;
import br.unb.deolhonoenade.DAO.OperacoesBancoDeDados;
import br.unb.deolhonoenade.model.Curso;

public class ControllerCurso {
	
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	private SQLiteDatabase db;
	private OperacoesBancoDeDados opBD;

	public ControllerCurso(Context context) {
		ImportarBancoDeDados bdados = new ImportarBancoDeDados(context);
		
		SQLiteDatabase database = bdados.openDataBase();
		
		this.opBD = new OperacoesBancoDeDados(database);
		
		this.db=database;
	}
	
	public ArrayList<Curso> buscaCurso(int codCurso, String uf){
		
		this.cursos = this.opBD.getCursos(codCurso, uf);
		
		return cursos;
	}
	
	public ArrayList<Curso> buscaCurso(int codCurso, String uf, String municipio){
		
		this.cursos = this.opBD.getCursos(codCurso, uf, municipio);
		
		return cursos;
	}
	
	public ArrayList<Curso> buscaCurso(int codCurso, String uf, String municipio, int categoria){
		
		this.cursos = this.opBD.getCursos(codCurso, uf, municipio, categoria);
		
		return cursos;
	}
	
	public SQLiteDatabase getDatabase(){
		return this.db;
	}
/*
	private SQLiteDatabase openDatabase(Context context) {
		ImportarBancoDeDados db = new ImportarBancoDeDados(context);
        return db.openDataBase();
	}
*/
}
