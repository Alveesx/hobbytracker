package backend;

import java.io.Serializable;

public class Jogos extends Passatempo implements Serializable {


    private static final long serialVersionUID = 1L;

    private String plataforma;
    private String genero;
    private boolean multijogador;
    private int nivelDificuldade;
    private int avaliacao;

    public Jogos(String nome, String plataforma, String genero, boolean multijogador, int nivelDificuldade, int avaliacao) {
        super(nome);
        this.plataforma = plataforma;
        this.genero = genero;
        this.multijogador = multijogador;
        this.nivelDificuldade = nivelDificuldade;
        this.avaliacao = avaliacao;
    }

    // --- IMPLEMENTAÇÃO OBRIGATÓRIA DA CLASSE MÃE ---
    @Override
    public String getPlanoIdeal() {
        return "Atenção ao tempo no ecrã, faça pausas de hora em hora!";
    }

    // --- GETTERS E SETTERS ---

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isMultijogador() {
        return multijogador;
    }

    public void setMultijogador(boolean multijogador) {
        this.multijogador = multijogador;
    }

    public int getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(int nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return super.toString() + " [Jogo: " + plataforma + " | " + genero + "]";
    }
}