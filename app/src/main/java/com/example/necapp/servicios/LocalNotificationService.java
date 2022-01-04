package com.example.necapp.servicios;

import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.necapp.R;

public class LocalNotificationService {
    public void show(Context context, String text)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifications")
                .setSmallIcon(R.drawable.logo_icono)
                .setContentTitle("Gobierno de nuevo laredo")
                .setContentText(text)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1, builder.build());
    }
}
