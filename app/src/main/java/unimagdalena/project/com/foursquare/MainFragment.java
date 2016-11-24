package unimagdalena.project.com.foursquare;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import unimagdalena.project.com.foursquare.pojos.CatAdpater;
import unimagdalena.project.com.foursquare.pojos.Categoria;
import unimagdalena.project.com.foursquare.pojos.GsonCategoriaParser;


public class MainFragment extends Fragment {
    private GridView gridView;
    private int n;
    private ImageView v;




    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.fragment_main, container, false);
        gridView= (GridView) vista.findViewById(R.id.matriz);
        v= (ImageView) vista.findViewById(R.id.imagen_cat);



        try{
            ConnectivityManager manager= (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info!=null &&info.isConnected()){

                JsonTask jTask=new JsonTask(gridView,getActivity());
                jTask.execute(new URL("https://dl.dropbox.com/s/utovgze2m31uvqp/nuevoJson.json?dl=0"));
            }else {
                Toast.makeText(getActivity(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return vista;

    }
    public class JsonTask extends AsyncTask<URL,Void,List<Categoria>> {
        private HttpURLConnection cont;
        private Context context;
        private GridView gridView;
        private CatAdpater adapter;

        public JsonTask(GridView gridew, Context context) {
            this.gridView = gridew;
            this.context = context;
        }

        @Override
        protected List<Categoria> doInBackground(URL... urls) {
            ArrayList<Categoria> categorias = null;
            try {
                cont = (HttpURLConnection) urls[0].openConnection();
                cont.setConnectTimeout(15000);
                cont.setReadTimeout(10000);
                int statusCode = cont.getResponseCode();
                if (statusCode != 200) {
                    categorias = new ArrayList<>();
                    categorias.add(new Categoria("Error", null, "Error"));
                } else {
                    InputStream stream = new BufferedInputStream(cont.getInputStream());
                    GsonCategoriaParser gsonCat = new GsonCategoriaParser();
                    categorias = (ArrayList<Categoria>) gsonCat.leerFlujoJson(stream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                cont.disconnect();
            }
            return categorias;
        }


        @Override
        protected void onPostExecute(final List<Categoria> categorias) {
            super.onPostExecute(categorias);
            if (categorias != null) {
                adapter = new CatAdpater(getActivity(), categorias);
                gridView.setAdapter(adapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Categoria cate = (Categoria) adapter.getItem(i);
                        Intent intent = new Intent(getActivity(), MainActivity2.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("cat", cate);
                        startActivity(intent);
                    }
                });
            } else {
                Toast.makeText(getActivity(), "Error de conexion", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
