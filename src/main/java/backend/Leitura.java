package backend;

import java.io.Serializable;

public class Leitura extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String autor;
    private String genero;
    private int numPaginas;
    private int avaliacao;

    // Construtor atualizado (Agora pede 5 coisas)
    public Leitura(String nome, String autor, String genero, int numPaginas, int avaliacao) {
        super(nome);
        this.autor = autor;
        this.genero = genero;
        this.numPaginas = numPaginas;
        this.avaliacao = avaliacao;
    }

    // --- GETTERS E SETTERS ---

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public int getNumPaginas(){
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas){
        this.numPaginas = numPaginas;
    }

    public int getAvaliacao(){
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao){
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        // Agora mostra a nota também
        return super.toString() + " [Autor: " + autor + " | Género: " + genero + " | " + numPaginas + " págs | Nota: " + avaliacao + "/10]";
    }
}