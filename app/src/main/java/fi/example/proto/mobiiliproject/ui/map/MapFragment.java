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

import fi.example.proto.mobiiliproject.R;

public class MapFragment extends Fragment {
    Button buttonMap;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View mapView = inflater.inflate(R.layout.fragment_map, container, false);
        buttonMap = (Button) mapView.findViewById(R.id.button_map);
        buttonMap.setOnClickListener(new View.OnClickListener() {

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
