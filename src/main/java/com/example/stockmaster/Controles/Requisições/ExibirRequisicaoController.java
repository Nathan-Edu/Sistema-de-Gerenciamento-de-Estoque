package com.example.stockmaster.Controles.Requisições;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ExibirRequisicaoController {

    @FXML
    private TextField numeroRcField;

    @FXML
    private TextField solicitanteField;

    @FXML
    private TextField materialField;

    @FXML
    private TextField quantidadeField;

    @FXML
    private TextField dataField;

    @FXML
    private Button salvarButton;

    @FXML
    private Button voltarButton;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleSalvarButtonAction(MouseEvent event) {
        // Implementar lógica para salvar a requisição exibida
        String numeroRc = numeroRcField.getText();
        String solicitante = solicitanteField.getText();
        String material = materialField.getText();
        String quantidade = quantidadeField.getText();
        String data = dataField.getText();

        // Lógica para salvar a requisição no sistema
        statusLabel.setText("Requisição salva com sucesso!");
    }

    @FXML
    private void handleVoltarButtonAction(MouseEvent event) {
        // Implementar lógica para voltar à tela anterior
    }
}

