package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class CompareController implements Initializable {

	private Controller controller;

	@FXML
	private Button myCompare;
	@FXML
	private Hyperlink reviews, aboutUs, home, login, add, logout;

	@FXML
	private ComboBox<String> myComboBox1;

	@FXML
	private ComboBox<String> myComboBox2;

	public static String ComboInfo1, ComboInfo2;

	String laptop_info[] = new String[325];

	public void homeScene(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void addAccount(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("NewSignup.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void loginScene(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void mainScene(ActionEvent ae) throws IOException {
        closeAllStages();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.show();
	}

	public void infoAboutUs(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InfoAboutUs.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
	}

	public void compare(ActionEvent ae) {

		if (ae.getSource() == myCompare) {
			try {

				if (myComboBox1.getValue() == (null) || myComboBox2.getValue() == (null)) {

					Alert alert = new Alert(AlertType.INFORMATION);

					DialogPane dialogPane = alert.getDialogPane();
					dialogPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					alert.setTitle("No Information");
					alert.setHeaderText("Laptop Model is not selected.");
					alert.setContentText("Please select laptop to compare.");
					alert.show();

				}

				else {

					Alert alert = new Alert(AlertType.INFORMATION);

					DialogPane dialogPane = alert.getDialogPane();
					dialogPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					alert.setTitle("Comparing");
					alert.setHeaderText("Please wait.");
					alert.setContentText("Comparision in progress...");
					alert.show();

					controller = new Controller();
					ComboInfo1 = myComboBox1.getValue();
					ComboInfo2 = myComboBox2.getValue();

					controller.setInfo(ComboInfo1, ComboInfo2);
					alert.show();
					Stage primaryStage = new Stage();

					FXMLLoader loader = new FXMLLoader(getClass().getResource("Laptop.fxml"));
					Parent root = loader.load();

					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

					primaryStage.setScene(scene);
					primaryStage.setTitle("Comparison");
					primaryStage.setResizable(false);
					primaryStage.getOnCloseRequest();

					primaryStage.show();
					new Thread(() -> {
						try {
							Thread.sleep(2000);
							Platform.runLater(alert::close);

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}).start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void colorChange(MouseEvent me) {

		myCompare.setStyle("-fx-background-color: #45a29e; -fx-background-radius: 20; -fx-text-fill:black");

	}

	public void colorNormal(MouseEvent me) {
		myCompare.setStyle(
				"-fx-background-color: #0b0c10; -fx-background-radius: 20; -fx-border-width: 2; -fx-border-color: #66fcf1; -fx-border-radius: 20;");
	}

	public void reviewScene(ActionEvent ae) {
		try {
			Stage primaryStage = new Stage();

			Parent root = FXMLLoader.load(getClass().getResource("Review.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("Review");
			primaryStage.setResizable(false);
			primaryStage.getOnCloseRequest();
			primaryStage.show();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
	
    private void closeAllStages() {
        List<Window> stagesToClose = new ArrayList<>(Stage.getWindows().filtered(window -> window instanceof Stage));
        
        for (Window window : stagesToClose) {
            ((Stage) window).close();
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.print("\n DRIVER ACTIVATED..... ");

			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/croma_info", "root", "Maiitra@09");
			System.out.print("\n DATABASE CONNNECTED.... ");

			Statement st2 = con2.createStatement();

			ResultSet rs2 = st2.executeQuery("select laptop from croma_updated2;");

			int i = 0;
			while (rs2.next()) {
				laptop_info[i] = rs2.getString("laptop");
				i++;
			}
			rs2.close();
			st2.close();
			con2.close();

		} catch (Exception e) {
			// e.printStackTrace();
		}

		myComboBox1.getItems().addAll(laptop_info);
		myComboBox2.getItems().addAll(laptop_info);
	}

}
