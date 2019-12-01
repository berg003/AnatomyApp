package org.semmelweis.university.anatomyapp.ui.qa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Be an Anatomist fragment");
    }

    LiveData<String> getText() {
        return mText;
    }
}