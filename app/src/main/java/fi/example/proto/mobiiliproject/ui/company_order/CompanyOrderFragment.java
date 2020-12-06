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

import fi.example.proto.mobiiliproject.R;

public class CompanyOrderFragment extends Fragment {
    String[] categories = {"Hernekeitto", "Kalakeitto", "Riisipuuro"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View orderview = inflater.inflate(R.layout.fragment_order_company, container, false);

        EditText time = orderview.findViewById(R.id.order_time_);


        EditText order_date = orderview.findViewById(R.id.order_date_);


        EditText order_amount = orderview.findViewById(R.id.order_amount_edit);


        EditText order_address = orderview.findViewById(R.id.address_);


        EditText order_more = orderview.findViewById(R.id.more_);



        Spinner spinner = orderview.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //


        ArrayAdapter aa = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, categories);
        aa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(aa);


        Button ordering = orderview.findViewById(R.id.order);
        ordering.setOnClickListener(view -> {
            Log.i("Send email", "");
            String[] TO = {"t8foju00@students.oamk.fi"};

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            //emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Tilaus");
            emailIntent.putExtra(Intent.EXTRA_TEXT, time.getText().toString()+"\n"+order_date.getText().toString()
                    +"\n"+order_amount.getText().toString()+"\n"+spinner.getSelectedItem().toString()
                    +"\n"+order_address.getText().toString()+"\n"+order_more.getText().toString());

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                Log.i("Finished sending", "");
            } catch (android.content.ActivityNotFoundException ex) {

            }

        });




        return orderview;
    }

    @SuppressLint("IntentReset")
    private void sendEmail() {

        Log.i("Send email", "");
        String[] TO = {"t8foju00@students.oamk.fi"};
        //String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        //emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Palautetta");
        //emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));

            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {

        }
    }
}
