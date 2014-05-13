package br.unb.deolhonoenade.Teste;

import br.unb.deolhonoenade.model.Curso;
import br.unb.deolhonoenade.model.Instituicao;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestCurso extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCurso() {
		fail("Not yet implemented");
	}

	public void testGetIES() {
		Curso curso = new Curso("Direito", 25, 15, "Brasilia", 3, 2);
		
		Instituicao ies = new Instituicao("UnB", "Universidade", "DF", "Publica", 1);
		
		curso.setIES(ies);
		
		Assert.assertEquals(new Instituicao("UFBA", "Universidade", "BA", "Publica", 10), curso.getIES());
	}

	public void testSetIES() {
		Curso curso = new Curso("Direito", 25, 15, "Brasilia", 3, 2);
		
		Instituicao ies = new Instituicao("UFBA", "Universidade", "BA", "Publica", 10);
		
		curso.setIES(ies);
		
		Assert.assertSame(new Instituicao("UFBA", "Universidade", "BA", "Publica", 10), curso.getIES());
	}

	public void testGetNome() {
		Curso curso = new Curso("curso",10,9,"saopaulo", 300, 000);
		 		assertEquals("curso",curso.getNome());
	}

	public void testSetNome() {
		fail("Not yet implemented");
	}

	public void testGetNumEstudantes() {
		fail("Not yet implemented");
	}

	public void testSetNumEstudantes() {
		fail("Not yet implemented");
	}

	public void testGetNumEstudantesInscritos() {
		fail("Not yet implemented");
	}

	public void testSetNumEstudantesInscritos() {
		Curso curso = new Curso("Administração", 15, 5, "Rio", 4, 023);
		 		
		 		curso.setNumEstudantesInscritos(20);
		 		
		 		assertNotSame(20,curso.getNumEstudantesInscritos());
	}

	public void testGetMunicipio() {
		Curso curso = new Curso("curso",10,9,"curitiba", 5, 100);
 		assertEquals("curitiba",curso.getMunicipio());
	}

	public void testSetMunicipio() {
		Curso curso = new Curso("direito",100,60,"Brasilia",3,400);
		 		
		 		curso.setMunicipio("BeloHorizonte");
		 		assertNotSame("Brasilia", curso.getMunicipio());
	}

	public void testGetConceitoEnade() {
		Curso curso = new Curso("administracao",10,9,"curitiba", 5, 100);
 		assertEquals(5,curso.getConceitoEnade());
	}

	public void testSetConceitoEnade() {
		fail("Not yet implemented");
	}

	public void testGetCodMunicipio() {
		fail("Not yet implemented");
	}

	public void testSetCodMunicipio() {
		fail("Not yet implemented");
	}

}
