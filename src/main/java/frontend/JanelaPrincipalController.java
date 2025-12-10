package frontend;

import backend.GestorPassatempos;
import backend.Leitura;
import backend.Passatempo;
import backend.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class JanelaPrincipalController {

    @FXML private TableView<Passatempo> tabelaPassatempos;
    @FXML private TableColumn<Passatempo, String> colNome;
    @FXML private TableColumn<Passatempo, Double> colProgresso;

    @FXML private TextField inputNome;
    @FXML private TextField inputMinutos;

    private GestorPassatempos gestor;

    @FXML
    public void initialize() {
        gestor = new GestorPassatempos();
        gestor.carregarDados();

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colProgresso.setCellValueFactory(new PropertyValueFactory<>("percentagemConclusao"));

        atualizarTabela();
    }

    // --- AÇÃO: ADICIONAR HOBBY ---
    @FXML
    public void acaoAdicionar() {
        String nome = inputNome.getText();
        if (nome == null || nome.trim().isEmpty()) return;

        // CORREÇÃO: Já não passamos preço, apenas Nome e Autor
        Leitura novo = new Leitura(nome, "Autor Desconhecido");

        // Define meta de 100 horas para haver barra de progresso
        novo.setObjetivoAnualHoras(100);

        gestor.adicionarPassatempo(novo);
        gestor.guardarDados(); // Grava logo para não perder dados

        atualizarTabela();
        inputNome.clear();
    }

    // --- AÇÃO: APAGAR HOBBY ---
    @FXML
    public void acaoApagar() {
        Passatempo selecionado = tabelaPassatempos.getSelectionModel().getSelectedItem();
        if (selecionado == null) return;

        gestor.getLista().remove(selecionado);
        gestor.guardarDados();

        atualizarTabela();
    }

    // --- AÇÃO: REGISTAR SESSÃO ---
    @FXML
    public void acaoRegistarSessao() {
        Passatempo selecionado = tabelaPassatempos.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            System.out.println("Seleciona um hobby primeiro!");
            return;
        }

        String textoMinutos = inputMinutos.getText();
        try {
            int minutos = Integer.parseInt(textoMinutos);

            // Cria a sessão com a data de hoje
            Sessao s = new Sessao(LocalDate.now(), minutos, "Prática registada");

            // Adiciona ao hobby
            selecionado.adicionarSessao(s);

            gestor.guardarDados();

            // Força a tabela a atualizar os números
            tabelaPassatempos.refresh();
            inputMinutos.clear();

        } catch (NumberFormatException e) {
            System.out.println("Erro: Os minutos têm de ser um número!");
        }
    }

    private void atualizarTabela() {
        ObservableList<Passatempo> dados = FXCollections.observableArrayList(gestor.getLista());
        tabelaPassatempos.setItems(dados);
    }
}