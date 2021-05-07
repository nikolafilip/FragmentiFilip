package hr.tvz.android.fragmentifilip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Receiver receiver = new Receiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager;

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver, filter);

        Car[] Cars = new Car[5];

        Cars[0] = new Car("Mitsubishi Lancer", "mitsubishi", "https://duckduckgo.com/?q=mitsubishi+lancer&t=ffab&iar=images&iax=images&ia=images");
        Cars[1] = new Car("Dodge Durango", "durango", "https://duckduckgo.com/?q=dodge+durango&t=ffab&iar=images&iax=images&ia=images");
        Cars[2] = new Car("Mercedes Benz C280", "merc", "https://duckduckgo.com/?q=mercedes+benz+c280&t=ffab&iar=images&iax=images&ia=images");
        Cars[3] = new Car("Dodge Charger", "charger", "https://duckduckgo.com/?q=dodge+charger&t=ffab&iar=images&iax=images&ia=images");
        Cars[4] = new Car("Toyota Prius",  "prius", "https://duckduckgo.com/?q=toyota+prius&t=ffab&iar=images&iax=images&ia=images");

        adapter = new AdapterRecyclerView(Cars);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}