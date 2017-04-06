/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5612;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin.vigil
 */
public class RegistradorDeLivros implements IRegistradorDeLivros {
    protected List<Livro> livros;
    protected static RegistradorDeLivros instancia;
    protected int ultimoSerial;
    Persistencia persistencia;
    
    private RegistradorDeLivros() throws IOException, ClassNotFoundException{
        this.persistencia = Persistencia.getInstancia();
        
        this.carregarListaDeLivros();
        this.carregarUltimoSerial();
    }
          
    private void carregarListaDeLivros() throws IOException, ClassNotFoundException{
        List<Livro> umaListaDeLivros = this.persistencia.carregarLivros();
        
        if(umaListaDeLivros == null)
            this.livros = new ArrayList<>();
        else
            this.livros = umaListaDeLivros;
    }
    
    private void carregarUltimoSerial() throws IOException, ClassNotFoundException{
        Integer umSerial = this.persistencia.carregarSerialUltimoLivroCadastrado();
        
        if(umSerial == null)
            this.ultimoSerial = -1;
        else
            this.ultimoSerial = umSerial;
    }
            
    @Override
    public List<Livro> getLivros() {
        return (List<Livro>) ((ArrayList<Livro>)livros).clone(); //faz um clone de livros para evitar que outras classes mudem this.livros
    }
    
    public static RegistradorDeLivros getInstancia() throws IOException, ClassNotFoundException{
        if (instancia == null)
            instancia = new RegistradorDeLivros();
                   
       return instancia;
    }
    
    @Override
    public void registrarLivro(Livro l) throws IOException{
        l.setSerial(++this.ultimoSerial);
        this.livros.add(l);
        this.persistencia.gravar(this.livros);
        this.persistencia.gravar(this.ultimoSerial);
    }
    
}
