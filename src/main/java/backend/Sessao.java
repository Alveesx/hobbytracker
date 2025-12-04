package backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Sessao implements Serializable, Comparable<Sessao> {
    private static final long serialVersionUID = 1L;

    private LocalDate data;
    private int duracaoMinutos;
    private String descricao;

    public Sessao(LocalDate data, int duracaoMinutos, String descricao) {
        this.data = data;
        this.duracaoMinutos = duracaoMinutos;
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public String getDescricao() {
        return descricao;
    }

    // Este método ensina a Sessão a comparar-se com outra para ver quem vem primeiro
    @Override
    public int compareTo(Sessao outraSessao) {
        return this.data.compareTo(outraSessao.getData());
    }
}