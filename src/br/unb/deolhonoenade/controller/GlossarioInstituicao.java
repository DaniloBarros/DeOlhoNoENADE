package br.unb.deolhonoenade.controller;
import java.util.ArrayList;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.unb.deolhonoenade.model.*;
import br.unb.deolhonoenade.DAO.*;

public class GlossarioInstituicao {
	
	ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
	
	public GlossarioInstituicao(Context context){
		InstanciaIES(context);
	}
	
	private void InstanciaIES(Context context){
		Instituicao ies;
		
		ImportarBancoDeDados bdados = new ImportarBancoDeDados(context, "de_olho_enade.db");
		
		SQLiteDatabase database = bdados.openDataBase();
		
		OperacoesBD opBD = new OperacoesBD(database);
		
		for(int i=0;  ;i++){
			try {
				this.instituicoes.add(opBD.getIES(i));
			} catch (Exception e) {
				break;
			}
		}
		
	}
	
}
