package com.example.clubcerveceromona.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clubcerveceromona.R;
import com.squareup.picasso.Picasso;


public class ImagenDetalleActivity extends AppCompatActivity {

    private ImageView imagen;
    private Toolbar toolbar;
    private TextView nombre;
    private TextView cantlikes;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_detalle);

        //System.out.println ("El precio es de " + cerveceria);

        String imagenTexto = getIntent().getStringExtra("imagen");
        String nombreTexto = getIntent().getStringExtra("nombrecervecero");
        String cantlikesTexto = getIntent().getStringExtra("cantlikes");



        imagen = findViewById(R.id.imagenGrande);
        toolbar = findViewById(R.id.toolbarDetalle);
        nombre = findViewById(R.id.nombreCerveceriaDetalle);
        cantlikes = findViewById(R.id.cantlikes);


        Picasso.with(this).load(imagenTexto).error(R.drawable.ic_error_outine).into(imagen);
        toolbar.setTitle(nombreTexto.toUpperCase());
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        nombre.setText("Cervecería "+nombreTexto);
        cantlikes.setText(cantlikesTexto+" ");



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }





}
