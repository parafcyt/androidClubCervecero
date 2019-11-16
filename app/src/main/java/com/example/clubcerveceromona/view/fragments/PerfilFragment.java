package com.example.clubcerveceromona.view.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.clubcerveceromona.LoginActivity;
import com.example.clubcerveceromona.R;
import com.example.clubcerveceromona.adapter.ImagenAdapterRecyclerView;
import com.example.clubcerveceromona.model.DatosxImagen;
import com.example.clubcerveceromona.view.ContainerActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements View.OnClickListener {

    CircleImageView circle;
    Toolbar toolbar;
    ImageView cerrarSesion;

    private FirebaseAuth mAuth;



    public PerfilFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        circle = v.findViewById(R.id.fotoPerfilCirculo);
        toolbar = v.findViewById(R.id.toolbarraPerfil);
        cerrarSesion = v.findViewById(R.id.cerrarSesion);

        mAuth = FirebaseAuth.getInstance();

        cerrarSesion.setOnClickListener(this);

        RecyclerView  perfilRecycler = v.findViewById(R.id.fotoPerfilRecycled);

        ImagenAdapterRecyclerView imagenAdapterRecyclerView= new ImagenAdapterRecyclerView(cargarTarjetas(), R.layout.cardview_foto, getActivity());

        perfilRecycler.setAdapter(imagenAdapterRecyclerView);

        //usamos LinearLayoutManager y le pasamos el adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        perfilRecycler.setLayoutManager(linearLayoutManager);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            toolbar.setTitle(name);
            Uri photoUrl = user.getPhotoUrl();
            Picasso.with(v.getContext()).load(photoUrl)
                    .placeholder(R.drawable.ic_perfil).error(R.drawable.ic_perfil).into(circle);

        }



        return v;
    }

    public ArrayList<DatosxImagen> cargarTarjetas(){

        ArrayList<DatosxImagen> datos = new ArrayList<>();

        datos.add(new DatosxImagen("http://www.taller.com.ar/img/about/about-ElTaller-Cerveceria.jpg","LAGASH","Hace 7 hs",
                "Happy Hour 21 a 24","10 me gusta"));

        datos.add(new DatosxImagen("https://cerveceriaburtonot.com/wp-content/uploads/2018/08/cerveceria-burton-ot-3.jpg","7 Colinas","Hace 7 hs",
                "Happy Hour 21 a 24","10 me gusta"));

        datos.add(new DatosxImagen("https://laderasur.com/content/uploads/2018/07/f376447d-01e3-4f57-8cab-068656e3ca2b.jpg","LAGASH","Hace 4 hs",
                "Happy Hour 21 a 24","10 me gusta"));

        datos.add(new DatosxImagen("https://http2.mlstatic.com/cerveceria-fondo-de-comercio-D_NQ_NP_844948-MLA30720764448_052019-F.jpg","LAGASH","Hace 1 hs",
                "Happy Hour 21 a 24","1 me gusta"));

        datos.add(new DatosxImagen("https://cerveceriaburtonot.com/wp-content/uploads/2018/08/cerveceria-burton-ot-3.jpg","LAGASH","Hace 3 hs",
                "Happy Hour 21 a 24","21 me gusta"));

        datos.add(new DatosxImagen("https://http2.mlstatic.com/cerveceria-fondo-de-comercio-D_NQ_NP_844948-MLA30720764448_052019-F.jpg","LAGASH","Hace 7 hs",
                "Happy Hour 21 a 24","1 me gusta"));

        return datos;


    }

    @Override
    public void onClick(View view) {
        mAuth.signOut();
        Toast.makeText(PerfilFragment.super.getContext(),"Sesión finalizada",Toast.LENGTH_LONG).show();
        Intent intent= new Intent(PerfilFragment.super.getContext(), LoginActivity.class);
        startActivity(intent);

    }
}
