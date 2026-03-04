package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import testingLab.MiddleEarthBattle;
import java.util.HashMap;
import java.util.Map;

public class MiddleEarthBattleTest {

    MiddleEarthBattle simulador = new MiddleEarthBattle();

    @Test
    public void test1_VictoriaBien() {
        Map<String, Integer> bien = new HashMap<>();
        bien.put("Elfos", 5);
        Map<String, Integer> mal = new HashMap<>();
        mal.put("Orcos", 5);
        assertTrue(simulador.calcularPuntos(bien, true) > simulador.calcularPuntos(mal, false));
    }

    @Test
    public void test2_VictoriaMal() {
        Map<String, Integer> bien = new HashMap<>();
        bien.put("Pelosos", 1);
        Map<String, Integer> mal = new HashMap<>();
        mal.put("Trolls", 1);
        assertTrue(simulador.calcularPuntos(mal, false) > simulador.calcularPuntos(bien, true));
    }

    @Test
    public void test3_EmpateTecnico() {
        Map<String, Integer> bien = new HashMap<>();
        bien.put("SureñosBuenos", 1);
        Map<String, Integer> mal = new HashMap<>();
        mal.put("Orcos", 1);
        assertEquals(simulador.calcularPuntos(bien, true), simulador.calcularPuntos(mal, false));
    }

    @Test
    public void test4_MultiplesRazas() {
        Map<String, Integer> bien = new HashMap<>();
        bien.put("Pelosos", 10); bien.put("Enanos", 2);
        assertEquals(16, simulador.calcularPuntos(bien, true));
    }

    @Test
    public void test5_RazaInexistente() {
        Map<String, Integer> ejercitoLoco = new HashMap<>();
        ejercitoLoco.put("Dragones", 100);
        ejercitoLoco.put("Elfos", 1);
        assertEquals(5, simulador.calcularPuntos(ejercitoLoco, true));
    }

    @Test
    public void test6_VerificarInstancia() {
        assertNotNull(simulador);
    }

    @Test
    public void test7_EjercitoVacio() {
        Map<String, Integer> vacio = new HashMap<>();
        assertEquals(0, simulador.calcularPuntos(vacio, true));
    }

    @Test
    public void test8_PoderMaximoEquilibrado() {
        Map<String, Integer> elfo = new HashMap<>(); elfo.put("Elfos", 1);
        Map<String, Integer> troll = new HashMap<>(); troll.put("Trolls", 1);
        assertEquals(simulador.calcularPuntos(elfo, true), simulador.calcularPuntos(troll, false));
    }

    @Test
    public void test9_CantidadesNegativas() {
        Map<String, Integer> negativo = new HashMap<>();
        negativo.put("Orcos", -5);
        assertEquals(-10, simulador.calcularPuntos(negativo, false));
    }

    @Test
    public void test10_DiferenciaExacta() {
        Map<String, Integer> peloso = new HashMap<>(); peloso.put("Pelosos", 1);
        Map<String, Integer> troll = new HashMap<>(); troll.put("Trolls", 1);
        int diff = simulador.calcularPuntos(troll, false) - simulador.calcularPuntos(peloso, true);
        assertEquals(4, diff);
    }
}