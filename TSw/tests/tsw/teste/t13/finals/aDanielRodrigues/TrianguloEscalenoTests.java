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
public class TrianguloEscalenoTests {

    private static Triangulo escaleno;

    public TrianguloEscalenoTests() {
    }

    @BeforeClass
    public static void setUpClass() {
        escaleno = new Triangulo(3.0, 4.0, 5.0);
    }

    @Test
    public void trianguloNaoDeveSerEquilatero() {
        assertFalse(escaleno.isEquilatero());
    }

    @Test(expected = Exception.class)
    public void trianguloComLadosInvalidosDeveRetornarExcecao() throws Exception {
        Triangulo trianguloInvalido = new Triangulo(1.0, 1.0, 40.0);
        trianguloInvalido.validarTodosOsLados();
    }

    @Test
    public void trianguloDeveValido() {
        assertTrue(escaleno.isTrianguloValido());
    }

    @Test(expected = Exception.class)
    public void trianguloComTamanhoInvalidoDeveRetornarExecao() throws Exception {
        Triangulo trianguloInvalido = new Triangulo(1.0, 1.0, 40.0);
        trianguloInvalido.validarTamanhoLado(40.0);
    }

    @Test
    public void trianguloDeveSerInvalido() {
        Triangulo trianguloInvalido = new Triangulo(1.0, 1.0, 40.0);
        assertFalse(trianguloInvalido.isTrianguloValido());
    }

    @Test
    public void trianguloDeveTerTresLadosValidos() {
        assertTrue(escaleno.isTresLadosValidos());
    }

    @Test
    public void trianguloDeveSerEscaleno() {
        assertTrue(escaleno.isEscaleno());
    }

    @Test
    public void trianguloNaoDeveSerIsoceles() {
        assertFalse(escaleno.isIsosceles());
    }

    @Test
    public void trianguloDeveRetangulo() {
        assertTrue(escaleno.isTrianguloRetangulo());
    }

    @Test
    public void tamanhoDeveSerValido() {
        assertTrue(escaleno.isTamanhoValido(escaleno.getLadoA()));
    }

    @Test
    public void tamanhoDeveSerInvalido() {
        assertFalse(escaleno.isTamanhoValido(40.0));
    }
}
