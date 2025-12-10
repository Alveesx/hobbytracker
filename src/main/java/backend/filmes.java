package backend;
import java.io.Serializable;
import java.time.LocalDateTime;

public class filmes extends Passatempo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String atores;
    private String producao;
    private String tipo;
    private String plataforma;
    private int avaliacao;

    public filmes(String nome,String atores,String producao,String tipo,String plataforma,int avaliacao){
        super(nome)
        this.atores = atores;
        this.producao = producao;
        this.tipo=tipo;
        this.plataforma=plataforma;
        this.avaliacao=avaliacao;
    }
    @Override
    public String getPlanoIdeal() {
        return "";
    }

