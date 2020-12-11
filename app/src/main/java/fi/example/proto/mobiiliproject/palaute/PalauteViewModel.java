package fi.example.proto.mobiiliproject.palaute;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PalauteViewModel extends ViewModel {

    private static LiveData<String> mText;
    //private MutableLiveData<String> mText;

    public PalauteViewModel() {
        mText = new MutableLiveData<>();
        ((MutableLiveData<String>) mText).setValue("Palaute");
    }

    public static LiveData<String> getText() {
        return mText;
    }
}
