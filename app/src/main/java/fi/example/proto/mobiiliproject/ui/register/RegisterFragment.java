package fi.example.proto.mobiiliproject.ui.register;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import fi.example.proto.mobiiliproject.R;

public class RegisterFragment extends Fragment {

    Button btnRegister;
    EditText text_input_first_name, text_input_last_name, text_input_email, text_input_username, text_input_password ;

    public RegisterFragment(){
        //Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Asetetaan register fragmentti view näkymäksi
        View view_register = inflater.inflate(R.layout.fragment_register, container, false);

        //Määritetään luoduille olioille viittaukset xml tiedostoon
        btnRegister = view_register.findViewById(R.id.btn_register);
        text_input_first_name = view_register.findViewById(R.id.edit_text_first_name);
        text_input_last_name = view_register.findViewById(R.id.edit_text_last_name);
        text_input_email = view_register.findViewById(R.id.email_register);
        text_input_username = view_register.findViewById(R.id.username_register);
        text_input_password = view_register.findViewById(R.id.password_register);

        //Asetetaan napinpainallukselle kuuntelija
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String muuttujiin talletetaan rekisteröintilomakkeella syötetty tieto
                final String firstname, lastname, email, username, password;
                firstname = String.valueOf(text_input_first_name.getText());
                lastname = String.valueOf(text_input_last_name.getText());
                email = String.valueOf(text_input_email.getText());
                username = String.valueOf(text_input_username.getText());
                password = String.valueOf(text_input_password.getText());

                //Jos kaikki kentät täytetty siirrytään eteenpäin
                if(!firstname.equals("") && !lastname.equals("") && !email.equals("") && !username.equals("") && !password.equals("")) {

                    //Luodaan olio Handler luokasta, millä voidaan lähettää ja prosessoida viestejä
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            //Luodaan taulukko, missä annetaan parametrin nimet
                            String[] field = new String[5];
                            field[0] = "firstname";
                            field[1] = "lastname";
                            field[2] = "email";
                            field[3] = "username";
                            field[4] = "password";

                            //Toinen taulukko, missä määritellään data
                            String[] data = new String[5];
                            data[0] = firstname;
                            data[1] = lastname;
                            data[2] = email;
                            data[3] = username;
                            data[4] = password;

                            //Luodaan putData olio ja välitetään parametreina osoite, metodi ja taulukoiden tiedot, jolloin tiedot tallenetaan tietokantaan
                            //signup.php rajapintafunktiolla käsitellään tiedot ja asetetaan tietokantaan
                            PutData putData = new PutData("http://192.168.1.6:1025/mobileProject/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult(); //Result muuttujaan tallenetaan saatu vastaus
                                    //Jos vastaus sama kuin tässä määritetty, rekisteröityminen onnistunut ja siirrytään kirjautumissivulle
                                    if (result.equals("Rekisterointi onnistui")) {
                                        Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
                                        Navigation.findNavController(view_register).navigate(R.id.action_nav_register_to_nav_sign_in); //Siirrytään kirjautumissivulle
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


        return view_register;
    }

}