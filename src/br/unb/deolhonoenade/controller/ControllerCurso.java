package br.unb.deolhonoenade.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
	
	public SQLiteDatabase getDatabase(){
		return this.db;
	}
	
	public int buscaCodCurso(String nomeCurso){
		int codCurso;
		
		codCurso = this.opBD.getCodCurso(nomeCurso);
		
		return codCurso;
	}
	
	public ArrayList<Curso> buscaCurso(int codCurso, String uf){
		
		this.cursos = this.opBD.getCursos(codCurso, uf);
		
		return cursos;
	}
	
	private List<Curso> buscaCurso(int codCurso, String uf, int tipoInt) {
		this.cursos = this.opBD.getCursos(codCurso, uf, tipoInt);
		
		return cursos;
	}
	
	public ArrayList<Curso> buscaCurso(int codCurso, String uf, String municipio){
		
		this.cursos = this.opBD.getCursos(codCurso, uf, municipio);
		
		return cursos;
	}
	
	public ArrayList<Curso> buscaCurso(int codCurso, String uf, String municipio, String tipo){
		
		this.cursos = this.opBD.getCursos(codCurso, uf, municipio, tipo);
		
		return cursos;
	}
	
	public List<String> buscaCidades(int codCurso, String uf){
		List<String> cidades = new ArrayList<String>();
		cidades = this.opBD.getCidades(codCurso, uf);
		return cidades;
	}
	
	public List<String> buscaTipos(int codCurso, String municipio){
		List<String> tipos = new ArrayList<String>();
		tipos = this.opBD.getTipoMunicipio(codCurso, municipio);
		return tipos;
	}
	
	public List<String> buscaTiposEstado(int codCurso, String estado) {
		List<String> tipos = new ArrayList<String>();
		tipos = this.opBD.getTipoEstado(codCurso, estado);
		return tipos;
	}

	public List<String> buscaUf(int codCurso) {
		List<String> ufs = new ArrayList<String>();
		ufs = this.opBD.getUfs(codCurso);
		return ufs;
	}
		
	public List<String> buscaStringCurso(int codCurso2, String uf2) {
		List<String> cursos = new ArrayList<String>();
		List<Curso> listaCursos = new ArrayList<Curso>();
		
		listaCursos = this.buscaCurso(codCurso2, uf2);
					
		for (int i = 0; i <listaCursos.size(); i++) {
			cursos.add(String.format("%s - %f", listaCursos.get(i).getIES().getNome(),
					listaCursos.get(i).getConceitoEnade()));
		}
		
		return cursos;
	}

	public List<String> buscaStringCurso(int codCurso2, String uf2,
			String municipio2, String tipo2) {
		
		List<String> cursos = new ArrayList<String>();
		List<Curso> listaCursos = new ArrayList<Curso>();
		
		listaCursos = this.buscaCurso(codCurso2, uf2, municipio2, tipo2);
		
		
		for (int i = 0; i <listaCursos.size(); i++) {
			cursos.add(String.format("%s - %f", listaCursos.get(i).getIES().getNome(),
					listaCursos.get(i).getConceitoEnade()));
		}
		
		return cursos;
	}

	public List<String> buscaStringCurso(int codCurso2, String uf2,
			String municipio2) {
		
		List<String> cursos = new ArrayList<String>();
		List<Curso> listaCursos = new ArrayList<Curso>();
		
		listaCursos = this.buscaCurso(codCurso2, uf2, municipio2);
		
		for (int i = 0; i <listaCursos.size(); i++) {
			cursos.add(String.format("%s - %f", listaCursos.get(i).getIES().getNome(),
					listaCursos.get(i).getConceitoEnade()));
		}
		
		return cursos;
	}

	public List<String> buscaStringCurso(int codCurso, String uf, int tipoInt) {
		List<String> cursos = new ArrayList<String>();
		List<Curso> listaCursos = new ArrayList<Curso>();
		
		
		listaCursos = this.buscaCurso(codCurso, uf, tipoInt);
		
		for (int i = 0; i <listaCursos.size(); i++) {
			cursos.add(String.format("%s - %f", listaCursos.get(i).getIES().getNome(),
					listaCursos.get(i).getConceitoEnade()));
		}
		
		return cursos;
	}

}
