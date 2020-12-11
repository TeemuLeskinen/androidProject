package fi.example.proto.mobiiliproject.ui.order;

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

public class OrderFragment extends Fragment {

    //luodaan view
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        OrderViewModel orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        //Asetetaan fragment_order(tilaussivu) näkymäksi
        View root = inflater.inflate(R.layout.fragment_order, container, false);
        final TextView textView = root.findViewById(R.id.orderTotalTextView);
        orderViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
}