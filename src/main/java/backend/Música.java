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
    @Override
    public String getPlanoIdeal() {
        return "";
    }
    public String getartista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
}
    public String getgenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getalbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    public int getavaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    @Override
    public String toString() {
        return super.toString() + " [Música: " + artista + " | " + genero + "]";
    }
}