package com.example.stockmaster.Controles.Lotes;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;

public class ListaLoteController {

    @FXML
    private TableView<?> tabelaEstoque;

    @FXML
    private TableColumn<?, ?> codigoLoteColumn;

    @FXML
    private TableColumn<?, ?> materialColumn;

    @FXML
    private TableColumn<?, ?> quantidadeColumn;

    @FXML
    private TableColumn<?, ?> dataEntradaColumn;

    @FXML
    private Button adicionarButton;

    @FXML
    private Button salvarButton;

    @FXML
    private Button voltarButton;

    @FXML
    private void handleAdicionarButtonAction() {
        // Implementar lógica para adicionar um novo lote
    }

    @FXML
    private void handleSalvarButtonAction() {
        // Implementar lógica para salvar as alterações
    }

    @FXML
    private void handleVoltarButtonAction() {
        // Implementar lógica para voltar à tela anterior
    }
}

