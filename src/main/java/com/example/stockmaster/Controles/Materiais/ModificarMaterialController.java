package com.example.stockmaster.Controles.Materiais;

import Aplicaçoes_Sistema_estoque.CadastroMaterialServ;
import Aplicaçoes_Sistema_estoque.Material;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModificarMaterialController {

    @FXML
    private TextField codigoMaterialField;

    @FXML
    private TextField descricaoCurtaField;

    @FXML
    private TextField unidadeMedidaField;

    @FXML
    private TextField descricaoLongaField;

    @FXML
    private Button modificarButton;

    @FXML
    private Label statusLabel;

    private CadastroMaterialServ cadastroProdutoServ = new CadastroMaterialServ();

    @FXML
    private void handleModificarButtonAction(MouseEvent event) {
        int idMaterial = Integer.parseInt(codigoMaterialField.getText());
        Material produto = cadastroProdutoServ.buscarProdutoPorId(idMaterial);

        if (produto != null) {
            produto.setDescricao_curta(descricaoCurtaField.getText());
            produto.setDescricao_Longa(descricaoLongaField.getText());
            produto.setUnidade_Medida(unidadeMedidaField.getText());

            statusLabel.setText("Material modificado com sucesso!");
        } else {
            statusLabel.setText("Material não encontrado.");
        }
    }
}
