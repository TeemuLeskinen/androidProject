package fi.example.proto.mobiiliproject.ui.products;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductsViewModel extends ViewModel {

    public ProductsViewModel() {
        MutableLiveData<String> mText = new MutableLiveData<>();

    }

   /* public LiveData<String> getText() {
        return mText;
    }*/
}