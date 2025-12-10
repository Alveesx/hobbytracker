package backend;

import java.io.*;
import java.util.ArrayList;

public class GestorPassatempos {

    private ArrayList<Passatempo> passatempos;
    private final String ARQUIVO = "dados.dat";

    // Construtor: inicializa a lista de passatempos vazia
    public GestorPassatempos() {
        this.passatempos = new ArrayList<Passatempo>();
    }

    // Adiciona um passatempo à lista
    public void adicionarPassatempo(Passatempo p) {
        passatempos.add(p);
    }

    // Retorna a lista completa de passatempos
    public ArrayList<Passatempo> getLista() {
        return passatempos;
    }

    // Guarda todos os dados no ficheiro
    // Serializa o último ID e a lista de passatempos
    public void guardarDados() {
        try {
            FileOutputStream fos = new FileOutputStream(ARQUIVO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(Passatempo.getUltimo());
            oos.writeObject(passatempos);

            oos.close();
            System.out.println("Dados guardados com sucesso.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Carrega os dados do ficheiro
    // Restaura o último ID e a lista de passatempos
    public void carregarDados() {
        File f = new File(ARQUIVO);
        // Se o ficheiro não existe, não faz nada
        if (!f.exists()) {
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Lê o último ID atribuído
            int ultimo = ois.readInt();
            Passatempo.setUltimo(ultimo);

            // Lê a lista de passatempos
            passatempos = (ArrayList<Passatempo>) ois.readObject();

            ois.close();
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
