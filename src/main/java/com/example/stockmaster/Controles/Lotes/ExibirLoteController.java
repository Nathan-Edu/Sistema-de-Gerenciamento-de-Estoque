package com.example.stockmaster.Controles.Lotes;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ExibirLoteController {

    @FXML
    private TextField codigoLoteField;

    @FXML
    private Button exibirButton;

    @FXML
    private Label resultadoLabel;

    @FXML
    private void handleExibirButtonAction() {
        // Implementar lógica para exibir informações do lote
        String codigoLote = codigoLoteField.getText();
        resultadoLabel.setText("Informações do lote exibidas.");
    }
}
