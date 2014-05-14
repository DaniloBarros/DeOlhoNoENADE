package br.unb.deolhonoenade.Teste;

import android.test.AndroidTestCase;
import br.unb.deolhonoenade.model.Curso;
import br.unb.deolhonoenade.model.Instituicao;
import junit.framework.Assert;
import java.util.ArrayList;

public class TestInstituicao extends AndroidTestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInstituicao() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		Assert.assertNotSame("Quimica", instituicao.getNome());
	}
		
	public void testGetCursos() {
		ArrayList<Curso> Cursos = new ArrayList<Curso>(50);
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		
		instituicao.setCursos(Cursos);
		
		Assert.assertEquals(new ArrayList<Curso>(10), instituicao.getCursos());
	}

	public void testSetCursos() {
        Curso curso = new Curso("Psicologia", 58, 62,"Cornelio Procopio", 2, 4106407);
 		curso.setNome("Adiministracao");
 		assertSame("Adiministracao", curso.getNome());
	}

	public void testGetNome() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		assertEquals("Universidade de Brasilia",instituicao.getNome());
	}

	public void testSetNome() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
 		
 		instituicao.setNome("Universidade Federal de Mato Grosso");
 		assertSame("Universidade Federal de Mato Grosso", instituicao.getNome());
	}


	public void testGetOrganizacaoAcademica() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		assertEquals("Universidades",instituicao.getOrganizacaoAcademica());
		
	}

	public void testSetOrganizacaoAcademica() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		instituicao.setOrganizacaoAcademica("Faculdades");
		assertSame("Faculdades", instituicao.getOrganizacaoAcademica());
	}

	public void testGetUf() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		assertEquals("Distrito Federal",instituicao.getUf());
		
	}

	public void testSetUf() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		instituicao.setUf("Distrito Federal");
		assertSame("Distrito Federal", instituicao.getUf());
	}

	public void testGetTipo() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		assertEquals("Publica",instituicao.getTipo());
	}

	public void testSetTipo() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		instituicao.setTipo("Publica");
		assertNotSame("Privada", instituicao.getTipo());
	}

	public void testGetCodIES() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		assertEquals(2, instituicao.getCodIES());
	}

	public void testSetCodIES() {
		Instituicao instituicao = new Instituicao("Universidade de Brasilia", "Universidades", "Distrito Federal", "Publica", 2);
		instituicao.setCodIES(2);
		assertEquals(2, instituicao.getCodIES());
	}

}
