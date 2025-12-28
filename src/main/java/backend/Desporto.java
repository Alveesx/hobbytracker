package backend;

import java.io.Serializable;

public class Desporto extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String categoria;               // Individual ou Equipa
    private String materialPrincipal;       // Bola, Raquete, Barco...
    private String objetivo;                // Marcar golos, Fazer pontos...
    private String local;                   // Pavilhão, Ar Livre...
    private int avaliacao;

    public Desporto(String nome, String categoria, String materialPrincipal, String objetivo, String local, int avaliacao) {
        super(nome);
        this.categoria = categoria;
        this.materialPrincipal = materialPrincipal;
        this.objetivo = objetivo;
        this.local = local;
        this.avaliacao = avaliacao;
    }

    // --- GETTERS E SETTERS ---

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMaterialPrincipal() {
        return materialPrincipal;
    }

    public void setMaterialPrincipal(String materialPrincipal) {
        this.materialPrincipal = materialPrincipal;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String getPlanoIdeal() {
        return "Atenção, não te esqueças de te hidratar!";
    }

    @Override
    public String toString() {
        // Formatação ajustada para bater certo com Jogos e Leitura
        return super.toString() + " [" + categoria + " | " + materialPrincipal + " | Obj: " + objetivo + " | " + local + " | Nota: " + avaliacao + "]";
    }
}