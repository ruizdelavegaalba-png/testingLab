//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import testingLab.MiddleEarthBattle;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MiddleEarthBattle simulador = new MiddleEarthBattle();

        // --- EJÉRCITO DEL BIEN ---
        Map<String, Integer> ejercitoBien = new HashMap<>();
        ejercitoBien.put("Pelosos", 10);
        ejercitoBien.put("Elfos", 5);
        ejercitoBien.put("Enanos", 2);

        // --- EJÉRCITO DEL MAL ---
        Map<String, Integer> ejercitoMal = new HashMap<>();
        ejercitoMal.put("Orcos", 20);
        ejercitoMal.put("Trolls", 2);
        ejercitoMal.put("Huargos", 5);

        // --- PROCESO DE BATALLA ---
        int puntosBien = simulador.calcularPuntos(ejercitoBien, true);
        int puntosMal = simulador.calcularPuntos(ejercitoMal, false);

        System.out.println("=== BATALLA POR LA TIERRA MEDIA ===");
        System.out.println("Puntos del Bien: " + puntosBien);
        System.out.println("Puntos del Mal: " + puntosMal);


        if (puntosBien > puntosMal) {
            System.out.println("¡EL BIEN HA GANADO! La paz vuelve a los reinos.");
        } else if (puntosMal > puntosBien) {
            System.out.println("¡EL MAL HA GANADO! La oscuridad reina.");
        } else {
            System.out.println("¡EMPATE! Los ejércitos se retiran para reagruparse.");
        }
    }
}