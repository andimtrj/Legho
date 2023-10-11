package main;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	ArrayList<Database> registered = new ArrayList<>();
	Database current = null;
	Scene loginPage, registerPage, adminPage;
	BorderPane bp;
	GridPane gp;
	Stage arg0;

	
	public void loginPage() {
	    // Components
	    Label title = new Label("Legho");
	    Label email = new Label("Email");
	    TextField emailField = new TextField();
	    Label password = new Label("Password");
	    PasswordField passwordField = new PasswordField();
	    Button registerBtn = new Button("Register");
	    Button loginBtn = new Button("Login");

	    // Layout
	    VBox root = new VBox(20);
	    root.setAlignment(Pos.CENTER);
	    root.setPadding(new Insets(40));

	    HBox emailBox = new HBox(55);
	    emailBox.setAlignment(Pos.CENTER);
	    emailField.setMinWidth(210);
	    emailField.setMinHeight(40);
	    emailBox.getChildren().addAll(email, emailField);
	    
	    HBox passwordBox = new HBox(10);
	    passwordBox.setAlignment(Pos.CENTER);
	    passwordField.setMinWidth(210);
	    passwordField.setMinHeight(40);
	    passwordBox.getChildren().addAll(password, passwordField);
	    
	    HBox buttonBox = new HBox(10);
	    buttonBox.setAlignment(Pos.CENTER);
	    ButtonBar buttonbar = new ButtonBar();
	    registerBtn.setMinHeight(40);
	    registerBtn.setPrefWidth(100);
	    loginBtn.setPrefWidth(100);
	    loginBtn.setMinHeight(40);
	    buttonBox.setPadding(new Insets(0, -95, 0, 0));
	    
	    buttonbar.getButtons().addAll(registerBtn, loginBtn);
	    buttonBox.getChildren().add(buttonbar);
	    root.getChildren().addAll(title, emailBox, passwordBox, buttonBox);
	    
	    // Styling
	    title.setStyle("-fx-font-size: 44; -fx-font-weight: bold;");
	    registerBtn.setStyle("-fx-background-color: #404040; -fx-text-fill: white; -fx-font-size: 14;");
	    loginBtn.setStyle("-fx-background-color: #404040; -fx-text-fill: white; -fx-font-size: 14;");
	    email.setStyle("-fx-font-size: 25");
	    password.setStyle("-fx-font-size: 25");

	    // Scene
	    loginPage = new Scene(root, 700, 600);
	    
	    //Event Handler
	    loginBtn.setOnMouseClicked(e -> {
	    	if(emailField.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Email must be filled!");
	    		alert.showAndWait();
	    	}
	    	else if(passwordField.getText().isEmpty()) {
	    		Alert alert2 = new Alert(AlertType.ERROR);
	    		alert2.setContentText("Password must be filled!");
	    		alert2.showAndWait();
	    	}
	    	else if(emailField.getText().equals("admin") && passwordField.getText().equals("admin")) {
	    		Admin admin = new Admin();
	    		try {
	    			admin.start(arg0);
	    		}
                catch(Exception o){
                	o.printStackTrace();
                }
	    	}
	    	else {
	    		for(Database database : registered) {
	    			if(database.getEmail().equals(emailField.getText())&&database.getPassword().equals(passwordField.getText())) {
						current = database;
						User welcome = new User();
			    		try {
			    			welcome.start(arg0);
			    		}
		                catch(Exception o){
		                	o.printStackTrace();
		                }
	    			}
	    			else {
	    				Alert alert3 = new Alert(AlertType.ERROR);
	    	    		alert3.setContentText("Please make sure that your email and password are correct!");
	    	    		alert3.showAndWait();
	    			}
	    		}
	    	}
	    	});
	    
	    registerBtn.setOnMouseClicked(e -> {
	    	registerPage();
	    });
	    
	
	}
	
	
	public void registerPage() {
	    // Components
	    Label title = new Label("Register");
	    Label email = new Label("Email");
	    TextField emailField = new TextField();
	    Label password = new Label("Password");
	    PasswordField passwordField = new PasswordField();
	    Label confirmPassword = new Label("Confirm Password");
	    PasswordField conPassField = new PasswordField();
	    Button loginBtn = new Button("Login");
	    Button registerBtn = new Button("Register");
	    Button resetBtn = new Button("Reset");

	    // Layout
	    VBox root = new VBox(20);
	    root.setAlignment(Pos.CENTER);
	    root.setPadding(new Insets(40));

	    HBox emailBox = new HBox(150);
	    emailBox.setAlignment(Pos.CENTER);
	    emailField.setMinWidth(320);
	    emailField.setMinHeight(40);
	    emailBox.getChildren().addAll(email, emailField);

	    HBox passwordBox = new HBox(106);
	    passwordBox.setAlignment(Pos.CENTER);
	    passwordField.setMinWidth(320);
	    passwordField.setMinHeight(40);
	    passwordBox.getChildren().addAll(password, passwordField);

	    HBox conpasswordBox = new HBox(10);
	    conpasswordBox.setAlignment(Pos.CENTER);
	    conPassField.setMinWidth(320);
	    conPassField.setMinHeight(40);
	    conpasswordBox.getChildren().addAll(confirmPassword, conPassField);

	    HBox buttonBox = new HBox(10);
	    buttonBox.setAlignment(Pos.CENTER);
	    ButtonBar buttonbar = new ButtonBar();
	    loginBtn.setPrefWidth(100);
	    loginBtn.setMinHeight(40);
	    registerBtn.setMinHeight(40);
	    registerBtn.setPrefWidth(100);
	    resetBtn.setMinHeight(40);
	    resetBtn.setPrefWidth(100);
	    buttonBox.setPadding(new Insets(0, -190, 0, 0));
	    buttonbar.getButtons().addAll(loginBtn, registerBtn, resetBtn);
	    buttonBox.getChildren().add(buttonbar);

	    root.getChildren().addAll(title, emailBox, passwordBox, conpasswordBox, buttonBox);

	    // Styling
	    title.setStyle("-fx-font-size: 44; -fx-font-weight: bold;");
	    loginBtn.setStyle("-fx-background-color: #404040; -fx-text-fill: white; -fx-font-size: 14;");
	    registerBtn.setStyle("-fx-background-color: #404040; -fx-text-fill: white; -fx-font-size: 14;");
	    resetBtn.setStyle("-fx-background-color: #404040; -fx-text-fill: white; -fx-font-size: 14;");
	    email.setStyle("-fx-font-size: 25");
	    password.setStyle("-fx-font-size: 25");
	    confirmPassword.setStyle("-fx-font-size: 25");
	    // Scene
	    registerPage = new Scene(root, 700, 600);
	    arg0.setScene(registerPage);
	    arg0.setTitle("Register");
	    Image icon = new Image("file:src/assets/logo.png");
		arg0.getIcons().add(icon);
	    arg0.show();
	    
	    // Event Handler
	    registerBtn.setOnMouseClicked(e -> {
	    	if(emailField.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Email must be filled!");
	    		alert.showAndWait();
	    	}
	    	else if(emailField.getText().contains("@email.com")) {
	    		int count = emailField.getText().length() - emailField.getText().replace("@", "").length();
	    		//kalau @ lebih dari 1
	    		if(count > 1) {
	    			Alert alert2 = new Alert(AlertType.ERROR);
	    			alert2.setContentText("Email must only contains at most 1 '@'!");
	    			alert2.showAndWait();
	    		}
	    		else if(!emailField.getText().endsWith("@email.com")) {
	    			Alert alert3 = new Alert(AlertType.ERROR);
	    			alert3.setContentText("Email must ends with '@email.com'!");
	    			alert3.showAndWait();
	    		}	
	    	}
	    	else if(emailField.getText().contains(" ")) {
	    		Alert alert4 = new Alert(AlertType.ERROR);
    			alert4.setContentText("Email must not contains spaces!");
    			alert4.showAndWait();
	    	}
	    	else if(passwordField.getText().isEmpty()) {
	    		Alert alert5 = new Alert(AlertType.ERROR);
	    		alert5.setContentText("Password must be filled!");
	    		alert5.showAndWait();
	    	}
	    	else if(conPassField.getText().isEmpty()) {
	    		Alert alert6 = new Alert(AlertType.ERROR);
	    		alert6.setContentText("Confirm Password must be filled!");
	    		alert6.showAndWait();
	    	}
	    	else if(!conPassField.getText().equals(passwordField.getText())) {
	    		Alert alert7 = new Alert(AlertType.ERROR);
	    		alert7.setContentText("Confirm Password not match!");
	    		alert7.showAndWait();
	    	}
	    	else
	    	{
	    		Integer flag = 1;
	    		for(Database database : registered) {
	    			if(database.getEmail().equals(emailField.getText())) {
	    				Alert alert8 = new Alert(AlertType.ERROR);
	    	    		alert8.setContentText("Email already registered!");
	    	    		alert8.showAndWait();
	    			}
	    		}
	    		if(flag == 1) {
	    			registered.add(new Database(emailField.getText(), passwordField.getText()));
	    			Alert alert9 = new Alert(AlertType.INFORMATION);
	    			alert9.setContentText("Account successfully registered!");
	    			alert9.showAndWait();
	    			arg0.setScene(loginPage);
	    		}
	    	}
	    });
	    loginBtn.setOnMouseClicked(e -> {
	        arg0.setScene(loginPage);
	    });
	    resetBtn.setOnMouseClicked(e -> {
	    	emailField.setText("");
	    	passwordField.setText("");
	    	conPassField.setText("");
	    });
	}




	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		this.arg0 = arg0;
		loginPage();
		arg0.setTitle("Login");
		arg0.setScene(loginPage);
		Image icon = new Image("file:src/assets/logo.png");
		arg0.getIcons().add(icon);
		arg0.show();		
	}

	
}



	




