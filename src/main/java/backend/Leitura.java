package backend;

public class Leitura extends Passatempo implements Monetizavel {
    private String autor;
    private double precoLivro;

    public Leitura(String nome, String autor, double precoLivro) {
        super(nome);
        this.autor = autor;
        this.precoLivro = precoLivro;
    }

    @Override
    public double getCusto() {
        return precoLivro; // Simples por agora, pode evoluir
    }

    @Override
    public String getMoeda() {
        return "EUR";
    }

    @Override
    public String getPlanoIdeal() {
        return "Ler pelo menos 30 min antes de dormir.";
    }
}