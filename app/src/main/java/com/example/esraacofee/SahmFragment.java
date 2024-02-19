package com.example.esraacofee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.esraacofee.Adapter.Drink_Adapter;
import com.example.esraacofee.Domen.DomenDrink;

import java.util.ArrayList;


public class SahmFragment extends Fragment {
    RecyclerView hotDrink ;
    private RecyclerView.Adapter adapter;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_sahm, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        hotDrink = view .findViewById(R.id.recyclV);
        hotDrink.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        ArrayList<DomenDrink> foodList = new ArrayList<>();
        foodList.add(new DomenDrink("lateh","Latte","with bokery",132.00));
        foodList.add(new DomenDrink("amrecana","Americano","with whole milk",144.00));
        foodList.add(new DomenDrink("coffffff","Espresso","with milk",175.00));
        foodList.add(new DomenDrink("lateh","Latte","with bokery",132.00));
        foodList.add(new DomenDrink("amrecana","Americano","with whole milk",144.00));
        foodList.add(new DomenDrink("coffffff","Espresso","with milk",175.00));
        foodList.add(new DomenDrink("lateh","Latte","with bokery",132.00));
        foodList.add(new DomenDrink("amrecana","Americano","with whole milk",144.00));
        foodList.add(new DomenDrink("coffffff","Espresso","with milk",175.00));
        foodList.add(new DomenDrink("lateh","Latte","with bokery",132.00));
        foodList.add(new DomenDrink("amrecana","Americano","with whole milk",144.00));
        foodList.add(new DomenDrink("coffffff","Espresso","with milk",175.00));
        foodList.add(new DomenDrink("lateh","Latte","with bokery",132.00));
        foodList.add(new DomenDrink("amrecana","Americano","with whole milk",144.00));
        foodList.add(new DomenDrink("coffffff","Espresso","with milk",175.00));


        adapter= new Drink_Adapter(foodList);
        hotDrink.setAdapter(adapter);

        return view;
    }
}