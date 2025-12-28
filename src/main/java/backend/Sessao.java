package backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Sessao implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate data;
    private double horas;
    private String descricao;

    public Sessao(LocalDate data, double horas, String descricao) {
        this.data = data;
        this.horas = horas;
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return data + " - " + horas + " h (" + descricao + ")";
    }
}