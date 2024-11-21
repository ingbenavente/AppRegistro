package com.example.appregistro.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appregistro.Controller.DetalleActivity;
import com.example.appregistro.Model.Club;
import com.example.appregistro.R;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder> {

    private final List<Club> clubes;
    private final OnItemLongClickListener longClickListener;
    private int selectedPosition = -1; // Almacena el elemento seleccionado

    public interface OnItemLongClickListener {
        void onItemLongClick(int position);
    }

    public ClubAdapter(List<Club> clubes, OnItemLongClickListener longClickListener) {
        this.clubes = clubes;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_club, parent, false);
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder holder, int position) {
        Club club = clubes.get(position);
        holder.imgLogo.setImageResource(club.getLogoId());
        holder.txtNombre.setText(club.getNombre());
        holder.txtDescripcion.setText(club.getDescripcion());

        // Mostrar el botón circular solo si el elemento está seleccionado
        holder.btnSelected.setVisibility(selectedPosition == position ? View.VISIBLE : View.GONE);

        // Configurar clic corto para abrir el detalle
        holder.itemView.setOnClickListener(v -> abrirDetalle(holder.itemView.getContext(), club));

        // Configurar clic largo para iniciar el ActionMode
        holder.itemView.setOnLongClickListener(v -> {
            if (longClickListener != null) {
                selectedPosition = position; // Actualiza la posición seleccionada
                longClickListener.onItemLongClick(position);
                notifyDataSetChanged(); // Actualiza la vista
            }
            return true;
        });
    }

    private void abrirDetalle(Context context, Club club) {
        Intent intent = new Intent(context, DetalleActivity.class);
        intent.putExtra("nombre", club.getNombre());
        intent.putExtra("logoId", club.getLogoId());
        intent.putExtra("info", club.getDescripcion());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return clubes.size();
    }

    public void clearSelection() {
        selectedPosition = -1; // Limpia la selección
        notifyDataSetChanged(); // Refresca la vista
    }

    static class ClubViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNombre;
        TextView txtDescripcion;
        ImageView btnSelected; // Botón circular

        public ClubViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.img_logo);
            txtNombre = itemView.findViewById(R.id.txt_nombre);
            txtDescripcion = itemView.findViewById(R.id.txt_descripcion);
            btnSelected = itemView.findViewById(R.id.btn_selected);
        }
    }
}
