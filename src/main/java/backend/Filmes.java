package backend;
import java.io.Serializable;

public class Filmes extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;


    private String atores;
    private String producao;
    private String categoria;
    private String plataforma;
    private int avaliacao;

    public Filmes(String nome, String atores, String producao, String categoria, String plataforma, int avaliacao){
        super(nome);
        this.atores = atores;
        this.producao = producao;
        this.categoria = categoria;
        this.plataforma = plataforma;
        this.avaliacao = avaliacao;
    }
// --- GETTERS E SETTERS ---

    public String getAtores() {

        return atores;
    }
    public String getProducao(){
        return producao;
    }
    public String getCategoria(){
        return categoria;
    }
    public String getPlataforma(){
        return plataforma;
    }
    public int getAvaliacao(){
        return avaliacao;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }
    public void setProducao(String producao) {this.producao = producao;
    }
    public void setCategoria(String tipo) {
        this.categoria = categoria;
    }
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    @Override
    public String getPlanoIdeal() {
        return "@@@@@@@@@@@@@@";
    }

    @Override
    public String toString() {
        return "Filme {nome='" + getNome() + "', atores='" + atores + "', producao='" + producao + "', categoria='" + categoria + "', plataforma='" + plataforma + "', avaliacao=" + avaliacao +"}";
    }
}

//Mudar msg
