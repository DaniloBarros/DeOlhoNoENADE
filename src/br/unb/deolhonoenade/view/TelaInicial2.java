package br.unb.deolhonoenade.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import br.unb.deolhonoenade.R;

import java.util.ArrayList;
import java.util.List;

public class TelaInicial2 extends Activity {

	private Spinner spinnerCurso;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_inicial2);
		
		addItensOnSpinnerCurso();
		addListenerOnButtonRanking();
		
		
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	

	private void addItensOnSpinnerCurso() {
		spinnerCurso = (Spinner) findViewById(R.id.spinner1);
		List<String> list = new ArrayList<String>();
		list.add("Administracao");
		list.add("Ciencias Contabeis");
		list.add("Ciencias Economicas");
		list.add("Design");
		list.add("Direito");
		list.add("Jornalismo");
		list.add("Psicologia");
		list.add("Publicidade e Propaganda");
		list.add("Relacoes Internacionais");
		list.add("Secretariado Executivo");
		list.add("Tec. em Gestao Comercial");
		list.add("Tec. em Gestao de R.H.");
		list.add("Tec. em Gestao Financeira");
		list.add("Tecnologia em Logistica");
		list.add("Tecnologia em Marketing");
		list.add("Tec. em Proc. Gerenciais");
		list.add("Turismo");
		
		/*
		<string name="cursos_prompt">Selecione um Curso</string>
	    <string-array name="cursos_array">
	        <item>Administracao</item> <!-- 1 -->
	        <item>Ciencias Contabeis</item><!-- 22 -->
	        <item>Ciencias Economicas</item><!-- 13 -->
	        <item>Design</item> <!-- 26 -->
	        <item>Direito</item><!-- 2 -->        
	        <item>Jornalismo</item><!-- 803 -->
	        <item>Psicologia</item><!-- 18 -->
	        <item>Publicidade e Propaganda</item><!-- 804 -->
	        <item>Relacoes Internacionais</item><!-- 81 -->
	        <item>Secretariado Executivo</item><!-- 67 -->
	        <item>Tec. em Gestao Comercial</item><!-- 93 -->
	        <item>Tec. em Gestao de R.H.</item><!-- 86 -->
	        <item>Tec. em Gestao Financeira</item><!-- 87 -->
	        <item>Tecnologia em Logistica</item><!-- 94 -->
	        <item>Tecnologia em Marketing</item><!-- 84 -->
	        <item>Tec. em Proc. Gerenciais</item><!-- 85 -->
	        <item>Turismo</item><!-- 29 -->
	    </string-array>
		    */
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinnerCurso.setAdapter(dataAdapter);
		
	}
	
	private void addListenerOnButtonRanking() {

		final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
		Button rank = (Button) findViewById(R.id.Ranking);
		rank.setOnClickListener (new OnClickListener(){
			
			@Override
	    	public void onClick(View v) {
	    		Intent intent = new Intent(TelaInicial2.this, RankingInicial.class);
	    		intent.putExtra("cursoSelecionado", String.valueOf(spinner1.getSelectedItem()));
	    		startActivity(intent);
	    	}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_inicial2, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_tela_inicial2,
					container, false);
			return rootView;
		}
	}

}
