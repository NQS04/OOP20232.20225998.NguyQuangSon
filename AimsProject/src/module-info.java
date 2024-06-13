module AimsProject {
    requires java.datatransfer;
    requires java.desktop;
    requires java.naming;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens hust.soict.globalict.aims.screen.customer.view to javafx.fxml;
    opens hust.soict.globalict.aims.screen.customer.controller to javafx.fxml;
    exports hust.soict.globalict.aims.screen.customer.controller;
    exports hust.soict.globalict.aims.screen.customer.store to javafx.graphics;
    opens hust.soict.globalict.aims.media to javafx.base;
}