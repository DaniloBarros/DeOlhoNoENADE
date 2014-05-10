package br.unb.deolhonoenade.model;

import br.unb.deolhonoenade.controller.GlossarioInstituicao;

public class Curso {
	
	private Instituicao IES;
	
	private int id;
	private int id_ies;
	private String nome;
	private int numEstudantes;
	private int numEstudantesInscritos;
	private String municipio;
	private int conceitoEnade;
	
	public Curso(int id, int id_ies, String nome, int numEstudantes, int numEstudantesInscritos,
			String municipio, int conceitoEnade, Instituicao IES) {
		this.id = id;
		this.nome = nome;
		this.numEstudantes = numEstudantes;
		this.numEstudantesInscritos = numEstudantesInscritos;
		this.municipio = municipio;
		this.conceitoEnade = conceitoEnade;
		this.IES=IES;
	}
	/*
	private void addIes(int cod_ies){
		
		Instituicao ies;
		
		//GlossarioInstituicao controller = new GlossarioInstituicao(context)
		
		//ies = controller.buscarIES(cod_ies);
		
		this.setIES(ies);
	}*/

	public int getId_ies() {
		return id_ies;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Instituicao getIES() {
		return IES;
	}

	public void setIES(Instituicao iES) {
		IES = iES;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumEstudantes() {
		return numEstudantes;
	}

	public void setNumEstudantes(int numEstudantes) {
		this.numEstudantes = numEstudantes;
	}

	public int getNumEstudantesInscritos() {
		return numEstudantesInscritos;
	}

	public void setNumEstudantesInscritos(int numEstudantesInscritos) {
		
		if(numEstudantesInscritos<this.numEstudantes){
			this.numEstudantesInscritos = numEstudantesInscritos;
		}else{
			System.err.println("N Estudantes inscritos maior que N Estudantes");
		}
		
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getConceitoEnade() {
		return conceitoEnade;
	}

	public void setConceitoEnade(int conceitoEnade) {
		this.conceitoEnade = conceitoEnade;
	}

	
}
