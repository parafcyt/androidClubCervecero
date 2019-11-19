package com.example.clubcerveceromona.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clubcerveceromona.LoginActivity;
import com.example.clubcerveceromona.R;
import com.example.clubcerveceromona.model.DatosxImagen;
import com.example.clubcerveceromona.view.CreateAccountActivity;
import com.example.clubcerveceromona.view.ImagenDetalleActivity;
import com.example.clubcerveceromona.view.MapsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ImagenAdapterRecyclerView extends RecyclerView.Adapter<ImagenAdapterRecyclerView.ImagenViewHolder> {

    private ArrayList<DatosxImagen> listaDeTarjetas;
    private int recurso;
    private Activity activity;

    private CheckBox corazoncito;
    private TextView megustan;


    //private Context contexto;
    //int posicionmarcada=0;


    public ImagenAdapterRecyclerView(ArrayList<DatosxImagen> listaDeTarjetas, int recurso, FragmentActivity activity) {
        this.listaDeTarjetas = listaDeTarjetas;
        this.recurso = recurso;
        this.activity = activity;
    }

    @NonNull
    @Override
    //será quien devuelva el ViewHolder con el layout(CardView) seteado que previamente definimos
    public ImagenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(recurso,parent,false);
        ImagenViewHolder imagenViewHolder = new ImagenViewHolder(v);

        return imagenViewHolder;
    }

    @Override
    //será quien se encargue de establecer los objetos en el ViewHolder
    public void onBindViewHolder(@NonNull final ImagenViewHolder holder, int position) {
        final DatosxImagen datosxImagen= listaDeTarjetas.get(position);

        //con holder obtengo los datos de la Cardview, menos la imagen que uso Picasso
        holder.nombreCerveceriaCard.setText(datosxImagen.getNombreCerveceria());
        holder.tiempoCard.setText(datosxImagen.getTiempo());
        holder.promocionCard.setText(datosxImagen.getPromocion());
        holder.cantidadLikesCard.setText(datosxImagen.getCantidadLikes());
        holder.megustaCard.setChecked(datosxImagen.getMegusta());


        //controlo x tarjeta
        holder.globoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MapsActivity.class);


                //paso a la activity
                intent.putExtra("nombreCerveceria", datosxImagen.getNombreCerveceria());
                intent.putExtra("direccion", datosxImagen.getDireccion());
                intent.putExtra("telefono", datosxImagen.getTelefono());
                intent.putExtra("horario", datosxImagen.getHorario());
                intent.putExtra("friendly", datosxImagen.getPreferencia());
                intent.putExtra("lat", datosxImagen.getLat());
                intent.putExtra("lng", datosxImagen.getLng());


                context.startActivity(intent);
            }

        });


        //imagen con picasso
        Picasso.with(activity).load(datosxImagen.getImagen()).error(R.drawable.ic_error_outine).into(holder.imagenCard);

        //pongo el listener del cardview ImagenDetalleActivity
        holder.imagenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ImagenDetalleActivity.class);

                intent.putExtra("imagen", datosxImagen.getImagen());
                intent.putExtra("nombrecervecero", datosxImagen.getNombreCerveceria());
                intent.putExtra("cantlikes", datosxImagen.getCantidadLikes());

                activity.startActivity(intent);
            }



        });


    }

    @Override
    //será quien devuelva la cantidad de items que se encuentra en la lista
    public int getItemCount() {
        return listaDeTarjetas.size();
    }

    //toma los valores del layout CardView
    public class ImagenViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagenCard;
        private TextView nombreCerveceriaCard;
        private TextView tiempoCard;
        private TextView promocionCard;
        private TextView cantidadLikesCard;
        private CheckBox megustaCard;

        private ImageView globoCard;




        public ImagenViewHolder(@NonNull View itemView) {
            super(itemView);

            imagenCard= itemView.findViewById(R.id.imagen);
            nombreCerveceriaCard= itemView.findViewById(R.id.nombreCerveceria);
            tiempoCard= itemView.findViewById(R.id.tiempo);
            promocionCard= itemView.findViewById(R.id.promocion);
            cantidadLikesCard= itemView.findViewById(R.id.cantidadLikes);
            megustaCard= itemView.findViewById(R.id.corazon);

            globoCard= itemView.findViewById((R.id.globito));

        }
    }


}
