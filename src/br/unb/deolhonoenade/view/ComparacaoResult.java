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
import android.widget.TextView;
import android.os.Build;

public class ComparacaoResult extends Activity {
	
	private String curso, estado1, estado2;
	private ControllerCurso controller;
	private int codCurso;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comparacao_result);
		
		controller = new ControllerCurso(this);
		
		curso = getIntent().getExtras().getString("cursoSelecionado");
		estado1 = getIntent().getExtras().getString("Estado1");
		estado2 = getIntent().getExtras().getString("Estado2");
		codCurso = controller.buscaCodCurso(curso);
		
		TextView titulo = (TextView) findViewById(R.id.stringCurso);
		
		titulo.setText(String.format("Comparacao do curso de\n\t%s",curso));
		
		List<String> list;		
		
		list = controller.comparaEstado(estado1, estado2, codCurso);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
		
		ListView listResult = (ListView) findViewById(R.id.ListResultado);
		
		listResult.setAdapter(adapter); 
		listResult.setClickable(false);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comparacao_result, menu);
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
	
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_comparacao_result, container, false);
			return rootView;
		}
	}

}
