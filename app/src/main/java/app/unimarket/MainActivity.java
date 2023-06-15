package app.unimarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import app.unimarket.adaptador.CategoriaAdaptador;
import app.unimarket.adaptador.DescuentosAdaptador;
import app.unimarket.adaptador.RecentlyViewedAdapter;
import app.unimarket.modelo.Categoria;
import app.unimarket.modelo.Descuentos;
import app.unimarket.modelo.RecentlyViewed;

public class MainActivity extends AppCompatActivity {
    RecyclerView descuentosRecyclerView, categoriaRecyclerView, recentlyViewedRecycler;
    DescuentosAdaptador descuentosAdaptador;
    ArrayList<Descuentos> descuentosList;
    ArrayList<Categoria> categoriaList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    ImageView allCategory;
    ArrayList<RecentlyViewed> recentlyViewedList;
    CategoriaAdaptador categoriaAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        descuentosRecyclerView = findViewById(R.id.descuentoRecycler);
        categoriaRecyclerView = findViewById(R.id.categoriaRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        descuentosList = new ArrayList<>();
        descuentosList.add(new Descuentos(1, R.drawable.desc_galletas));
        descuentosList.add(new Descuentos(2, R.drawable.desc_cereal));
        descuentosList.add(new Descuentos(3, R.drawable.desc_helado));
        descuentosList.add(new Descuentos(4, R.drawable.desc_carne));
        descuentosList.add(new Descuentos(5, R.drawable.desc_apple));
        descuentosList.add(new Descuentos(6, R.drawable.gaseosa));


        categoriaList = new ArrayList<>();
        categoriaList.add(new Categoria(1, R.drawable.frutas));
        categoriaList.add(new Categoria(2, R.drawable.galleta));
        categoriaList.add(new Categoria(3, R.drawable.carnes));
        categoriaList.add(new Categoria(5, R.drawable.bebidas));
        categoriaList.add(new Categoria(6, R.drawable.vegetales));
        categoriaList.add(new Categoria(7, R.drawable.frutas));
        categoriaList.add(new Categoria(8, R.drawable.galleta));
        categoriaList.add(new Categoria(8, R.drawable.carnes));
        categoriaList.add(new Categoria(9, R.drawable.bebidas));
        categoriaList.add(new Categoria(10, R.drawable.vegetales));


        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Fruta 1", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Officiis, quos.", "Bs. 20", " ", " ", R.drawable.card2oreo, R.drawable.galletas));
        recentlyViewedList.add(new RecentlyViewed("Fruta 2", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Officiis, quos.", "Bs. 35", " ", " ", R.drawable.card2gaseosas, R.drawable.bebidas));
        recentlyViewedList.add(new RecentlyViewed("Fruta 3", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Officiis, quos.", "Bs. 30", " ", " ", R.drawable.card2cereal, R.drawable.carne_roja));
        recentlyViewedList.add(new RecentlyViewed("Fruta 4", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Officiis, quos.", "Bs. 10", " ", " ", R.drawable.card2chocolates, R.drawable.cereal));

        setDescuentosRecycler(descuentosList);
        setCategoriaRecycler(categoriaList);
        setRecentlyViewedRecycler(recentlyViewedList);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

    }

    private void setDescuentosRecycler(ArrayList<Descuentos> dataListDesc) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        descuentosRecyclerView.setLayoutManager(layoutManager);
        descuentosAdaptador = new DescuentosAdaptador(this, dataListDesc);
        descuentosRecyclerView.setAdapter(descuentosAdaptador);
    }
    public void setCategoriaRecycler(ArrayList<Categoria> datalistCat) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoriaRecyclerView.setLayoutManager(layoutManager);
        categoriaAdaptador = new CategoriaAdaptador(this, datalistCat);
        categoriaRecyclerView.setAdapter(categoriaAdaptador);
    }
    private void setRecentlyViewedRecycler(ArrayList<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this, recentlyViewedDataList);
        categoriaRecyclerView.setAdapter(recentlyViewedAdapter);
    }
}