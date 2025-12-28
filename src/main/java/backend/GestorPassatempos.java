package backend;

import java.io.*;
import java.util.ArrayList;

public class GestorPassatempos {

    private ArrayList<Passatempo> passatempos;
    private final String ARQUIVO = "dados.dat";

    public GestorPassatempos() {
        this.passatempos = new ArrayList<Passatempo>();
    }

    public void adicionarPassatempo(Passatempo p) {
        passatempos.add(p);
    }

    public ArrayList<Passatempo> getLista() {
        return passatempos;
    }

    public void guardarDados() {
        try {
            FileOutputStream fos = new FileOutputStream(ARQUIVO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(passatempos);
            oos.close();
            System.out.println("Dados guardados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao guardar: " + e.getMessage());
        }
    }

    public void carregarDados() {
        File f = new File(ARQUIVO);
        if (!f.exists()) {
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            passatempos = (ArrayList<Passatempo>) ois.readObject();
            ois.close();
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao ler ficheiro: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe: " + e.getMessage());
        }
    }
}