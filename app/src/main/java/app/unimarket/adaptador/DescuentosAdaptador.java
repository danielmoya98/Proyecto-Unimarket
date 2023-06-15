package app.unimarket.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import app.unimarket.R;
import app.unimarket.modelo.Descuentos;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DescuentosAdaptador extends RecyclerView.Adapter<DescuentosAdaptador.DescuentosProductosViewHolder>{
    Context context;
    ArrayList<Descuentos> descuentosList;


    public DescuentosAdaptador(Context context, ArrayList<Descuentos> descuentosList) {
        this.context = context;
        this.descuentosList = descuentosList;
    }

    @NonNull
    @Override
    public DescuentosProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.descuentos_filas_items, parent, false);
        return new DescuentosProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DescuentosProductosViewHolder holder, int position) {
        holder.imgDescuentoView.setImageResource(descuentosList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {

        return descuentosList.size();
    }

    public static class DescuentosProductosViewHolder extends RecyclerView.ViewHolder{
        ImageView imgDescuentoView;
        public DescuentosProductosViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDescuentoView = itemView.findViewById(R.id.imgCategoria);
        }
    }

}
