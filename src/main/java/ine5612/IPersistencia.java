/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5612;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author martin
 */
public interface IPersistencia {

    List<Livro> carregarLivros() throws IOException, ClassNotFoundException;

    Integer carregarSerialUltimoLivroCadastrado() throws IOException, ClassNotFoundException;

    void gravar(List<Livro> livros) throws IOException;

    void gravar(Integer serialDoUltimoLivroRegistrado) throws IOException;
    
}
