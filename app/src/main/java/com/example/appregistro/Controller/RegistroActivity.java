package com.example.appregistro.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appregistro.R;

public class RegistroActivity extends AppCompatActivity {

    private EditText etNombre, etEmail, etPassword, etEdad;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Enlazar elementos del diseño
        etNombre = findViewById(R.id.et_nombre);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etEdad = findViewById(R.id.et_edad);
        btnRegistrar = findViewById(R.id.btn_registrar);

        // Botón de registro
        btnRegistrar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String edadStr = etEdad.getText().toString().trim();

            // Validaciones
            if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(edadStr)) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!email.contains("@") || !email.contains(".")) {
                Toast.makeText(this, "Por favor, ingresa un correo válido", Toast.LENGTH_SHORT).show();
                return;
            }

            int edad;
            try {
                edad = Integer.parseInt(edadStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "La edad debe ser un número válido", Toast.LENGTH_SHORT).show();
                return;
            }

            if (edad < 18) {
                Toast.makeText(this, "Debes ser mayor de 18 años para registrarte", Toast.LENGTH_SHORT).show();
                return;
            }

            // Enviar el mensaje de bienvenida a la ventana principal
            Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
            intent.putExtra("nombre", nombre);
            startActivity(intent);

            // Limpiar campos y mostrar mensaje de éxito
            etNombre.setText("");
            etEmail.setText("");
            etPassword.setText("");
            etEdad.setText("");
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        });
    }
}
