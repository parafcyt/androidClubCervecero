package com.example.clubcerveceromona.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.clubcerveceromona.R;


public class CreateAccountActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mostrarToolbar(getResources().getString(R.string.toolbar_crearcuenta));

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
}
