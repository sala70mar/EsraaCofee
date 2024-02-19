package com.example.esraacofee.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.esraacofee.Domen.DomenDrink;
import com.example.esraacofee.MainActivity3;
import com.example.esraacofee.R;


import java.util.ArrayList;


public class Drink_Adapter extends RecyclerView.Adapter<Drink_Adapter.ViewHolder> {
    ArrayList<DomenDrink> nearDomainsL;

    public Drink_Adapter(ArrayList<DomenDrink> categoryDomains) {
        this.nearDomainsL = categoryDomains;
    }

    @NonNull
    @Override
    public Drink_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_item,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Drink_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(nearDomainsL.get(position).getTitle());

        holder.fee.setText(String.valueOf( nearDomainsL.get(position).getFee()));
        holder.extra.setText(String.valueOf( nearDomainsL.get(position).getExtra()));





        int drawableResource=holder.itemView.getContext().getResources().getIdentifier(nearDomainsL.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
//
        Glide.with(holder.itemView.getContext())
                .load(drawableResource)
                .into(holder.pic);

        holder.linearLayoutGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity3.class);
                intent.putExtra("object", nearDomainsL.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return nearDomainsL.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, fee,extra;
        ImageView pic;

        LinearLayout linearLayoutGo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            extra = itemView.findViewById(R.id.extra);
            linearLayoutGo = itemView.findViewById(R.id.linearGo);

        }
    }

}
