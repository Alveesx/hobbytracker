package backend;

public class Desporto extends Passatempo {
    private String categoria;               //Individual ou Equipa
    private String materialPrincipal;       //Bola, Raquete, Barco, Apenas o corpo
    private String objetivo;                //Marcar golos, Fazer mais pontos, Chegar primeiro
    private String local;                   //Pavilhão, Ar Livre, Piscina
    private String dificuldade;             //Fácil, Médio, Difícil
    private int avaliacao;

    public Desporto(String nome, String categoria, String materialPrincipal, String objetivo, String local, String dificuldade, int avaliacao) {
        super(nome);
        this.categoria = categoria;
        this.materialPrincipal = materialPrincipal;
        this.objetivo = objetivo;
        this.local = local;
        this.dificuldade = dificuldade;
        this.avaliacao = avaliacao;
    }


    // --- GETTERS E SETTERS ---

    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}


    public String getMaterialPrincipal() {return materialPrincipal;}
    public void setMaterialPrincipal(String materialPrincipal) {this.materialPrincipal = materialPrincipal;}


    public String getObjetivo() {return objetivo;}
    public void setObjetivo(String objetivo) {this.objetivo = objetivo;}


    public String getLocal() {return local;}
    public void setLocal(String local) {this.local = local;}


    public String getDificuldade() {return dificuldade;}
    public void setDificuldade(String dificuldade) {this.dificuldade = dificuldade;}


    public int getAvaliacao() {return avaliacao;}
    public void setAvaliacao(int avaliacao) {this.avaliacao = avaliacao;}


    @Override
    public String getPlanoIdeal() {
        return "Atenção, não te esqueças de te hidratar!";
    }

    @Override
    public String toString() {
        return super.toString() +
                "[Desporto: "+ categoria +" | "+ materialPrincipal +" | " + objetivo +" | "+ local +" | "+ dificuldade +" | "+ avaliacao +"]";
    }
}


