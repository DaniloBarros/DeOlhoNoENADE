package br.unb.deolhonoenade.Teste;

import java.util.ArrayList;

import br.unb.deolhonoenade.controller.ControllerCurso;
import br.unb.deolhonoenade.model.Curso;
import br.unb.deolhonoenade.model.Instituicao;
import junit.framework.Assert;
import android.test.AndroidTestCase;

public class TestControllerCurso extends AndroidTestCase {

	//ControllerCurso controller = new ControllerCurso(getContext());
	
	public TestControllerCurso() {
		super();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testControllerCurso() {
		fail("Not yet implemented");
	}

	public void testGetDatabase() {
		fail("Not yet implemented");
	}
	
	public void testBuscaCodCurso() {
		int codCurso;
		ControllerCurso controller = new ControllerCurso(getContext());

		codCurso = controller.buscaCodCurso("Administracao");
		Assert.assertEquals(1, codCurso);
	}

	public void testBuscaCursoIntString() {
		ControllerCurso controller = new ControllerCurso(getContext());
		ArrayList<Curso> cursosT = new ArrayList<Curso>();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		Instituicao ies1 = new Instituicao("FACULDADE BARAO DO RIO BRANCO", "FACULDADES", "PRIVADA", 2132);
		Instituicao ies2 = new Instituicao("FACULDDE DA AMAZONIA OCIDENTAL", "FACULDADES", "PRIVADA", 2343);
		Instituicao ies3 = new Instituicao("FACULDADE DE DESENVOLVIMENTO SUSTENTAVEL DE CRUZEIRO DO SUL", "FACULDADES", "PRIVADA", 2072);
		
		Curso curso1 = new Curso(1, 2072, "ADMINISTRACAO", 29, 26, "CRUZEIRO DO SUL", (float)0.785, "AC", ies3);
		Curso curso2 = new Curso(1, 2132, "ADMINISTRACAO", 147, 125, "RIO BRANCO", (float)1.605, "AC", ies1);
		Curso curso3 = new Curso(1, 2343, "ADMINISTRACAO", 49, 48, "RIO BRANCO", (float)1.432, "AC", ies2);
		
		cursosT.add(curso2);
		cursosT.add(curso3);
		cursosT.add(curso1);
		
		cursos = controller.buscaCurso(1, "AC");
		Assert.assertEquals(cursosT, cursos);
	}

	public void testBuscaCursoIntStringString() {
		fail("Not yet implemented");
	}

	public void testBuscaCursoIntStringStringString() {
		fail("Not yet implemented");
	}

	public void testBuscaCidades() {
		fail("Not yet implemented");
	}

	public void testBuscaTipos() {
		fail("Not yet implemented");
	}

	public void testBuscaTiposEstado() {
		fail("Not yet implemented");
	}

	public void testBuscaUf() {
		fail("Not yet implemented");
	}

	public void testBuscaStringCursoIntString() {
		fail("Not yet implemented");
	}

	public void testBuscaStringCursoIntStringStringString() {
		fail("Not yet implemented");
	}

	public void testBuscaStringCursoIntStringString() {
		fail("Not yet implemented");
	}

	public void testBuscaStringCursoIntStringInt() {
		fail("Not yet implemented");
	}

}
