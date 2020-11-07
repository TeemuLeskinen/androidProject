package fi.example.proto.mobiiliproject.ui.tuotteet;

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

public class TuotteetFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TuotteetViewModel tuotteetViewModel = new ViewModelProvider(this).get(TuotteetViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tuotteet, container, false);
        final TextView textView = root.findViewById(R.id.text_tuotteet);
        tuotteetViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}