package hr.tvz.android.fragmentifilip.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import hr.tvz.android.fragmentifilip.AdapterRecyclerView;
import hr.tvz.android.fragmentifilip.Car;
import hr.tvz.android.fragmentifilip.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Car[] Cars = new Car[5];

        Cars[0] = new Car("Mitsubishi Lancer", "mitsubishi", "https://duckduckgo.com/?q=mitsubishi+lancer&t=ffab&iar=images&iax=images&ia=images");
        Cars[1] = new Car("Dodge Durango", "durango", "https://duckduckgo.com/?q=dodge+durango&t=ffab&iar=images&iax=images&ia=images");
        Cars[2] = new Car("Mercedes Benz C280", "merc", "https://duckduckgo.com/?q=mercedes+benz+c280&t=ffab&iar=images&iax=images&ia=images");
        Cars[3] = new Car("Dodge Charger", "charger", "https://duckduckgo.com/?q=dodge+charger&t=ffab&iar=images&iax=images&ia=images");
        Cars[4] = new Car("Toyota Prius",  "prius", "https://duckduckgo.com/?q=toyota+prius&t=ffab&iar=images&iax=images&ia=images");

        RecyclerView.Adapter adapter = new AdapterRecyclerView(Cars);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}