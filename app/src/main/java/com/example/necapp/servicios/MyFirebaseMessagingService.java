package com.example.necapp.servicios;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.necapp.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();

    @Override
    public void onNewToken(@NonNull String token)
    {
        super.onNewToken(token);

        Log.d(TAG, "Token: " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        // Obteniendo el mensaje de la notificación
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if(remoteMessage.getNotification() != null)
        {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            {
                NotificationChannel channel = new NotificationChannel("notifications", "notifications", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel);

                LocalNotificationService notificationService = new LocalNotificationService();
                notificationService.show(getApplicationContext(), remoteMessage.getNotification().getBody());
            }
        }
    }

    public void getToken()
    {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<String> task) {
                if(!task.isSuccessful())
                {
                    Log.e(TAG, "Failed to get the token.");
                    return;
                }

                String token = task.getResult();
                Log.e(TAG, "Aqui Token: " + token);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Log.e(TAG, "Failed to get the token: " + e.getLocalizedMessage());
            }
        });
    }
}
