package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int ultimo = 0;

    private int uid;
    protected String nome;
    protected ArrayList<Sessao> historico;
    protected int objetivoAnualMinutos;

    // Construtor
    public Passatempo(String nome) {
        ultimo++;
        this.uid = ultimo;
        this.nome = nome;
        this.historico = new ArrayList<Sessao>();
        this.objetivoAnualMinutos = 0;
    }

    // Retorna o último UID atribuído
    public static int getUltimo() {
        return ultimo;
    }

    // Define o último UID
    public static void setUltimo(int u) {
        ultimo = u;
    }

    // Retorna o UID único
    public String getUid() {
        return String.valueOf(uid);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Sessao> getHistorico() {
        return historico;
    }

    public void adicionarSessao(Sessao s) {
        historico.add(s);
        Collections.sort(historico);
    }

    public void setObjetivoAnualHoras(int horas) {
        this.objetivoAnualMinutos = horas * 60;
    }

    public double getPercentagemConclusao() {
        if (objetivoAnualMinutos == 0) {
            return 0.0;
        }
        int total = 0;
        int anoAtual = LocalDate.now().getYear();
        for (int i = 0; i < historico.size(); i++) {
            Sessao s = historico.get(i);
            if (s.getData().getYear() == anoAtual) {
                total += s.getDuracaoMinutos();
            }
        }
        return (double) total / objetivoAnualMinutos * 100;
    }

    public String getPlanoIdeal() {
        return "Praticar com regularidade e moderação.";
    }

    @Override
    public String toString() {
        return "UID: " + uid + " Nome: " + nome;
    }
}