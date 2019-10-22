package com.example.clubcerveceromona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.clubcerveceromona.view.ContainerActivity;
import com.example.clubcerveceromona.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        botonlogin=findViewById(R.id.button);
        botonlogin.setOnClickListener(this);
    }

    public void onCrearCuenta(View view){
//      instanciar una actividad
        Intent intent= new Intent(LoginActivity.this, CreateAccountActivity.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(this, "Logueado", Toast.LENGTH_SHORT).show();
        Toast.makeText(this,getResources().getString(R.string.toastMensajeLogon ),Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(LoginActivity.this, ContainerActivity.class);
        startActivity(intent);
    }
}
