package hr.tvz.android.fragmentifilip;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    private Car[] mDataset;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public AdapterRecyclerView(Car[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view, parent, false);

        return new ViewHolder((TextView)v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position].name);
        holder.mTextView.setOnClickListener(v -> {
            Intent myIntent = new Intent(v.getContext(), DetailsActivity.class);
            myIntent.putExtra("object", mDataset[position]);
            v.getContext().startActivity(myIntent);
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
