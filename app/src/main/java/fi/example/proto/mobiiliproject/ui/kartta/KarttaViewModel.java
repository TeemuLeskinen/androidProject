package fi.example.proto.mobiiliproject.ui.kartta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KarttaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KarttaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Karttasivu");
    }

    public LiveData<String> getText() {
        return mText;
    }
}