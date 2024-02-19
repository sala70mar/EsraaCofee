package com.example.esraacofee;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esraacofee.Adapter.CartAdapter;
import com.example.esraacofee.Adapter.Drink_Adapter;
import com.example.esraacofee.Domen.DomenDrink;
import com.example.esraacofee.Helper.ManagementCart;
import com.example.esraacofee.interFace.ChangeNumberItemListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ShoppingFragment extends Fragment {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    TextView totalFeeTax , deliveryTxt,taxTxt,totalTxt  , checkOut;
    private long tax;
    private ScrollView scrollView;
    LinearLayout emptyTax;

    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shopping, container, false);


        managementCart = new ManagementCart(getContext());

        initView();
        initList();
        CalculateCart();
        bottomNavigation();


        return view;
    }


    private void bottomNavigation(){

        TextView checkOut =view. findViewById(R.id.chec);

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


    }
    private void initView() {
        recyclerViewList =view. findViewById(R.id.recyclV);
        totalFeeTax =view. findViewById(R.id.totalFeeTxt);
        deliveryTxt =view. findViewById(R.id.deliveryTxt);
        taxTxt =view. findViewById(R.id.TaxTxt);
        totalTxt =view. findViewById(R.id.totalTxt);
        emptyTax = view.findViewById(R.id.emptyTax);
        scrollView = view.findViewById(R.id.scrollView3);
        recyclerViewList = view.findViewById(R.id.recyclerviewCart);

    }

    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter =new CartAdapter(managementCart.getListCart(), getContext(), new ChangeNumberItemListener() {
            @Override
            public void changed() {
                CalculateCart();

            }
        });
        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()){
            emptyTax.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else {
            emptyTax.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }
    private void CalculateCart(){
        double percentTax = 0.01;
        double delivery  =10;


        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100)/100;
        double total = Math.round((managementCart.getTotalFee()+tax +delivery) * 100)/100;
        double itemTotal  =Math.round(managementCart.getTotalFee()*100)/100;

        totalFeeTax.setText("EGP "+itemTotal);

        taxTxt.setText("EGP "+tax);
        deliveryTxt.setText("EGP "+delivery);
        totalTxt.setText("EGP "+total);
    }

}