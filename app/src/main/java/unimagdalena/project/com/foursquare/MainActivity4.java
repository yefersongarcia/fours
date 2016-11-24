package unimagdalena.project.com.foursquare;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import unimagdalena.project.com.foursquare.pojos.Categoria;
import unimagdalena.project.com.foursquare.pojos.Sitio;

public class MainActivity4 extends AppCompatActivity implements OnMapReadyCallback{
    private SupportMapFragment fragmentMap;
    private Categoria item;
    private ArrayList<Sitio>sitios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle bundle=getIntent().getExtras();
        item= (Categoria) bundle.get("item");
        sitios=item.getSitios();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentMap=(SupportMapFragment)fragmentManager.findFragmentById(R.id.mapasact);
        if(fragmentMap!=null){
            fragmentMap=SupportMapFragment.newInstance();
            fragmentMap.getMapAsync(this);
            fragmentMap.setRetainInstance(true);
            fragmentManager.beginTransaction().add(R.id.mapasact,fragmentMap).commit();
        }

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap=fragmentMap.getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);

        for (Sitio sitio:sitios){

            googleMap.addMarker(new MarkerOptions().position(new LatLng(sitio.getUbicacion().getLatitud(), sitio.getUbicacion().getLongitud())).title(sitio.getNombre()));

        }


    }
}
