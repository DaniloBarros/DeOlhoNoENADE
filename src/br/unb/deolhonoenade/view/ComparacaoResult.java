package br.unb.deolhonoenade.view;

import java.util.ArrayList;
import java.util.List;

import br.unb.br.deolhonoenade.graphs.holographlibrary.Bar;
import br.unb.br.deolhonoenade.graphs.holographlibrary.BarGraph;
import br.unb.deolhonoenade.R;
import br.unb.deolhonoenade.R.id;
import br.unb.deolhonoenade.R.layout;
import br.unb.deolhonoenade.R.menu;
import br.unb.deolhonoenade.controller.ControllerCurso;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
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
		
		List<Float> list;		
		
		list = controller.comparaEstado(estado1, estado2, codCurso);
				
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		ArrayList<Bar> points = new ArrayList<Bar>();
		Bar d = new Bar();
		d.setColor(Color.parseColor("#99CC00"));
		d.setName(estado1);
		d.setValue(list.get(0));
		Bar d2 = new Bar();
		d2.setColor(Color.parseColor("#FFBB33"));
		d2.setName(estado2);
		d2.setValue(list.get(1));
		points.add(d);
		points.add(d2);

		BarGraph g = (BarGraph)findViewById(R.id.graph2);
		g.setBars(points);
		g.setUnit(" ");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.comparacao_result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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
