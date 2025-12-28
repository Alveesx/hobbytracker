package frontend;

import backend.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class JanelaPrincipalController {

    @FXML private TableView<Passatempo> tabelaPassatempos;

    @FXML private TableColumn<Passatempo, String> colNome;
    @FXML private TableColumn<Passatempo, String> colTipo;
    @FXML private TableColumn<Passatempo, String> colPrincipal;
    @FXML private TableColumn<Passatempo, String> colSecundaria;
    @FXML private TableColumn<Passatempo, String> colDetalhe1;
    @FXML private TableColumn<Passatempo, String> colDetalhe2;
    @FXML private TableColumn<Passatempo, String> colAvaliacao;
    @FXML private TableColumn<Passatempo, String> colTempoTotal;

    @FXML private TextField inputNome;
    @FXML private ComboBox<String> comboTipo;
    @FXML private Label lblCampo1, lblCampo2, lblCampo3, lblCampo4, lblCampo5;
    @FXML private TextField txtCampo1, txtCampo2, txtCampo3, txtCampo4, txtCampo5;

    @FXML private TextField inputHoras;

    private GestorPassatempos gestor;

    @FXML
    public void initialize() {
        gestor = new GestorPassatempos();
        gestor.carregarDados();

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));

        colPrincipal.setCellValueFactory(cellData -> {
            Passatempo p = cellData.getValue();
            if (p instanceof Leitura) return new SimpleStringProperty(((Leitura) p).getAutor());
            if (p instanceof Filmes)  return new SimpleStringProperty(((Filmes) p).getRealizador());
            if (p instanceof Música)  return new SimpleStringProperty(((Música) p).getArtista());
            if (p instanceof Jogos)   return new SimpleStringProperty(((Jogos) p).getPlataforma());
            if (p instanceof Desporto) return new SimpleStringProperty(((Desporto) p).getCategoria());
            return new SimpleStringProperty("-");
        });

        colSecundaria.setCellValueFactory(cellData -> {
            Passatempo p = cellData.getValue();
            if (p instanceof Leitura) return new SimpleStringProperty(((Leitura) p).getGenero());
            if (p instanceof Filmes)  return new SimpleStringProperty(((Filmes) p).getCategoria());
            if (p instanceof Música)  return new SimpleStringProperty(((Música) p).getGenero());
            if (p instanceof Jogos)   return new SimpleStringProperty(((Jogos) p).getGenero());
            if (p instanceof Desporto) return new SimpleStringProperty(((Desporto) p).getLocal());
            return new SimpleStringProperty("-");
        });

        colDetalhe1.setCellValueFactory(cellData -> {
            Passatempo p = cellData.getValue();
            if (p instanceof Leitura) return new SimpleStringProperty(((Leitura) p).getNumPaginas() + " págs");
            if (p instanceof Filmes)  return new SimpleStringProperty(((Filmes) p).getPlataforma());
            if (p instanceof Música)  return new SimpleStringProperty(((Música) p).getAlbum());
            if (p instanceof Jogos)   return new SimpleStringProperty(((Jogos) p).isMultijogador() ? "Online" : "Offline");
            return new SimpleStringProperty("-");
        });

        colDetalhe2.setCellValueFactory(cellData -> {
            Passatempo p = cellData.getValue();
            if (p instanceof Jogos) return new SimpleStringProperty(((Jogos) p).getNivelDificuldade() + "/5");
            return new SimpleStringProperty("-");
        });

        colAvaliacao.setCellValueFactory(cellData -> {
            Passatempo p = cellData.getValue();
            int nota = 0;
            if (p instanceof Leitura) nota = ((Leitura) p).getAvaliacao();
            if (p instanceof Filmes)  nota = ((Filmes) p).getAvaliacao();
            if (p instanceof Música)  nota = ((Música) p).getAvaliacao();
            if (p instanceof Jogos)   nota = ((Jogos) p).getAvaliacao();
            if (p instanceof Desporto) nota = ((Desporto) p).getAvaliacao();
            return new SimpleStringProperty(nota + "/10");
        });

        colTempoTotal.setCellValueFactory(new PropertyValueFactory<>("tempoTotalFormatado"));

        atualizarTabela();

        comboTipo.getItems().addAll("Leitura", "Jogo", "Filme", "Música", "Desporto");
        comboTipo.setOnAction(event -> atualizarFormularioVisual());
        comboTipo.getSelectionModel().selectFirst();
        atualizarFormularioVisual();
    }

    private void atualizarFormularioVisual() {
        String tipo = comboTipo.getValue();
        if (tipo == null) return;

        txtCampo1.clear(); txtCampo2.clear(); txtCampo3.clear(); txtCampo4.clear(); txtCampo5.clear();

        switch (tipo) {
            case "Leitura":
                configurarCampo(1, "Autor"); configurarCampo(2, "Género"); configurarCampo(3, "Nº Páginas"); configurarCampo(4, "Avaliação (0-10)"); esconderCampo(5);
                break;
            case "Filme":
                configurarCampo(1, "Realizador"); configurarCampo(2, "Categoria"); configurarCampo(3, "Plataforma"); configurarCampo(4, "Avaliação (0-10)"); esconderCampo(5);
                break;
            case "Música":
                configurarCampo(1, "Artista"); configurarCampo(2, "Álbum"); configurarCampo(3, "Género"); configurarCampo(4, "Avaliação (0-10)"); esconderCampo(5);
                break;
            case "Jogo":
                configurarCampo(1, "Plataforma"); configurarCampo(2, "Género"); configurarCampo(3, "Online? (Sim/Não)"); configurarCampo(4, "Dificuldade (1-5)"); configurarCampo(5, "Avaliação (0-10)");
                break;
            case "Desporto":
                configurarCampo(1, "Categoria (Ind/Equipa)");
                configurarCampo(2, "Local");
                configurarCampo(3, "Avaliação (0-10)");
                esconderCampo(4);
                esconderCampo(5);
                break;
        }
    }

    @FXML
    public void acaoAdicionar() {
        String nome = inputNome.getText();
        String tipo = comboTipo.getValue();

        if (nome == null || nome.trim().isEmpty()) { mostrarAlerta("Aviso", "Escreve um nome!"); return; }

        try {
            Passatempo novo = null;
            switch (tipo) {
                case "Leitura":
                    novo = new Leitura(nome, txtCampo1.getText(), txtCampo2.getText(), Integer.parseInt(txtCampo3.getText()), Integer.parseInt(txtCampo4.getText()));
                    novo.setObjetivoAnualHoras(100); break;

                case "Filme":
                    novo = new Filmes(nome, txtCampo1.getText(), txtCampo2.getText(), txtCampo3.getText(), Integer.parseInt(txtCampo4.getText()));
                    novo.setObjetivoAnualHoras(150); break;

                case "Música":
                    novo = new Música(nome, txtCampo1.getText(), txtCampo2.getText(), txtCampo3.getText(), Integer.parseInt(txtCampo4.getText()));
                    novo.setObjetivoAnualHoras(300); break;

                case "Jogo":
                    boolean online = txtCampo3.getText().equalsIgnoreCase("Sim");
                    novo = new Jogos(nome, txtCampo1.getText(), txtCampo2.getText(), online, Integer.parseInt(txtCampo4.getText()), Integer.parseInt(txtCampo5.getText()));
                    novo.setObjetivoAnualHoras(200); break;

                case "Desporto":
                    novo = new Desporto(nome, txtCampo1.getText(), txtCampo2.getText(), Integer.parseInt(txtCampo3.getText()));
                    novo.setObjetivoAnualHoras(120); break;
            }

            if (novo != null) {
                gestor.adicionarPassatempo(novo);
                gestor.guardarDados();
                atualizarTabela();
                inputNome.clear();
                atualizarFormularioVisual();
            }
        } catch (Exception e) {
            mostrarAlerta("Erro", "Verifica se os campos de números estão corretos!");
            e.printStackTrace();
        }
    }

    @FXML public void acaoRegistarSessao() {
        Passatempo selecionado = tabelaPassatempos.getSelectionModel().getSelectedItem();
        if (selecionado == null) { mostrarAlerta("Erro", "Seleciona um hobby primeiro!"); return; }
        try {
            String texto = inputHoras.getText().replace(',', '.');
            double horas = Double.parseDouble(texto);

            selecionado.adicionarSessao(new Sessao(LocalDate.now(), horas, "Sessão Manual"));

            gestor.guardarDados();
            tabelaPassatempos.refresh();
            inputHoras.clear();
            mostrarAlerta("Sucesso", "Adicionados " + horas + " horas!");
        } catch (NumberFormatException e) { mostrarAlerta("Erro", "Número inválido! Usa ex: 0.5"); }
    }

    @FXML public void acaoApagar() {
        Passatempo sel = tabelaPassatempos.getSelectionModel().getSelectedItem();
        if (sel != null) { gestor.getLista().remove(sel); gestor.guardarDados(); atualizarTabela(); }
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo); alert.setHeaderText(null); alert.setContentText(mensagem); alert.showAndWait();
    }

    private void atualizarTabela() {
        ObservableList<Passatempo> dados = FXCollections.observableArrayList(gestor.getLista());
        tabelaPassatempos.setItems(dados);
    }

    private void configurarCampo(int id, String txt) {
        if (id==1) {lblCampo1.setText(txt);lblCampo1.setVisible(true);txtCampo1.setVisible(true);}
        if (id==2) {lblCampo2.setText(txt);lblCampo2.setVisible(true);txtCampo2.setVisible(true);}
        if (id==3) {lblCampo3.setText(txt);lblCampo3.setVisible(true);txtCampo3.setVisible(true);}
        if (id==4) {lblCampo4.setText(txt);lblCampo4.setVisible(true);txtCampo4.setVisible(true);}
        if (id==5) {lblCampo5.setText(txt);lblCampo5.setVisible(true);txtCampo5.setVisible(true);}
    }

    private void esconderCampo(int id) {
        if (id==1) {lblCampo1.setVisible(false);txtCampo1.setVisible(false);}
        if (id==2) {lblCampo2.setVisible(false);txtCampo2.setVisible(false);}
        if (id==3) {lblCampo3.setVisible(false);txtCampo3.setVisible(false);}
        if (id==4) {lblCampo4.setVisible(false);txtCampo4.setVisible(false);}
        if (id==5) {lblCampo5.setVisible(false);txtCampo5.setVisible(false);}
    }
}