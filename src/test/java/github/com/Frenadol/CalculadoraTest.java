package github.com.Frenadol;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(5,0));
        assertEquals(16, miCalculadora.multiplica(4,4));
        assertEquals(-5, miCalculadora.multiplica(-5,1));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4,2));
        assertEquals(2.5, miCalculadora.divide(10,4));
        assertEquals(4, miCalculadora.divide(10,2.5));
        assertEquals(3.2, miCalculadora.divide(8,2.5));
        assertEquals(0.5, miCalculadora.divide(2,4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4,2) > 0);
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
        assertTrue(miCalculadora.divide(-4,-2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5,0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    void suma() {
        assertEquals(-10,miCalculadora.suma(-4,-6));
        assertEquals(20,miCalculadora.suma(15,5));
        assertEquals(-100,miCalculadora.suma(-50,-50    ));
        assertEquals(200,miCalculadora.suma(190,10));

    }
    @Test
    void resta() {
        assertTrue(miCalculadora.resta(-20,-20)<0);
        assertEquals(20,miCalculadora.resta(40,20));
        assertTrue(miCalculadora.resta(50,50) <=0);
        assertEquals(200,miCalculadora.resta(400,200));

    }
    @Test
    void potencia() {
        assertTrue(miCalculadora.potencia(2,2) >=4);
        assertEquals(1024,miCalculadora.potencia(2,10));
        assertEquals(81,miCalculadora.potencia(9,2));
        assertEquals(100,miCalculadora.potencia(10,2));

    }
    @Test
    void raizCuadrada() throws Calculadora.OperacionInvalidaException{
        assertEquals(1,miCalculadora.raizCuadrada(1));
        assertEquals(0,miCalculadora.raizCuadrada(0));
        assertEquals(2,miCalculadora.raizCuadrada(4));
        assertEquals(6.0,miCalculadora.raizCuadrada(-36),0.0002);
    }

}