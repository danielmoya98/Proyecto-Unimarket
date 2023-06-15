package app.unimarket.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.unimarket.AllCategory;
import app.unimarket.R;
import app.unimarket.modelo.AllCategoryModel;
import app.unimarket.modelo.Categoria;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {
    Context context;
    List<AllCategoryModel> categoriaList;

    public AllCategoryAdapter(Context context, List<AllCategoryModel> categoriaList) {
        this.context = context;
        this.categoriaList = categoriaList;
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_category_row_items, parent, false);
        return new AllCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {
        holder.imgCategoria.setImageResource(categoriaList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public static class AllCategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategoria;
        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCategoria = itemView.findViewById(R.id.imgCategoria);
        }
    }
}
