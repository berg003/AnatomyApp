package org.semmelweis.university.anatomyapp.ui.beananatomist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import org.semmelweis.university.anatomyapp.R;

public class BeananatomistFragment extends Fragment {

    private BeananatomistViewModel beananatomistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        beananatomistViewModel =
                ViewModelProviders.of(this).get(BeananatomistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_beananatomist, container, false);
        final TextView textView = root.findViewById(R.id.text_beananatomist);
        beananatomistViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}