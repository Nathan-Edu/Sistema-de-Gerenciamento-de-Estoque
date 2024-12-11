package com.example.stockmaster.Controles.LoginUsuario;

import Aplicaçoes_Sistema_estoque.CadastroUsuarioServ;
import Aplicaçoes_Sistema_estoque.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField userField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink cadastreSeLink;

    @FXML
    private Label statusLabel;

    private CadastroUsuarioServ cadastroUsuarioServ = new CadastroUsuarioServ();

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String email = userField.getText();
        String senha = senhaField.getText();

        Usuario usuario = cadastroUsuarioServ.buscarUsuarioPorEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            statusLabel.setText("Login bem-sucedido!");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/stockmaster/Principal/PagInicial.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                statusLabel.setText("Erro ao carregar a tela inicial.");
            }
        } else {
            statusLabel.setText("Credenciais inválidas. Tente novamente.");
        }
    }

    @FXML
    private void handleCadastreSeLinkAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/stockmaster/LoginUsuario/CadastroUsuario.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) cadastreSeLink.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Erro ao carregar a tela de cadastro.");
        }
    }
}
