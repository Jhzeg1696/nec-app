package com.example.necapp.iu.principal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrincipalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PrincipalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("\"En Nuevo Laredo viviremos los mejores años de nuestras vidas.\"");
    }

    public LiveData<String> getText() {
        return mText;
    }
}