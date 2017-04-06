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
public interface IRegistradorDeLivros {

    List<Livro> getLivros();

    void registrarLivro(Livro l) throws IOException;
    
}
