package com.example.appregistro.Utils;

import com.example.appregistro.Model.Club;
import com.example.appregistro.R;

import java.util.ArrayList;

public class DataHolder {
    public static ArrayList<Club> clubes = new ArrayList<>();

    static {
        clubes.add(new Club("Alianza Lima", "Club histórico de Perú fundado en 1901. Alianza Lima ha sido campeón nacional en múltiples ocasiones y es conocido por su fiel hinchada.", R.drawable.alianza_lima));
        clubes.add(new Club("Universitario", "Fundado en 1924, Universitario de Deportes es el equipo con más títulos de la liga peruana. Su estadio, Monumental, es uno de los más grandes de Sudamérica.", R.drawable.universitario));
        clubes.add(new Club("Sporting Cristal", "Fundado en 1955, el club es conocido por su estilo ofensivo y sus colores celestes. Sporting Cristal es uno de los equipos más laureados del fútbol peruano.", R.drawable.sporting_cristal));
        clubes.add(new Club("Cienciano", "El único club peruano en ganar títulos internacionales, la Copa Sudamericana y la Recopa Sudamericana. Cienciano es orgullo de Cusco.", R.drawable.cienciano));
        clubes.add(new Club("Melgar", "Club emblemático de Arequipa fundado en 1915. Melgar es conocido por ser uno de los mejores equipos fuera de Lima.", R.drawable.melgar));
        clubes.add(new Club("Carlos A. Mannucci", "Equipo histórico de Trujillo, conocido por su tradición y pasión. Carlos A. Mannucci ha sido un ejemplo de perseverancia en el fútbol peruano.", R.drawable.mannucci));
    }
}
