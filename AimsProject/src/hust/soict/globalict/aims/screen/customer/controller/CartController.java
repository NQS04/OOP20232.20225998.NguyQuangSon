package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    private Cart cart;
    private Store store;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel = new Label();

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContentText(((Playable) tblMedia.getSelectionModel().getSelectedItem()).playMedia());
        dialogPane.setHeaderText("Playing Media");
        dialog.setDialogPane(dialogPane);
        ButtonType closeButton = new ButtonType("Confirm");
        dialog.getDialogPane().getButtonTypes().add(closeButton);

        Button closeButtonNode = (Button) dialog.getDialogPane().lookupButton(closeButton);
        closeButtonNode.setOnAction(e -> dialog.close());
        dialog.showAndWait();
    }

    @FXML
    TextField tfFilter;

    @FXML
    RadioButton radioBtnFilterId;

    @FXML
    RadioButton radioBtnFilterTitle;

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel.setText(cart.getTotalCost()+"$");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try{
            final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("View Store");
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media,Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,Float>("cost"));
        if (cart.getItemOrdered() != null) {
            tblMedia.setItems(cart.getItemOrdered());
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
        updateTotalCost();
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            if(media instanceof Playable) {
                btnPlay.setVisible(true);
            }
            else {
                btnPlay.setVisible(false);
            }
        }
    }

    public void showFilteredMedia(String value){
        FilteredList<Media> filteredData = new FilteredList<>(cart.getItemOrdered(), b -> true);

        if (value == null || value.isEmpty()) {
            filteredData.setPredicate(media -> true);
        } else {
            if (radioBtnFilterId.isSelected()) {
                filteredData.setPredicate(media -> String.valueOf(media.getID()).contains(value));
            } else if (radioBtnFilterTitle.isSelected()) {
                filteredData.setPredicate(media -> media.getTitle().toLowerCase().contains(value.toLowerCase()));
            }
        }

        tblMedia.setItems(filteredData);
    }

    public void updateTotalCost(){
        costLabel.setText(String.format("%.2f$", cart.getTotalCost()));
    }

    public void placeOrderPressed(){
        Dialog<String> dialog = new Dialog<>();
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContentText("Your order has been created\nTotal cost: "+cart.getTotalCost()+"$\nThank you for shopping with us!");
        dialogPane.setHeaderText("Order Created");
        dialog.setDialogPane(dialogPane);
        // Create a ButtonType for closing the dialog
        ButtonType closeButton = new ButtonType("Confirm");
        dialog.getDialogPane().getButtonTypes().add(closeButton);

        // Set the close button to close the dialog
        Button closeButtonNode = (Button) dialog.getDialogPane().lookupButton(closeButton);
        closeButtonNode.setOnAction(e -> dialog.close());
        if(!(cart.getItemOrdered().isEmpty())){
            dialog.showAndWait();
            cart.empty();
            updateTotalCost();
            tblMedia.setItems(cart.getItemOrdered());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cart is empty");
            alert.showAndWait();
        }


    }

}
