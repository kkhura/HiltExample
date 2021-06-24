package com.kkhura.hiltexample.dashboard.translate.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kkhura.hiltexample.R;
import com.kkhura.hiltexample.dashboard.translate.TranslationConstantKt;
import com.kkhura.hiltexample.dashboard.translate.viewmodel.TranslateViewModel;
import com.kkhura.hiltexample.di.qualifier.FragmentQualifier;

import java.util.HashMap;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TranslateJavaFragment extends Fragment {

    private TranslateViewModel userViewModel;

    @FragmentQualifier
    @Inject
    String fragmentString;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_user, container, false);

        userViewModel = new ViewModelProvider(this).get(TranslateViewModel.class);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HashMap<String, String> map = new HashMap<>();
        map.put(TranslationConstantKt.TARGET_LANGUAGE, "es");
        map.put(TranslationConstantKt.SOURCE_LANGUAGE, "en");
        map.put(TranslationConstantKt.STRING, "Hello world");
        userViewModel.fetchTranslation(map, "https://blanc-stg1--simpplr.visualforce.com/");
        userViewModel.getUserResponse().observe(getViewLifecycleOwner(), o -> {
            if (o != null) {
                ((TextView) rootView.findViewById(R.id.textFragment)).setText(o);
            }
        });

    }

}
