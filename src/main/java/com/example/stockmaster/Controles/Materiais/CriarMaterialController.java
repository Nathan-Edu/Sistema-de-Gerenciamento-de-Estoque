package com.example.stockmaster.Controles.Materiais;

import Aplicaçoes_Sistema_estoque.CadastroMaterialServ;
import Aplicaçoes_Sistema_estoque.Material;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CriarMaterialController {

    @FXML
    private TextField codigoMaterialField;

    @FXML
    private TextField descricaoCurtaField;

    @FXML
    private TextField unidadeMedidaField;

    @FXML
    private TextField descricaoLongaField;

    @FXML
    private Button salvarButton;

    @FXML
    private Button voltarButton;

    @FXML
    private Label statusLabel;

    private CadastroMaterialServ cadastroProdutoServ = new CadastroMaterialServ();

    @FXML
    private void handleSalvarButtonAction(MouseEvent event) {
        int idMaterial = Integer.parseInt(codigoMaterialField.getText());
        String descricaoCurta = descricaoCurtaField.getText();
        String descricaoLonga = descricaoLongaField.getText();
        int quantidade = 0;  // Inicialmente 0, pois estamos apenas criando o produto
        String unidadeMedida = unidadeMedidaField.getText();
        String deposito = "";  // Caso necessário

        Material produto = new Material(idMaterial, descricaoCurta, descricaoLonga, quantidade, unidadeMedida, deposito);
        cadastroProdutoServ.adicionaProduto(produto);

        statusLabel.setText("Material salvo com sucesso!");
    }

    @FXML
    private void handleVoltarButtonAction(MouseEvent event) {
        // Implementar lógica para voltar à tela anterior
    }
}
