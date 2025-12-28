package backend;

import java.io.Serializable;

public class Filmes extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String atores;
    private String producao;
    private String categoria;
    private String plataforma;
    private int avaliacao;

    // Construtor
    public Filmes(String nome, String atores, String producao, String categoria, String plataforma, int avaliacao) {
        super(nome);
        this.atores = atores;
        this.producao = producao;
        this.categoria = categoria;
        this.plataforma = plataforma;
        this.avaliacao = avaliacao;
    }

    // --- GETTERS E SETTERS ---

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getProducao() {
        return producao;
    }

    public void setProducao(String producao) {
        this.producao = producao;
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

    // --- MÉTODOS OBRIGATÓRIOS ---

    @Override
    public String getPlanoIdeal() {
        return "Ver um filme relaxante ao fim de semana com pipocas.";
    }

    @Override
    public String toString() {
        // Exemplo: ID: 1 Nome: Matrix [Atores: Keanu... | Prod: Warner | Cat: SciFi | Plat: Netflix | Nota: 10/10]
        return super.toString() + " [Atores: " + atores + " | Prod: " + producao + " | Cat: " + categoria + " | Plat: " + plataforma + " | Nota: " + avaliacao + "/10]";
    }
}