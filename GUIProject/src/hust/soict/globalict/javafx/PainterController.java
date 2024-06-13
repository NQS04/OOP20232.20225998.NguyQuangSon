package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraserButton;

    @FXML
    private RadioButton penButton;

    @FXML
    private ToggleGroup tools;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        if(!drawingAreaPane.getBoundsInParent().contains(event.getX(), event.getY())) {
            return;
        }
        if(penButton.isSelected()) {
            newCircle.setFill(Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
        else if(eraserButton.isSelected()) {
            newCircle.setFill(Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

}

