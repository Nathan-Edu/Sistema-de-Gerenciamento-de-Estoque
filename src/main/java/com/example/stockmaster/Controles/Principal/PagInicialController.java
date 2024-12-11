package com.example.stockmaster.Controles.Principal;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class PagInicialController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();


        if ("admin".equals(username) && "admin".equals(password)) {

            showAlert("Login bem-sucedido!", "Bem-vindo ao sistema.");

            // Abrir a tela principal após login
            openMainApplication();
        } else {
            // Exibe um alerta de erro no login
            showAlert("Erro no login", "Usuário ou senha incorretos.");
        }

        System.out.println("Usuário: " + username);
        System.out.println("Senha: " + password);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Abrir a tela principal
    private void openMainApplication() {
        try {
            // Carregar a tela principal (por exemplo, PagInicial.fxml)
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/stockmaster/PagInicial.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setTitle("Sistema de Estoque");
            stage.setScene(scene);
            stage.show();

            // Fechar a tela de login
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
