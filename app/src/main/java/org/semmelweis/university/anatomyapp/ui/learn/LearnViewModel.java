package org.semmelweis.university.anatomyapp.ui.learn;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LearnViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LearnViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Learn Anatomy fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}