module GUIProject {
    requires java.datatransfer;
    requires java.desktop;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens hust.soict.globalict.javafx to javafx.fxml;
    exports  hust.soict.globalict.javafx to javafx.graphics;
}