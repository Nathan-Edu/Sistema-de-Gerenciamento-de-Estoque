package com.example.stockmaster.Controles.Lotes;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ModificarLoteController {

    @FXML
    private TextField codigoLoteField;

    @FXML
    private TextField codigoMaterialField;

    @FXML
    private TextField quantidadeField;

    @FXML
    private TextField dataField;

    @FXML
    private Button modificarButton;

    @FXML
    private Button voltarButton;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleModificarButtonAction() {
        // Implementar lógica para modificar o lote existente
        String codigoLote = codigoLoteField.getText();
        String codigoMaterial = codigoMaterialField.getText();
        String quantidade = quantidadeField.getText();
        String data = dataField.getText();

        statusLabel.setText("Lote modificado com sucesso!");
    }

    @FXML
    private void handleVoltarButtonAction() {
        // Implementar lógica para voltar à tela anterior
    }
}