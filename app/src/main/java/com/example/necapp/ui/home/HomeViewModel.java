package com.example.necapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("\"En Nuevo Laredo viviremos los mejores años de nuestras vidas.\"");
    }

    public LiveData<String> getText() {
        return mText;
    }
}