package br.unb.deolhonoenade.view;

import java.util.List;

import org.w3c.dom.Text;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.unb.deolhonoenade.R;
import br.unb.deolhonoenade.controller.ControllerCurso;

public class ComparacaoResultC extends Activity {
	
	private String curso, estado1, estado2, cidade1, cidade2;
	private int media1, media2, codCurso;
	private ControllerCurso controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comparacao_result_c);
		
		controller = new ControllerCurso(this);
		
		curso = getIntent().getExtras().getString("cursoSelecionado");
		estado1 = getIntent().getExtras().getString("estado1");
		estado2 = getIntent().getExtras().getString("estado2");
		cidade1 = getIntent().getExtras().getString("cidade1");
		cidade2 = getIntent().getExtras().getString("cidade2");
		codCurso = controller.buscaCodCurso(curso);
		
		
		TextView cursoSelecionado = (TextView) findViewById(R.id.cursoSelecionado1);
		cursoSelecionado.setText(getIntent().getExtras().getString("cursoSelecionado"));
		//cursoSelecionado.setText(String.format("%d" , codCurso));
		
		TextView estado1Selecionado = (TextView) findViewById(R.id.estado1);
		estado1Selecionado.setText(getIntent().getExtras().getString("estado1"));
		
		TextView cidade1Selecionada = (TextView) findViewById(R.id.cidade1);
		cidade1Selecionada.setText(getIntent().getExtras().getString("cidade1"));
		
		
		TextView estado2Selecionado = (TextView) findViewById(R.id.estado2);
		estado2Selecionado.setText(getIntent().getExtras().getString("estado2"));
		
		TextView cidade2Selecionada = (TextView) findViewById(R.id.cidade2);
		cidade2Selecionada.setText(getIntent().getExtras().getString("cidade2"));
		
		List<Float> list;
		
		list = controller.comparacaoCidade(codCurso, estado1, cidade1, estado2, cidade2);
		
		float media1 = list.get(0);
		float media2 = list.get(1);
		
		
		TextView mediaCidade1 = (TextView) findViewById(R.id.nota1);
		mediaCidade1.setText(String.format("%f" , media1));
		
		TextView mediaCidade2 = (TextView) findViewById(R.id.nota2);
		mediaCidade2.setText(String.format("%f" , media2));
		

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comparacao_result_c, menu);
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
					R.layout.fragment_comparacao_result_c, container, false);
			return rootView;
		}
	}

}
