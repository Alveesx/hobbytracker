package backend;

import java.io.Serializable;

public class Leitura extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String autor;
    private String genero;
    private int numPaginas;

    // Construtor atualizado
    public Leitura(String nome, String autor, String genero, int numPaginas) {
        super(nome);
        this.autor = autor;
        this.genero = genero;
        this.numPaginas = numPaginas;
    }

    // --- GETTERS E SETTERS ---

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }


    @Override
    public String getPlanoIdeal() {
        return "Ler um capitulo ou 20 paginas por dia.";
    }

    @Override
    public String toString() {
        // Exemplo: ID: 1 Nome: X [Autor: Y | Género: Z | 300 págs]
        return super.toString() + " [Autor: " + autor + " | Género: " + genero + " | " + numPaginas + " págs]";
    }
}

//terminado