package fi.example.proto.mobiiliproject.ui.tuotteet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TuotteetViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TuotteetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tuotesivu");
    }

    public LiveData<String> getText() {
        return mText;
    }
}