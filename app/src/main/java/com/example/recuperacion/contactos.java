package com.example.recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toast;
import android.widget.Toast;
public class contactos<editTextWeb> extends AppCompatActivity {
    EditText editTextWeb;
    Button contactos;
    Button bnt_Bus;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        editTextWeb = findViewById(R.id.Escribaurl);
        contactos = findViewById(R.id.abrircontactos);
        bnt_Bus = findViewById(R.id.btnbuscar);
        regresar = findViewById(R.id.regresa);

        Toastmensaje toastmensaje = new Toastmensaje();

        toastmensaje.mostrartoast(this);


        contactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContacts();
            }
        });

        bnt_Bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchUrl();
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar(v);
            }
        });

    }

    public void openContacts() {
        Intent IntenCont = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
        startActivity(IntenCont);
    }


    public void searchUrl() {
        String url = editTextWeb.getText().toString();
        if (url != null && !url.isEmpty()){
            Intent intentWeb = new Intent();
            intentWeb.setAction(Intent.ACTION_VIEW);
            intentWeb.setData(Uri.parse("http://"+url));
            startActivity(intentWeb);
        }
        else {
            Toast.makeText(contactos.this, "Ingrese una Url", Toast.LENGTH_SHORT).show();
        }

    }

    public void regresar(View view) {
        Intent intent2 = new Intent (this, MainActivity.class);
        startActivityForResult(intent2, 0);
    }



}
