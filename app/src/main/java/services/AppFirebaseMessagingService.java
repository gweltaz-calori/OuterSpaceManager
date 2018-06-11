package services;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.gcalori.outerspacemanager.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

public class AppFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("onMessageReceived", "onMessageReceived: "+remoteMessage);
        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            showNotification(remoteMessage.getNotification().getBody());
        }

    }

    private void showNotification(String body) {
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, "notifs")
                        .setSmallIcon(R.drawable.ic_attack)
                        .setContentTitle("FCM Message")
                        .setContentText(body);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 , notificationBuilder.build());

    }
}
