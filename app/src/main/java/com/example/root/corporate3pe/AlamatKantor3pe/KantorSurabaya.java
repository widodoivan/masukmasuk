package com.example.root.corporate3pe.AlamatKantor3pe;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.root.corporate3pe.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class KantorSurabaya extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kantor_surabaya);
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

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.addMarker(new MarkerOptions().position(new LatLng(-7.376056, 112.728242)).
                title("Tiga Permata Ekspres").icon(BitmapDescriptorFactory.
                defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.animateCamera(CameraUpdateFactory.
                newLatLngZoom(new LatLng(-7.376056, 112.728242), 15 ));



//        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//        Criteria criteria = new Criteria();
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
//        if (location != null){
//            Toast.makeText(this, "lokasi oke", Toast.LENGTH_SHORT).show();
//            LatLng kantorsurabaya = new LatLng(-7.376002, 112.728218);
//            mMap.addMarker(new MarkerOptions().position(kantorsurabaya).title("Latitude: " + location.getLatitude()).snippet("Longitude: "+ location.getLongitude()));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(kantorsurabaya));
//        }else{
//            Toast.makeText(this, "Lokasi tidak ditemukan", Toast.LENGTH_SHORT).show();
//        }

        // Add a marker in Sydney and move the camera

    }
}
