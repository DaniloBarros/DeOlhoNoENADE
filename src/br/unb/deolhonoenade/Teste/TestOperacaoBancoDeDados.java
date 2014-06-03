package br.unb.deolhonoenade.Teste;

import br.unb.deolhonoenade.DAO.OperacoesBancoDeDados;
import br.unb.deolhonoenade.controller.ControllerCurso;
import br.unb.deolhonoenade.model.Instituicao;
import android.test.AndroidTestCase;

public class TestOperacaoBancoDeDados extends AndroidTestCase {
	
	private OperacoesBancoDeDados opBD;
	private ControllerCurso controller;
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testOperacoesBancoDeDados() {
		//fail("Not yet implemented");
	}

	public void testGetCursosIntString() {
		//fail("Not yet implemented");
	}

	public void testGetIES() {
		controller = new ControllerCurso(getContext());
		opBD = new OperacoesBancoDeDados(controller.getDatabase());
		Instituicao ies = new Instituicao("UNIVERSIDADE FEDERAL DE MATO GROSSO","UNIVERSIDADES","PUBLICA",1);
		assertEquals(opBD.getIES(1).getNome(),ies.getNome());
		assertEquals(opBD.getIES(1).getOrganizacaoAcademica(),ies.getOrganizacaoAcademica());
		assertEquals(opBD.getIES(1).getTipo(),ies.getTipo());
		
		
	}

	public void testGetCursosIntStringString() {
		//fail("Not yet implemented");
	}

	public void testGetCursosIntStringStringString() {
		//fail("Not yet implemented");
	}

	public void testGetCursosIntStringInt() {
		//fail("Not yet implemented");
	}

	public void testGetCidades() {
		//fail("Not yet implemented");
	}

	public void testGetCodCurso() {
		//fail("Not yet implemented");
	}

	public void testGetUfs() {
		//fail("Not yet implemented");
	}

	public void testGetTipoMunicipio() {
		//fail("Not yet implemented");
	}

	public void testGetTipoEstado() {
		//fail("Not yet implemented");
	}

}
