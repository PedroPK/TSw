package tsw.teste.t13.finals.aDanielRodrigues;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dansr
 */
public class TrianguloEquilateroTests {

    private static Triangulo equilatero;

    public TrianguloEquilateroTests() {
    }

    @BeforeClass
    public static void setUpClass() {
        equilatero = new Triangulo(1.0, 1.0, 1.0);
    }

    @Test
    public void trianguloDeveSerEquilatero() {
        assertTrue(equilatero.isEquilatero());
    }

    @Test
    public void trianguloDeveValido() {
        assertTrue(equilatero.isTrianguloValido());
    }

    @Test(expected = Exception.class)
    public void trianguloComTamanhoInvalidoDeveRetornarExecao() throws Exception {
        Triangulo trianguloInvalido = new Triangulo(1.0, 1.0, 40.0);
        trianguloInvalido.validarTamanhoLado(40.0);
    }

    @Test
    public void TamanhoDeveSerValido() {
        assertTrue(equilatero.isTamanhoValido(equilatero.getLadoA()));
    }

    @Test
    public void TamanhoDeveSerInvalido() {
        assertFalse(equilatero.isTamanhoValido(40.0));
    }

    @Test
    public void trianguloDeveSerInvalido() {
        Triangulo trianguloInvalido = new Triangulo(1.0, 1.0, 40.0);
        assertFalse(trianguloInvalido.isTrianguloValido());
    }

    @Test(expected = Exception.class)
    public void trianguloComLadosInvalidosDeveRetornarExcecao() throws Exception {
        Triangulo trianguloInvalido = new Triangulo(1.0, 1.0, 40.0);
        trianguloInvalido.validarTodosOsLados();
    }

    @Test
    public void trianguloDeveTerTresLadosValidos() {
        assertTrue(equilatero.isTresLadosValidos());
    }

    @Test
    public void trianguloNaoDeveSerEscaleno() {
        assertFalse(equilatero.isEscaleno());
    }

    @Test
    public void trianguloNaoDeveSerIsoceles() {
        assertFalse(equilatero.isIsosceles());
    }

    @Test
    public void trianguloNaoDeveRetangulo() {
        assertFalse(equilatero.isTrianguloRetangulo());
    }
}
