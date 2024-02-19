package com.example.esraacofee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.esraacofee.Adapter.CartAdapter;
import com.example.esraacofee.Adapter.Favorite_Adapter;
import com.example.esraacofee.Helper.ManagementCart;
import com.example.esraacofee.interFace.ChangeNumberItemListener;
import com.example.esraacofee.interFace.ChangeRmoveFavorite;


public class FavoritFragment extends Fragment {
    View view;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewListFavorite;
    private ManagementCart managementCart;
    ScrollView scrollViewFav;
    LinearLayout emptyTaxFavo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favorit, container, false);

        recyclerViewListFavorite =view.findViewById(R.id.favorite_recyclerview);
        scrollViewFav =view.findViewById(R.id.scrollViewFav);
        emptyTaxFavo =view.findViewById(R.id.emptyTaxFavo);
        managementCart = new ManagementCart(getContext());


        initList();


        return view;
    }

    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewListFavorite.setLayoutManager(linearLayoutManager);
        adapter =new Favorite_Adapter(managementCart.getListCart(), getContext(), new ChangeRmoveFavorite() {

            @Override
            public void removeFavorite() {

            }
        });
        recyclerViewListFavorite.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()){
            emptyTaxFavo.setVisibility(View.VISIBLE);
            recyclerViewListFavorite.setVisibility(View.GONE);
        }else {
            emptyTaxFavo.setVisibility(View.GONE);
            recyclerViewListFavorite.setVisibility(View.VISIBLE);
        }
    }

}