package br.unb.deolhonoenade.controller;
import java.util.ArrayList;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import br.unb.deolhonoenade.model.*;
import br.unb.deolhonoenade.DAO.*;

/**
 * Possivelmente sera DELETADA no futuro
 * Dado que, os cursos retornados ja tem
 * o relacionamento com as IES e vice-versa
 */

public class GlossarioInstituicao {
	
	private ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
	
	public GlossarioInstituicao(Context context){
		instanciaIES(context);
	}
	
	private void instanciaIES(Context context){
		
		ImportarBancoDeDados bdados = new ImportarBancoDeDados(context);
		
		SQLiteDatabase database = bdados.openDataBase();
		
		OperacoesBancoDeDados opBD = new OperacoesBancoDeDados(database);
		
		for(int i=0;  ;i++){
			try{
				instituicoes.add(opBD.getIES(i));
	        }catch(CursorIndexOutOfBoundsException e){
	           break;
	        }
		}
		
	}

	public Instituicao buscaIes(int cod_ies){
		
		Instituicao ies = null;
		
		for(Instituicao IES : this.instituicoes){
			if(IES.getCodIES()==cod_ies){
				ies=IES;
				break;
			}
		}
		
		return ies;
	}
	
	
	public ArrayList<Instituicao> getInstituicoes() {
		return instituicoes;
	}
	
	
	
}
