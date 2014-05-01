package br.unb.deolhonoenade.Teste;

import br.unb.deolhonoenade.model.Curso;
import junit.framework.TestCase;

public class testsetMunicipioCurso extends TestCase {

	public testsetMunicipioCurso(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSetMunicipio() {
		Curso curso = new Curso("direito",100,60,"Brasilia",3,400);
		
		curso.setMunicipio("BeloHorizonte");
		assertNotSame("Brasilia", curso.getMunicipio());
	
	}

}
