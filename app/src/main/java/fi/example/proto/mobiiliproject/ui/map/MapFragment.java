package fi.example.proto.mobiiliproject.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

import fi.example.proto.mobiiliproject.R;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private MapViewModel mapViewModel;
    public static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

    MapView mapV;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mapViewModel =
                new ViewModelProvider(this).get(MapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_map, container, false);
        /*final TextView textView = root.findViewById(R.id.text_map);
        mapViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/
        mapV =(MapView) root.findViewById(R.id.mapView);

        Bundle mapViewBundle = null;
        if(savedInstanceState  != null){
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
            mapV.onCreate(mapViewBundle);
            mapV.getMapAsync(this);
        }
        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50,6)));
       // googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom());
    }

    @Override
    public void onResume() {
        super.onResume();
        mapV.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapV.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapV.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapV.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapV.onLowMemory();
    }
}