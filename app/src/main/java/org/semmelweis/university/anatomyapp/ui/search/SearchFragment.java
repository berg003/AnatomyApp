package org.semmelweis.university.anatomyapp.ui.search;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.ortiz.touchview.TouchImageView;

import org.semmelweis.university.anatomyapp.R;

import java.util.Objects;
import java.util.TreeMap;

import static org.semmelweis.university.anatomyapp.ui.search.SearchConstant.fragmentMap;

public class SearchFragment extends Fragment {

    private Integer currentFragmentKey;
    private AutoCompleteTextView searchAutoCompleteTextView;
    private TextView textView;
    private TouchImageView touchImageView;
    private TouchImageView touchImageSelector;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchAutoCompleteTextView=view.findViewById(R.id.search_autocomplete);
        searchAutoCompleteTextView.setOnItemClickListener((parent, v, position, id) -> showImageAndWritePart(null));

        view.findViewById(R.id.search_cancel).setOnClickListener(v -> {
            searchAutoCompleteTextView.setText("");
            currentFragmentKey = null;
        });
        view.findViewById(R.id.search_up).setOnClickListener(v -> showImageAndWritePart(SearchConstant.ARROW_UP));
        view.findViewById(R.id.search_down).setOnClickListener(v -> showImageAndWritePart(SearchConstant.ARROW_DOWN));

        textView=view.findViewById(R.id.search_textview);
        touchImageView=view.findViewById(R.id.search_touchimageview);
        touchImageSelector=view.findViewById(R.id.select_touchimageview);
        touchImageSelector.setOnTouchImageViewListener(() -> touchImageView.setZoom(touchImageSelector));

        initAutoCompleteTextView(searchAutoCompleteTextView);

        return view;
    }

    private void initAutoCompleteTextView(AutoCompleteTextView searchAutoCompleteTextView) {
        searchAutoCompleteTextView.setOnKeyListener((v, keyCode, event) -> {
            // If the event is a key-down event on the "enter" button
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                hideKeyboardAndSearch();
                return true;
            } else if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode != KeyEvent.KEYCODE_ENTER)) {
                currentFragmentKey = null;
            }
            return false;
        });
        searchAutoCompleteTextView.setAdapter(new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, fragmentMap.keySet().toArray()));
    }

    private void hideKeyboardAndSearch() {
        FragmentActivity activity=getActivity();
        assert activity != null;
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        Objects.requireNonNull(imm).hideSoftInputFromWindow(searchAutoCompleteTextView.getWindowToken(), 0);
        showImageAndWritePart(null);
    }

    private void showImageAndWritePart(String arrow) {
        String text = searchAutoCompleteTextView.getText().toString();
        TreeMap<Integer,SearchDto> fragmentMap=SearchConstant.fragmentMap.get(text);
        if (fragmentMap != null) {
            Integer fragmentKey = arrow == null || currentFragmentKey == null || (SearchConstant.ARROW_UP.equals(arrow) && fragmentMap.lowerKey(currentFragmentKey) == null)  || (SearchConstant.ARROW_DOWN.equals(arrow) && fragmentMap.higherKey(currentFragmentKey) == null) ? fragmentMap.firstKey() :
                    (SearchConstant.ARROW_UP.equals(arrow) ? fragmentMap.lowerKey(currentFragmentKey) : fragmentMap.higherKey(currentFragmentKey));
            textView.setText(fragmentMap.get(fragmentKey).getNumbers() + " - " + text);
            touchImageView.setImageResource(fragmentKey);
            touchImageSelector.setImageResource(fragmentMap.get(fragmentKey).getSelectorImageId() == null ? R.drawable.blank : fragmentMap.get(fragmentKey).getSelectorImageId());
            currentFragmentKey=fragmentKey;
        } else {
            textView.setText("N/A");
            touchImageView.setImageResource(R.drawable.blank);
            touchImageSelector.setImageResource(R.drawable.blank);
        }
    }
}