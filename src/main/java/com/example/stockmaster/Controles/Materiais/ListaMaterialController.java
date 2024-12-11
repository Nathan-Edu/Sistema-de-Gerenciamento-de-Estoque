package com.example.stockmaster.Controles.Materiais;

import Aplicaçoes_Sistema_estoque.CadastroMaterialServ;
import Aplicaçoes_Sistema_estoque.Material;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaMaterialController {

    @FXML
    private TableView<Material> tabelaMateriais;

    @FXML
    private TableColumn<Material, Integer> codigoMaterialColumn;

    @FXML
    private TableColumn<Material, String> descricaoCurtaColumn;

    @FXML
    private TableColumn<Material, String> unidadeMedidaColumn;

    @FXML
    private TableColumn<Material, String> descricaoLongaColumn;

    @FXML
    private Button voltarButton;

    private CadastroMaterialServ cadastroProdutoServ = new CadastroMaterialServ();
    private ObservableList<Material> produtoList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        codigoMaterialColumn.setCellValueFactory(new PropertyValueFactory<>("id_material"));
        descricaoCurtaColumn.setCellValueFactory(new PropertyValueFactory<>("descricao_curta"));
        unidadeMedidaColumn.setCellValueFactory(new PropertyValueFactory<>("unidade_Medida"));
        descricaoLongaColumn.setCellValueFactory(new PropertyValueFactory<>("descricao_Longa"));

        produtoList.addAll(cadastroProdutoServ.listarProdutos());
        tabelaMateriais.setItems(produtoList);
    }
}
