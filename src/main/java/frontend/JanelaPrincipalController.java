package frontend;

// IMPORTS DO BACKEND (O Java tem de encontrar estas classes na pasta backend)
import backend.GestorPassatempos;
import backend.Leitura;
import backend.Passatempo;
import backend.Sessao;

// IMPORTS DO JAVAFX (Para a janela funcionar)
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField; // <--- Faltava este para a caixa de texto
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate; // Para a data da sessão

public class JanelaPrincipalController {

    // --- 1. LIGAÇÃO AO SCENE BUILDER (VIEW) ---
    // Estes nomes têm de ser IGUAIS aos fx:id do Scene Builder

    @FXML private TableView<Passatempo> tabelaPassatempos;
    @FXML private TableColumn<Passatempo, String> colNome;
    @FXML private TableColumn<Passatempo, Double> colProgresso;

    // A Caixa de Texto onde escreves o nome
    @FXML private TextField inputNome;

    // O Cérebro do Backend
    private GestorPassatempos gestor;

    // --- 2. INICIALIZAÇÃO (Corre automaticamente ao abrir) ---
    @FXML
    public void initialize() {
        System.out.println("--- CONTROLADOR INICIADO ---");

        // Preparar o Gestor
        gestor = new GestorPassatempos();
        gestor.carregarDados();

        // Configurar as Colunas da Tabela
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colProgresso.setCellValueFactory(new PropertyValueFactory<>("percentagemConclusao"));

        // Mostrar os dados que já existem
        atualizarTabela();
    }

    // --- 3. AÇÃO DO BOTÃO "ADICIONAR" ---
    @FXML
    public void acaoAdicionar() {
        // A. Ler o texto da caixa
        String nomeDigitado = inputNome.getText();

        // B. Validação: Se estiver vazio, não faz nada
        if (nomeDigitado == null || nomeDigitado.trim().isEmpty()) {
            System.out.println("Aviso: Nome vazio. Nada foi criado.");
            return;
        }

        System.out.println("A criar passatempo: " + nomeDigitado);

        // C. Criar o objeto Leitura (Backend)
        Leitura novo = new Leitura(nomeDigitado, "Autor Desconhecido", 0.0);
        novo.setObjetivoAnualHoras(100); // Meta fixa de 100h para teste

        // TRUQUE: Adicionar uma sessão de teste só para veres a barra de progresso a mexer
        Sessao s = new Sessao(LocalDate.now(), 600, "Sessão inicial de teste");
        novo.adicionarSessao(s);

        // D. Guardar no Sistema e na Tabela
        gestor.adicionarPassatempo(novo);
        tabelaPassatempos.getItems().add(novo);

        // E. Limpar a caixa de texto para ficares pronto para o próximo
        inputNome.clear();
    }

    // --- 4. MÉTODOS AUXILIARES ---
    private void atualizarTabela() {
        if (gestor.getLista().isEmpty()) {
            System.out.println("A lista está vazia.");
        }
        // Converte a lista do backend para lista visual
        ObservableList<Passatempo> dadosVisuais = FXCollections.observableArrayList(gestor.getLista());
        tabelaPassatempos.setItems(dadosVisuais);
    }
}