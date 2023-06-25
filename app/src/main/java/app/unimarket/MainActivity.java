package app.unimarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.unimarket.adaptador.CategoriaAdaptador;
import app.unimarket.adaptador.DescuentosAdaptador;
import app.unimarket.adaptador.RecentlyViewedAdapter;
import app.unimarket.modelo.Categoria;
import app.unimarket.modelo.Descuentos;
import app.unimarket.modelo.RecentlyViewed;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor sensor;
    private SwitchCompat switchSensor;
    private TextView txtTemperatura;

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

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        switchSensor = findViewById(R.id.switchSensor);
        txtTemperatura = findViewById(R.id.txtTemperatura);

        switchSensor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCkecked) {
                if(isCkecked) {
                    if(sensor != null) {
                        sensorManager.registerListener(MainActivity.this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "El dispositivo no tiene sensor de temperatura.", Toast.LENGTH_SHORT).show();
                        switchSensor.setChecked(false);
                    }
                }
                else {
                    sensorManager.unregisterListener(MainActivity.this);
                    txtTemperatura.setText("Temp");
                }
            }
        });


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
        recentlyViewedList.add(new RecentlyViewed("Galletas Oreo", "Lorem, ipsum dolor sit amet consectetur adipisicing elit.", "Bs. 20", " ", " ", R.drawable.card2oreo, R.drawable.galletas_oreo));
        recentlyViewedList.add(new RecentlyViewed("Gaseosas", "Lorem, ipsum dolor sit amet consectetur adipisicing elit.", "Bs. 35", " ", " ", R.drawable.card2gaseosas, R.drawable.gaseosas_d));
        recentlyViewedList.add(new RecentlyViewed("Froot Loops", "Lorem, ipsum dolor sit amet consectetur adipisicing elit.", "Bs. 30", " ", " ", R.drawable.card2cereal, R.drawable.frootloops_cereales));
        recentlyViewedList.add(new RecentlyViewed("Chocolates", "Lorem, ipsum dolor sit amet consectetur adipisicing elit.", "Bs. 90", " ", " ", R.drawable.card2chocolates, R.drawable.chocolates_d));

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

    @Override
    protected void onResume() {
        super.onResume();

        if(switchSensor.isChecked() && sensor != null) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float temperatura = sensorEvent.values[0];
        txtTemperatura.setText(temperatura + "°C");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}