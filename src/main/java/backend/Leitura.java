package backend;

public class Leitura extends Passatempo implements Monetizavel {

    // Chave Mestra para não dar erro de persistência
    private static final long serialVersionUID = 1L;

    private String autor;
    private double precoLivro;
    private int paginas; // Opcional, mas boa ideia ter

    public Leitura(String nome, String autor, double precoLivro) {
        super(nome);
        this.autor = autor;
        this.precoLivro = precoLivro;
    }

    @Override
    public double getCusto() {
        return precoLivro;
    }

    @Override
    public String getMoeda() {
        return "EUR";
    }

    @Override
    public String getPlanoIdeal() {
        return "Ler 30 minutos por dia antes de dormir.";
    }

    // --- GETTERS E SETTERS ESPECÍFICOS DE LEITURA ---
    // (O JavaFX vai precisar disto para criar as colunas da tabela)

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecoLivro() {
        return precoLivro;
    }

    public void setPrecoLivro(double precoLivro) {
        this.precoLivro = precoLivro;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}