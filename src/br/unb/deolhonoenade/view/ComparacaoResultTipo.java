package br.unb.deolhonoenade.view;

import java.util.List;

import br.unb.deolhonoenade.R;
import br.unb.deolhonoenade.R.id;
import br.unb.deolhonoenade.R.layout;
import br.unb.deolhonoenade.R.menu;
import br.unb.deolhonoenade.controller.ControllerCurso;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;

public class ComparacaoResultTipo extends Activity {

	private ControllerCurso controller;
	private List<String> result;
	private float resultado1, resultado2;
	private String estado1, estado2, tipo1, tipo2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comparacao_result_tipo);
		
		controller = new ControllerCurso(this);
		resultado1 = getIntent().getExtras().getFloat("resultado1");
		resultado2 = getIntent().getExtras().getFloat("resultado2");
		
		estado1 = getIntent().getExtras().getString("Estado1");
		tipo1 = getIntent().getExtras().getString("Tipo1");
		estado2 = getIntent().getExtras().getString("Estado2");
		tipo2 = getIntent().getExtras().getString("Tipo2");
		
			
		result.add(String.format("O Resultado da IES do Tipo %s do Estado %s e: %f", tipo1, estado1, resultado1));
		result.add(String.format("O Resultado da IES do Tipo %s do Estado %s e: %f", tipo2, estado2, resultado2));
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, result);
		
		ListView resultado = (ListView) findViewById(R.id.ListResultadoTipo);
		
		resultado.setAdapter(dataAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comparacao_result_tipo, menu);
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
			View rootView = inflater.inflate(
					R.layout.fragment_comparacao_result_tipo, container, false);
			return rootView;
		}
	}

}
