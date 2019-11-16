package com.example.clubcerveceromona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.clubcerveceromona.view.ContainerActivity;
import com.example.clubcerveceromona.view.CreateAccountActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private TextInputEditText textInputCorreo;
    private TextInputEditText textInputContrasenia;
    private Button botonlogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textInputCorreo=findViewById(R.id.textInputLogCorreo);
        textInputContrasenia=findViewById(R.id.textInputLogContrasenia);

        botonlogin=findViewById(R.id.botonIniciar);
        botonlogin.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


    }

    public void onCrearCuenta(View view){
//      instanciar una actividad
        Intent intent= new Intent(LoginActivity.this, CreateAccountActivity.class);
        startActivity(intent);

    }

    //para ver si ya esta logueado
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
        if (currentUser!=null) {
            Toast.makeText(LoginActivity.this, "Bienvenido " + currentUser.getDisplayName(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {

        if (textInputCorreo.getText().toString().isEmpty() || textInputContrasenia.getText().toString().isEmpty()){
            Toast.makeText(LoginActivity.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();
        }
        else{
            mAuth.signInWithEmailAndPassword(textInputCorreo.getText().toString(), textInputContrasenia.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(LoginActivity.this,"Bienvenido "+user.getDisplayName(),Toast.LENGTH_LONG).show();
                                Intent intent= new Intent(LoginActivity.this, ContainerActivity.class);
                                startActivity(intent);

                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }

                            // ...
                        }
                    });

        }




    }
}
