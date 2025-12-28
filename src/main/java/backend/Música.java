package backend;

import java.io.Serializable;

public class Música extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String genero;
    private String artista;
    private String album;
    private int avaliacao;

    public Música(String nome, String artista, String album, String genero, int avaliacao) {
        super(nome);
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.avaliacao = avaliacao;
    }

    // --- GETTERS E SETTERS ---

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String getPlanoIdeal() {
        return "Atenção ao volume, não exceda os 80 decibéis!";
    }

    @Override
    public String toString() {
        // Formato padronizado: ID: 1 Nome: X [Artista: Y | Género: Z | Álbum: W | Nota: 10]
        return super.toString() + " [Artista: " + artista + " | Género: " + genero + " | Álbum: " + album + " | Nota: " + avaliacao + "/10]";
    }
}