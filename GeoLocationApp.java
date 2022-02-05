
/*
 * Name: Samuel Hernandez
 * Date: 05/07/2021
 * Course Number:CSC-112
 * Course Name: Intermediate Java 
 * Email:sguzmanhernandez0001@student.stcc.edu
 * Short Description of the Problem: A GEOLocationApp using JSON and API
 */



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class GeoLocationApp extends Application {
	public static final double APPWIDTH = 750;
	public static final double APPHEIGHT = 300;
	public static final String TITLE = " IP LookUp App";
	public static final String PANESTYLE = "-fx-font-weight: bold; -fx-font-size: 16pt";
	public static final String AUTHOR = " Samuel Hernandez ";
	private TextField tf1, tf2, tf3, tf4;
	private TextArea tfStatus;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new AppGUI(), APPWIDTH, APPHEIGHT);
		primaryStage.setTitle(TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(true);
		scene.getStylesheets().add("AppStyle.css");

	}

	public static void main(String[] args) {
		launch(args);
	}

	public class AppGUI extends BorderPane {

		public AppGUI() {
			var form = new Form();
			var textFieldStatus = new TextFieldStatus();

			this.setTop(form);
			this.setCenter(textFieldStatus);
			// this.setCenter();
			this.setId("backgroundPane");

		}

		public class Form extends GridPane {
			public Form() {

				var lblEnterIP = new Label("Enter a IP Address:");
				var btnLocate = new Button("Locate");

				btnLocate.setOnAction(e -> numberValidator());

				tf1 = new TextField();
				tf2 = new TextField();
				tf3 = new TextField();
				tf4 = new TextField();
				Label lbdot1 = new Label(".");
				lbdot1.setTranslateY(9);
				Label lbdot2 = new Label(".");
				lbdot2.setTranslateY(9);
				Label lbdot3 = new Label(".");
				lbdot3.setTranslateY(9);

				tf1.setPrefColumnCount(4);
				tf2.setPrefColumnCount(4);
				tf3.setPrefColumnCount(4);
				tf4.setPrefColumnCount(4);

				// lblEnterIP.setAlignment(Pos.CENTER);
				// this.getChildren().addAll(lblEnterIP,tf1,tf2);
				this.add(lblEnterIP, 0, 0);
				this.add(tf1, 1, 0);
				this.add(lbdot1, 2, 0);
				this.add(tf2, 3, 0);
				this.add(lbdot2, 4, 0);
				this.add(tf3, 5, 0);
				this.add(lbdot3, 6, 0);
				this.add(tf4, 7, 0);
				this.add(btnLocate, 8, 0);
				this.setVgap(4);
				this.setHgap(3);
				this.setPadding(new Insets(6));
				this.setAlignment(Pos.CENTER_LEFT);

				// this.add(lblEnterIP, 0, 0);
			}

			public void numberValidator() {
				try {
					int a = Integer.parseInt(tf1.getText());
					int b = Integer.parseInt(tf2.getText());
					int c = Integer.parseInt(tf3.getText());
					int d = Integer.parseInt(tf4.getText());

					if (a < 0 || a > 255) {
						throw new Exception("Error");

					}
					if (b < 0 || b > 255) {
						throw new Exception("Error");

					}
					if (c < 0 || c > 255) {
						throw new Exception("Error");

					}
					
					if (d < 0 || d > 255) {
						throw new Exception("Error");
                     
					} new APIConnection(tfStatus,formatIP(a,b,c,d)); 
					
				
				} catch (Exception e) {
					tfStatus.appendText(e.getMessage() + "\n");
				}
			}

			public String formatIP(int a, int b, int c, int d) {

				return String.format("%d.%d.%d.%d", a, b, c, d);
			}
		}
			public class TextFieldStatus extends VBox {
				public TextFieldStatus() {
					var lblStatus = new Label("Status");
            
					this.setPadding(new Insets(6));
					tfStatus = new TextArea();
					tfStatus.setEditable(false);
					VBox.setVgrow(tfStatus, Priority.ALWAYS);
					this.getChildren().addAll(lblStatus, tfStatus);

				}

			}
		}

	}


