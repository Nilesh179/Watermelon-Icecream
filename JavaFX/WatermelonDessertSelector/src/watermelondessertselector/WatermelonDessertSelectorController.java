/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watermelondessertselector;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Abhilash G 
 */
public class WatermelonDessertSelectorController implements Initializable {
    
    // Watermelon Dessert Selector
    @FXML private CheckBox watermelonIcecubesCheckBox;
    @FXML private CheckBox thinWatermelonShredsCheckBox;
    @FXML private CheckBox watermelonSpheresCheckBox;
    @FXML private TextField extraToppingsTextField;
    @FXML private Button orderButton;
    @FXML private Label orderSummaryLabel;
   
    // Add Extra Fruits
    @FXML private ChoiceBox extraFruitsChoiceBox;
    @FXML private Button addFruitButton;
    @FXML private Label extraFruitSummaryLabel;
    
    // Add Dried Fruits
    @FXML private ComboBox driedFruitsComboBox;
    @FXML private Label driedFruitSummaryLabel;
    
    // Dessert Awesomeness Level
    @FXML private RadioButton superAwesomeRadioButton;
    @FXML private RadioButton awesomeRadioButton;
    @FXML private RadioButton okayRadioButton;
    @FXML private RadioButton tastesLikeShitRadioButton;
    @FXML Label dessertRatingLabel;
    private ToggleGroup dessertAwesomenessToggleGroup;
    
    // Fruit List Selector
    @FXML private ListView fruitListView;
    @FXML private Button selectorButton;
    @FXML private TextArea awesomeFruitTextArea;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeToggleGroup();
        onOrderButtonPressed();
        initializeChoiceBoxData();
        initializeComboBoxData();
        initializeFruitList();
        onAddFruitButtonClicked();
        onSelectFruitButtonClicked();
    }    
    
    /**
     * Invoked when the Order button of
     * the Watermelon Dessert Selector is pressed
     */
    public void onOrderButtonPressed() {
        orderButton.setOnAction((event) -> {
            String order = "";
            
            if(watermelonIcecubesCheckBox.isSelected()) {
                order = order + "Watermelon Icecubes "; 
            }
            
            if(thinWatermelonShredsCheckBox.isSelected()) {
                order = order + " Thin Watermelon Shreds";
            }
                
            if(watermelonSpheresCheckBox.isSelected()) {
                order = order + " Watermelon Balls";
            }
            
            if(!extraToppingsTextField.getText().isEmpty()) {
                order = order + " " + extraToppingsTextField.getText();
            }
            orderSummaryLabel.setText(order);
            System.out.println(order);
        });
    }
    
    public void onAddFruitButtonClicked() {
        addFruitButton.setOnAction((event) -> {
            extraFruitSummaryLabel.setText(extraFruitsChoiceBox.getValue()
                    .toString());
            System.out.println(extraFruitsChoiceBox.getValue()
                    .toString());
        });
    }
    
    public void onComboBoxItemSelected() {
        driedFruitSummaryLabel.setText("Selected Dry Fruit:\n"
                +driedFruitsComboBox.getValue().toString());
        System.out.println(driedFruitsComboBox.getValue().toString());
    }
    
    public void onRadioButtonClicked() {
        if(dessertAwesomenessToggleGroup.getSelectedToggle()
                .equals(superAwesomeRadioButton)) {
            dessertRatingLabel.setText("Super Awesome");
        }
        
        if(dessertAwesomenessToggleGroup.getSelectedToggle()
                .equals(awesomeRadioButton)) {
            dessertRatingLabel.setText("Awesome");
        }
        
        if(dessertAwesomenessToggleGroup.getSelectedToggle()
                .equals(okayRadioButton)) {
            dessertRatingLabel.setText("Okay");
        }
        if(dessertAwesomenessToggleGroup.getSelectedToggle()
                .equals(tastesLikeShitRadioButton)) {
            dessertRatingLabel.setText("Tastes like shit");
        }        
    }
    
    public void onSelectFruitButtonClicked() {
        selectorButton.setOnAction((event) -> {
            ObservableList items = fruitListView.getSelectionModel()
                    .getSelectedItems();
            
            StringBuilder fruits = new StringBuilder("Awesome Fruits are -\n");
            
            items.forEach((item) -> {
                awesomeFruitTextArea.setText(fruits.append(item)
                        .append(" ").toString());
            });
        });
    }
    
    public void onRestButtonClicked() {
        extraFruitSummaryLabel.setText("");
        extraFruitSummaryLabel.setText("");
        driedFruitSummaryLabel.setText("");
        dessertRatingLabel.setText("");
        awesomeFruitTextArea.setText("");
        extraToppingsTextField.setText("");
        orderSummaryLabel.setText("");
        
        if(watermelonIcecubesCheckBox.isSelected()) {
            watermelonIcecubesCheckBox.setSelected(false);
        }
        
        if(thinWatermelonShredsCheckBox.isSelected()) {
            thinWatermelonShredsCheckBox.setSelected(false);
        }
        
        if(watermelonSpheresCheckBox.isSelected()) {
            watermelonSpheresCheckBox.setSelected(false);
        }
        
        extraFruitsChoiceBox.setValue("Select a fruit");
        driedFruitsComboBox.setValue("");
        
        if(dessertAwesomenessToggleGroup.getSelectedToggle().isSelected()) {
            dessertAwesomenessToggleGroup.getSelectedToggle()
                    .setSelected(false);
        }
        
        fruitListView.getSelectionModel().clearSelection();
    }
    
    private void initializeChoiceBoxData() {
        extraFruitsChoiceBox.setValue("Select Extra Fruit");
        extraFruitsChoiceBox.getItems().add("Lychee");
        extraFruitsChoiceBox.getItems().addAll("Apple", "Mango", "Orange");
    }
    
    private void initializeComboBoxData() {
        driedFruitsComboBox.setValue("Select a dried fruit");
        driedFruitsComboBox.getItems().add("Raisin");
        driedFruitsComboBox.getItems().addAll("Nut", "Almond", "Prune");
    }
    
    /**
     * This method initializes the ToggleGroup for RadioButtons
     */
    private void initializeToggleGroup() {
        dessertAwesomenessToggleGroup = new ToggleGroup();
        superAwesomeRadioButton.setToggleGroup(dessertAwesomenessToggleGroup);
        awesomeRadioButton.setToggleGroup(dessertAwesomenessToggleGroup);
        okayRadioButton.setToggleGroup(dessertAwesomenessToggleGroup);
        tastesLikeShitRadioButton.setToggleGroup(dessertAwesomenessToggleGroup);
    }
    
    private void initializeFruitList() {
        fruitListView.getItems()
                .addAll("Watermelon", "Apple", "Mango", "Dragon Fruit", "Kiwi");
        fruitListView.getSelectionModel()
                .setSelectionMode(SelectionMode.MULTIPLE);
    }
}

