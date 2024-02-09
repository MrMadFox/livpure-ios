package com.livpure.safedrink.servicefirebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.livpure.safedrink.R;
import com.livpure.safedrink.login.MainActivity;
import com.moengage.firebase.MoEFireBaseHelper;
import com.moengage.pushbase.MoEPushHelper;
/* loaded from: classes3.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        message.getData();
        if (MoEPushHelper.getInstance().isFromMoEngagePlatform(message.getData())) {
            MoEFireBaseHelper.Companion.getInstance().passPushPayload(getApplicationContext(), message.getData());
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.e("NEWTOKEN", "onNewToken: " + token);
        MoEFireBaseHelper.getInstance().passPushToken(getApplicationContext(), token);
    }

    private void showNotification(String message) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(67108864);
        ((NotificationManager) getSystemService("notification")).notify(0, new NotificationCompat.Builder(this).setAutoCancel(true).setContentTitle("test").setContentText(message).setSmallIcon(R.drawable.common_google_signin_btn_icon_dark).setContentIntent(PendingIntent.getActivities(this, 0, new Intent[]{intent}, 134217728)).build());
    }
}
