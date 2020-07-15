package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller implements Initializable{
	
	@FXML
	private TableView<TableRowDataModel> myTableView;
	@FXML
	private TableColumn<TableRowDataModel, String> nameColumn;
	@FXML
	private TableColumn<TableRowDataModel, String> numressColumn;
	@FXML
	private TableColumn<TableRowDataModel, String> codeColumn;
	@FXML
	private TableColumn<TableRowDataModel, String> etcColumn;
	
	@FXML
	private TextField NameField;
	@FXML
	private TextField NumField;
	@FXML
	private TextField codeField;
	@FXML
	private TextField etcField;

	@FXML
    private Button addButton;
	
	ObservableList<TableRowDataModel> myList = FXCollections.observableArrayList(
            new TableRowDataModel(new SimpleStringProperty("Jin Seong"), new SimpleStringProperty("DaeJeon"), new SimpleStringProperty("male"), new SimpleStringProperty("male")),
            new TableRowDataModel(new SimpleStringProperty("Jang Ho"), new SimpleStringProperty("SiGol"), new SimpleStringProperty("male"), new SimpleStringProperty("male")),
            new TableRowDataModel(new SimpleStringProperty("Sung Bin"), new SimpleStringProperty("SuWon"), new SimpleStringProperty("male"), new SimpleStringProperty("male")),
            new TableRowDataModel(new SimpleStringProperty("Key Hwang"), new SimpleStringProperty("DaeJeon"), new SimpleStringProperty("male"), new SimpleStringProperty("male")),
            new TableRowDataModel(new SimpleStringProperty("Seong Woo"), new SimpleStringProperty("DaeJeon"), new SimpleStringProperty("male"), new SimpleStringProperty("male")),
            new TableRowDataModel(new SimpleStringProperty("I kyun"), new SimpleStringProperty("BuSan"), new SimpleStringProperty("male"), new SimpleStringProperty("male"))
    );
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        numressColumn.setCellValueFactory(cellData -> cellData.getValue().numProperty());
        codeColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
        etcColumn.setCellValueFactory(cellData -> cellData.getValue().etcProperty());
        myTableView.setItems(myList);
        
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				myTableView.getItems().add(
						new TableRowDataModel
						(
						new SimpleStringProperty(NameField.getText()),
						new SimpleStringProperty(NumField.getText()),
						new SimpleStringProperty(codeField.getText()),
						new SimpleStringProperty(etcField.getText())
                        ));
			}
        });
   }
}
