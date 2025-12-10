package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int ultimo = 0;

    private int id;
    protected String nome;
    protected ArrayList<Sessao> historico;
    protected int objetivoAnualMinutos;

    // Construtor: cria um passatempo com nome e atribui um ID único automático
    public Passatempo(String nome) {
        ultimo++;
        this.id = ultimo;
        this.nome = nome;
        this.historico = new ArrayList<Sessao>();
        this.objetivoAnualMinutos = 0;
    }

    // Retorna o último ID atribuído
    public static int getUltimo() {
        return ultimo;
    }

    // Define o último ID (usado ao carregar dados guardados)
    public static void setUltimo(int u) {
        ultimo = u;
    }

    // Retorna o ID único deste passatempo
    public int getId() {
        return id;
    }

    // Retorna o nome do passatempo
    public String getNome() {
        return nome;
    }

    // Altera o nome do passatempo
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna a lista completa de sessões realizadas
    public ArrayList<Sessao> getHistorico() {
        return historico;
    }

    // Adiciona uma nova sessão ao histórico e ordena a lista
    public void adicionarSessao(Sessao s) {
        historico.add(s);
        Collections.sort(historico);
    }

    // Define o objetivo anual em horas (convertido internamente para minutos)
    public void setObjetivoAnualHoras(int horas) {
        this.objetivoAnualMinutos = horas * 60;
    }

    // Calcula a percentagem de conclusão do objetivo anual
    // Soma apenas as sessões do ano corrente e divide pelo objetivo
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

    // Método abstrato: cada tipo de passatempo deve implementar o seu plano ideal
    public abstract String getPlanoIdeal();

    // Retorna uma representação em texto do passatempo (ID e nome)
    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nome;
    }
}
