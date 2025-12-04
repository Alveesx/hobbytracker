package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Passatempo implements Serializable {
    protected String nome;
    protected List<Sessao> historico; // Lista de sessões realizadas

    public Passatempo(String nome) {
        this.nome = nome;
        this.historico = new ArrayList<>();
    }

    public void adicionarSessao(Sessao s) {
        this.historico.add(s);
    }

    // Método abstrato: cada hobby tem de dizer como se planeia
    public abstract String getPlanoIdeal();

    public String getNome() { return nome; }
    public List<Sessao> getHistorico() { return historico; }
}