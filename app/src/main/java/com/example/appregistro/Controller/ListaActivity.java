package com.example.appregistro.Controller;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appregistro.Adapters.ClubAdapter;
import com.example.appregistro.R;
import com.example.appregistro.Utils.DataHolder;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ClubAdapter clubAdapter;
    private ActionMode actionMode;
    private int selectedPosition = -1; // Almacena la posición seleccionada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Configurar el adaptador con clics largos para activar el ActionMode
        clubAdapter = new ClubAdapter(DataHolder.clubes, position -> {
            if (actionMode != null) {
                return;
            }
            selectedPosition = position; // Actualiza la posición seleccionada
            actionMode = startSupportActionMode(actionModeCallback); // Inicia el ActionMode
        });

        recyclerView.setAdapter(clubAdapter);
    }

    // Callback para manejar el ActionMode
    private final ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_contextual, menu); // Inflar el menú contextual
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // No es necesario actualizar nada dinámicamente
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.menu_eliminar) {
                confirmarEliminacion();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null; // Limpia el ActionMode
            selectedPosition = -1; // Resetea la posición seleccionada
            clubAdapter.clearSelection(); // Limpia la selección en el adaptador
        }
    };

    private void confirmarEliminacion() {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Confirmar eliminación")
                .setMessage("¿Estás seguro de que deseas eliminar este club?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    DataHolder.clubes.remove(selectedPosition);
                    clubAdapter.notifyItemRemoved(selectedPosition);
                    Toast.makeText(this, "Club eliminado", Toast.LENGTH_SHORT).show();
                    if (actionMode != null) {
                        actionMode.finish();
                    }
                })
                .setNegativeButton("No", (dialog, which) -> {
                    Toast.makeText(this, "Acción cancelada", Toast.LENGTH_SHORT).show();
                    if (actionMode != null) {
                        actionMode.finish();
                    }
                })
                .show();
    }
}
