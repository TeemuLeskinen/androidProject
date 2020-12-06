package fi.example.proto.mobiiliproject.ui.Sign_in;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;



import fi.example.proto.mobiiliproject.R;

public class Sign_inFragment extends Fragment {

    Button btnLogIn; 
    TextView txtViewRegister;

    EditText text_input_first_name, text_input_last_name, text_input_email, text_input_username, text_input_password ;

    public Sign_inFragment(){
        //Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Sign_inViewModel sign_inViewModel = new ViewModelProvider(this).get(Sign_inViewModel.class);
        View view_log_in = inflater.inflate(R.layout.fragment_sign_in, container, false);

    btnLogIn = view_log_in.findViewById(R.id.btn_login) ;
    txtViewRegister = view_log_in.findViewById(R.id.textview_register) ;

    btnLogIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Navigation.findNavController(view_log_in).navigate(R.id.action_nav_sign_in_to_nav_home);
        }
    });

    txtViewRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Navigation.findNavController(view_log_in).navigate(R.id.action_nav_sign_in_to_nav_register);
        }
    });


        return view_log_in;

    }
}