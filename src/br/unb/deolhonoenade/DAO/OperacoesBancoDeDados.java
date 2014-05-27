package br.unb.deolhonoenade.DAO;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import br.unb.deolhonoenade.controller.ControllerCurso;
import br.unb.deolhonoenade.model.Curso;
import br.unb.deolhonoenade.model.Instituicao;

public class OperacoesBancoDeDados {
	
	SQLiteDatabase database;
	//Set do nome e campos das tabelas
	private final String CURSO_TABLE_NAME = "curso";
	private final String[] CURSO_COLUMNS_NAME = new String[]{"instituicao_cod_ies",
			"num_estud_curso", "num_estud_insc",
			"nome_curso", "municipio", "conceito_enade", "cod_area_curso", "uf"};
	
	private final String IES_TABLE_NAME = "instituicao";
	private final String[] IES_COLUMNS_NAME = new String[]{"cod_ies", 
			"org_academica", "nome_ies", "tipo"};
	
	private final String WHERE_CLAUSE = "cod_ies = ?";
	
	public OperacoesBancoDeDados(SQLiteDatabase database) {
		if(database!=null){
			this.database = database;
		}else{
			
		}
		
	}
	
	public ArrayList<Curso> getCursos(int codAreaCurso, String ufIES){
		
		// Criacao de Variaveis
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Curso curso;
		Instituicao ies;
		
		// Instanciando codigo do curso como string
		String codg_Curso = String.valueOf(codAreaCurso);
		/*Cursor que aponta para as linhas retornadas pelo
		 *  cruzamento das tabelas instituicao e curso
		 *  dado os parametros codigo da area do Curso
		 *  e codigo da UF
		 */
		Cursor cursor = database.rawQuery("SELECT b.instituicao_cod_ies, " +
				"b.num_estud_curso, b.num_estud_insc, b.nome_curso, " + 
				"b.municipio, b.conceito_enade, b.cod_area_curso , b.uf " +
				"FROM instituicao a, curso b WHERE a.cod_ies = b.instituicao_cod_ies " +
				"AND b.uf = ? AND "+"b.cod_area_curso = ?", new String[]{ufIES,codg_Curso} );
		
		// Verifica se o cruzamento de dados retornou algo
		// Se sim, coloca o cursor na primeira linha de dados
		if(cursor != null){
			cursor.moveToFirst();
		}else
			return null;
		
		do{
			// Instancia ies sem relacao com curso
			ies = this.getIES(Integer.parseInt(cursor.getString(0)));
			// Instancia curso com ies sem o curso
			curso = new Curso( Integer.parseInt(cursor.getString(6)) ,Integer.parseInt(cursor.getString(0)), cursor.getString(3),
					Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
					cursor.getString(4), Float.parseFloat(cursor.getString(5)), cursor.getString(7), ies );
			// Adiciona o curso a ies
			ies.adicionaCurso(curso);
			// Adiciona ies com relacionamento com o curso
			curso.setIES(ies);
			// Adiciona o curso ao ArrayList que sera retornado
			cursos.add( curso );
			
		}while(cursor.moveToNext()); // Move o cursor para a proxima linha		
		
		return cursos;
		
	}
	
	// Retorna os dados de Instituicao
	public Instituicao getIES(int codIES) {
		String string_codIES = String.format("%d",codIES);
		
		/*Cria um cursor que aponta para os resultados
		 * retonados da tabela de instituicoes
		 * dado o codigo da ies
		 */
		
		Cursor cursor = database.rawQuery("SELECT a.org_academica, " +
				"a.nome_ies, a.tipo " +
				"FROM instituicao a WHERE a.cod_ies = ? "
				, new String[]{string_codIES});
		
		if(cursor != null)
			cursor.moveToFirst();
		else
			return null;
		// Cria a instuicao e instancia com os dados retornados pelo cursor
		Instituicao ies = new Instituicao(cursor.getString(1), cursor.getString(0), 
				cursor.getString(2), codIES);
		
		return ies;
	}//Fim do getIES().
	
	/**
	 * Sobrecarga de Metodos
	 * @param codAreaCurso
	 * @param ufIES
	 * @param municipio
	 * @return
	 */
	public ArrayList<Curso> getCursos(int codAreaCurso, String ufIES, String municipio){

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Curso curso;
		Instituicao ies;
	
		String codg_Curso = String.valueOf(codAreaCurso);
		
		Cursor cursor = database.rawQuery("SELECT b.instituicao_cod_ies, " +
				"b.num_estud_curso, b.num_estud_insc, b.nome_curso, " + 
				"b.municipio, b.conceito_enade, b.cod_area_curso " +
				"FROM instituicao a, curso b WHERE a.cod_ies = b.instituicao_cod_ies " +
				"AND b.uf = ? AND b.cod_area_curso = ? AND b.municipio = ?", new String[]{ufIES,codg_Curso,municipio} );

		if(cursor != null){
			cursor.moveToFirst();
		}else
			return null;
		
		do{
			ies = this.getIES(Integer.parseInt(cursor.getString(0)));

			curso = new Curso( Integer.parseInt(cursor.getString(6)) ,Integer.parseInt(cursor.getString(0)), cursor.getString(3),
					Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
					cursor.getString(4), Float.parseFloat(cursor.getString(5)), ufIES,
					ies );

			ies.adicionaCurso(curso);

			curso.setIES(ies);

			cursos.add( curso );
			
		}while(cursor.moveToNext());	
		
		return cursos;
		
	}
	
	/**
	 * Categoria 0-Ambos 1-Privada 2-Publica
	 * @param codAreaCurso
	 * @param ufIES
	 * @param municipio
	 * @param categoria
	 * @return
	 */
	public ArrayList<Curso> getCursos(int codAreaCurso, String ufIES, String municipio, String tipo){
		

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Curso curso;
		Instituicao ies = new Instituicao("Inexistente","vazio","vazio",0);
		
		tipo = tipo.toUpperCase();
		
		String codg_Curso = String.valueOf(codAreaCurso);
	
		Cursor cursor = database.rawQuery("SELECT b.instituicao_cod_ies, " +
				"b.num_estud_curso, b.num_estud_insc, b.nome_curso, " + 
				"b.municipio, b.conceito_enade, b.cod_area_curso " +
				"FROM instituicao a, curso b WHERE a.cod_ies = b.instituicao_cod_ies " +
				"AND b.uf = ? AND "+"b.cod_area_curso = ? AND b.municipio = ? "+
				"AND a.tipo = ?", new String[]{ufIES,codg_Curso,municipio,tipo} );
		
		if(cursor != null){
			cursor.moveToFirst();
		}else
			return null;
		
		do{
			try{
				ies = this.getIES(Integer.parseInt(cursor.getString(0)));
			}catch(CursorIndexOutOfBoundsException e){
				curso = new Curso(0,0,"Inexistente",0,0,"vazio",0,"vazio",ies);
				cursos.add(curso);
				return cursos;
			}

			curso = new Curso( Integer.parseInt(cursor.getString(6)) ,Integer.parseInt(cursor.getString(0)), cursor.getString(3),
					Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
					cursor.getString(4), Float.parseFloat(cursor.getString(5)), ufIES,
					ies );

			ies.adicionaCurso(curso);

			curso.setIES(ies);

			cursos.add( curso );
			
		}while(cursor.moveToNext());	
		
		return cursos;
		
	}
	
	/**
	 * 
	 * @param codAreaCurso
	 * @param ufIES
	 * @param municipio
	 * @param tipoInt
	 * @return
	 */
	public ArrayList<Curso> getCursos(int codAreaCurso, String ufIES, int tipoInt) {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Curso curso;
		Instituicao ies;
		
		String tipo = new String();
		
		if(tipoInt==1){
			tipo="Privada";
		}else{
			tipo="Publica";
		}
		
		tipo = tipo.toUpperCase();
		
		String codg_Curso = String.valueOf(codAreaCurso);
	
		Cursor cursor = database.rawQuery("SELECT b.instituicao_cod_ies, " +
				"b.num_estud_curso, b.num_estud_insc, b.nome_curso, " + 
				"b.municipio, b.conceito_enade, b.cod_area_curso " +
				"FROM instituicao a, curso b WHERE a.cod_ies = b.instituicao_cod_ies " +
				"AND b.uf = ? AND b.cod_area_curso = ? AND a.tipo = ?"
				, new String[]{ufIES,codg_Curso,tipo} );
		
		if(cursor != null){
			cursor.moveToFirst();
		}else
			return null;
		
		do{

			ies = this.getIES(Integer.parseInt(cursor.getString(0)));

			curso = new Curso( Integer.parseInt(cursor.getString(6)) ,Integer.parseInt(cursor.getString(0)), cursor.getString(3),
					Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
					cursor.getString(4), Float.parseFloat(cursor.getString(5)), ufIES,
					ies );

			ies.adicionaCurso(curso);

			curso.setIES(ies);

			cursos.add( curso );
			
		}while(cursor.moveToNext());	
		
		return cursos;
	}
	


	public List<String> getCidades(int codAreaCurso ,String ufIES){
		
		List<String> cidades = new ArrayList<String>();
		
		cidades.add("Todas");
		
		String codg_Curso = String.valueOf(codAreaCurso);
		ufIES = ufIES.toUpperCase();
		
		Cursor cursor = database.rawQuery("SELECT b.municipio " +
				"FROM instituicao a, curso b WHERE b.uf = ? AND "+
				"b.cod_area_curso = ? AND a.cod_ies = b.instituicao_cod_ies "+
				"GROUP BY b.municipio", new String[]{ufIES, codg_Curso} );
		
		if(cursor!=null){
			cursor.moveToFirst();
		}else{
			return null;
		}
		
		do{
			cidades.add(cursor.getString(0));
			
		}while(cursor.moveToNext());
		
		return cidades;
	}

	public int getCodCurso(String nomeCurso) {
		
		int codCurso;
		
		nomeCurso = nomeCurso.toUpperCase();
		
		Cursor cursor = database.rawQuery("SELECT cod_area_curso " +
				"FROM curso WHERE nome_curso = ? " +
				"GROUP BY cod_area_curso", new String[]{nomeCurso} );
		
		if(cursor!=null){
			cursor.moveToFirst();
		}else{
			return 0;
		}
		
		//Linha com Erro. Cursor Index out of Bounds.
		codCurso = Integer.parseInt(cursor.getString(0));

		return codCurso;
	}

	public List<String> getUfs(int codAreaCurso) {

		List<String> ufs = new ArrayList<String>();
		
		String codg_Curso = String.valueOf(codAreaCurso);
		
		Cursor cursor = database.rawQuery("SELECT b.uf " +
				"FROM instituicao a, curso b WHERE b.cod_area_curso = ? "+
				"AND a.cod_ies = b.instituicao_cod_ies "+
				"GROUP BY b.uf", new String[]{codg_Curso} );
		
		if(cursor!=null){
			cursor.moveToFirst();
		}else{
			return null;
		}
		
		do{
			ufs.add(cursor.getString(0));
			
		}while(cursor.moveToNext());
		
		return ufs;
	}
	
	public List<String> getTipoMunicipio(int codAreaCurso, String municipio){
		
		List<String> tipos = new ArrayList<String>();
	
		String codg_Curso = String.valueOf(codAreaCurso);
		
		municipio = municipio.toUpperCase();
		
		Cursor cursor = database.rawQuery("SELECT a.tipo " +
				"FROM instituicao a, curso b WHERE b.municipio = ? AND "+
				"b.cod_area_curso = ? AND a.cod_ies = b.instituicao_cod_ies "+
				"GROUP BY a.tipo", new String[]{municipio, codg_Curso} );
		
		if(cursor!=null){
			cursor.moveToFirst();
		}else{
			return null;
		}
		
		do{
			tipos.add(cursor.getString(0));
			
		}while(cursor.moveToNext());
		
		
		if(tipos.size()>=2)
			tipos.add(0, "Ambas");
		
		return tipos;
	}
	
	public List<String> getTipoEstado(int codCurso, String estado) {
		List<String> tipos = new ArrayList<String>();
		
		String codg_Curso = String.valueOf(codCurso);
		
		estado = estado.toUpperCase();
		
		Cursor cursor = database.rawQuery("SELECT a.tipo " +
				"FROM instituicao a, curso b WHERE b.uf = ? AND "+
				"b.cod_area_curso = ? AND a.cod_ies = b.instituicao_cod_ies "+
				"GROUP BY a.tipo", new String[]{estado, codg_Curso} );
		
		if(cursor!=null){
			cursor.moveToFirst();
		}else{
			return null;
		}
		
		do{
			tipos.add(cursor.getString(0));
			
		}while(cursor.moveToNext());
		
		
		if(tipos.size()>=2)
			tipos.add(0, "Ambas");
		
		return tipos;
		
	}
	
}
