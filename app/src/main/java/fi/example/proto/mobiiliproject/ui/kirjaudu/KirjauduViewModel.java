package fi.example.proto.mobiiliproject.ui.kirjaudu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KirjauduViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KirjauduViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Kirjaudu");
    }

    public LiveData<String> getText() {
        return mText;
    }
}