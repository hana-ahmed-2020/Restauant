
package com.example.restauant;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Restaurant");
        String tag="MainActivity";

        EditText nom =findViewById(R.id.nomClient);
        EditText motPasse =findViewById(R.id.password);
        Button connecter = findViewById(R.id.connecterBtn);
        Button creer =findViewById(R.id.createBtn);

        connecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((nom.length() <= 0) && (motPasse.length() <= 0)) {
                    Toast.makeText(getApplicationContext(), " Entre vos coordonnes ", Toast.LENGTH_LONG).show();
                    return;
                } else if ((nom.length() <= 0)) {
                    Toast.makeText(getApplicationContext(), " votre nom", Toast.LENGTH_LONG).show();
                    return;
                } else if ((motPasse.length() <= 0)) {
                    Toast.makeText(getApplicationContext(), " votre mot de passe", Toast.LENGTH_LONG).show();
                    return;
                }
                String Nom = nom.getText().toString();
                String MotPasse = motPasse.getText().toString();
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Client");
                query.whereEqualTo("Nom",Nom) ;
                query.whereEqualTo("Mot Passe",MotPasse);
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e==null){
                            Log.d(tag," le client est trouvee");
                            Intent i =new Intent(MainActivity.this,pageMenu.class);
                            startActivity(i);
                        }
                        else {
                            Log.d(tag," le client n'est pas trouvee");
                            showAlert("Erreur", "s'il vous plait faite votre enregistrement");
                        }
                    }
                });
            }});

        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity (new Intent(MainActivity.this,enregistrement.class));
            }
        });

    }
    void showAlert(String titreAlerte, String messageAlerte){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle(titreAlerte);
        alertDialogBuilder
                .setMessage(messageAlerte)
                .setCancelable(false)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}



