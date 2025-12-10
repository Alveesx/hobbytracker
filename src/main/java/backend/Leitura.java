package backend;

import java.io.Serializable;

public class Leitura extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String autor;

    // Construtor: cria uma leitura com nome e autor
    public Leitura(String nome, String autor) {
        super(nome);
        this.autor = autor;
    }

    // Retorna o autor do livro
    public String getAutor() {
        return autor;
    }

    // Altera o autor do livro
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Retorna o plano ideal para este tipo de passatempo
    @Override
    public String getPlanoIdeal() {
        return "Ler um capitulo por dia";
    }

    // Retorna uma representação em texto da leitura (inclui ID, nome e autor)
    @Override
    public String toString() {
        return super.toString() + " Autor: " + autor;
    }
}
