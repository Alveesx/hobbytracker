package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPassatempos {
    private List<Passatempo> passatempos;
    private final String ARQUIVO = "dados.dat";

    public GestorPassatempos() {
        this.passatempos = new ArrayList<>();
    }

    public void adicionarPassatempo(Passatempo p) {
        this.passatempos.add(p);
    }

    public void guardarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(passatempos);
            System.out.println("Dados guardados com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro fatal a guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarDados() {
        File f = new File(ARQUIVO);
        if (!f.exists()) return; // Se não existe, começa do zero

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            this.passatempos = (List<Passatempo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro a carregar: " + e.getMessage());
        }
    }

    public List<Passatempo> getLista() { return passatempos; }
}