package hr.tvz.android.fragmentifilip;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.raizlabs.android.dbflow.config.FlowManager;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import hr.tvz.android.fragmentifilip.model.Cars;

public class DrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Dohvat registracijskog tokena uređaja za Firebase
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("Main activity", "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult();

                        Log.d("Main activity", token);
                        Toast.makeText(DrawerActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });
        // this.napuniBazu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void napuniBazu() {
        Cars a = new Cars();
        a.setName("Mitsubishi Lancer");
        a.setImage("mitsubishi");
        a.setUrl("https://duckduckgo.com/?q=mitsubishi+lancer&t=ffab&iar=images&iax=images&ia=images");
        FlowManager.getModelAdapter(Cars.class).save(a);

        a.setName("Dodge Durango");
        a.setImage("durango");
        a.setUrl("https://duckduckgo.com/?q=dodge+durango&t=ffab&iar=images&iax=images&ia=images");
        FlowManager.getModelAdapter(Cars.class).save(a);

        a.setName("Mercedes Benz C280");
        a.setImage("merc");
        a.setUrl("https://duckduckgo.com/?q=mercedes+benz+c280&t=ffab&iar=images&iax=images&ia=images");
        FlowManager.getModelAdapter(Cars.class).save(a);

        a.setName("Dodge Charger");
        a.setImage("charger");
        a.setUrl("https://duckduckgo.com/?q=dodge+charger&t=ffab&iar=images&iax=images&ia=images");
        FlowManager.getModelAdapter(Cars.class).save(a);

        a.setName("Toyota Prius");
        a.setImage("prius");
        a.setUrl("https://duckduckgo.com/?q=toyota+prius&t=ffab&iar=images&iax=images&ia=images");
        FlowManager.getModelAdapter(Cars.class).save(a);

    }
}