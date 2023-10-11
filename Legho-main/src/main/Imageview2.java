package main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Imageview2 extends Application {
	Stage stage;
	Scene iv1Page;
	BorderPane bp;
	GridPane gp;
	HBox button1, button2;
	VBox container;
	
	public void iv1Page() {
		ImageView iv1 = new ImageView(new Image(getClass().getResourceAsStream("/assets/lego2.png")));
		Text description = new Text("Bring the magical personality and elegant movement of Hedwig, \n the celebrated snowy owl from the Harry Potter™ movies, to life");
		bp = new BorderPane();
		gp = new GridPane();
		button1 = new HBox();
		button2 = new HBox();
		container = new VBox();
		Button rtrRight = new Button("Rotate Right");
		Button rtrLeft = new Button("Rotate Left");
		Button zoomIn = new Button("Zoom In");
		Button zoomOut = new Button("Zoom Out");
		rtrRight.setMinWidth(250);
		rtrLeft.setMinWidth(250);
		zoomIn.setMinWidth(250);
		zoomOut.setMinWidth(250);
		iv1.setFitWidth(200);
		iv1.setFitHeight(200);

		button1.getChildren().addAll(rtrRight, zoomIn);
		button1.setAlignment(Pos.CENTER);
		button1.setSpacing(15);
		button2.getChildren().addAll(rtrLeft, zoomOut);
		button2.setAlignment(Pos.CENTER);
		button2.setSpacing(15);
		container.getChildren().addAll(iv1, description, button1, button2);
		container.setAlignment(Pos.CENTER);
		bp.setCenter(container);
		BorderPane.setAlignment(container, Pos.CENTER);
		double initialScale = 1.0;
		iv1.setScaleX(initialScale);
		iv1.setScaleY(initialScale);
		iv1.setPreserveRatio(true);
		rtrRight.setOnMouseClicked(e -> {
			iv1.setRotate(iv1.getRotate()+90);
		});
		rtrLeft.setOnMouseClicked(e -> {
			iv1.setRotate(iv1.getRotate()-90);
		});
		zoomIn.setOnMouseClicked(e -> {
			
			if(iv1.getScaleX() <= 2.5) {
				iv1.setScaleX(iv1.getScaleX()*1.2);
				iv1.setScaleY(iv1.getScaleY()*1.2);
				iv1.setPreserveRatio(true);
			}
		});
		zoomOut.setOnMouseClicked(e -> {
			iv1.setPreserveRatio(true);
			if(iv1.getScaleX() >= 0.4) {
				iv1.setScaleX(iv1.getScaleX()*0.8);
				iv1.setScaleY(iv1.getScaleY()*0.8);
				iv1.setPreserveRatio(true);
			}
		});
		
		iv1Page = new Scene(bp, 600, 600);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
		iv1Page();
		arg0.setScene(iv1Page);
	    arg0.setTitle("View Image");
	    Image icon = new Image("file:src/assets/logo.png");
		arg0.getIcons().add(icon);
	    arg0.show();
	}

}
