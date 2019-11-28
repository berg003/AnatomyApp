package org.semmelweis.university.anatomyapp.ui.findparts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import org.semmelweis.university.anatomyapp.R;

public class FindpartsFragment extends Fragment {

    private FindpartsViewModel findpartsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        findpartsViewModel =
                ViewModelProviders.of(this).get(FindpartsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_findparts, container, false);
        final TextView textView = root.findViewById(R.id.text_findparts);
        findpartsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}