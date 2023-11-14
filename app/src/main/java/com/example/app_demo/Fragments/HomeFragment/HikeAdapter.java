package com.example.app_demo.Fragments.HomeFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_demo.Models.Hike;
import com.example.app_demo.R;

import java.util.List;

public class HikeAdapter extends RecyclerView.Adapter<HikeAdapter.ViewHolder> {
    List<Hike> hikes;
    Context context;

    IOnClickHike iOnClickHike;

    public IOnClickHike getiOnClickHike() {
        return iOnClickHike;
    }

    public void setiOnClickHike(IOnClickHike iOnClickHike) {
        this.iOnClickHike = iOnClickHike;
    }

    public void setHikes(List<Hike> hikes) {
        this.hikes = hikes;
        notifyDataSetChanged();
    }

    public HikeAdapter(List<Hike> hikes, Context context) {
        this.hikes = hikes;
        this.context = context;
    }

    @NonNull
    @Override
    public HikeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_hike, parent, false);
        HikeAdapter.ViewHolder viewHolder = new HikeAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HikeAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Hike hike = hikes.get(position);

        holder.tvName.setText(hike.getName());

        holder.tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickHike.iOnClickMore(hike, position);
            }
        });

        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickHike.iOnClickDelete(hike, position);
            }
        });

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickHike.iOnClickDetail(hike, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hikes == null ? 0 : hikes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvMore, tvDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvMore = itemView.findViewById(R.id.tvMore);
            tvDelete = itemView.findViewById(R.id.tvDelete);
        }
    }
}
