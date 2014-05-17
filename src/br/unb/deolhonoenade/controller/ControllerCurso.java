package br.unb.deolhonoenade.controller;

import java.util.ArrayList;
import java.util.List;

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
	
	public ArrayList<Curso> buscaCurso(int codCurso, String uf, String municipio){
		
		this.cursos = this.opBD.getCursos(codCurso, uf, municipio);
		
		return cursos;
	}
	
	public ArrayList<Curso> buscaCurso(int codCurso, String uf, String municipio, String org_Aca){
		
		this.cursos = this.opBD.getCursos(codCurso, uf, municipio, org_Aca);
		
		return cursos;
	}
	
	public List<String> buscaCidades(int codCurso, String uf){
		List<String> cidades = new ArrayList<String>();
		cidades = this.opBD.getCidades(codCurso, uf);
		return cidades;
	}

	public List<String> buscaUf(int codCurso) {
		List<String> ufs = new ArrayList<String>();
		ufs = this.opBD.getUfs(codCurso);
		return ufs;
	}
	
	private List<Curso> ordenaListCurso(List<Curso> list){

		Curso aux;
		
		for (int j = 0; j < 2; j++) {
			
			for (int i = 0; i < (list.size() - 1); i++) {
				if (list.get(i).getConceitoEnade() < list.get(
						i + 1).getConceitoEnade()) {
					aux = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, aux);
				}

			}
			for (int i = list.size() - 1; i >= 1; i--) {
				if (list.get(i).getConceitoEnade() > list.get(
						i - 1).getConceitoEnade()) {
					aux = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, aux);
				}
			}
			
		}
		
		return list;
	}

	public List<String> buscaStringCurso(int codCurso2, String uf2) {
		List<String> cursos = new ArrayList<String>();
		List<Curso> listaCursos = new ArrayList<Curso>();
		
		listaCursos = this.buscaCurso(codCurso2, uf2);
		
		listaCursos = this.ordenaListCurso(listaCursos);
		
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
		
		listaCursos = this.ordenaListCurso(listaCursos);
		
		for (int i = 0; i <listaCursos.size(); i++) {
			cursos.add(String.format("%s - %f", listaCursos.get(i).getNome(),
					listaCursos.get(i).getConceitoEnade()));
		}
		
		return cursos;
	}

	public List<String> buscaStringCurso(int codCurso2, String uf2,
			String municipio2) {
		
		List<String> cursos = new ArrayList<String>();
		List<Curso> listaCursos = new ArrayList<Curso>();
		
		listaCursos = this.buscaCurso(codCurso2, uf2, municipio2);
		
		listaCursos = this.ordenaListCurso(listaCursos);
		
		for (int i = 0; i <listaCursos.size(); i++) {
			cursos.add(String.format("%s - %f", listaCursos.get(i).getNome(),
					listaCursos.get(i).getConceitoEnade()));
		}
		
		return cursos;
	}
	
/*
	private SQLiteDatabase openDatabase(Context context) {
		ImportarBancoDeDados db = new ImportarBancoDeDados(context);
        return db.openDataBase();
	}
*/
}
