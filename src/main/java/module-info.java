module com.example.stockmaster {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.example.stockmaster.Controles.Lotes to javafx.fxml;
    opens com.example.stockmaster.Controles.Materiais to javafx.fxml;
    opens com.example.stockmaster.Controles.LoginUsuario to javafx.fxml;
    opens com.example.stockmaster.Controles.Principal to javafx.fxml;
    opens com.example.stockmaster.Telas.Lotes to javafx.fxml;
    opens com.example.stockmaster.Telas.LoginUsuario to javafx.fxml;
    opens com.example.stockmaster.Telas.Principal to javafx.fxml;
    opens com.example.stockmaster.Telas.Materiais to javafx.fxml;

    exports com.example.stockmaster.Controles.Lotes;
    exports com.example.stockmaster.Controles.Materiais;
    exports com.example.stockmaster.Controles.LoginUsuario;
    exports com.example.stockmaster.Controles.Principal;
    exports com.example.stockmaster.Telas.Lotes;
    exports com.example.stockmaster.Telas.LoginUsuario;
    exports com.example.stockmaster.Telas.Principal;
    exports com.example.stockmaster.Telas.Materiais;
}
