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
		Curso curso = new Curso("Direito", 25, 15, "portoalegre", 3, 6);
		Assert.assertNotSame("Urubu", curso.getNome());
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
		Curso curso = new Curso("direito",100,60,"cuiaba",3,65);
 		
 		curso.setNome("medicina");
 		assertSame("medicina", curso.getNome());
	}

	public void testGetNumEstudantes() {
		Curso curso = new Curso("engenharia",100,9,"campinas", 300, 011);
 		assertEquals(100,curso.getNumEstudantes());
	}

	public void testSetNumEstudantes() {
		Curso curso = new Curso("direito",100,60,"cuiaba",3,65); 		
 		curso.setNumEstudantes(500);
 		assertSame(500, curso.getNome());
	}

	public void testGetNumEstudantesInscritos() {
		Curso curso = new Curso("Administracao", 15, 5, "Sergipe", 4, 023);
 		
 		assertSame(5,curso.getNumEstudantesInscritos());
	}

	public void testSetNumEstudantesInscritos() {
		Curso curso = new Curso("Administracao", 15, 5, "Rio", 4, 023);
		 		
		 		curso.setNumEstudantesInscritos(20);
		 		
		 		assertNotSame(20,curso.getNumEstudantesInscritos());
	}

	public void testGetMunicipio() {
		Curso curso = new Curso("direito",20,10,"curitiba", 4, 100);
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
		Curso curso = new Curso("administracao",10,9,"curitiba", 5, 100);
 		curso.setConceitoEnade(4);
		assertEquals(4,curso.getConceitoEnade());
	}

	public void testGetCodMunicipio() {
		Curso curso = new Curso("administracao",10,9,"acre", 3, 88);
 		assertEquals(5,curso.getCodMunicipio());
	}

	public void testSetCodMunicipio() {
		Curso curso = new Curso("administracao",10,9,"acre", 3, 88);
 		curso.setCodMunicipio(83);
		assertEquals(83,curso.getConceitoEnade());
	}

}
