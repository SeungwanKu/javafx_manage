package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller implements Initializable{
	private static int dexA = 0;
	private static int dexB = 0;
	private static int dexC = 0;
	
	private static int lowA = 0;
	private static int lowB = 0;
	private static int lowC = 0;
	
	@FXML
	private TableView<TableRowDataModel> myTableView;
	@FXML
	private TableColumn<TableRowDataModel, String> nameColumn;
	@FXML
	private TableColumn<TableRowDataModel, String> numColumn;
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
	@FXML
    private Button addButton1;
	@FXML
    private Button addButton2;
	
	@FXML
	private Button delButton;
	@FXML
	private Button delButton1;
	@FXML
	private Button delButton2;
	
	@FXML
	private Canvas canvasA;
	
	@FXML
	private Canvas canvasB;
	
	@FXML
	private Canvas canvasC;
	
	GraphicsContext gcA;
	GraphicsContext gcB;
	GraphicsContext gcC;
	
	ObservableList<TableRowDataModel> myList = FXCollections.observableArrayList();
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        numColumn.setCellValueFactory(cellData -> cellData.getValue().numProperty());
        codeColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
        etcColumn.setCellValueFactory(cellData -> cellData.getValue().etcProperty());
        myTableView.setItems(myList);
        
        gcA = canvasA.getGraphicsContext2D();
        gcB = canvasB.getGraphicsContext2D(); 
        gcC = canvasC.getGraphicsContext2D(); 
        
        
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
				drawA();
			}
        });
        
        addButton1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
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
				drawB();
			}
        });
        
        addButton2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
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
				drawC();
			}
        });
        
        delButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				
			int selcectedIndex=myTableView.getSelectionModel().getSelectedIndex();
			
			if(selcectedIndex>=0){
				myTableView.getItems().remove(selcectedIndex);
				removeA();
			}
			
			else{
				Alert alert =new Alert (AlertType.WARNING);
				
			}
		}
       });
        
        delButton1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				
			int selcectedIndex=myTableView.getSelectionModel().getSelectedIndex();
			
			if(selcectedIndex>=0){
				myTableView.getItems().remove(selcectedIndex);
				removeB();
			}
			
			else{
				Alert alert =new Alert (AlertType.WARNING);
				
			}
		}
       });
        
        delButton2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				
			int selcectedIndex=myTableView.getSelectionModel().getSelectedIndex();
			
			if(selcectedIndex>=0){
				myTableView.getItems().remove(selcectedIndex);
				removeC();
			}
			
			else{
				Alert alert =new Alert (AlertType.WARNING);
				
			}
		}
       });
        
        
	}
	void drawA() {
		gcA.setFill(Color.RED);
		gcA.fillRect(1+50*dexA, 1+50*lowA, 50, 50);
		dexA++;
		
		if(dexA == 5) {
			dexA = 0;
			lowA++;
		}
	}
	
	void drawB() {
		gcB.setFill(Color.GREEN);
		gcB.fillRect(1+50*dexB, 1+50*lowB, 50, 50);
		dexB++;
		
		if(dexB == 5) {
			dexB = 0;
			lowB++;
		}
	}
	
	void drawC() {
		gcC.setFill(Color.BLUE);
		gcC.fillRect(1+50*dexC, 1+50*lowC, 50, 50);
		dexC++;
		
		if(dexC == 5) {
			dexC = 0;
			lowC++;
		}
	}
	
	void removeA() {
		dexA--;
		gcA.setFill(Color.WHITE);
    	gcA.fillRect(1+50*dexA, 1+50*lowA, 50, 50);
    	if(dexA == 0) {
    		lowA--;
    		dexA=5;
    	}
	}
	void removeB() {
		dexB--;
		gcB.setFill(Color.WHITE);
    	gcB.fillRect(1+50*dexB, 1+50*lowB, 50, 50);
    	if(dexB == 0) {
    		lowB--;
    		dexB=5;
    	}
	}
	void removeC() {
		dexC--;
		gcC.setFill(Color.WHITE);
    	gcC.fillRect(1+50*dexC, 1+50*lowC, 50, 50);
    	if(dexC == 0) {
    		lowC--;
    		dexC=5;
    	}
	}
}
