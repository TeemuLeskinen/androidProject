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

    //Tämä koodi on kierto ratkaisu. Halusin tehdä erillisen karttanäkymän sivun alakulmaan, mutta tuloksetta.
    //Hyödynnetään nappia, johon liitetään ulkoinen linkki googlemaps hakuun.

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Luodaan View fragment_map xml
        View mapView = inflater.inflate(R.layout.fragment_map, container, false);
        //Määritetään button xml tiedostosta
        buttonMap1 = (Button) mapView.findViewById(R.id.button_map);
        //asetetaan button click, joka kutsuu aliohjelmaa openMap();
        buttonMap1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return mapView;
    }

    //aliohjelma openMap() käyttää intentiä, joka avaa Uri.parsella koordinaatiston GoogleMapsissa.
    private void openMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:65.013384,25.4651043?z=14"));
        //käynnistetään intent
        startActivity(intent);
    }
}
// Alhaalla koodi jota yritin saada toimimaan mappi fragmenttiin. Koodi toimi demo projektissa, jossa hyödynnettiin fragmentteja mutta liitettynä projektiin crashaa.
// Olisikohan syy siinä että kutsutaan FragmentActivitya Fragmentin sijasta?
// Map fragment laajentuu Fragment Activityyn johon on liitetty OnMapReadyCallback


/*public class MapFragment extends FragmentActivity implements OnMapReadyCallback{
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map);

// käytetään supportMapFragmenttia, joka toimii Googlemaps karttanäkymän fragmenttina. XML tiedostossa olisi map_frag id:llä oleva fragmentti, jota kutsutaan tässä findFragmentById:llä.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager(). findFragmentById(R.id.map_frag);
        mapFragment.getMapAsync(this);
    }
//onMapReady aliohjelma, johon määritetään googleMap

    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;

//asetetaan latitude ja longitude, tässätapauksessa Oulun torinranta

        LatLng oulu = new LatLng(65.013384, 25.4651043);
//lisätään kartan nuoli, joka osoittaa koordinaattien osoittaman paikan addMarker avulla.
        mMap.addMarker(new MarkerOptions().position(oulu).title("Oulu marker"));
//kameran liikutus
        mMap.moveCamera(CameraUpdateFactory.newLatLng(oulu));
    }
}*/