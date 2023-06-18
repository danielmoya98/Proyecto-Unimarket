package app.unimarket.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.unimarket.R;
import app.unimarket.modelo.Categoria;

public class CategoriaAdaptador extends RecyclerView.Adapter<CategoriaAdaptador.CategoriaViewHolder> {
    Context context;
    List<Categoria> categoriaList;

    public CategoriaAdaptador(Context context, List<Categoria> categoriaList) {
        this.context = context;
        this.categoriaList = categoriaList;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categoria_filas_items, parent, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        holder.imgCategoria.setImageResource(categoriaList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public static class CategoriaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategoria;
        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCategoria = itemView.findViewById(R.id.imgCategoria);
        }
    }
}
