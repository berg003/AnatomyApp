package org.semmelweis.university.anatomyapp.ui.beananatomist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BeananatomistViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BeananatomistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Be an Anatomist fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}