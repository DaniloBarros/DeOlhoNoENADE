package br.unb.deolhonoenade.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
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
import br.unb.br.deolhonoenade.graphs.holographlibrary.Bar;
import br.unb.br.deolhonoenade.graphs.holographlibrary.BarGraph;
import br.unb.deolhonoenade.R;
import br.unb.deolhonoenade.controller.ControllerCurso;

public class ComparacaoResultIES extends Activity {

	private ControllerCurso controller;
	private List<String> result, aux;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comparacao_result_ies);
		
		controller = new ControllerCurso(this);
		
		result = getIntent().getExtras().getStringArrayList("dadosIes1");
		aux = getIntent().getExtras().getStringArrayList("dadosIes2");
		
		ArrayList<Bar> points = new ArrayList<Bar>();
		Bar d = new Bar();
		d.setColor(Color.parseColor("#99CC00"));
		d.setName("test \ntest");
		d.setValue(Float.parseFloat(result.get(5)));
		Bar d2 = new Bar();
		d2.setColor(Color.parseColor("#FFBB33"));
		d2.setName(aux.get(0));
		d2.setValue(Float.parseFloat(aux.get(5)));
		points.add(d);
		points.add(d2);

		BarGraph g = (BarGraph)findViewById(R.id.graph);
		g.setBars(points);
		g.setUnit(" ");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comparacao_result_ie, menu);
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
					R.layout.fragment_comparacao_result_ie, container, false);
			return rootView;
		}
	}
	
	

}
