package com.example.appregistro.Controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appregistro.R;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // Referencias a los elementos
        ImageView imgLogo = findViewById(R.id.img_logo_detalle);
        TextView txtDetalle = findViewById(R.id.txt_detalle);
        Button btnVolver = findViewById(R.id.btn_volver);

        // Obtener los datos enviados desde ListaActivity
        String nombre = getIntent().getStringExtra("nombre");
        int logoId = getIntent().getIntExtra("logoId", 0);
        String info = getIntent().getStringExtra("info");

        // Configurar los elementos con los datos recibidos
        imgLogo.setImageResource(logoId);
        txtDetalle.setText("Nombre del Club: " + nombre + "\n\n" + info);

        // Manejar el clic del botón de regresar
        btnVolver.setOnClickListener(v -> finish());
    }
}
