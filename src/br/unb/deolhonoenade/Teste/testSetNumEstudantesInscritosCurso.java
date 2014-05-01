package br.unb.deolhonoenade.Teste;

import br.unb.deolhonoenade.model.Curso;
import junit.framework.TestCase;

public class testSetNumEstudantesInscritosCurso extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSetNumEstudantesInscritos() {
		Curso curso = new Curso("Administração", 15, 5, "Rio", 4, 023);
		
		curso.setNumEstudantesInscritos(20);
		
		assertNotSame(20,curso.getNumEstudantesInscritos());
	}

}
