package com.example.restauant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class pageMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_menu);
        setTitle(" Menu ");

        Button commande=findViewById(R.id.button);
        ListView lv = findViewById(R.id.listMenu);
        Spinner spinner = findViewById(R.id.spinner2);
        String item =spinner.getSelectedItem().toString();
        ArrayList<Object> liste= new ArrayList<>();


        if(item.equals("Dessert  ")){
            String[] titre ={"pancake" ,"Waffle","cheese cake","Strawberry cake"};
            int[] Pictures = {R.drawable.pancake,R.drawable.waffle,R.drawable.cheese,R.drawable.stawberry};
            String[] prix = {"9","8","10","11"};
            MenuAdapter cl = new MenuAdapter(this,titre,prix,Pictures);
            lv.setAdapter(cl);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object itemlist1 = parent.getItemAtPosition(position);
                    liste.add(itemlist1);
                }
            });
        }
        if(item.equals("Boire")){
            String[] titre ={"Express" ,"Cappuccino","caffe au lait","the ammonde"};
            int[] Pictures = {R.drawable.espres,R.drawable.cappucino,R.drawable.lait,R.drawable.the};
            String[] prix = {"3","3","4","5"};
            MenuAdapter cl = new MenuAdapter(pageMenu.this,titre,prix,Pictures);
            lv.setAdapter(cl);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object itemlist2 = parent.getItemAtPosition(position);
                    liste.add(itemlist2);
                }
            });
        }
        if(item.equals("Jus")){
            String[] titre ={"citronnade" ,"jus d'orange","lait de poule"};
            int[] Pictures = {R.drawable.citro,R.drawable.orange,R.drawable.poule};
            String[] prix = {"5","5","5"};
            MenuAdapter cl = new MenuAdapter(pageMenu.this,titre,prix,Pictures);
            lv.setAdapter(cl);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object itemlist3 = parent.getItemAtPosition(position);
                    liste.add(itemlist3);
                }
            });
        }
        if(item.equals("Food")){
            String[] titre ={"Pizza" ,"Sandwich","Burgger","Tacos"};
            int[] Pictures = {R.drawable.pizza,R.drawable.sandwich,R.drawable.burgger,R.drawable.tacos};
            String[] prix = {"15","8","10","8ex"};
            MenuAdapter cl = new MenuAdapter(pageMenu.this,titre,prix,Pictures);
            lv.setAdapter(cl);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object itemlist4 = parent.getItemAtPosition(position);
                    liste.add(itemlist4);
                }
            });
        }
        commande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(pageMenu.this, commander.class);
                inte.putExtra("liste",liste);
                startActivity(inte);
            }
        });

    }
}