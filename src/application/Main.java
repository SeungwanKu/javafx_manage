package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage)throws Exception {
			Parent root =FXMLLoader.load(getClass().getResource("sample.fxml"));
			Scene scene = new Scene(root);
			scene .getStylesheets().add(getClass().getResource("tableview.css").toExternalForm());
			primaryStage.setTitle("물품저장창고");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			

		} 
	
	public static void main(String[] args) {
		launch(args);
	}
}
