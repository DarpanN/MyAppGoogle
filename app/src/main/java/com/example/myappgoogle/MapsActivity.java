package com.example.myappgoogle;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        CameraUpdate zoom;
       zoom = CameraUpdateFactory.zoomTo(16);


        // Add a marker in Sydney and move the camera
        LatLng softwarica = new LatLng(28.394857, 84.124008);
        mMap.addMarker(new MarkerOptions().position(softwarica).title("Softwarica College "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(softwarica));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13));


        LatLng bigmovie = new LatLng(27.7097, 85.3267);
        mMap.addMarker(new MarkerOptions().position(bigmovie).title("Bigmovie"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bigmovie));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));



    }

    public void loadLocation(){
        List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(27.70628,85.3267,"Softwarica"));
        placeList.add(new Place(27.6931,85.2807,"Kalanki"));
        placeList.add(new Place(27.7111,85.2283,"Dhachowk"));

        CameraUpdate centre,zoom;
        for (Place Place:placeList){
            zoom = CameraUpdateFactory.zoomTo(15);
            centre = CameraUpdateFactory.newLatLng(new LatLng(Place.getLat(),Place.getLon()));
            mMap.addMarker(new MarkerOptions().position(new LatLng(Place.getLat(),Place.getLon())).title(Place.getName()));

             mMap.moveCamera(centre);
                mMap.animateCamera(zoom);
                mMap.getUiSettings().setZoomControlsEnabled(true);
        }
    }
}
