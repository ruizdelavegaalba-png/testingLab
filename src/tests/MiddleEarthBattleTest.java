package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import testingLab.MiddleEarthBattle;
import java.util.HashMap;

public class MiddleEarthBattleTest {

    MiddleEarthBattle simulador = new MiddleEarthBattle();

    @Test
    public void test1_VictoriaBien() {
        HashMap<String, Integer> bien = new HashMap<>();
        bien.put("Elfos", 5);
        HashMap<String, Integer> mal = new HashMap<>();
        mal.put("Orcos", 5);

        int pBien = simulador.calcularPuntos(bien, true);
        int pMal = simulador.calcularPuntos(mal, false);

        assertTrue(pBien > pMal);
        assertEquals(25, pBien);
    }

    @Test
    public void test2_VictoriaMal() {
        HashMap<String, Integer> bien = new HashMap<>();
        bien.put("Pelosos", 1);
        HashMap<String, Integer> mal = new HashMap<>();
        mal.put("Trolls", 1);

        int pBien = simulador.calcularPuntos(bien, true);
        int pMal = simulador.calcularPuntos(mal, false);

        assertTrue(pMal > pBien);
        assertEquals(5, pMal);
    }

    @Test
    public void test3_EmpateTecnico() {
        HashMap<String, Integer> bien = new HashMap<>();
        bien.put("SureñosBuenos", 1);
        HashMap<String, Integer> mal = new HashMap<>();
        mal.put("Orcos", 1);

        int pBien = simulador.calcularPuntos(bien, true);
        int pMal = simulador.calcularPuntos(mal, false);

        assertEquals(pBien, pMal);
    }

    @Test
    public void test4_MultiplesRazas() {
        HashMap<String, Integer> bien = new HashMap<>();
        bien.put("Pelosos", 10);
        bien.put("Enanos", 2);
        bien.put("Númenóreanos", 1);

        int resultado = simulador.calcularPuntos(bien, true);
        assertEquals(20, resultado);
    }

    @Test
    public void test5_RazaInexistente() {
        HashMap<String, Integer> ejercitoLoco = new HashMap<>();
        ejercitoLoco.put("Dragones", 100);
        ejercitoLoco.put("Elfos", 1);

        int resultado = simulador.calcularPuntos(ejercitoLoco, true);
        assertEquals(5, resultado);
    }

    @Test
    public void test6_VerificarInstancia() {
        assertNotNull(simulador);
    }

    @Test
    public void test7_EjercitoVacio() {
        HashMap<String, Integer> vacio = new HashMap<>();
        int resultado = simulador.calcularPuntos(vacio, true);
        assertEquals(0, resultado);
    }

    @Test
    public void test8_PoderMaximoEquilibrado() {
        HashMap<String, Integer> elfo = new HashMap<>();
        elfo.put("Elfos", 1);
        HashMap<String, Integer> troll = new HashMap<>();
        troll.put("Trolls", 1);

        assertEquals(simulador.calcularPuntos(elfo, true), simulador.calcularPuntos(troll, false));
    }

    @Test
    public void test9_CantidadesNegativas() {
        HashMap<String, Integer> negativo = new HashMap<>();
        negativo.put("Orcos", -5);

        int resultado = simulador.calcularPuntos(negativo, false);
        assertEquals(-10, resultado);
    }

    @Test
    public void test10_DiferenciaExacta() {
        HashMap<String, Integer> peloso = new HashMap<>();
        peloso.put("Pelosos", 1);
        HashMap<String, Integer> troll = new HashMap<>();
        troll.put("Trolls", 1);

        int diferencia = simulador.calcularPuntos(troll, false) - simulador.calcularPuntos(peloso, true);
        assertEquals(4, diferencia);
    }
}