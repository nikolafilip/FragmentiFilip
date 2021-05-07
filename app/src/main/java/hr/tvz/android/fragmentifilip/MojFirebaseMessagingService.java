package hr.tvz.android.fragmentifilip;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MojFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = " FCM Service";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        //Ovdje je potrebno hendlati poruke
        //Poslati broadcast, podignuti aktivnost, startati servis ili sl
        Intent intent = new Intent(getApplicationContext(), ShowMessage.class);
        intent.putExtra("poruka", remoteMessage);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "To: " + remoteMessage.getTo());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refresh token: " + token);
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        // Ovdje je potrebno poslati token na vlastiti server kako bi se točno znalo kamo poruka mora doći
    }
}