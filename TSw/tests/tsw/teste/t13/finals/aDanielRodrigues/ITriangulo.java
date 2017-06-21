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
public interface ITriangulo {

    // Metodos de Validação
    public void validarTamanhoLado(Double pTamanho) throws Exception;

    public void validarTodosOsLados() throws Exception;

    public boolean isTamanhoValido(Double ptamanhoLado);

    ///Metodos de Situação
    public boolean isEquilatero();

    public boolean isIsosceles();

    public boolean isEscaleno();

    public boolean isTrianguloValido();

    public boolean isTresLadosValidos();

    public boolean isTrianguloRetangulo();

}
