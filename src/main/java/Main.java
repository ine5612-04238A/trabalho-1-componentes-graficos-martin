/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ine5612.RegistradorDeLivros;
import ine5612.Livro;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author martin.vigil
 */
public class Main {
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        RegistradorDeLivros controlador = RegistradorDeLivros.getInstancia();
                
        Livro l1 = new Livro();
        Livro l2 = new Livro();
//                
//        l1.setAutor("Autor 0");
//        l1.setNome("Titulo 0");
        l2.setAutor("Autor 1");
        l2.setNome("Livro 1");
//        
//        controlador.registrarLivro(l1);
        controlador.registrarLivro(l2);
       
        
    }
}
