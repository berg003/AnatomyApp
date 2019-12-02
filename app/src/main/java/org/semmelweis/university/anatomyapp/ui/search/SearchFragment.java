package org.semmelweis.university.anatomyapp.ui.search;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.semmelweis.university.anatomyapp.R;

import java.util.Objects;

public class SearchFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        ImageView searchCancel=root.findViewById(R.id.search_cancel);
        final AutoCompleteTextView searchAutoCompleteTextView=root.findViewById(R.id.search_autocomplete);
        searchCancel.setOnClickListener(v -> searchAutoCompleteTextView.setText(""));

        searchAutoCompleteTextView.setOnKeyListener((v, keyCode, event) -> {
            // If the event is a key-down event on the "enter" button
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // Perform action on key press
                InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Activity.INPUT_METHOD_SERVICE);
                //Find the currently focused view, so we can grab the correct window token from it.
                View view = getActivity().getCurrentFocus();
                //If no view currently has focus, create a new one, just so we can grab a window token from it
                if (view == null) {
                    view = new View(getActivity());
                }
                Objects.requireNonNull(imm).hideSoftInputFromWindow(view.getWindowToken(), 0);
                //TODO: search for item
                return true;
            }
            return false;
        });

        return root;
    }
}