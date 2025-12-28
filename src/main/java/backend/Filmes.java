package backend;

import java.io.Serializable;

public class Filmes extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String realizador;
    private String categoria;
    private String plataforma;
    private int avaliacao;

    public Filmes(String nome, String realizador, String categoria, String plataforma, int avaliacao) {
        super(nome);
        this.realizador = realizador;
        this.categoria = categoria;
        this.plataforma = plataforma;
        this.avaliacao = avaliacao;
    }

    public String getRealizador() {
        return realizador;
    }

    public void setRealizador(String realizador) {
        this.realizador = realizador;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String getPlanoIdeal() {
        return "Ver um filme relaxante ao fim de semana.";
    }

    @Override
    public String toString() {
        return super.toString() + " [Realizador: " + realizador + " | Categoria: " + categoria + " | Plat: " + plataforma + " | Nota: " + avaliacao + "/10]";
    }
}