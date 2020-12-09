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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import fi.example.proto.mobiiliproject.R;
//import fi.example.proto.mobiiliproject.palaute.PalauteViewModel;

public class PalauteFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View palauteview = inflater.inflate(R.layout.fragment_palaute, container, false);
        ImageView iv = palauteview.findViewById(R.id.imageButton);
        TextView textView = palauteview.findViewById(R.id.textView2);
        Button palaute = palauteview.findViewById(R.id.sendEmail);
        palaute.setOnClickListener((view -> {sendEmail();}));

        return palauteview;
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

