package com.example.esraacofee.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.example.esraacofee.Helper.ManagementCart;
import com.example.esraacofee.MainActivity3;
import com.example.esraacofee.R;
import com.example.esraacofee.interFace.ChangeNumberItemListener;
import com.example.esraacofee.interFace.ChangeRmoveFavorite;

import java.util.ArrayList;


public class Favorite_Adapter extends RecyclerView.Adapter<Favorite_Adapter.ViewHolder> {
    private ArrayList<DomenDrink> foodDomains;
    private ManagementCart managementCart;
    private ChangeNumberItemListener changeNumberItemListener;
    private ChangeRmoveFavorite changeRmoveFavorite;

    public Favorite_Adapter(ArrayList<DomenDrink> foodDomains, Context context , ChangeRmoveFavorite changeRmoveFavorite) {
        this.foodDomains = foodDomains;
        this.managementCart = new ManagementCart(context);
        this.changeRmoveFavorite = changeRmoveFavorite;
    }

    @Override
    public Favorite_Adapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Favorite_Adapter. ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.addFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity3.class);
                intent.putExtra("object", foodDomains.get(position));
                holder.itemView.getContext().startActivity(intent);            }
        });

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.removeItem(foodDomains, position, new ChangeRmoveFavorite() {


                    @Override
                    public void removeFavorite() {
                        notifyDataSetChanged();
                        changeRmoveFavorite.removeFavorite();
                    }
                }); {

                }

                }
        });

        holder.titleTaxFav.setText(foodDomains.get(position).getTitle());
        holder.extraFav.setText(String.valueOf(foodDomains.get(position).getExtra()));
        holder.totalFav.setText(String.valueOf(Math.round((foodDomains.get(position).getNumberInCard() * foodDomains.get(position).getFee()) * 100) / 100));
//        holder.nun.setText(String.valueOf(foodDomains.get(position).getNumberInCard()));

        int drawableReourceId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic()
                ,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.picCartFav);

    }

    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTaxFav , extraFav;
        ImageView picCartFav , plusItem, remove;
        TextView totalFav , nun;
        LinearLayout addFavorite;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTaxFav = itemView.findViewById(R.id.titleTaxFav);
            picCartFav = itemView.findViewById(R.id.picCartFav);
            extraFav = itemView.findViewById(R.id.extraFav);
            totalFav = itemView.findViewById(R.id.totalFav);
            remove = itemView.findViewById(R.id.remove);
            addFavorite = itemView.findViewById(R.id.addFavorite);




        }
    }
}
