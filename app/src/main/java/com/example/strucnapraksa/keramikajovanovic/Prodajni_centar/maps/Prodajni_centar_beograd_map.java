package com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.maps;

import android.app.Dialog;
import android.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.strucnapraksa.keramikajovanovic.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Simic on 8/27/2017.
 */

public class Prodajni_centar_beograd_map extends Fragment {

    GoogleMap mGoogleMap;
    private static final LatLng BEOGRAD = new LatLng(45.246400, 19.769324);

    public void ProcessMap(View v){

        if(mGoogleMap == null){

            mGoogleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapFragment)).getMap();


        } else{

            mGoogleMap.addMarker(new MarkerOptions().position(BEOGRAD).title("Керамика Јовановић нови сад"));
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BEOGRAD, 15));
        }
    }

    public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.prodajni_centar_beograd, container, false);
        ProcessMap(v);
        return v;

    }





}
