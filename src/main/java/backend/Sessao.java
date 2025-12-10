package backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Sessao implements Serializable, Comparable<Sessao> {

    private static final long serialVersionUID = 1L;
    private LocalDate data;
    private int duracaoMinutos;
    private String descricao;

    // Construtor: cria uma sessão com data, duração em minutos e descrição
    public Sessao(LocalDate data, int duracaoMinutos, String descricao) {
        this.data = data;
        this.duracaoMinutos = duracaoMinutos;
        this.descricao = descricao;
    }

    // Retorna a data da sessão
    public LocalDate getData() {
        return data;
    }

    // Retorna a duração da sessão em minutos
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    // Retorna a descrição da sessão
    public String getDescricao() {
        return descricao;
    }

    // Compara esta sessão com outra pela data (para ordenação)
    @Override
    public int compareTo(Sessao outra) {
        return this.data.compareTo(outra.getData());
    }

    // Retorna uma representação em texto da sessão (data e duração)
    @Override
    public String toString() {
        return data + ": " + duracaoMinutos + " min";
    }
}
