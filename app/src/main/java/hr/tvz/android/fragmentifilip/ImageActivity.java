package hr.tvz.android.fragmentifilip;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.dropup);

        Car phone = getIntent().getExtras().getParcelable("object");

        int res = getResources().getIdentifier(phone.image, "drawable", this.getPackageName());
        ImageView image = findViewById(R.id.image);
        image.startAnimation(animation);
        image.setImageResource(res);
    }
}