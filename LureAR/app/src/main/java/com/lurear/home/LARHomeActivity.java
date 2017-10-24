package com.lurear.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lurear.R;
import com.lurear.app.LARCommon;
import com.lurear.base.LARBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LARHomeActivity extends LARBaseActivity implements OnMapReadyCallback {
    @BindView(R.id.btHomeSide)
    ImageView mIBHomeSide;

    @BindView(R.id.btHomePin)
    ImageView mIBHomePin;

    @BindView(R.id.btSelectGeoFence)
    ImageView mIBSelectGeoFence;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng TutorialsPoint = new LatLng(21, 57);
        mMap.addMarker(new
                MarkerOptions().position(TutorialsPoint).title("Tutorialspoint.com"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TutorialsPoint));

    }
    @OnClick(R.id.btHomePin)
    void homePinClickListener() {
        LARCommon.showDistancePickerDialog(LARHomeActivity.this);
    }

    @OnClick(R.id.btSelectGeoFence)
    void selectGeoFenceClickListener() {
        Intent intent = new Intent(LARHomeActivity.this, LARSelectLocationActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    @OnClick(R.id.btHomeSide)
    void homeSideClickListener() {
        Intent intent = new Intent(LARHomeActivity.this, LARHomeSideMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }
    @OnClick(R.id.btnHomeAr)
    void homeARClickListener() {
        Intent intent = new Intent(LARHomeActivity.this, LARAddCheckInActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean supportOffline() {
        return false;
    }
}
