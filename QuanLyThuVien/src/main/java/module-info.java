module com.mycompany.quanlythuvien {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens com.mycompany.quanlythuvien to javafx.fxml;
    exports com.mycompany.quanlythuvien;
    exports com.mycompany.Pojo;
}