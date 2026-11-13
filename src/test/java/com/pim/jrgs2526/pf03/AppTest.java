package com.pim.jrgs2526.pf03;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Unit test for simple App.
 */
public class AppTest {
//    @Test
//    public void testCalcularAprobado() {
//        App main = new App();
//        int resultado = main.calcularNota(6);
//        Assertions.assertEquals(1, resultado);
//    }
//
//    @Test
//    public void testCalcularSuspenso() {
//        App main = new App();
//        int resultado = main.calcularNota(2);
//        Assertions.assertEquals(-1, resultado);
//    }
//
//    @Test
//    public void testCalcularError() {
//        App main = new App();
//        try {
//            int resultado = main.calcularNota(63);
//        }
//        catch (IllegalArgumentException e) {
//            Assertions.assertEquals("Error al calcular la nota", e.getMessage());
//            return;
//        }
//        Assertions.fail();
//    }

    @ParameterizedTest(name = "Nota: {0} -> Esperado: {1}")
    @CsvSource({
            "6, 1",
            "2, -1"
    })
    public void testCalcularNotaParametrizado(int nota, int resultadoEsperado) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest(name = "Nota inválida: {0}")
    @CsvSource({
            "63",
            "-5"
    })
    public void testCalcularErrorParametrizado(int notaInvalida) {
        App main = new App();
        try {
            main.calcularNota(notaInvalida);
            fail("Debería haber lanzado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Error al calcular la nota", e.getMessage());
        }
    }
}
