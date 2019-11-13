package com.example.clubcerveceromona.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clubcerveceromona.R;
import com.example.clubcerveceromona.adapter.ImagenAdapterRecyclerView;
import com.example.clubcerveceromona.model.DatosxImagen;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        RecyclerView  perfilRecycler = v.findViewById(R.id.fotoPerfilRecycled);

        ImagenAdapterRecyclerView imagenAdapterRecyclerView= new ImagenAdapterRecyclerView(cargarTarjetas(), R.layout.cardview_foto, getActivity());

        perfilRecycler.setAdapter(imagenAdapterRecyclerView);

        //usamos LinearLayoutManager y le pasamos el adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        perfilRecycler.setLayoutManager(linearLayoutManager);


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

}
