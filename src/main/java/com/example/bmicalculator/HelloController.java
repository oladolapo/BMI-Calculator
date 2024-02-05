package com.example.bmicalculator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    Alert alert = new Alert(Alert.AlertType.ERROR);
    @FXML
    TextField weightKilograms = new TextField();
    @FXML
    TextField heightCentimeter = new TextField();
    @FXML
    TableView<User> bmiDetails;
    @FXML
    TableColumn<User, Double> weight;
    @FXML
    TableColumn<User, Double> height;
    @FXML
    TableColumn<User, Double> calculatedBmi;
    @FXML
    TableColumn<User, String> weightStatus;

    @FXML
    public void onCalculate(ActionEvent event){
        double userWeight = Double.parseDouble(weightKilograms.getText());
        double userHeight = Double.parseDouble(heightCentimeter.getText());
        if (weightKilograms.getText().isEmpty() || heightCentimeter.getText().isEmpty() ){
            alert.setTitle("Error");
            alert.setContentText("Please insert a value for each text field");
            alert.show();
        } else {
            User u1 = new User(userWeight, userHeight);
            ObservableList<User> user = bmiDetails.getItems();
            user.add(u1);
            bmiDetails.setItems(user);
            weightKilograms.clear();
            heightCentimeter.clear();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weight.setCellValueFactory(new PropertyValueFactory<User, Double>("weight"));
        height.setCellValueFactory(new PropertyValueFactory<User, Double>("height"));
        calculatedBmi.setCellValueFactory(new PropertyValueFactory<User, Double>("calculatedBmi"));
        weightStatus.setCellValueFactory(new PropertyValueFactory<User, String>("weightStatus"));
    }
}