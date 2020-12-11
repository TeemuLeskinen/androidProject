package fi.example.proto.mobiiliproject.ui.map;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import fi.example.proto.mobiiliproject.R;

public class MapFragment extends Fragment {
    Button buttonMap1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View mapView = inflater.inflate(R.layout.fragment_map, container, false);
        buttonMap1 = (Button) mapView.findViewById(R.id.button_map);
        buttonMap1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return mapView;
    }

    private void openMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:65.013384,25.4651043?z=14"));
        startActivity(intent);
    }
}

/*public class MapFragment extends FragmentActivity implements OnMapReadyCallback{
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager(). findFragmentById(R.id.map_frag);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;

        LatLng oulu = new LatLng(65.013384, 25.4651043);
        mMap.addMarker(new MarkerOptions().position(oulu).title("Oulu marker"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(oulu));
    }
}*/