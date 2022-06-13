package com.sunny.retrofitapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunny.retrofitapi.R;
import com.sunny.retrofitapi.databinding.ActivityBodyApiBinding;
import com.sunny.retrofitapi.databinding.BodyLayoutBinding;
import com.sunny.retrofitapi.model.BodyModel;

import java.util.List;

public class BodyAdapter extends RecyclerView.Adapter<BodyAdapter.Viewholder> {

    Context context;
    List<BodyModel> list;

    public BodyAdapter(Context context, List<BodyModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.body_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.binding.userId.setText(list.get(position).getUserId().toString());
        holder.binding.geId.setText(list.get(position).getId().toString());
        holder.binding.title.setText(list.get(position).getTitle());
        holder.binding.body.setText(list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        BodyLayoutBinding binding;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            binding = BodyLayoutBinding.bind(itemView);
        }
    }
}
