package fi.example.proto.mobiiliproject.ui.kirjaudu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import static fi.example.proto.mobiiliproject.R.id.text_kirjaudu;
import static fi.example.proto.mobiiliproject.R.layout.fragment_kirjaudu;

public class KirjauduFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        KirjauduViewModel signInViewModel = new ViewModelProvider(this).get(KirjauduViewModel.class);
        View root = inflater.inflate(fragment_kirjaudu, container, false);
        final TextView textView = root.findViewById(text_kirjaudu);
        signInViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
}