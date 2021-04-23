package com.kkhura.hiltexample;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.kkhura.hiltexample.di.qualifier.AppQualifier;

public class ViewModelTest extends ViewModel {

    private final String applicationString;
    private final SavedStateHandle savedStateHandle;

    @ViewModelInject
    ViewModelTest(@AppQualifier String applicationString,
                  @Assisted SavedStateHandle savedStateHandle) {
        this.applicationString = applicationString;
        this.savedStateHandle = savedStateHandle;
    }
}
