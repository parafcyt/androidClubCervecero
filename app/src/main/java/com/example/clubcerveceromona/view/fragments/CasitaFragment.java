package com.example.clubcerveceromona.view.fragments;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.clubcerveceromona.R;
import com.example.clubcerveceromona.adapter.ImagenAdapterRecyclerView;
import com.example.clubcerveceromona.model.DatosxImagen;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CasitaFragment extends Fragment {




    public CasitaFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_casita, container, false);

        mostrarToolbarraa("Inicio", v);

        RecyclerView tarjetaRecycler = v.findViewById(R.id.recyclerView);

        ImagenAdapterRecyclerView imagenAdapterRecyclerView= new ImagenAdapterRecyclerView(cargarTarjetas(), R.layout.cardview_foto, getActivity());

        tarjetaRecycler.setAdapter(imagenAdapterRecyclerView);

        //usamos LinearLayoutManager y le pasamos el adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        tarjetaRecycler.setLayoutManager(linearLayoutManager);



        return v;
    }

    //metodo del array
    public ArrayList <DatosxImagen> cargarTarjetas(){

        ArrayList<DatosxImagen> datos = new ArrayList<>();

        datos.add(new DatosxImagen("https://www.thebeertimes.com/wp-content/uploads/2018/06/Cerveza_artesanal.jpg",
                "7 Colinas", "Hace 4 minutos", "2", "Estrada 838",
                "03442 43-2811","Martes a Domingo de 19:30 a 2 Hs", "Gay Friendly",
                false, -32.479900,-58.235322,"Cerveza Negra 50% OFF"));

        datos.add(new DatosxImagen("https://images.clarin.com/2019/01/15/actualmente-la-ciudad-cuenta-con___Lte01HS8K_1200x0__1.jpg",
                "Biguá", "Hace 1 hora", "10", "Juan Domingo Perón 34",
                "--","Lunes a Domingo de 19:30 a 00:30 Hs.", "LGBT Friendly",
                true, -32.485051, -58.231004,"Happy Hour 21 a 23hs."));

        datos.add(new DatosxImagen("https://www.cronista.com/__export/1536170691575/sites/diarioelcronista/img/2018/09/05/cerveza1.jpg_1866758231.jpg",
                "Drakkar", "Hace 5 horas", "20", "Artusi 755",
                "03442 43-7805","Jueves a Domingo de 20:00 a 2 Hs", "Pet Friendly",
                true,-32.480557, -58.233931,"Descuento Camioneros"));

        datos.add(new DatosxImagen("https://media.elpatagonico.com/adjuntos/193/imagenes/028/62'9/0028629938.jpg",
                "Träctor", "Hace 7 horas", "10", "Artusi 998",
                "03442 15-53-9608", "Miercoles a Sabado de 20:00 a 3 Hs", "Child Friendly",
                true,-32.481204, -58.237988,"Promo Machirulo"));

        datos.add(new DatosxImagen("https://images.clarin.com/2019/03/28/LqsIpI6FD_1256x620__1.jpg",
                "Lagash", "Hace 6 horas", "30", "Calle Ruiz Moreno 657",
                "--","Martes a Domingo de 19:30 a 2 Hs","Gay Friendly",
                true,-32.477274, -58.248289,"Descuento UOCRA"));

        datos.add(new DatosxImagen("https://images.clarin.com/2019/01/15/uH8yqnI9W_1256x620__1.jpg",
                "7 Colinas", "Hace 9 horas", "30", "Estrada 838",
                "03442 43-2811","Martes a Domingo de 19:30 a 2 Hs", "LGBT Friendly",
                true, -32.479900,-58.235322,"Sí se puede, 20% OFF"));

        datos.add(new DatosxImagen("https://images.clarin.com/2019/01/15/entre-las-variedades-mas-buscadas___JBnsNc5S8_1200x0__1.jpg",
                "Biguá", "Hace 3 horas", "33", "Juan Domingo Perón 34",
                "--","Lunes a Domingo de 19:30 a 00:30 Hs.", "Gay Friendly",
                true, -32.485051, -58.231004,"Viva Perón 30% OFF"));

        datos.add(new DatosxImagen("https://www.cronista.com/export/sites/diarioelcronista/img/2018/08/03/cervezas_01_crop1533309198187.jpg_315635302.jpg",
                "Drakkar", "Hace 8 horas", "35", "Artusi 755",
                "03442 43-7805","Jueves a Domingo de 20:00 a 2 Hs", "Pet Friendly",
                false,-32.480557, -58.233931,"LTA 2x1"));

        datos.add(new DatosxImagen("https://cdn.forbes.com.mx/2018/08/Cerveza-artesanal-640x360.jpg",
                "Lagash", "Hace 8 horas", "50", "Calle Ruiz Moreno 657",
                "--","Martes a Domingo de 19:30 a 2 Hs","Gay Friendly",
                false,-32.477274, -58.248289,"Marxistas 25% OFF"));

        datos.add(new DatosxImagen("https://ecocuyo.com/wp-content/uploads/2019/04/TAIPEI1-108-696x406.jpg",
                "Träctor", "Hace 9 horas", "40", "Artusi 998",
                "03442 15-53-9608", "Miercoles a Sabado de 20:00 a 3 Hs", "Pet Friendly",
                false,-32.481204, -58.237988,"Chicas trans 20% OFF"));

        datos.add(new DatosxImagen("https://static.wixstatic.com/media/b54170_cfd1966cf0ee42418f3a67a5337ed2f5~mv2.jpg/v1/fill/w_960,h_720,al_c,q_90/file.jpg",
                "7 Colinas", "Hace 15 horas", "50", "Estrada 838",
                "03442 43-2811","Martes a Domingo de 19:30 a 2 Hs", "LGBT Friendly",
                false, -32.479900,-58.235322,"20% OFF Picadas"));


        return datos;


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void mostrarToolbarraa(String titulo, View view){
        Toolbar toolbarraa= view.findViewById(R.id.toolbarra);
        toolbarraa.setTitle(titulo);
        toolbarraa.setNavigationIcon(null);
    }

}
