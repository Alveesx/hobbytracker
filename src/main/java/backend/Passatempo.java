package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Passatempo implements Serializable {

    // A "Chave Mestra" obrigatória
    private static final long serialVersionUID = 1L;

    protected String nome;
    protected List<Sessao> historico;

    public Passatempo(String nome) {
        this.nome = nome;
        this.historico = new ArrayList<>();
    }

    // Adiciona e ordena logo cronologicamente
    public void adicionarSessao(Sessao s) {
        this.historico.add(s);
        Collections.sort(this.historico);
    }

    // --- MÉTODOS DE ESTATÍSTICA E LÓGICA ---

    public int getMinutosTotais() {
        int total = 0;
        for (Sessao s : historico) {
            total += s.getDuracaoMinutos();
        }
        return total;
    }

    public int getNumSessoesNoMes(int ano, int mes) {
        int count = 0;
        for (Sessao s : historico) {
            if (s.getData().getYear() == ano && s.getData().getMonthValue() == mes) {
                count++;
            }
        }
        return count;
    }

    public boolean isAtivoRecentemente() {
        if (historico.isEmpty()) return false;
        Sessao ultima = historico.get(historico.size() - 1);
        // Verifica se a última sessão foi nos últimos 7 dias
        return !ultima.getData().isBefore(LocalDate.now().minusDays(7));
    }

    // --- GETTERS E ABSTRATOS ---

    public abstract String getPlanoIdeal();

    public String getNome() { return nome; }

    public List<Sessao> getHistorico() { return historico; }

    // --- LÓGICA DE METAS (O que te vai dar o 20) ---

    // Objetivo em minutos para o ano corrente (ex: 3000 min/ano)
    protected int objetivoAnualMinutos = 0;

    public void setObjetivoAnualHoras(int horas) {
        this.objetivoAnualMinutos = horas * 60;
    }

    public int getObjetivoAnualMinutos() {
        return objetivoAnualMinutos;
    }

    // Calcula % de progresso (Crucial para as estatísticas visuais)
    public double getPercentagemConclusao() {
        if (objetivoAnualMinutos == 0) return 0.0;

        int totalEsteAno = 0;
        int anoAtual = LocalDate.now().getYear();

        for (Sessao s : historico) {
            if (s.getData().getYear() == anoAtual) {
                totalEsteAno += s.getDuracaoMinutos();
            }
        }
        return ((double) totalEsteAno / objetivoAnualMinutos) * 100;
    }

    // SETTERS (Obrigatórios para editar dados na Interface Gráfica)

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHistorico(List<Sessao> historico) {
        this.historico = historico;
        Collections.sort(this.historico); // Garante ordenação se substituíres a lista
    }
}