package com.example.clubcerveceromona.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.Toast;
import android.widget.Toolbar;

import com.example.clubcerveceromona.LoginActivity;
import com.example.clubcerveceromona.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonIniciar;
    private TextInputEditText textInputCorreo;
    private TextInputEditText textInputContrasenia;
    private TextInputEditText textInputContraseniaConfirmar;
    private TextInputEditText textInputNombre;

    private FirebaseAuth mAuth;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mostrarToolbar(getResources().getString(R.string.toolbar_crearcuenta));

        mAuth = FirebaseAuth.getInstance();

        textInputCorreo=findViewById(R.id.textoInputCorreo);
        textInputContrasenia=findViewById(R.id.textoInputContrasenia);
        textInputContraseniaConfirmar=findViewById(R.id.textInputContraseniaConfirmar);
        textInputNombre=findViewById(R.id.textoInputNombre);
        botonIniciar=findViewById(R.id.botonCrearCuenta);


        botonIniciar.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void mostrarToolbar(String titulo){
        Toolbar toolbar = findViewById(R.id.toolbarra);
        toolbar.setTitle(titulo);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {

        if (textInputCorreo.getText().toString().isEmpty() || textInputContrasenia.getText().toString().isEmpty() ||
        textInputContraseniaConfirmar.getText().toString().isEmpty() || textInputNombre.getText().toString().isEmpty())

        {
            Toast.makeText(CreateAccountActivity.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();
        }
        else {
            if (!textInputContrasenia.getText().toString().equals(textInputContraseniaConfirmar.getText().toString())){

                Toast.makeText(CreateAccountActivity.this, "Las contraseñas deben ser iguales", Toast.LENGTH_LONG).show();

            }
            else{

                mAuth.createUserWithEmailAndPassword(textInputCorreo.getText().toString(), textInputContrasenia.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(textInputNombre.getText().toString())
                                            .setPhotoUri(Uri.parse("https://www.verywellfit.com/thmb/ftrX7zkpT9A0S1Kvc8egsq5lM_A=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/beer-1059087146-5be1ab9746e0fb005154e0dc.jpg"))
                                            .build();
                                    user.updateProfile(profileUpdates)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Intent intent = new Intent(CreateAccountActivity.this, ContainerActivity.class);
                                                        startActivity(intent);
                                                        //Log.d(TAG, "User profile updated.");
                                                    }

                                                }
                                            });

                                    //updateUI(user);
                                } else {
                                    Toast.makeText(CreateAccountActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                }
        }
    }
}
