package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private List<Sessao> historico;
    private int objetivoAnualHoras;

    public Passatempo(String nome) {
        this.nome = nome;
        this.historico = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Sessao> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Sessao> historico) {
        this.historico = historico;
    }

    public int getObjetivoAnualHoras() {
        return objetivoAnualHoras;
    }

    public void setObjetivoAnualHoras(int objetivoAnualHoras) {
        this.objetivoAnualHoras = objetivoAnualHoras;
    }

    public void adicionarSessao(Sessao s) {
        historico.add(s);
    }

    public double getHorasTotais() {
        double total = 0;
        for (Sessao s : historico) {
            total += s.getHoras();
        }
        return total;
    }

    public String getTempoTotalFormatado() {
        return String.format("%.1f Horas", getHorasTotais());
    }

    public String getPlanoIdeal() {
        return "Divirta-se com o seu passatempo!";
    }

    @Override
    public String toString() {
        return "ID: " + nome;
    }
}