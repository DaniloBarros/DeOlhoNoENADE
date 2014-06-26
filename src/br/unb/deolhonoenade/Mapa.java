package br.unb.deolhonoenade;

import java.util.ArrayList;

import br.unb.deolhonoenade.controller.ControllerCurso;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
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
        ControllerCurso controller = new ControllerCurso(this);
        ArrayList<Float> mediaACAL = new ArrayList<Float>();
       
        String content = "<html>"
                + "<head>"
                + "<script type='text/javascript' src='https://www.google.com/jsapi'></script>"
                + "<script type='text/javascript'>"
                + "google.load('visualization', '1', {'packages': ['geochart']});"
                + "google.setOnLoadCallback(drawRegionsMap);"
                + "function drawRegionsMap() {"
                + "var data = google.visualization.arrayToDataTable(["
                + "['Estado', 'Nota Média'],"
                + "['Distrito Federal', 1300.527],"
                + "['Goias', 700],"
                + "['Mato Grosso do Sul', 400.435],"
                + "['Minas Gerais', 500],"
                + "['Sao Paulo', 600],"
                + "['Mato Grosso', " + String.valueOf((float)x) + "],"
                + "['Amazonas', 850]"
                + "]);"
                + "var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));"
                + "chart.draw(data, {width: 1280, height: 720, region: 'BR', resolution: 'provinces'});"
                + "};"
                + "</script>"
                + "</head>"
                + "<body>"
                + "<div id='chart_div' style='width: 1024px; height: 768px;'></div>"
                + "Olá"
                + "</body>" + "</html>";
 
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
