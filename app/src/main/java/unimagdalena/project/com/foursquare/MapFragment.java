package unimagdalena.project.com.foursquare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private SupportMapFragment fragmentMap;
    public MapFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_map, container, false);
        FragmentManager fragmentManager=getChildFragmentManager();
        fragmentMap=(SupportMapFragment)fragmentManager.findFragmentById(R.id.mapas);
        if(fragmentMap!=null){
            fragmentMap=SupportMapFragment.newInstance();
            fragmentMap.getMapAsync(this);
            fragmentMap.setRetainInstance(true);
            fragmentManager.beginTransaction().add(R.id.mapas,fragmentMap).commit();
        }

        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap=fragmentMap.getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);





    }


}
