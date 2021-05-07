package hr.tvz.android.fragmentifilip;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.messaging.RemoteMessage;

public class ShowMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        RemoteMessage remoteMessage = getIntent().getExtras().getParcelable("poruka");
        ((TextView)findViewById(R.id.tvOd)).setText(remoteMessage.getFrom());
        ((TextView)findViewById(R.id.tvPoruka)).setText(remoteMessage.getNotification().getBody());
    }
}