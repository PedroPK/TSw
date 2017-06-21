/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsw.teste.t13.finals.aDanielRodrigues;

/**
 *
 * @author dansr
 */
public class Triangulo implements ITriangulo {

    protected Double ladoA;
    protected Double ladoB;
    protected Double ladoC;

    public Double getLadoA() {
        return ladoA;
    }

    public Double getLadoB() {
        return ladoB;
    }

    public Double getLadoC() {
        return ladoC;
    }

    public Triangulo(Double ladoA, Double ladoB, Double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public void validarTamanhoLado(Double pTamanho) throws Exception {
        if (!isTamanhoValido(pTamanho)) {
            throw new Exception("Tamnaho do lado é inválido.");
        }
    }

    @Override
    public void validarTodosOsLados() throws Exception {
        if (!isTresLadosValidos()) {
            throw new Exception("Os lados do triangulo são inválidos.");
        }
    }

    @Override
    public boolean isTamanhoValido(Double ptamanhoLado) {
        boolean validaSomasComAB = ladoA + ladoB > ptamanhoLado;
        boolean validaSomasComAC = ladoA + ladoC > ptamanhoLado;
        boolean validaSomasComBC = ladoB + ladoC > ptamanhoLado;
        return validaSomasComAB && validaSomasComAC && validaSomasComBC;
    }

    @Override
    public boolean isEquilatero() {
        return ladoA.equals(ladoB) && ladoB.equals(ladoC);
    }

    @Override
    public boolean isIsosceles() {
        return !isEquilatero() && !isEscaleno();
    }

    @Override
    public boolean isEscaleno() {
        return !ladoA.equals(ladoB) && !ladoB.equals(ladoC) && !ladoA.equals(ladoC);
    }

    @Override
    public boolean isTrianguloValido() {
        Double moduloLadoA = Math.abs((ladoB - ladoC));
        boolean validaPeranteModuloA = (moduloLadoA < ladoA);
        boolean validaPeranteSomaDosLadosA = ladoA < ladoB + ladoC;

        Double moduloLadoB = Math.abs((ladoA - ladoC));
        boolean validaPeranteModuloB = (moduloLadoB < ladoB);
        boolean validaPeranteSomaDosLadosB = ladoB < ladoA + ladoC;

        Double moduloLadoC = Math.abs((ladoA - ladoB));
        boolean validaPeranteModuloC = (moduloLadoC < ladoC);
        boolean validaPeranteSomaDosLadosC = ladoC < ladoA + ladoB;

        return (validaPeranteModuloA && validaPeranteSomaDosLadosA)
                && (validaPeranteModuloB && validaPeranteSomaDosLadosB)
                && (validaPeranteModuloC && validaPeranteSomaDosLadosC);
    }

    @Override
    public boolean isTresLadosValidos() {
        return isTamanhoValido(ladoA) && isTamanhoValido(ladoB) && isTamanhoValido(ladoC);
    }

    @Override
    public boolean isTrianguloRetangulo() {
        Double quadradoA = ladoA * ladoA;
        Double quadradoB = (ladoB * ladoB);
        Double quadradoC = (ladoC * ladoC);
        boolean trianguloERetanguloA = quadradoA.equals(quadradoB + quadradoC);
        boolean trianguloERetanguloB = quadradoB.equals(quadradoA + quadradoC);
        boolean trianguloERetanguloC = quadradoC.equals(quadradoA + quadradoB);
        return trianguloERetanguloA || trianguloERetanguloB || trianguloERetanguloC;
    }

}
