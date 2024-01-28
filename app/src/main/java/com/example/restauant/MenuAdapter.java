package com.example.restauant;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<String> {

    Activity act;
    String[] titre;
    String[] prix;
    int [] Pictures ;
    public MenuAdapter(Activity context ,String[] names,String[] prix,int[] pictures)
    { super(context ,R.layout.list_item,names);
        act=context ;
        titre=names;
        Pictures=pictures;
        this.prix=prix;
    }
    public View getView(int position, View convertView , ViewGroup parent)
    {
        LayoutInflater inflater=act.getLayoutInflater();
        View v= inflater.inflate(R.layout.list_item,parent,false);
        TextView tv =v.findViewById(R.id.titre);
        TextView pv =v.findViewById(R.id.prix);
        ImageView Iv =v.findViewById(R.id.imageView);
        tv.setText(titre[position]);
        pv.setText(prix[position]);
        Iv.setImageResource(Pictures[position]);
        return v;
    }
}