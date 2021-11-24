package com.example.necapp.ui.registro;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistroViewModel extends ViewModel {
    private MutableLiveData<String> mensaje;

    public RegistroViewModel()
    {
        mensaje = new MutableLiveData<>();
        mensaje.setValue("Hello World");
    }

    public LiveData<String> getMensaje(){ return this.mensaje; }
}
