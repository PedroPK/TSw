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
public class TrianguloIsoscelesTests {

    private static Triangulo isosceles;

    public TrianguloIsoscelesTests() {
    }

    @BeforeClass
    public static void setUpClass() {
        isosceles = new Triangulo(3.0, 4.0, 4.0);
    }

    @Test
    public void trianguloNaoDeveSerEquilatero() {
        assertFalse(isosceles.isEquilatero());
    }

    @Test
    public void trianguloDeveValido() {
        assertTrue(isosceles.isTrianguloValido());
    }

    @Test
    public void tamanhoDeveSerValido() {
        assertTrue(isosceles.isTamanhoValido(isosceles.getLadoA()));
    }

    @Test
    public void tamanhoDeveSerInvalido() {
        assertFalse(isosceles.isTamanhoValido(40.0));
    }

    @Test(expected = Exception.class)
    public void trianguloComLadosInvalidosDeveRetornarExcecao() throws Exception {
        Triangulo trianguloInvalido = new Triangulo(1.0, 1.0, 40.0);
        trianguloInvalido.validarTodosOsLados();
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
        assertTrue(isosceles.isTresLadosValidos());
    }

    @Test
    public void trianguloNaoDeveSerEscaleno() {
        assertFalse(isosceles.isEscaleno());
    }

    @Test
    public void trianguloDeveSerIsoceles() {
        assertTrue(isosceles.isIsosceles());
    }

    @Test
    public void trianguloNaoDeveRetangulo() {
        assertFalse(isosceles.isTrianguloRetangulo());
    }
}
