package com.example.esraacofee.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.esraacofee.Domen.DomenDrink;
import com.example.esraacofee.interFace.ChangeNumberItemListener;
import com.example.esraacofee.interFace.ChangeRmoveFavorite;

import java.util.ArrayList;


public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void  insertFood(DomenDrink item){
        ArrayList<DomenDrink> listFood = getListCart();
                boolean existAlready = false;
                int n = 0;
        for (int i = 0;i< listFood.size() ; i++) {
            if (listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = i;
                break;
            }

        }

        if (existAlready){
            listFood.get(n).setNumberInCard(item.getNumberInCard());
        }else {
            listFood.add(item);
        }

        tinyDB.putListObject("CartList",listFood);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();

    }
    public ArrayList<DomenDrink> getListCart(){

        return tinyDB.getListObject("CartList");
    }
    public void plusNumberFood(ArrayList<DomenDrink>listFood, int position, ChangeNumberItemListener changeNumberItemListener){
        listFood.get(position).setNumberInCard(listFood.get(position).getNumberInCard()+1);
        tinyDB.putListObject("CartList",listFood);
        changeNumberItemListener.changed();
    }

    public void removeItem(ArrayList<DomenDrink> listfood, int position, ChangeRmoveFavorite changeRmoveFavorite){
            listfood.remove(position);
        tinyDB.putListObject("CartList",listfood);
        changeRmoveFavorite.removeFavorite();
        }




    public void minusNumberFood(ArrayList<DomenDrink> listfood, int position, ChangeNumberItemListener changeNumberItemListener){
        if (listfood.get(position).getNumberInCard()==1){
            listfood.remove(position);
        }else {
            listfood.get(position).setNumberInCard(listfood.get(position).getNumberInCard()-1);
        }

        tinyDB.putListObject("CartList",listfood);
        changeNumberItemListener.changed();

    }

    public Double getTotalFee(){
        ArrayList<DomenDrink> listfood = getListCart();
        double fee=0;
        for (int i = 0; i < listfood.size(); i++) {
            fee = fee + (listfood.get(i).getFee()*listfood.get(i).getNumberInCard());

        }
        return fee;
    }
}
