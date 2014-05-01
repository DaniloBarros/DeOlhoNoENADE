package br.unb.deolhonoenade.model;

public class Curso {
	
	private Instituicao IES;
	
	private String nome;
	private int numEstudantes;
	private int numEstudantesInscritos;
	private String municipio;
	private int conceitoEnade;
	private int codMunicipio;
	
	public Curso(String nome, int numEstudantes, int numEstudantesInscritos,
			String municipio, int conceitoEnade, int codMunicipio) {
		super();
		this.nome = nome;
		this.numEstudantes = numEstudantes;
		this.numEstudantesInscritos = numEstudantesInscritos;
		this.municipio = municipio;
		this.conceitoEnade = conceitoEnade;
		this.codMunicipio = codMunicipio;
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

	public int getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(int codMunicipio) {
		this.codMunicipio = codMunicipio;
	}
	
	
	
}
