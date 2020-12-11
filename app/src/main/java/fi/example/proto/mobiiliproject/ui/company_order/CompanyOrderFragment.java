package fi.example.proto.mobiiliproject.ui.company_order;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;

import fi.example.proto.mobiiliproject.MainActivity;
import fi.example.proto.mobiiliproject.R;
import fi.example.proto.mobiiliproject.ui.home.HomeFragment;

public class CompanyOrderFragment extends Fragment {

    String[] categories = {"Hernekeitto", "Kalakeitto", "Riisipuuro"};
    @SuppressLint("IntentReset")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View orderview = inflater.inflate(R.layout.fragment_order_company, container, false);


        EditText time = orderview.findViewById(R.id.order_time_);


        EditText order_date = orderview.findViewById(R.id.order_date_);


        EditText order_amount = orderview.findViewById(R.id.order_amount_edit);


        EditText order_address = orderview.findViewById(R.id.address_);


        EditText order_more = orderview.findViewById(R.id.more_);


        Spinner spinner = orderview.findViewById(R.id.spinner);



        ArrayAdapter aa = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, categories);

        spinner.setAdapter(aa);


        Button ordering = orderview.findViewById(R.id.order);
        ordering.setOnClickListener(view -> {
            Log.i("Send email", "");
            String[] TO = {"t8foju00@students.oamk.fi"};

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
                //lähetysosoite, TO määritelty yllä
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            //otsikko
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Tilaus");
            //kerätään edittexteistä asiakkaan niihin laittamat tiedot sähköpostin tekstiksi
            emailIntent.putExtra(Intent.EXTRA_TEXT, time.getText().toString()+"\n"+order_date.getText().toString()
                    +"\n"+order_amount.getText().toString()+"\n"+spinner.getSelectedItem().toString()
                    +"\n"+order_address.getText().toString()+"\n"+order_more.getText().toString());

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                Log.i("Finished sending", "");
            } catch (android.content.ActivityNotFoundException ignored) {

            }

        });




        return orderview;
    }


}
