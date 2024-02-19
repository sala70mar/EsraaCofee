package com.example.esraacofee;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.esraacofee.Domen.DomenDrink;
import com.example.esraacofee.Helper.ManagementCart;

public class MainActivity3 extends AppCompatActivity {
    LinearLayout large,medium,small;
    private TextView titleTex, feeTxt , extraTxt , numberOrderTxt ,numberCard;
    private TextView addTOCartBtn;
    private ImageView plusBtn , minusBtn , picFood;
    private DomenDrink object;

    ImageView largeIcon,medeamIcon ,largeIconWite,medeamIconOrange,smallIcon,smallIconOrange;

    int numberOrder = 1;
    private ManagementCart managementCart;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        managementCart = new ManagementCart(this);

        initView();
        getBundle();

        large=findViewById(R.id.large);
        largeIcon=findViewById(R.id.largeIcon);
        largeIconWite=findViewById(R.id.largeIconWite);
        medeamIcon=findViewById(R.id.medeamIcon);
        medeamIconOrange=findViewById(R.id.medeamIconOrange);
        medium=findViewById(R.id.medeam);
        small=findViewById(R.id.small);
        smallIcon=findViewById(R.id.smallIcon);
        smallIconOrange=findViewById(R.id.smallIconOrange);

        large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (large.isPressed()){
                    large.setBackgroundDrawable(getResources().getDrawable(R.drawable.bagraonmedyam));
                    largeIcon.setVisibility(View.GONE);
                    largeIconWite.setVisibility(View.VISIBLE);

                    medium.setBackgroundDrawable(getResources().getDrawable(R.drawable.bacrwondscl));
                    medeamIcon.setVisibility(View.GONE);
                    medeamIconOrange.setVisibility(View.VISIBLE);

                    small.setBackgroundDrawable(getResources().getDrawable(R.drawable.bacrwondscl));
                    smallIcon.setVisibility(View.VISIBLE);
                    smallIconOrange.setVisibility(View.GONE);


                }

            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (medium.isPressed()){

                    large.setBackgroundDrawable(getResources().getDrawable(R.drawable.bacrwondscl));
                    largeIcon.setVisibility(View.VISIBLE);
                    largeIconWite.setVisibility(View.GONE);

                    medium.setBackgroundDrawable(getResources().getDrawable(R.drawable.bagraonmedyam));
                    medeamIcon.setVisibility(View.VISIBLE);
                    medeamIconOrange.setVisibility(View.GONE);

                    small.setBackgroundDrawable(getResources().getDrawable(R.drawable.bacrwondscl));
                    smallIcon.setVisibility(View.VISIBLE);
                    smallIconOrange.setVisibility(View.GONE);

                }
            }
        });

        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (small.isPressed()){
                    small.setBackgroundDrawable(getResources().getDrawable(R.drawable.bagraonmedyam));
                    smallIcon.setVisibility(View.GONE);
                    smallIconOrange.setVisibility(View.VISIBLE);

                    medium.setBackgroundDrawable(getResources().getDrawable(R.drawable.bacrwondscl));
                    medeamIcon.setVisibility(View.GONE);
                    medeamIconOrange.setVisibility(View.VISIBLE);

                    large.setBackgroundDrawable(getResources().getDrawable(R.drawable.bacrwondscl));
                    largeIcon.setVisibility(View.VISIBLE);
                    largeIconWite.setVisibility(View.GONE);


                }
            }
        });





    }

    private void getBundle() {
        object = (DomenDrink) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTex.setText(object.getTitle());
        feeTxt.setText("EGP "+object.getFee());
        extraTxt.setText(object.getExtra());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder>1){
                    numberOrder = numberOrder-1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addTOCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCard(numberOrder);
                managementCart.insertFood(object);




            }
        });

    }



    private void initView() {
        addTOCartBtn = findViewById(R.id.addTOCartBtn);
        titleTex = findViewById(R.id.titleTex);
        feeTxt = findViewById(R.id.feeTxt);
        extraTxt = findViewById(R.id.extraTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood  = findViewById(R.id.drinkPic);
    }

}