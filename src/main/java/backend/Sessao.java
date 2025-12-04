package backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Sessao implements Serializable {
    private LocalDate data;
    private int duracaoMinutos;
    private String descricao; // "Corri 5km" ou "Li cap. 3"

    public Sessao(LocalDate data, int duracaoMinutos, String descricao) {
        this.data = data;
        this.duracaoMinutos = duracaoMinutos;
        this.descricao = descricao;
    }

    public LocalDate getData() { return data; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    // Getters e Setters
}