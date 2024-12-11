package com.example.stockmaster.Controles.Materiais;

import Aplicaçoes_Sistema_estoque.CadastroMaterialServ;
import Aplicaçoes_Sistema_estoque.Material;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ExibirMaterialController {

    @FXML
    private TextField codigoMaterialField;

    @FXML
    private TextField descricaoCurtaField;

    @FXML
    private TextField unidadeMedidaField;

    @FXML
    private TextField descricaoLongaField;

    @FXML
    private Button exibirButton;

    @FXML
    private Label statusLabel;

    private CadastroMaterialServ cadastroProdutoServ = new CadastroMaterialServ();

    @FXML
    private void handleExibirButtonAction(MouseEvent event) {
        int idMaterial = Integer.parseInt(codigoMaterialField.getText());
        Material produto = cadastroProdutoServ.buscarProdutoPorId(idMaterial);

        if (produto != null) {
            descricaoCurtaField.setText(produto.getDescricao_curta());
            descricaoLongaField.setText(produto.getDescricao_Longa());
            unidadeMedidaField.setText(produto.getUnidade_Medida());
            // Considerando que 'quantidade' não faz parte da tela de exibição de material

            statusLabel.setText("Material exibido com sucesso!");
        } else {
            statusLabel.setText("Material não encontrado.");
        }
    }
}
