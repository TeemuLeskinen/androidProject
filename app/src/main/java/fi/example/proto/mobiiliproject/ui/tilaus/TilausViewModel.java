package fi.example.proto.mobiiliproject.ui.tilaus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TilausViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TilausViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tilaussivu");
    }

    public LiveData<String> getText() {
        return mText;
    }
}