package com.example.esraacofee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout sahm;

    ImageView shopping,shopping11 , book , favorit ,account11,account22,
            account, home,home1,book11,book22,favorit11,favorit22;

    @SuppressLint({"MissingInflatedId", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        getSupportFragmentManager().beginTransaction().replace(R.id.startactivity , new SahmFragment()).commit();



        sahm = findViewById(R.id.sahm);
        shopping = findViewById(R.id.shooping);
        book = findViewById(R.id.book);
        favorit = findViewById(R.id.favorit);
        account = findViewById(R.id.account);
        shopping11 = findViewById(R.id.shooping11);
        home = findViewById(R.id.homeee);
        home1 = findViewById(R.id.home1);
        book11 = findViewById(R.id.book11);
        book22 = findViewById(R.id.book22);
        favorit11 = findViewById(R.id.favorit11);
        favorit22 = findViewById(R.id.favorit22);
        account11 = findViewById(R.id.accunt11);
        account22 = findViewById(R.id.account22);

//
//        if (shopping11.isVisibleToUserForAutofill(R.id.book22)){
//            book22.setVisibility(View.GONE);
//            favorit22.setVisibility(View.GONE);
//            account22.setVisibility(View.GONE);
//        }
//        if (shopping11.isActivated()){
//            book22.setVisibility(View.GONE);
//            favorit22.setVisibility(View.GONE);
//            account22.setVisibility(View.GONE);
//        }

        account22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SahmFragment());

                account.setVisibility(View.VISIBLE);
                account22.setVisibility(View.GONE);
                home.setVisibility(View.VISIBLE);
                account11.setVisibility(View.GONE);

            }
        });

        favorit22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SahmFragment());

                favorit.setVisibility(View.VISIBLE);
                favorit22.setVisibility(View.GONE);
                home.setVisibility(View.VISIBLE);
                favorit11.setVisibility(View.GONE);

            }
        });

        book22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SahmFragment());

                book.setVisibility(View.VISIBLE);
                book22.setVisibility(View.GONE);
                home.setVisibility(View.VISIBLE);
                book11.setVisibility(View.GONE);

            }
        });

        shopping11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SahmFragment());
                home.setVisibility(View.VISIBLE);
                home1.setVisibility(View.GONE);
                shopping.setVisibility(View.VISIBLE);
                shopping11.setVisibility(View.GONE);

                book22.setVisibility(View.GONE);
            favorit22.setVisibility(View.GONE);
            account22.setVisibility(View.GONE);

            }
        });
        ////////////////////////////////////////////////////

//        sahm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (home.isPressed()){
//
//
//                    replaceFragment(new SahmFragment());
//
////                    home.setVisibility(View.GONE);
////                    home1.setVisibility(View.VISIBLE);
////                    shopping.setVisibility(View.GONE);
////                    shopping11.setVisibility(View.VISIBLE);
//
//
//
//                }
//            }
//        });

        ////////////////////////////////////////

        if (shopping.isVisibleToUserForAutofill(R.id.shooping)){
            shopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//
                    replaceFragment(new ShoppingFragment());

                    if (shopping.isPressed()){
                        shopping.setVisibility(View.GONE);
                        shopping11.setVisibility(View.VISIBLE);
                        home.setVisibility(View.GONE);
                        home1.setVisibility(View.VISIBLE);


                        book22.setVisibility(View.GONE);
                        favorit22.setVisibility(View.GONE);
                        account22.setVisibility(View.GONE);


                        book.setVisibility(View.VISIBLE);
                        book11.setVisibility(View.GONE);
                        favorit.setVisibility(View.VISIBLE);
                        favorit11.setVisibility(View.GONE);
                        account.setVisibility(View.VISIBLE);
                        account11.setVisibility(View.GONE);



//                        favorit11.setVisibility(View.GONE);
//                        account11.setVisibility(View.GONE);

                    }

                }
            });


        }


        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new BookFragment());
                book.setVisibility(View.GONE);
                book22.setVisibility(View.VISIBLE);
                home.setVisibility(View.GONE);
                book11.setVisibility(View.VISIBLE);

                shopping11.setVisibility(View.GONE);
                favorit22.setVisibility(View.GONE);
                account22.setVisibility(View.GONE);

                home1.setVisibility(View.GONE);
                shopping.setVisibility(View.VISIBLE);
                favorit.setVisibility(View.VISIBLE);
                favorit11.setVisibility(View.GONE);
                account.setVisibility(View.VISIBLE);
                account11.setVisibility(View.GONE);



            }
        });
//
        favorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FavoritFragment());
                favorit.setVisibility(View.GONE);
                favorit22.setVisibility(View.VISIBLE);
                home.setVisibility(View.GONE);
                favorit11.setVisibility(View.VISIBLE);

                shopping11.setVisibility(View.GONE);
                book22.setVisibility(View.GONE);
                account22.setVisibility(View.GONE);

                shopping.setVisibility(View.VISIBLE);
                home1.setVisibility(View.GONE);
                book.setVisibility(View.VISIBLE);
                book11.setVisibility(View.GONE);
                account.setVisibility(View.VISIBLE);
                account11.setVisibility(View.GONE);


            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AccountFragment());
                account.setVisibility(View.GONE);
                account22.setVisibility(View.VISIBLE);
                home.setVisibility(View.GONE);
                account11.setVisibility(View.VISIBLE);

                shopping11.setVisibility(View.GONE);
                book22.setVisibility(View.GONE);
                favorit22.setVisibility(View.GONE);

                shopping.setVisibility(View.VISIBLE);
                home1.setVisibility(View.GONE);
                favorit.setVisibility(View.VISIBLE);
                favorit11.setVisibility(View.GONE);
                book.setVisibility(View.VISIBLE);
                book11.setVisibility(View.GONE);

            }
        });




    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.startactivity,fragment);
        fragmentTransaction.commit();

    }
}