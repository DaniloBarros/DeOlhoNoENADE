package br.unb.deolhonoenade.view;

import java.util.ArrayList;
import java.util.List;

import br.unb.deolhonoenade.R;
import br.unb.deolhonoenade.R.id;
import br.unb.deolhonoenade.R.layout;
import br.unb.deolhonoenade.R.menu;
import br.unb.deolhonoenade.controller.ControllerCurso;
import br.unb.deolhonoenade.model.Curso;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class ComparacaoTipo extends Activity {
	
	private Spinner EstadoT1, Tipo1;
	private ControllerCurso controller;
	private String estado, municipio;
	private int codCurso;
	private List<String> dados;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comparacao_tipo);
		this.controller = new ControllerCurso(this);
		TextView cursoSelecionado = (TextView) findViewById(R.id.nomeCursoSelecionado);
		cursoSelecionado.setText(getIntent().getExtras().getString("cursoSelecionado"));
		
		codCurso = controller.buscaCodCurso(getIntent().getExtras().getString("cursoSelecionado"));
		
		addItensOnSpinnerEstadoT1(codCurso);
		addListenerOnButtonBuscar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comparacao_tipo, menu);
		return true;
	}
	
private void addItensOnSpinnerEstadoT1(int codCurso) {
		
		EstadoT1 = (Spinner) findViewById(R.id.EstadoT1);
		List<String> list = new ArrayList<String>();
		
		list = controller.buscaUf(codCurso);
					
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			EstadoT1.setAdapter(dataAdapter);
			
			EstadoT1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		 
					@Override
					public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
						
						estado = parent.getItemAtPosition(posicao).toString();
						
						addItensOnSpinnerTipo1(estado);						
					}
				
					
					

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});	
	}

private void addItensOnSpinnerTipo1(String uf) {
	this.Tipo1 = (Spinner) findViewById(R.id.Tipo1);
	List<String> list;
	list = controller.buscaTiposEstado(codCurso, uf);
	
			
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			this.Tipo1.setAdapter(dataAdapter);
			
			this.Tipo1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
					
					
					municipio = parent.getItemAtPosition(posicao).toString();
					addItensOnSpinnerTipos(estado, municipio);
					
				}
	 
				

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
				}
			});
	
}

private void addItensOnSpinnerTipos(String estado, String municipio) {
}



private void addListenerOnButtonBuscar() {

	Button comparar = (Button) findViewById(R.id.comparaT1);
	comparar.setOnClickListener (new OnClickListener(){
		
		@Override
    	public void onClick(View v) {
			Intent result =  new Intent(ComparacaoTipo.this, ComparacaoTipoFinal.class);
			result.putStringArrayListExtra("dadosTipo1", (ArrayList<String>) dados);
			result.putExtra("codCurso", codCurso);

    		startActivity(result);
    	}
	});
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
			View rootView = inflater.inflate(R.layout.fragment_comparacao_tipo,
					container, false);
			return rootView;
		}
	}

}
