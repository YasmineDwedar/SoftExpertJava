package com.example.softexpertjava.adapator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.example.softexpertjava.R;
import com.example.softexpertjava.databinding.CarItemBinding;
import com.example.softexpertjava.model.Data;

import java.util.List;

public class CarAdaptor  extends RecyclerView.Adapter<CarAdaptor.ViewHolder>{
    Context context;
    List<Data>  arrName;

    public CarAdaptor(Context context, List<Data> arrName) {
        this.context = context;
        this.arrName = arrName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtName.setText(arrName.get(position).getBrand());
        if(arrName.get(position).getIsUsed().equals("true")){
            holder.txtName.setText("Used");
        }else{
            holder.txtName.setText("New");
        }

        Glide.with(context)
                .load(arrName.get(position).getImageUrl())
                .override(100, Target.SIZE_ORIGINAL) // resizes width to 100, preserves original height, does not respect aspect ratio
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return arrName.size();
    }




        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView txtID, txtName;
            ImageView img;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                txtID = itemView.findViewById(R.id.comp_job_title);
                txtName = itemView.findViewById(R.id.comp_name);
                img = itemView.findViewById(R.id.car_img);

            }
        }
}

