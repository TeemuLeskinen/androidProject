package fi.example.proto.mobiiliproject.ui.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import fi.example.proto.mobiiliproject.R;
import fi.example.proto.mobiiliproject.ui.home.HomeFragment;
import fi.example.proto.mobiiliproject.ui.products.ProductsFragment;

public class ProductsFragment extends Fragment {

    public ProductsFragment(){
        //empty public contructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProductsViewModel productsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        View viewProducts = inflater.inflate(R.layout.fragment_products, container, false);



       /* final TextView textView = root.findViewById(R.id.text_products);
        productsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/
        return viewProducts;
    }
}