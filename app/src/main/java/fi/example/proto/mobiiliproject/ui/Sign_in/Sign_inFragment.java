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


import com.vishnusivadas.advanced_httpurlconnection.PutData;

import fi.example.proto.mobiiliproject.R;

public class Sign_inFragment extends Fragment {

    Button btnLogIn; 
    TextView txtViewRegister;

    EditText text_input_username, text_input_password ;

    public Sign_inFragment(){
        //Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Sign_inViewModel sign_inViewModel = new ViewModelProvider(this).get(Sign_inViewModel.class);
        View view_log_in = inflater.inflate(R.layout.fragment_sign_in, container, false);

        text_input_username = view_log_in.findViewById(R.id.edit_text_username);
        text_input_password = view_log_in.findViewById(R.id.edit_text_password);
        btnLogIn = view_log_in.findViewById(R.id.btn_login) ;
        txtViewRegister = view_log_in.findViewById(R.id.textview_register) ;

        btnLogIn.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {

            final String username, password;

            username = String.valueOf(text_input_username.getText());
            password = String.valueOf(text_input_password.getText());

            if(!username.equals("") && !password.equals("")) {

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        String[] field = new String[2];
                        field[0]= "username";
                        field[1]= "password";

                        String[] data = new String[2];
                        data[0] = username;
                        data[1] = password;

                        PutData putData = new PutData("http://192.168.1.6:1025/mobileProject/login.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Kirjautuminen onnistui")) {
                                    Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
                                    Navigation.findNavController(view_log_in).navigate(R.id.action_nav_sign_in_to_nav_home);
                                } else {
                                    Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                    }
                });
            }
            else {
                Toast.makeText(getContext(), "Täytä kaikki kentät", Toast.LENGTH_SHORT).show();
            }
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