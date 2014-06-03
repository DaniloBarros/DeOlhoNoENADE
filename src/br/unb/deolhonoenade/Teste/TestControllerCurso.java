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

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCodIESDoArrayCursos() {

		ControllerCurso controller = new ControllerCurso(getContext());

		controller.buscaCurso(2, "DF");
		Assert.assertEquals(2, controller.getCodIESDoArrayCursos(0));

	}

	public void testDadosIES() {

		ControllerCurso controller = new ControllerCurso(getContext());
		Instituicao ies = controller.buscaInstituicao(1);
		List<String> dadosIES = controller.getDadosIES(1);

		Assert.assertEquals(dadosIES.get(0), ies.getNome());
		Assert.assertEquals(dadosIES.get(1), ies.getOrganizacaoAcademica());
		Assert.assertEquals(dadosIES.get(2), ies.getTipo());
	}
	
	public void comparaEstado(){
		ControllerCurso controller = new ControllerCurso(getContext());
		
		String estado1="DF", estado2="AM";
		
		
		assertEquals(controller.comparaEstado(estado1, estado2, 1).get(0),"media do estado DF e 1,902917");
		
	}
	

}
