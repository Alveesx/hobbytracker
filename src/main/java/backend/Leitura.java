package backend;

import java.io.Serializable;

public class Leitura extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String autor;

    public Leitura(String nome, String autor) {
        super(nome);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String getPlanoIdeal() {
        return "Ler um capitulo por dia";
    }

    @Override
    public String toString() {
        return super.toString() + " Autor: " + autor;
    }
}