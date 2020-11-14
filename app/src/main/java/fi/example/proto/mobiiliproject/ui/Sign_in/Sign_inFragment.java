package fi.example.proto.mobiiliproject.ui.Sign_in;

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

public class Sign_inFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Sign_inViewModel sign_inViewModel = new ViewModelProvider(this).get(Sign_inViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sign_in, container, false);
        final TextView textView = root.findViewById(R.id.text_sign_in);
        sign_inViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
}