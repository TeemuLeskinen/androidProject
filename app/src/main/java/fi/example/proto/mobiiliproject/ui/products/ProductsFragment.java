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
import androidx.navigation.Navigation;

import fi.example.proto.mobiiliproject.R;
import fi.example.proto.mobiiliproject.ui.home.HomeFragment;
import fi.example.proto.mobiiliproject.ui.products.ProductsFragment;

public class ProductsFragment extends Fragment {

    Button buttonOrder1, buttonOrder2, buttonOrder3, buttonOrder4, buttonOrder5, buttonOrder6;
    //luodaan view
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProductsViewModel productsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        View viewProducts = inflater.inflate(R.layout.fragment_products, container, false);

        //haetaan buttonit tuotteille
        buttonOrder1 = (Button) viewProducts.findViewById(R.id.buttonOrder1);
        buttonOrder2 = (Button) viewProducts.findViewById(R.id.buttonOrder2);
        buttonOrder3 = (Button) viewProducts.findViewById(R.id.buttonOrder3);
        buttonOrder4 = (Button) viewProducts.findViewById(R.id.buttonOrder4);
        buttonOrder5 = (Button) viewProducts.findViewById(R.id.buttonOrder5);
        buttonOrder6 = (Button) viewProducts.findViewById(R.id.buttonOrder6);


        //asetetaan onClickListener, jonka avulla nappia klikkaamalla siirrytään tuotteista action_nav_products... actionin avulla order sivulle
        buttonOrder1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                    Navigation.findNavController(viewProducts).navigate(R.id.action_nav_products_to_nav_order);
                }
            });


        buttonOrder2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Navigation.findNavController(viewProducts).navigate(R.id.action_nav_products_to_nav_order);
            }
        });

        buttonOrder3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Navigation.findNavController(viewProducts).navigate(R.id.action_nav_products_to_nav_order);
            }
        });

        buttonOrder4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Navigation.findNavController(viewProducts).navigate(R.id.action_nav_products_to_nav_order);
            }
        });

        buttonOrder5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Navigation.findNavController(viewProducts).navigate(R.id.action_nav_products_to_nav_order);
            }
        });

        buttonOrder6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Navigation.findNavController(viewProducts).navigate(R.id.action_nav_products_to_nav_order);
            }
        });

        return viewProducts;
    }

}