package backend;

public class Música extends Passatempo {
    private String genero;
    private String artista;
    private String album;
    private int avaliacao;

    public Música(String nome, String artista, String album, String genero, int avaliacao) {
        super(nome);
        this.artista = artista;
        this.genero = genero;
        this.album = album;
        this.avaliacao = avaliacao;
    }


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
        return "Atenção ao volume não exceda os 80 decibéis!";
    }
    @Override
    public String toString() {
        return super.toString() +
                " [Música: " + artista + " | " + genero + " | " + album + " | " + avaliacao + "]";
    }
}
