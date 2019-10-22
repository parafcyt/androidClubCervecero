package com.example.clubcerveceromona.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clubcerveceromona.R;
import com.example.clubcerveceromona.view.model.DatosxImagen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagenAdapterRecyclerView extends RecyclerView.Adapter<ImagenAdapterRecyclerView.ImagenViewHolder> {

    private ArrayList<DatosxImagen> listaDeTarjetas;
    private int recurso;
    private Activity activity;

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
    public void onBindViewHolder(@NonNull ImagenViewHolder holder, int position) {
        DatosxImagen datosxImagen= listaDeTarjetas.get(position);

        //con holder obtengo los datos de la Cardview, menos la imagen que uso Picasso
        holder.nombreCerveceriaCard.setText(datosxImagen.getNombreCerveceria());
        holder.tiempoCard.setText(datosxImagen.getTiempo());
        holder.promocionCard.setText(datosxImagen.getPromocion());
        holder.cantidadLikesCard.setText(datosxImagen.getCantidadLikes());

        //imagen con picasso
        Picasso.with(activity).load(datosxImagen.getImagen()).error(R.drawable.ic_casita).into(holder.imagenCard);

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

        public ImagenViewHolder(@NonNull View itemView) {
            super(itemView);

            imagenCard= itemView.findViewById(R.id.imagen);
            nombreCerveceriaCard= itemView.findViewById(R.id.nombreCerveceria);
            tiempoCard= itemView.findViewById(R.id.tiempo);
            promocionCard= itemView.findViewById(R.id.promocion);
            cantidadLikesCard= itemView.findViewById(R.id.cantidadLikes);
        }
    }


}
