package com.example.bunnygene.services.helpers;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

import com.example.bunnygene.web.MainActivity;

public class Notif {

    public static NotificationManagerCompat notifManagerCompat;
    public static Context context;
    public static int notifIdx = 1;



    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void showNotif(Context context, String title, String text, String key)
    {

        Notif.context = context;
        notifManagerCompat = NotificationManagerCompat.from(context);

        Intent notificationIntent = new Intent(context, MainActivity.class);
        notificationIntent.putExtra("NotificationMessage", key);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(context);
        taskStackBuilder.addNextIntentWithParentStack(notificationIntent);
        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationChannel channel = new NotificationChannel(key, key, NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = Notif.context.getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        Notification notification;
        NotificationCompat.Builder builder = new NotificationCompat.Builder( context, key)
                .setSmallIcon(android.R.drawable.stat_notify_sync)
                .setContentTitle( title)
                .setContentText(text)
                .setContentIntent(pendingIntent);


        notification = builder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        notifManagerCompat.notify(notifIdx++,notification);
    }

}
