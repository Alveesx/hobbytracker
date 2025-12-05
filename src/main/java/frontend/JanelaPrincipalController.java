package frontend;

// IMPORTS DO BACKEND
import backend.GestorPassatempos;
import backend.Leitura;
import backend.Passatempo;
import backend.Sessao;

// IMPORTS DO JAVAFX
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class JanelaPrincipalController {

    // --- 1. LIGAÇÃO AO SCENE BUILDER (VIEW) ---
    @FXML private TableView<Passatempo> tabelaPassatempos;
    @FXML private TableColumn<Passatempo, String> colNome;
    @FXML private TableColumn<Passatempo, Double> colProgresso;

    // A Caixa de Texto onde escreves o nome
    @FXML private TextField inputNome;

    // O Cérebro do Backend
    private GestorPassatempos gestor;

    // --- 2. INICIALIZAÇÃO ---
    @FXML
    public void initialize() {
        System.out.println("--- CONTROLADOR INICIADO ---");

        gestor = new GestorPassatempos();
        gestor.carregarDados();

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colProgresso.setCellValueFactory(new PropertyValueFactory<>("percentagemConclusao"));

        atualizarTabela();
    }

    // --- 3. AÇÃO DO BOTÃO "ADICIONAR" ---
    @FXML
    public void acaoAdicionar() {
        // A. Ler o texto da caixa
        String nomeDigitado = inputNome.getText();

        // B. Validação
        if (nomeDigitado == null || nomeDigitado.trim().isEmpty()) {
            System.out.println("Aviso: Nome vazio. Nada foi criado.");
            return;
        }

        System.out.println("A criar passatempo: " + nomeDigitado);

        // C. Criar o objeto Leitura
        Leitura novo = new Leitura(nomeDigitado, "Autor Desconhecido", 0.0);
        novo.setObjetivoAnualHoras(100);

        // Adicionar sessão de teste
        Sessao s = new Sessao(LocalDate.now(), 600, "Sessão inicial de teste");
        novo.adicionarSessao(s);

        // D. Guardar no Sistema e na Tabela
        gestor.adicionarPassatempo(novo);
        tabelaPassatempos.getItems().add(novo);

        // Grava no disco IMEDIATAMENTE após adicionar
        gestor.guardarDados();
        System.out.println("Dados guardados no ficheiro com sucesso.");

        // E. Limpar a caixa
        inputNome.clear();
    }

    // --- 4. AÇÃO DO BOTÃO "APAGAR" (NOVO) ---
    @FXML
    public void acaoApagar() {
        // 1. Descobrir qual linha está selecionada (fica azul)
        Passatempo selecionado = tabelaPassatempos.getSelectionModel().getSelectedItem();

        // 2. Proteção: Se o utilizador clicar no botão sem selecionar nada
        if (selecionado == null) {
            System.out.println("Aviso: Nada selecionado para apagar.");
            return;
        }

        System.out.println("A apagar: " + selecionado.getNome());

        // 3. Remover do Backend (Lista real)
        gestor.getLista().remove(selecionado);

        // 4. Remover do Frontend (Lista visual)
        tabelaPassatempos.getItems().remove(selecionado);

        // 5. Gravar a alteração no disco para ser definitivo
        gestor.guardarDados();

        System.out.println("Passatempo removido e ficheiro atualizado.");
    }

    // --- 5. MÉTODOS AUXILIARES ---
    private void atualizarTabela() {
        if (gestor.getLista().isEmpty()) {
            System.out.println("A lista está vazia.");
        }
        ObservableList<Passatempo> dadosVisuais = FXCollections.observableArrayList(gestor.getLista());
        tabelaPassatempos.setItems(dadosVisuais);
    }
}