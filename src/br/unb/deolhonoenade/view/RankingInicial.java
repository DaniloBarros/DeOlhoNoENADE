package br.unb.deolhonoenade.view;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import br.unb.deolhonoenade.R;
import br.unb.deolhonoenade.controller.ControllerCurso;

public class RankingInicial extends Activity implements
		ActionBar.OnNavigationListener {

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	private Spinner tipUniv, spinnerEstados, spinnerCidades;
	private List<String> tipos = new ArrayList<String>();
	private ArrayList<String> cursos = new ArrayList<String>();
	private String curso, tipo, estado, municipio;
	private int codCurso;
	private ControllerCurso controller;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking_inicial);
		
		controller = new ControllerCurso(this);
		
		TextView cursoSelecionado = (TextView) findViewById(R.id.textView1);
		
		curso = getIntent().getExtras().getString("cursoSelecionado");
		cursoSelecionado.setText(getIntent().getExtras().getString("cursoSelecionado"));
		
		this.codCurso = controller.buscaCodCurso(curso);
		
		addItensOnSpinnerEstado(codCurso);
		addListenerOnButtonBuscar();
		addItensOnSpinnerTipo();
		
		
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		} 
		// Set up the action bar to show a dropdown list.
/*		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(actionBar.getThemedContext(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, new String[] {
								getString(R.string.title_section1),
								getString(R.string.title_section2),
								getString(R.string.title_section3), }), this);	*/
		
		
	}



	private void addItensOnSpinnerTipo() {
		
		//Adicionando dados do Spinner Tipo de Universidade
				tipos.add("Ambas");
				tipos.add("Privada");
				tipos.add("Publica");
				
				//Identificando o Spinner
				tipUniv = (Spinner) findViewById(R.id.universidade);
				ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipos);
				ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
				spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				tipUniv.setAdapter(spinnerArrayAdapter);
		 
				//M�todo do Spinner para capturar o item selecionado
				tipUniv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		 
					@Override
					public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
						//pega nome pela posição
						tipo = parent.getItemAtPosition(posicao).toString();
						//imprime um Toast na tela com o nome que foi selecionado
						Toast.makeText(RankingInicial.this, "Opção Selecionada: " + tipo, Toast.LENGTH_LONG).show();
					}
		 
					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});
		
	}

	private void addItensOnSpinnerEstado(int codCurso) {
		
		spinnerEstados = (Spinner) findViewById(R.id.SpinnerEstados);
		List<String> list = new ArrayList<String>();
		
		list = controller.buscaUf(codCurso);
		
		/*list.add("AC");
		list.add("AL");
		list.add("AP");
		list.add("AM");
		list.add("BA");
		list.add("CE");
		list.add("ES");
		list.add("GO");
		list.add("MA");
		list.add("MT");
		list.add("MS");
		list.add("MG");
		list.add("PR");
		list.add("PB");
		list.add("PA");
		list.add("PE");
		list.add("PI");
		list.add("RJ");
		list.add("RN");
		list.add("RS");
		list.add("RO");
		list.add("RR");
		list.add("SC");
		list.add("SE");
		list.add("SP");
		list.add("TO");
		*/
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinnerEstados.setAdapter(dataAdapter);
			
			
			
			spinnerEstados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		 
					@Override
					public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
						//pega nome pela posição
						estado = parent.getItemAtPosition(posicao).toString();
						//imprime um Toast na tela com o nome que foi selecionado
						Toast.makeText(RankingInicial.this, "Estado Selecionado: " + estado, Toast.LENGTH_LONG).show();
						
						addItensOnSpinnerMunicipio(estado);
					}
		 
					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});
			
			
	}
	
	private void addItensOnSpinnerMunicipio(String uf) {
		this.spinnerCidades = (Spinner) findViewById(R.id.spinnerCidade);
		List<String> list;
		list = controller.buscaCidades(codCurso, uf);
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			this.spinnerCidades.setAdapter(dataAdapter);
			
			this.spinnerCidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
					
					municipio = parent.getItemAtPosition(posicao).toString();
					
					Toast.makeText(RankingInicial.this, "Cidade Selecionada: " + municipio, Toast.LENGTH_LONG).show();
				}
	 
				@Override
				public void onNothingSelected(AdapterView<?> parent) {
				}
			});
		
	}
	
	private void addListenerOnButtonBuscar() {

		//Botão Buscar
				Button buscar = (Button) findViewById(R.id.buscar);
				buscar.setOnClickListener (new OnClickListener(){
					
					@Override
			    	public void onClick(View v) {
			    		Intent intent = new Intent(RankingInicial.this, RankingResult.class);
			    		
			    		intent.putExtra("CodigoCurso", curso);
			            intent.putExtra("Estado", estado);
			            intent.putExtra("Municipio", municipio);
			            intent.putExtra("Tipo", tipo);
			    		startActivity(intent);
			    	}
				});
		
	}
	

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
//		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
//				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ranking_inicial, menu);
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

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
		getFragmentManager()
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
		return true;
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

/*		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_ranking_inicial,
					container, false);
			TextView textView = (TextView) rootView
					.findViewById(R.id.section_label);
	//		textView.setText(Integer.toString(getArguments().getInt(
	//				ARG_SECTION_NUMBER)));
			return rootView; 
		} */
	}

}
