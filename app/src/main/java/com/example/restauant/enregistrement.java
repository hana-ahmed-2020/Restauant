package com.example.restauant;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.ParseException;
import com.parse.ParseObject;

import com.parse.SaveCallback;


public class enregistrement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement);


        ParseObject Client = new ParseObject("Client");
        EditText nomClient =findViewById(R.id.nomClient1);
        EditText password =findViewById(R.id.password1);
        EditText mail =findViewById(R.id.mail);
        EditText numero =findViewById(R.id.num);
        Button connecter =findViewById(R.id.connecter);
        connecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((nomClient.length() <= 0) && (password.length() <= 0) && (mail.length() <= 0) && (numero.length() <= 0)) {
                    Toast.makeText(getApplicationContext(), " Entre vos coordonnes ", Toast.LENGTH_LONG).show();
                    return;
                } else if ((nomClient.length() <= 0)) {
                    Toast.makeText(getApplicationContext(), " votre nom", Toast.LENGTH_LONG).show();
                    return;
                } else if ((password.length() <= 0)) {
                    Toast.makeText(getApplicationContext(), " votre mot de passe", Toast.LENGTH_LONG).show();
                    return;
                } else if ((mail.length() <= 0)) {
                    Toast.makeText(getApplicationContext(), " votre address mail", Toast.LENGTH_LONG).show();
                    return;
                } else if ((numero.length() <= 0)) {
                    Toast.makeText(getApplicationContext(), " votre address numero portable", Toast.LENGTH_LONG).show();
                    return;
                }

                String Nom = nomClient.getText().toString();
                String motPasse = password.getText().toString();
                String Email = mail.getText().toString();
                int Numero = Integer.parseInt(numero.getText().toString());

                Client.put("nom",Nom);
                Client.put("mail",Email);
                Client.put("mot de passe ",motPasse);
                Client.put("Numero", Numero);
                Client.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            // Account creation successful
                            Toast.makeText(getApplicationContext(), "creer avec success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(enregistrement.this, pageMenu.class);
                            startActivity(intent);
                            finish();
                            // Close the create account activity
                        } else {
                            // Account creation failed, show an error message
                            Toast.makeText(enregistrement.this, "pas de creation de compte ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

              /* Client.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            // Account creation successful
                            Toast.makeText(enregistrement.this, "creer avec success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(enregistrement.this, pageMenu.class);
                            startActivity(intent);
                            finish(); // Close the create account activity
                        } else {
                            // Account creation failed, show an error message
                            Toast.makeText(enregistrement.this, "pas de creation de compte ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });*/
    }}