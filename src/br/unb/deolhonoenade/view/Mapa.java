package br.unb.deolhonoenade.view;

import java.util.ArrayList;
import java.util.List;

import br.unb.deolhonoenade.R;
import br.unb.deolhonoenade.controller.ControllerCurso;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Mapa extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa);

		WebView webview = (WebView) findViewById(R.id.webView1);
        double x;
        x = 700.735;
        String xConvert = String.format("%f", x);
        String curso = getIntent().getExtras().getString("cursoSelecionado");
        ControllerCurso controller = new ControllerCurso(this);
        int codCurso = controller.buscaCodCurso(curso);
        List<Float> mediaEstados = new ArrayList<Float>();
        
        
        List<String> medias = new ArrayList<String>();
        
        /*mediaEstados = controller.comparaEstado("AC", "AL", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("AP", "AM", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("BA", "CE", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("DF", "ES", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("GO", "MA", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("MT", "MS", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("MG", "PA", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("PB", "PR", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("PE", "PI", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("RJ", "RN", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("RS", "RO", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("RR", "SC", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("SP", "SE", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));
        medias.add(String.valueOf(mediaEstados.get(1)));
        mediaEstados = controller.comparaEstado("TO", "SE", codCurso);
        medias.add(String.valueOf(mediaEstados.get(0)));*/
        
        
        ArrayList<String> cidades = (ArrayList<String>) controller.buscaUf(codCurso);
        
        for(int i = 0; i<cidades.size()-11; i++){
        	controller = new ControllerCurso(this);
        	String oi = new String();
        	try {
				oi = String.format("%.3f", controller.mediaEstado(cidades.get(i), codCurso));
			} catch (Exception e) {
				
				Log.e(this.getClass().toString(), "erro");
			}
        	Log.e(this.getClass().toString(), oi + cidades.get(i));
        	medias.add(oi);
        	
        }
        
        String content = "<html>"
                + "<head>"
                + "<script type='text/javascript' src='https://www.google.com/jsapi'></script>"
                + "<script type='text/javascript'>"
                + "google.load('visualization', '1', {'packages': ['geochart']});"
                + "google.setOnLoadCallback(drawRegionsMap);"
                + "function drawRegionsMap() {"
                + "var data = google.visualization.arrayToDataTable(["
                + "['Estado', 'Nota Média'],"
                + "['Acre', " + medias.get(0) + "],"
                + "['Alagoas', " + medias.get(1) + "],"
                + "['Amazonas', " + medias.get(2) + "],"
                + "['Amapa', " + medias.get(3) + "],"
                + "['Bahia', " + medias.get(4) + "],"
                + "['Ceara', " + medias.get(5) + "],"
                + "['Distrito Federal', " + medias.get(6) + "],"
                + "['Espirito Santo', " + medias.get(7) + "],"
                + "['Goias', " + medias.get(8) + "],"
                + "['Maranhao', " + medias.get(9) + "],"
                + "['Minas Gerais', " + medias.get(10) + "],"
                + "['Mato Grosso do Sul', " + medias.get(11) + "],"
                + "['Mato Grosso', " + medias.get(12) + "],"
                + "['Para', " + medias.get(13) + "],"
                + "['Paraiba', " + medias.get(14) + "],"
                + "['Pernambuco', " + medias.get(15) + "],";
        
        medias = new ArrayList<String>();
        
        for(int i = 16; i<cidades.size(); i++){
        	controller = new ControllerCurso(this);
        	String oi = new String();
        	try {
				oi = String.format("%.3f", controller.mediaEstado(cidades.get(i), codCurso));
			} catch (Exception e) {
				
				Log.e(this.getClass().toString(), "erro");
			}
        	Log.e(this.getClass().toString(), oi + cidades.get(i));
        	medias.add(oi);
        	
        }
        
        String content2 = "['Piaui', 2],"
                + "['Parana', 2],"
                + "['Rio de Janeiro', 3],"
                + "['Rio Grande do Norte', 4],"
                + "['Rio Grande do Sul', 1],"
                + "['Rondonia', 2],"
                + "['Roraima', 2],"
                + "['Santa Catarina', 2],"
                + "['Sao Paulo', 423],"
                + "['Sergipe', 1],"
                + "['Tocantins', 3],"            
                + "]);"
                + "var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));"
                + "chart.draw(data, {width: 1280, height: 720, region: 'BR', resolution: 'provinces'});"
                + "};"
                + "</script>"
                + "</head>"
                + "<body>"
                + "<div id='chart_div' style='width: 1024px; height: 768px;'></div>"
                + "Olá"
                + "</body>" 
                + "</html>";
        
        content += content2;
 
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.requestFocusFromTouch();
        
        //Usando o método abaixo (loadDataWithBaseURL) não é necessário o arquivo .html da pasta assets.
        //Sendo assim é executado um "html" em tempo real usando a string 'content' acima.
        //Só que não consegui fazer este funcionar.
        webview.loadDataWithBaseURL( "file:///android_asset/", content, "text/html", "utf-8", null );
        
        //webview.loadUrl("file:///android_asset/Mapa.html"); // Can be used in this way too.
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mapa, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_mapa, container,
					false);
			return rootView;
		}
	}

}
