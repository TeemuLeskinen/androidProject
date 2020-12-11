package fi.example.proto.mobiiliproject.ui.palaute;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import fi.example.proto.mobiiliproject.R;


public class PalauteFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View palauteview = inflater.inflate(R.layout.fragment_palaute, container, false);

        Button palaute = palauteview.findViewById(R.id.sendEmail);
        palaute.setOnClickListener((view -> {sendEmail();}));

        return palauteview;
    }
        //sähköpostinlähetys:
    @SuppressLint("IntentReset")
    private void sendEmail() {

            Log.i("Send email", "");
                //määritellään lähetysosoite
            String[] TO = {"t8foju00@students.oamk.fi"};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
                //vastaanottaja
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                //sähköpostin otsikko
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Palautetta");

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                Log.i("Finished sending email...", "");
            } catch (android.content.ActivityNotFoundException ignored) {

            }
        }
    }

