package com.example.carrito;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
public class SegundaActivity extends AppCompatActivity {


    private List<Double> preciosProductos;
    private TextView txtCarrito;
    private LinearLayout linearCarrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        Button btnIrAVentana2 = findViewById(R.id.botonRegresar);
        btnIrAVentana2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para realizar la transición a la otra ventana
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




        preciosProductos = new ArrayList<>();
        linearCarrito = findViewById(R.id.linearCarrito);

        Intent intent = getIntent();
        if (intent != null) {
            double precioProducto = intent.getDoubleExtra("precioProducto", 0.0);
            preciosProductos.add(precioProducto);
            mostrarPreciosCarrito();
        }


    }

    private void mostrarPreciosCarrito() {


        for (double precio : preciosProductos) {
            TextView textView = new TextView(this);
            textView.setText("$" + precio);
            textView.setTextSize(16);
            linearCarrito.addView(textView);
        }

    }

}

