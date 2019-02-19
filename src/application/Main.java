package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Parent root=FXMLLoader.load(getClass().getResource("/application/apecexml.fxml"));
			Parent root =FXMLLoader.load(getClass().getResource("/application/environement.fxml"));
			Scene scene = new Scene(root,primaryStage.getMaxWidth(),primaryStage.getMaxHeight());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.setTitle("Department Of Environment ( V-1.8.1 )");
			primaryStage.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
