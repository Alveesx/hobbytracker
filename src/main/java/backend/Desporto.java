package backend;

import java.io.Serializable;

public class Desporto extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String categoria;
    private String local;
    private int avaliacao;

    public Desporto(String nome, String categoria, String local, int avaliacao) {
        super(nome);
        this.categoria = categoria;
        this.local = local;
        this.avaliacao = avaliacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String getPlanoIdeal() {
        return "Praticar desporto regularmente!";
    }

    @Override
    public String toString() {
        return super.toString() + " [Categoria: " + categoria + " | Local: " + local + " | Nota: " + avaliacao + "/10]";
    }
}