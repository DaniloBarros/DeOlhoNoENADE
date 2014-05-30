package br.unb.deolhonoenade.Teste;

import java.util.ArrayList;
import java.util.List;

import br.unb.deolhonoenade.DAO.OperacoesBancoDeDados;
import br.unb.deolhonoenade.controller.ControllerCurso;
import br.unb.deolhonoenade.model.Curso;
import br.unb.deolhonoenade.model.Instituicao;
import junit.framework.Assert;
import android.database.sqlite.SQLiteDatabase;
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
		ControllerCurso controller = new ControllerCurso(getContext());
		List<String> cidadesT = new ArrayList<String>();
		List<String> cidades = new ArrayList<String>();
		
		String cidade1 = new String("Todas");
		String cidade2 = new String("CRUZEIRO DO SUL");
		String cidade3 = new String("RIO BRANCO");
		
		cidadesT.add(cidade1);
		cidadesT.add(cidade2);
		cidadesT.add(cidade3);
		
		cidades = controller.buscaCidades(1, "AC");
		Assert.assertEquals(cidadesT, cidades);
	}

	// Busca tipos quando os tipos é só um tipo de instituição
	public void testBuscaTiposAC() {
		ControllerCurso controller = new ControllerCurso(getContext());
		List<String> tiposT = new ArrayList<String>();
		List<String> tipos = new ArrayList<String>();
		
		String tipo1 = new String("PRIVADA");

		tiposT.add(tipo1);
		
		tipos = controller.buscaTipos(1, "RIO BRANCO");
		Assert.assertEquals(tiposT, tipos);
	}
	
	/* Busca tipos quando os tipos é mais de um tipo de instituição
	 * Tipos devem ser Ambas, PRIVADA e PUBLICA
	 */
	public void testBuscaTiposDF() {
		ControllerCurso controller = new ControllerCurso(getContext());
		List<String> tiposT = new ArrayList<String>();
		List<String> tipos = new ArrayList<String>();
		
		String tipo1 = new String("Ambas");
		String tipo2 = new String("PRIVADA");
		String tipo3 = new String("PUBLICA");

		tiposT.add(tipo1);
		tiposT.add(tipo2);
		tiposT.add(tipo3);
		
		tipos = controller.buscaTipos(1, "BRASILIA");
		Assert.assertEquals(tiposT, tipos);
	}

	/* Busca tipos quando os tipos é mais de um tipo de instituição
	 * Tipos devem ser Ambas, PRIVADA e PUBLICA
	 */
	public void testBuscaTiposEstado() {
		ControllerCurso controller = new ControllerCurso(getContext());
		List<String> tiposT = new ArrayList<String>();
		List<String> tipos = new ArrayList<String>();
		
		String tipo1 = new String("Ambas");
		String tipo2 = new String("PRIVADA");
		String tipo3 = new String("PUBLICA");

		tiposT.add(tipo1);
		tiposT.add(tipo2);
		tiposT.add(tipo3);
		
		tipos = controller.buscaTiposEstado(1, "DF");
		Assert.assertEquals(tiposT, tipos);
	}
	
	// Busca tipos quando os tipos é só um tipo de instituição
	public void testBuscaTiposEstadoAC() {
		ControllerCurso controller = new ControllerCurso(getContext());
		List<String> tiposT = new ArrayList<String>();
		List<String> tipos = new ArrayList<String>();
		
		String tipo1 = new String("PRIVADA");

		tiposT.add(tipo1);
		
		tipos = controller.buscaTiposEstado(1, "AC");
		Assert.assertEquals(tiposT, tipos);
	}

	public void testBuscaUf() {
		ControllerCurso controller = new ControllerCurso(getContext());
		List<String> ufsT = new ArrayList<String>();
		List<String> ufs = new ArrayList<String>();
		
		String uf1 = new String("AL");
		String uf2 = new String("AM");
		String uf3 = new String("AP");
		String uf4 = new String("BA");
		String uf5 = new String("CE");
		String uf6 = new String("DF");
		String uf7 = new String("GO");
		String uf8 = new String("MA");
		String uf9 = new String("MG");
		String uf10 = new String("MS");
		String uf11 = new String("MT");
		String uf12 = new String("PA");
		String uf13 = new String("PB");
		String uf14 = new String("PE");
		String uf15 = new String("PI");
		String uf16 = new String("PR");
		String uf17 = new String("RJ");
		String uf18 = new String("RN");
		String uf19 = new String("RR");
		String uf20 = new String("RS");
		String uf21 = new String("SC");
		String uf22 = new String("SE");
		String uf23 = new String("SP");

		ufsT.add(uf1);
		ufsT.add(uf2);
		ufsT.add(uf3);
		ufsT.add(uf4);
		ufsT.add(uf5);
		ufsT.add(uf6);
		ufsT.add(uf7);
		ufsT.add(uf8);
		ufsT.add(uf9);
		ufsT.add(uf10);
		ufsT.add(uf11);
		ufsT.add(uf12);
		ufsT.add(uf13);
		ufsT.add(uf14);
		ufsT.add(uf15);
		ufsT.add(uf16);
		ufsT.add(uf17);
		ufsT.add(uf18);
		ufsT.add(uf19);
		ufsT.add(uf20);
		ufsT.add(uf21);
		ufsT.add(uf22);
		ufsT.add(uf23);
		
		ufs = controller.buscaUf(67);
		Assert.assertEquals(ufsT, ufs);
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
