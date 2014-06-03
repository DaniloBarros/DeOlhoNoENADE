package br.unb.deolhonoenade.Teste;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import br.unb.deolhonoenade.DAO.ImportarBancoDeDados;
import br.unb.deolhonoenade.DAO.OperacoesBancoDeDados;
import br.unb.deolhonoenade.controller.ControllerCurso;
import br.unb.deolhonoenade.model.Curso;
import br.unb.deolhonoenade.model.Instituicao;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

public class TestOperacoesBancoDeDados extends AndroidTestCase {

	public TestOperacoesBancoDeDados() {
		super();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testOperacoesBancoDeDados() {
		fail("Not yet implemented");
	}

	public void testGetCursosIntString() {
		
		SQLiteDatabase db;
		OperacoesBancoDeDados opBD;
		
		ImportarBancoDeDados bdados = new ImportarBancoDeDados(getContext());
		
		SQLiteDatabase database = bdados.openDataBase();
		
		opBD = new OperacoesBancoDeDados(database);
		
		db=database;
		
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
		
		cursos = opBD.getCursos(1, "AC");
		
		Assert.assertEquals(cursosT.get(0).getConceitoEnade(), cursos.get(0).getConceitoEnade());
		Assert.assertEquals(cursosT.get(0).getId(), cursos.get(0).getId());
		Assert.assertEquals(cursosT.get(0).getId_ies(), cursos.get(0).getId_ies());
		Assert.assertEquals(cursosT.get(0).getNumEstudantes(), cursos.get(0).getNumEstudantes());
		
		Assert.assertEquals(cursosT.get(1).getConceitoEnade(), cursos.get(1).getConceitoEnade());
		Assert.assertEquals(cursosT.get(1).getId(), cursos.get(1).getId());
		Assert.assertEquals(cursosT.get(1).getId_ies(), cursos.get(1).getId_ies());
		Assert.assertEquals(cursosT.get(1).getNumEstudantes(), cursos.get(1).getNumEstudantes());
		
		Assert.assertEquals(cursosT.get(2).getConceitoEnade(), cursos.get(2).getConceitoEnade());
		Assert.assertEquals(cursosT.get(2).getId(), cursos.get(2).getId());
		Assert.assertEquals(cursosT.get(2).getId_ies(), cursos.get(2).getId_ies());
		Assert.assertEquals(cursosT.get(2).getNumEstudantes(), cursos.get(2).getNumEstudantes());
		

	}

	public void testGetIES() {
		fail("Not yet implemented");
	}

	public void testGetCursosIntStringString() {
		SQLiteDatabase db;
		OperacoesBancoDeDados opBD;
		
		ImportarBancoDeDados bdados = new ImportarBancoDeDados(getContext());
		
		SQLiteDatabase database = bdados.openDataBase();
		
		opBD = new OperacoesBancoDeDados(database);
		
		db=database;
		
		ArrayList<Curso> cursosT = new ArrayList<Curso>();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		Instituicao ies3 = new Instituicao("FACULDADE DE DESENVOLVIMENTO SUSTENTAVEL DE CRUZEIRO DO SUL", "FACULDADES", "PRIVADA", 2072);
		
		Curso curso1 = new Curso(1, 2072, "ADMINISTRACAO", 29, 26, "CRUZEIRO DO SUL", (float)0.785, "AC", ies3);
		
		cursosT.add(curso1);
		
		
		cursos = opBD.getCursos(1, "AC", "CRUZEIRO DO SUL");
		
		Assert.assertEquals(cursosT.get(0).getConceitoEnade(), cursos.get(0).getConceitoEnade());
		Assert.assertEquals(cursosT.get(0).getId(), cursos.get(0).getId());
		Assert.assertEquals(cursosT.get(0).getId_ies(), cursos.get(0).getId_ies());
		Assert.assertEquals(cursosT.get(0).getNumEstudantes(), cursos.get(0).getNumEstudantes());
				
	}

	public void testGetCursosIntStringStringString() {
		//SQLiteDatabase db;
		OperacoesBancoDeDados opBD;
		
		ImportarBancoDeDados bdados = new ImportarBancoDeDados(getContext());
		
		SQLiteDatabase database = bdados.openDataBase();
		opBD = new OperacoesBancoDeDados(database);		
		//db=database;
		
		ArrayList<Curso> cursosT = new ArrayList<Curso>();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		Instituicao ies = new Instituicao("UNIVERSIDADE DE BRASILIA", "UNIVERSIDADES", "PUBLICA", 2);
		Curso curso1 =  new Curso(1, 2, "ADMINISTRACAO", 141, 89, "BRASILIA", (float)3.735, "DF", ies);
		
		cursosT.add(curso1);
		cursos = opBD.getCursos(1, "DF", "BRASILIA", "PUBLICA");
			
		Assert.assertEquals(cursosT.get(0).getConceitoEnade(), cursos.get(0).getConceitoEnade());
		Assert.assertEquals(cursosT.get(0).getId(), cursos.get(0).getId());
		Assert.assertEquals(cursosT.get(0).getId_ies(), cursos.get(0).getId_ies());
		Assert.assertEquals(cursosT.get(0).getNumEstudantes(), cursos.get(0).getNumEstudantes());		
	}

	public void testGetCursosIntStringInt() {
		fail("Not yet implemented");
	}

	public void testGetCidades() {
		fail("Not yet implemented");
	}

	public void testGetCodCurso() {
		fail("Not yet implemented");
	}

	public void testGetUfs() {
		fail("Not yet implemented");
	}

	public void testGetTipoMunicipio() {
		fail("Not yet implemented");
	}

	public void testGetTipoEstado() {
		fail("Not yet implemented");
	}

}
