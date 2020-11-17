package fi.example.proto.mobiiliproject.ui.Sign_in;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

import fi.example.proto.mobiiliproject.R;
import fi.example.proto.mobiiliproject.ui.home.HomeFragment;
import fi.example.proto.mobiiliproject.ui.products.ProductsFragment;

public class Sign_inFragment extends Fragment {

    Button btnLogIn;

    public Sign_inFragment(){
        //Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Sign_inViewModel sign_inViewModel = new ViewModelProvider(this).get(Sign_inViewModel.class);
        View view_log_in = inflater.inflate(R.layout.fragment_sign_in, container, false);

    btnLogIn = view_log_in.findViewById(R.id.btn_login) ;

    btnLogIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Navigation.findNavController(view_log_in).navigate(R.id.action_nav_sign_in_to_nav_home);

        }
    });


        return view_log_in;

    }
}