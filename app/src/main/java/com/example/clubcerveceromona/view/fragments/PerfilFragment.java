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

        datos.add(new DatosxImagen("https://cdn.forbes.com.mx/2018/08/Cerveza-artesanal-640x360.jpg",
                "Lagash", "Hace 8 horas", "50", "Calle Ruiz Moreno 657",
                "--","Martes a Domingo de 19:30 a 2 Hs","Gay Friendly",
                true,-32.477274, -58.248289,"Marxistas 25% OFF"));

        datos.add(new DatosxImagen("https://ecocuyo.com/wp-content/uploads/2019/04/TAIPEI1-108-696x406.jpg",
                "Träctor", "Hace 9 horas", "40", "Artusi 998",
                "03442 15-53-9608", "Miercoles a Sabado de 20:00 a 3 Hs", "Pet Friendly",
                true,-32.481204, -58.237988,"Chicas trans 20% OFF"));

        datos.add(new DatosxImagen("https://www.thebeertimes.com/wp-content/uploads/2018/06/Cerveza_artesanal.jpg",
                "7 Colinas", "Hace 4 minutos", "2", "Estrada 838",
                "03442 43-2811","Martes a Domingo de 19:30 a 2 Hs", "Gay Friendly",
                true, -32.479900,-58.235322,"Cerveza Negra 50% OFF"));

        datos.add(new DatosxImagen("https://images.clarin.com/2019/01/15/uH8yqnI9W_1256x620__1.jpg",
                "7 Colinas", "Hace 9 horas", "30", "Estrada 838",
                "03442 43-2811","Martes a Domingo de 19:30 a 2 Hs", "LGBT Friendly",
                true, -32.479900,-58.235322,"Sí se puede, 20% OFF"));

        datos.add(new DatosxImagen("https://www.cronista.com/__export/1536170691575/sites/diarioelcronista/img/2018/09/05/cerveza1.jpg_1866758231.jpg",
                "Drakkar", "Hace 5 horas", "20", "Artusi 755",
                "03442 43-7805","Jueves a Domingo de 20:00 a 2 Hs", "Pet Friendly",
                true,-32.480557, -58.233931,"Descuento Camioneros"));

        datos.add(new DatosxImagen("https://images.clarin.com/2019/01/15/entre-las-variedades-mas-buscadas___JBnsNc5S8_1200x0__1.jpg",
                "Biguá", "Hace 3 horas", "33", "Juan Domingo Perón 34",
                "--","Lunes a Domingo de 19:30 a 00:30 Hs.", "Gay Friendly",
                true, -32.485051, -58.231004,"Viva Perón 30% OFF"));

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
