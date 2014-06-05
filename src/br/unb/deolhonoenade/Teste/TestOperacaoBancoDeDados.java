package br.unb.deolhonoenade.Teste;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
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

	public void testGetTipoMunicipio() {
		//fail("Not yet implemented");
	}

	public void testGetTipoEstado() {
		//fail("Not yet implemented");
	}

}
