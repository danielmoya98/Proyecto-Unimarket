package com.example.carrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ImageView myImageView;
    private View buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnIrAVentana2 = findViewById(R.id.btnIrAVentana2);
        btnIrAVentana2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para realizar la transición a la otra ventana
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(intent);
            }
        });



    }

    public void agregarProducto1(View view) {
        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        intent.putExtra("precioProducto", 10.99); // Cambia el valor por el precio del producto 1
        startActivity(intent);
    }

    public void agregarProducto2(View view) {
        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        intent.putExtra("precioProducto", 19.99); // Cambia el valor por el precio del producto 2
        startActivity(intent);
    }

}