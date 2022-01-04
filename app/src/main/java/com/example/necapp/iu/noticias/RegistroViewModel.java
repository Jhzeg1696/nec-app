package com.example.necapp.iu.noticias;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.necapp.servicios.MyFirebaseMessagingService;

//import com.example.necapp.services.MyFirebaseMessagingService;

public class RegistroViewModel extends ViewModel {
    private MutableLiveData<String> mensaje;
    private MyFirebaseMessagingService firebaseMessagingService;

    public RegistroViewModel()
    {
        mensaje = new MutableLiveData<>();
        firebaseMessagingService = new MyFirebaseMessagingService();
        firebaseMessagingService.getToken();
        mensaje.setValue("Hello World");
    }

    public LiveData<String> getMensaje(){ return this.mensaje; }
}
