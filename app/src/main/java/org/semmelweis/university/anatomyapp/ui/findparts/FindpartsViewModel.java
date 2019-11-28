package org.semmelweis.university.anatomyapp.ui.findparts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FindpartsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FindpartsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Find Anatomy Parts fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}