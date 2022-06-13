package com.sunny.retrofitapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunny.retrofitapi.R;
import com.sunny.retrofitapi.databinding.ImageLayoutBinding;
import com.sunny.retrofitapi.model.ImageModel;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.Viewholder> {
    Context context;
    List<ImageModel> list;

    public ImageAdapter(Context context, List<ImageModel> list){
        this.context = context;
        this.list = list;

    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.binding.uId.setText(list.get(position).getId().toString());
        holder.binding.uName.setText(list.get(position).getUsername());
        holder.binding.name.setText(list.get(position).getName());
        holder.binding.mail.setText(list.get(position).getEmail());
        holder.binding.street.setText(list.get(position).getAddress().getStreet());
        holder.binding.suit.setText(list.get(position).getAddress().getSuite());
        holder.binding.city.setText(list.get(position).getAddress().getCity());
        holder.binding.zipcode.setText(list.get(position).getAddress().getZipcode());
        holder.binding.lat.setText(list.get(position).getAddress().getGeo().getLat());
        holder.binding.log.setText(list.get(position).getAddress().getGeo().getLng());
        holder.binding.phone.setText(list.get(position).getPhone());
        holder.binding.website.setText(list.get(position).website);
        holder.binding.cName.setText(list.get(position).getCompany().name);
        holder.binding.catchphrase.setText(list.get(position).getCompany().catchPhrase);
        holder.binding.bs.setText(list.get(position).getCompany().bs);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageLayoutBinding binding;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            binding = ImageLayoutBinding.bind(itemView);
        }
    }
}
