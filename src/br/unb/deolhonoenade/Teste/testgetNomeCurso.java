package br.unb.deolhonoenade.Teste;

import br.unb.deolhonoenade.model.Curso;
import junit.framework.TestCase;

public class testgetNomeCurso extends TestCase {

	public testgetNomeCurso(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetNome() {
		Curso curso = new Curso("curso",10,9,"saopaulo", 300, 000);
		assertEquals("curso",curso.getNome());
	}

}
