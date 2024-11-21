package com.example.appregistro.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appregistro.R;

public class MainActivity extends AppCompatActivity {

    private Button btnRegistro;
    private Button btnLista;
    private TextView tvBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar vistas
        btnRegistro = findViewById(R.id.btn_registro);
        btnLista = findViewById(R.id.btn_lista);
        TextView tvBienvenida = findViewById(R.id.tv_bienvenida);
        TextView tvNombre = findViewById(R.id.tv_nombre);

        // Mostrar mensaje de bienvenida si hay datos del registro
        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            if (nombre != null && !nombre.isEmpty()) {
                tvBienvenida.setText("Bienvenido");
                tvNombre.setText(nombre);
            }
        }

        // Navegar a RegistroActivity
        btnRegistro.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity.this, RegistroActivity.class);
            startActivity(intent1);
        });

        // Navegar a ListaActivity
        btnLista.setOnClickListener(v -> {
            Intent intent12 = new Intent(MainActivity.this, ListaActivity.class);
            startActivity(intent12);
        });
    }


}
