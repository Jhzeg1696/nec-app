package com.example.necapp.services;

import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.necapp.R;

public class LocalNotificationService {
    public void show(Context context)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifications")
                .setSmallIcon(R.drawable.logo_icono)
                .setContentTitle("Gobierno de nuevo laredo")
                .setContentText("Ejemplo de notificacion")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1, builder.build());
    }
}
