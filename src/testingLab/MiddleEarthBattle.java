package testingLab;
import java.util.HashMap;
import java.util.Map;


public class MiddleEarthBattle {

    // Reglas de puntuación (Nombre de raza -> Puntos)
    private final Map<String, Integer> reglasBien = new HashMap<>();
    private final Map<String, Integer> reglasMal = new HashMap<>();

    public MiddleEarthBattle() {
        // Cargar valores del Bien
        reglasBien.put("Pelosos", 1);
        reglasBien.put("SureñosBuenos", 2);
        reglasBien.put("Enanos", 3);
        reglasBien.put("Númenóreanos", 4);
        reglasBien.put("Elfos", 5);

        // Cargar valores del Mal
        reglasMal.put("SureñosMalos", 2);
        reglasMal.put("Orcos", 2);
        reglasMal.put("Goblins", 2);
        reglasMal.put("Huargos", 3);
        reglasMal.put("Trolls", 5);
    }

    //Calcula el poder total de un ejército comparándolo con su tabla de reglas.

    public int calcularPuntos(Map<String, Integer> ejercito, boolean esBondadoso) {
        Map<String, Integer> reglas = esBondadoso ? reglasBien : reglasMal;
        int total = 0;

        for (Map.Entry<String, Integer> entrada : ejercito.entrySet()) {
            String raza = entrada.getKey();
            int cantidad = entrada.getValue();

            // Buscamos el valor de la raza en las reglas. Si no existe, vale 0.
            int valorUnidad = reglas.getOrDefault(raza, 0);
            total += cantidad * valorUnidad;
        }
        return total;
    }
}