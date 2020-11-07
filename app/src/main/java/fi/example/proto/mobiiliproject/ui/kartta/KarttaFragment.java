package fi.example.proto.mobiiliproject.ui.kartta;

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

import fi.example.proto.mobiiliproject.R;

public class KarttaFragment extends Fragment {

    private KarttaViewModel karttaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        karttaViewModel =
                new ViewModelProvider(this).get(KarttaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_kartta, container, false);
        final TextView textView = root.findViewById(R.id.text_kartta);
        karttaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}