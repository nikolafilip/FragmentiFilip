package hr.tvz.android.fragmentifilip;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Car car = getActivity().getIntent().getExtras().getParcelable("object");

        TextView name = rootView.findViewById(R.id.name);
        name.setText(car.name);

        int res = getResources().getIdentifier(car.image, "drawable", getActivity().getPackageName());
        ImageView image = rootView.findViewById(R.id.image);
        image.setImageResource(res);
        image.setOnClickListener(v -> {
            Intent myIntent = new Intent(v.getContext(), ImageActivity.class);
            myIntent.putExtra("object", car);
            v.getContext().startActivity(myIntent);
        });

        final Button btn = rootView.findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(car.url));
            startActivity(browserIntent);
        });

        final Button share = rootView.findViewById(R.id.share);
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
        return rootView;
    }
}