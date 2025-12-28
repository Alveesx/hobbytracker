package frontend;

import backend.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class JanelaPrincipalController {

    @FXML private TableView<Passatempo> tabelaPassatempos;
    @FXML private TableColumn<Passatempo, String> colNome;
    @FXML private TableColumn<Passatempo, Double> colProgresso;

    @FXML private TextField inputNome;
    @FXML private ComboBox<String> comboTipo;

    // Campos Genéricos
    @FXML private Label lblCampo1, lblCampo2, lblCampo3, lblCampo4, lblCampo5;
    @FXML private TextField txtCampo1, txtCampo2, txtCampo3, txtCampo4, txtCampo5;

    @FXML private TextField inputMinutos;

    private GestorPassatempos gestor;

    @FXML
    public void initialize() {
        gestor = new GestorPassatempos();
        gestor.carregarDados();

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colProgresso.setCellValueFactory(new PropertyValueFactory<>("percentagemConclusao"));
        atualizarTabela();

        comboTipo.getItems().addAll("Leitura", "Jogo", "Filme", "Música", "Desporto");
        comboTipo.setOnAction(event -> atualizarFormularioVisual());
        comboTipo.getSelectionModel().selectFirst();
        atualizarFormularioVisual();
    }

    // --- MUDANÇA 1: MOSTRAR O CAMPO DE AVALIAÇÃO NA LEITURA ---
    private void atualizarFormularioVisual() {
        String tipo = comboTipo.getValue();
        if (tipo == null) return;

        txtCampo1.clear(); txtCampo2.clear(); txtCampo3.clear(); txtCampo4.clear(); txtCampo5.clear();

        switch (tipo) {
            case "Leitura":
                configurarCampo(1, "Autor");
                configurarCampo(2, "Género");
                configurarCampo(3, "Nº Páginas");
                configurarCampo(4, "Avaliação (1-10)"); // <--- AGORA ESTE APARECE
                esconderCampo(5);                        // Só o 5 fica escondido
                break;

            case "Jogo":
                configurarCampo(1, "Plataforma");
                configurarCampo(2, "Género");
                configurarCampo(3, "Online? (Sim/Não)");
                configurarCampo(4, "Dificuldade (1-5)");
                configurarCampo(5, "Avaliação (1-10)");
                break;

            case "Filme":
                configurarCampo(1, "Atores");
                configurarCampo(2, "Produção");
                configurarCampo(3, "Categoria");
                configurarCampo(4, "Plataforma");
                configurarCampo(5, "Avaliação (1-10)");
                break;

            case "Música":
                configurarCampo(1, "Artista");
                configurarCampo(2, "Álbum");
                configurarCampo(3, "Género");
                configurarCampo(4, "Avaliação (1-10)");
                esconderCampo(5);
                break;

            case "Desporto":
                configurarCampo(1, "Categoria (Ind/Equi)");
                configurarCampo(2, "Material");
                configurarCampo(3, "Objetivo");
                configurarCampo(4, "Local");
                configurarCampo(5, "Avaliação (0-10)");
                break;
        }
    }

    private void configurarCampo(int id, String texto) {
        if (id == 1) { lblCampo1.setText(texto); lblCampo1.setVisible(true); txtCampo1.setVisible(true); }
        if (id == 2) { lblCampo2.setText(texto); lblCampo2.setVisible(true); txtCampo2.setVisible(true); }
        if (id == 3) { lblCampo3.setText(texto); lblCampo3.setVisible(true); txtCampo3.setVisible(true); }
        if (id == 4) { lblCampo4.setText(texto); lblCampo4.setVisible(true); txtCampo4.setVisible(true); }
        if (id == 5) { lblCampo5.setText(texto); lblCampo5.setVisible(true); txtCampo5.setVisible(true); }
    }

    private void esconderCampo(int id) {
        if (id == 1) { lblCampo1.setVisible(false); txtCampo1.setVisible(false); }
        if (id == 2) { lblCampo2.setVisible(false); txtCampo2.setVisible(false); }
        if (id == 3) { lblCampo3.setVisible(false); txtCampo3.setVisible(false); }
        if (id == 4) { lblCampo4.setVisible(false); txtCampo4.setVisible(false); }
        if (id == 5) { lblCampo5.setVisible(false); txtCampo5.setVisible(false); }
    }

    // --- MUDANÇA 2: LER O VALOR QUANDO CLICAS ADICIONAR ---
    @FXML
    public void acaoAdicionar() {
        String nome = inputNome.getText();
        String tipo = comboTipo.getValue();

        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: O nome é obrigatório.");
            return;
        }

        try {
            Passatempo novo = null;

            switch (tipo) {
                case "Leitura":
                    int paginas = Integer.parseInt(txtCampo3.getText());
                    int notaLeitura = Integer.parseInt(txtCampo4.getText());

                    novo = new Leitura(nome, txtCampo1.getText(), txtCampo2.getText(), paginas, notaLeitura);
                    novo.setObjetivoAnualHoras(100);
                    break;

                case "Jogo":
                    boolean online = txtCampo3.getText().equalsIgnoreCase("Sim");
                    novo = new Jogos(nome, txtCampo1.getText(), txtCampo2.getText(), online, Integer.parseInt(txtCampo4.getText()), Integer.parseInt(txtCampo5.getText()));
                    novo.setObjetivoAnualHoras(200);
                    break;

                case "Filme":
                    novo = new Filmes(nome, txtCampo1.getText(), txtCampo2.getText(), txtCampo3.getText(), txtCampo4.getText(), Integer.parseInt(txtCampo5.getText()));
                    novo.setObjetivoAnualHoras(150);
                    break;

                case "Música":
                    novo = new Música(nome, txtCampo1.getText(), txtCampo2.getText(), txtCampo3.getText(), Integer.parseInt(txtCampo4.getText()));
                    novo.setObjetivoAnualHoras(300);
                    break;

                case "Desporto":
                    novo = new Desporto(nome, txtCampo1.getText(), txtCampo2.getText(), txtCampo3.getText(), txtCampo4.getText(), Integer.parseInt(txtCampo5.getText()));
                    novo.setObjetivoAnualHoras(120);
                    break;
            }

            if (novo != null) {
                gestor.adicionarPassatempo(novo);
                gestor.guardarDados();
                atualizarTabela();

                inputNome.clear();
                atualizarFormularioVisual();
                System.out.println("Adicionado: " + tipo);
            }

        } catch (NumberFormatException e) {
            System.out.println("Erro: Verifica os campos numéricos (Páginas, Avaliação, Dificuldade)!");
        }
    }

    @FXML
    public void acaoApagar() {
        Passatempo selecionado = tabelaPassatempos.getSelectionModel().getSelectedItem();
        if (selecionado == null) return;
        gestor.getLista().remove(selecionado);
        gestor.guardarDados();
        atualizarTabela();
    }

    @FXML
    public void acaoRegistarSessao() {
        Passatempo selecionado = tabelaPassatempos.getSelectionModel().getSelectedItem();
        if (selecionado == null) return;
        try {
            int minutos = Integer.parseInt(inputMinutos.getText());
            selecionado.adicionarSessao(new Sessao(LocalDate.now(), minutos, "Sessão manual"));
            gestor.guardarDados();
            tabelaPassatempos.refresh();
            inputMinutos.clear();
        } catch (NumberFormatException e) {
            System.out.println("Erro: Minutos inválidos.");
        }
    }

    private void atualizarTabela() {
        ObservableList<Passatempo> dados = FXCollections.observableArrayList(gestor.getLista());
        tabelaPassatempos.setItems(dados);
    }
}