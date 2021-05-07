package hr.tvz.android.fragmentifilip;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Car car = getIntent().getExtras().getParcelable("object");

        TextView name = findViewById(R.id.name);
        name.setText(car.name);

        int res = getResources().getIdentifier(car.image, "drawable", this.getPackageName());
        ImageView image = findViewById(R.id.image);
        image.setImageResource(res);
        image.setOnClickListener(v -> {
            Intent myIntent = new Intent(v.getContext(), ImageActivity.class);
            myIntent.putExtra("object", car);
            v.getContext().startActivity(myIntent);
        });

        final Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(car.url));
            startActivity(browserIntent);
        });

        final Button share = findViewById(R.id.share);
        share.setOnClickListener(v -> {

            new AlertDialog.Builder(v.getContext())
                    .setTitle(R.string.share)
                    .setMessage(R.string.share_text)
                    .setPositiveButton("Share", (dialog, which) -> {
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, car.url);
                        sendIntent.setType("text/plain");

                        Intent shareIntent = Intent.createChooser(sendIntent, null);
                        startActivity(shareIntent);
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });
    }
}