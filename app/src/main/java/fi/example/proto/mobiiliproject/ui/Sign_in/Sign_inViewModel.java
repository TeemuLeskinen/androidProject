package fi.example.proto.mobiiliproject.ui.Sign_in;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Sign_inViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Sign_inViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Kirjaudu");
    }

    /*public LiveData<String> getText() {
        return mText;
    }*/
}