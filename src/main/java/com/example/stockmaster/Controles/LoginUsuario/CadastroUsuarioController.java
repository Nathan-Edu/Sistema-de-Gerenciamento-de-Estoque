package com.example.stockmaster.Controles.LoginUsuario;

import Aplicaçoes_Sistema_estoque.CadastroUsuarioServ;
import Aplicaçoes_Sistema_estoque.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class CadastroUsuarioController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private PasswordField confirmarSenhaField;

    @FXML
    private Button registrarButton;

    @FXML
    private Button voltarButton;

    @FXML
    private Label statusLabel;

    private CadastroUsuarioServ cadastroUsuarioServ = new CadastroUsuarioServ();

    @FXML
    private void handleRegistrarButtonAction(ActionEvent event) {
        String nome = nomeField.getText();
        String email = emailField.getText();
        String senha = senhaField.getText();
        String confirmarSenha = confirmarSenhaField.getText();

        if (senha.equals(confirmarSenha)) {
            Usuario novoUsuario = new Usuario(nome, email, senha);
            boolean registrado = cadastroUsuarioServ.registrarUsuario(novoUsuario);

            if (registrado) {
                statusLabel.setText("Cadastro bem-sucedido!");
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/stockmaster/LoginUsuario/Login.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) registrarButton.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                    statusLabel.setText("Erro ao carregar a tela de login.");
                }
            } else {
                statusLabel.setText("Erro ao registrar usuário. Tente novamente.");
            }
        } else {
            statusLabel.setText("Senhas não coincidem. Tente novamente.");
        }
    }

    @FXML
    private void handleVoltarButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/stockmaster/LoginUsuario/Login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) voltarButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Erro ao carregar a tela de login.");
        }
    }
}
