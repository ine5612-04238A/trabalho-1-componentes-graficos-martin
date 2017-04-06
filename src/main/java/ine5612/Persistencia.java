package ine5612;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author martin.vigil
 */
public class Persistencia implements IPersistencia {

    public static final String ARQUIVO_LIVROS = "livros";
    public static final String ARQUIVO_SERIAL_ULTIMO_LIVRO_CADASTRADO = "serialUltimoLivroCadastrado";

    private static Persistencia instancia;

    private Persistencia() {

    }

    public static Persistencia getInstancia() {
        if (instancia == null) {
            instancia = new Persistencia();
        }

        return instancia;
    }

    private void gravar(Object objeto, String nomeDoArquivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(nomeDoArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(objeto);
        oos.close();
    }

    private Object carregar(String nomeDoArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        Object ret = null;
        File file = new File(nomeDoArquivo);

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ret = ois.readObject();
        }
        return ret;
    }

    @Override
    public void gravar(List<Livro> livros) throws IOException {
        this.gravar(livros, ARQUIVO_LIVROS);
    }
    
    @Override
    public void gravar(Integer serialDoUltimoLivroRegistrado) throws IOException{
        this.gravar(serialDoUltimoLivroRegistrado, ARQUIVO_SERIAL_ULTIMO_LIVRO_CADASTRADO);
    }

    @Override
    public List<Livro> carregarLivros() throws IOException, ClassNotFoundException {
        Object ret = null;

        try {
            ret = this.carregar(ARQUIVO_LIVROS);
        } catch (FileNotFoundException exception) {

        }

        if (ret != null) {
            return (List<Livro>) ret;
        } else {
            return null;
        }
    }
    
    @Override
    public Integer carregarSerialUltimoLivroCadastrado() throws IOException, ClassNotFoundException {
        Object ret = null;

        try {
            ret = this.carregar(ARQUIVO_SERIAL_ULTIMO_LIVRO_CADASTRADO);
        } catch (FileNotFoundException exception) {

        }

        if (ret != null) {
            return (Integer) ret;
        } else {
            return null;
        }
    }
}
