package main;

import java.io.File;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Admin extends Application{
	BorderPane bp;
	GridPane gp;
	Scene adminPage;
	Stage arg0;
	DefaultValue value = new DefaultValue();
	public String itemDesc1=value.itemDesc1, itemDesc2=value.itemDesc2, itemDesc3 =value.itemDesc3, itemDesc4 = value.itemDesc4;
	public String itemPrice1 =value.itemPrice1, itemPrice2 =value.itemPrice2, itemPrice3=value.itemPrice3, itemPrice4=value.itemPrice4;
	public String itemStock1 =value.itemStock1, itemStock2 =value.itemStock2, itemStock3=value.itemStock3, itemStock4=value.itemStock4;
	
	public void adminPage() {
		bp = new BorderPane();
		gp = new GridPane();
		Menu menu = new Menu("Menu");
		MenuItem logout = new MenuItem("Logout");
		MenuBar mb = new MenuBar();
		VBox MenuContainer = new VBox();
		menu.getItems().add(logout);
		mb.getMenus().addAll(menu);
		MenuContainer.getChildren().add(mb);
		
		logout.setOnAction(e -> {
			Main loginPage = new Main();
			try {
				loginPage.start(arg0);
//				Stage.close();
			}
			catch(Exception o) {
				o.printStackTrace();
			}	
		});
		
		
		
		//Item 1
		Label itemNameLbl1 = new Label("Name:");
		Label itemPriceLbl1 = new Label("Price:");
		Label itemStockLbl1 = new Label("Stock:");
		Label itemDescriptionLbl1 = new Label("Description:");
		Button updateBtn1 = new Button("Update");
		TextField itemNameField1 = new TextField("Ironman Hulkbuster");
		itemNameField1.setEditable(false);
		TextField itemPriceField1 = new TextField(itemPrice1);
		TextField itemStockField1 = new TextField(itemStock1);
		TextField itemDesField1 = new TextField(itemDesc1);

		ImageView iv1 = new ImageView(new Image(getClass().getResourceAsStream("/assets/lego5.png")));
		iv1.setFitWidth(100);
		iv1.setFitHeight(100);

	
		
		HBox npsContainer1 = new HBox();
		HBox desContainer1 = new HBox();
		VBox lblContainer1 = new VBox();
		itemDesField1.setMinWidth(480);
		iv1.setOnMouseClicked(e -> {
			Imageview1 img1 = new Imageview1();
	        try {
	            img1.start(new Stage());
	        } catch (Exception o) {
	            o.printStackTrace();
	        }
		});
		updateBtn1.setOnMouseClicked(e -> {
			
			if(itemPriceField1.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Price must be filled!");
	    		alert.showAndWait();
	    	}
			else if(itemStockField1.getText().isEmpty()) {
				Alert alert1 = new Alert(AlertType.ERROR);
	    		alert1.setContentText("Stock must be filled!");
	    		alert1.showAndWait();
			}
			else if(itemDesField1.getText().isEmpty()) {
				Alert alert2 = new Alert(AlertType.ERROR);
	    		alert2.setContentText("Description must be filled!");
	    		alert2.showAndWait();
			}
			
			try {
				Integer priceCheck = Integer.parseInt(itemPriceField1.getText());
				Integer stockCheck = Integer.parseInt(itemStockField1.getText());
				if(priceCheck <= 0) {
					Alert alert3 = new Alert(AlertType.ERROR);
		    		alert3.setContentText("Price must more than 0!");
		    		alert3.showAndWait();
				}
				else if(stockCheck < 0) {
					Alert alert4 = new Alert(AlertType.ERROR);
		    		alert4.setContentText("Stock must equal or more than 0!");
		    		alert4.showAndWait();
				}
				else {
					value.itemPrice1 = itemPriceField1.getText();
					value.itemStock1 = itemStockField1.getText();
					value.itemDesc1 = itemDesField1.getText();
					itemPriceField1.setText(value.itemPrice1);
					itemStockField1.setText(value.itemStock1);
					itemDesField1.setText(value.itemDesc1);
				}
			}
			catch(NumberFormatException o) {
				Alert alert5 = new Alert(AlertType.ERROR);
	    		alert5.setContentText("Price or Stock must be numeric!");
	    		alert5.showAndWait();
			}
						
			
		});

		//Item 2
		Label itemNameLbl2 = new Label("Name:");
		Label itemPriceLbl2 = new Label("Price:");
		Label itemStockLbl2 = new Label("Stock:");
		Label itemDescriptionLbl2 = new Label("Description:");
		Button updateBtn2 = new Button("Update");
		TextField itemNameField2 = new TextField("Hogwarts Icons - Collectors' Edition");
		itemNameField2.setEditable(false);
		TextField itemPriceField2 = new TextField(itemPrice2);
		TextField itemStockField2 = new TextField(itemStock2);
		TextField itemDesField2 = new TextField(itemDesc2);

		ImageView iv2 = new ImageView(new Image(getClass().getResourceAsStream("/assets/lego2.png")));
		iv2.setFitWidth(100);
		iv2.setFitHeight(100);

		
		HBox npsContainer2 = new HBox();
		HBox desContainer2 = new HBox();
		VBox lblContainer2 = new VBox();
		itemDesField2.setMinWidth(480);
		updateBtn2.setOnMouseClicked(e -> {
			
			if(itemPriceField2.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Price must be filled!");
	    		alert.showAndWait();
	    	}
			else if(itemStockField2.getText().isEmpty()) {
				Alert alert1 = new Alert(AlertType.ERROR);
	    		alert1.setContentText("Stock must be filled!");
	    		alert1.showAndWait();
			}
			else if(itemDesField2.getText().isEmpty()) {
				Alert alert2 = new Alert(AlertType.ERROR);
	    		alert2.setContentText("Description must be filled!");
	    		alert2.showAndWait();
			}
			
			try {
				Integer priceCheck = Integer.parseInt(itemPriceField2.getText());
				Integer stockCheck = Integer.parseInt(itemStockField2.getText());
				if(priceCheck <= 0) {
					Alert alert3 = new Alert(AlertType.ERROR);
		    		alert3.setContentText("Price must more than 0!");
		    		alert3.showAndWait();
				}
				else if(stockCheck < 0) {
					Alert alert4 = new Alert(AlertType.ERROR);
		    		alert4.setContentText("Stock must equal or more than 0!");
		    		alert4.showAndWait();
				}
				else {
					value.itemPrice2 = itemPriceField2.getText();
					value.itemStock2 = itemStockField2.getText();
					value.itemDesc2 = itemDesField2.getText();
					
					itemPriceField2.setText(value.itemPrice2);
					itemStockField2.setText(value.itemStock2);
					itemDesField2.setText(value.itemDesc2);
				}
			}
			catch(NumberFormatException o) {
				Alert alert5 = new Alert(AlertType.ERROR);
	    		alert5.setContentText("Price or Stock must be numeric!");
	    		alert5.showAndWait();
			}
			
			
			
		});
		iv2.setOnMouseClicked(e -> {
			Imageview2 img2 = new Imageview2();
	        try {
	            img2.start(new Stage());
	        } catch (Exception o) {
	            o.printStackTrace();
	        }
		});
	
		//Item 3
		Label itemNameLbl3 = new Label("Name:");
		Label itemPriceLbl3 = new Label("Price:");
		Label itemStockLbl3 = new Label("Stock:");
		Label itemDescriptionLbl3 = new Label("Description:");
		Button updateBtn3 = new Button("Update");
		TextField itemNameField3 = new TextField("Mickey Mouse");
		itemNameField3.setEditable(false);
		TextField itemPriceField3 = new TextField(itemPrice3);
		TextField itemStockField3 = new TextField(itemStock3);
		TextField itemDesField3 = new TextField(itemDesc3);

		ImageView iv3 = new ImageView(new Image(getClass().getResourceAsStream("/assets/lego3.png")));
		iv3.setFitWidth(100);
		iv3.setFitHeight(100);

		
		HBox npsContainer3 = new HBox();
		HBox desContainer3 = new HBox();
		VBox lblContainer3 = new VBox();
		itemDesField3.setMinWidth(480);
		updateBtn3.setOnMouseClicked(e -> {
			
			if(itemPriceField3.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Price must be filled!");
	    		alert.showAndWait();
	    	}
			else if(itemStockField3.getText().isEmpty()) {
				Alert alert1 = new Alert(AlertType.ERROR);
	    		alert1.setContentText("Stock must be filled!");
	    		alert1.showAndWait();
			}
			else if(itemDesField3.getText().isEmpty()) {
				Alert alert2 = new Alert(AlertType.ERROR);
	    		alert2.setContentText("Description must be filled!");
	    		alert2.showAndWait();
			}
			
			try {
				Integer priceCheck = Integer.parseInt(itemPriceField3.getText());
				Integer stockCheck = Integer.parseInt(itemStockField3.getText());
				if(priceCheck <= 0) {
					Alert alert3 = new Alert(AlertType.ERROR);
		    		alert3.setContentText("Price must more than 0!");
		    		alert3.showAndWait();
				}
				else if(stockCheck < 0) {
					Alert alert4 = new Alert(AlertType.ERROR);
		    		alert4.setContentText("Stock must equal or more than 0!");
		    		alert4.showAndWait();
				}
				else {
					value.itemPrice3 = itemPriceField3.getText();
					value.itemStock3 = itemStockField3.getText();
					value.itemDesc3 = itemDesField3.getText();
					
					itemPriceField3.setText(value.itemPrice3);
					itemStockField3.setText(value.itemStock3);
					itemDesField3.setText(value.itemDesc3);
				}
			}
			catch(NumberFormatException o) {
				Alert alert5 = new Alert(AlertType.ERROR);
	    		alert5.setContentText("Price or Stock must be numeric!");
	    		alert5.showAndWait();
			}
		});
		iv3.setOnMouseClicked(e -> {
			Imageview3 img3 = new Imageview3();
	        try {
	            img3.start(new Stage());
	        } catch (Exception o) {
	            o.printStackTrace();
	        }
		});
		
		//Item 4
		Label itemNameLbl4 = new Label("Name:");
		Label itemPriceLbl4 = new Label("Price:");
		Label itemStockLbl4 = new Label("Stock:");
		Label itemDescriptionLbl4 = new Label("Description:");
		Button updateBtn4 = new Button("Update");
		TextField itemNameField4 = new TextField("Eiffel Tower");
		itemNameField4.setEditable(false);
		TextField itemPriceField4 = new TextField(itemPrice4);
		TextField itemStockField4 = new TextField(itemStock4);
		TextField itemDesField4 = new TextField(itemDesc4);

		ImageView iv4 = new ImageView(new Image(getClass().getResourceAsStream("/assets/lego4.png")));
		iv4.setFitWidth(100);
		iv4.setFitHeight(100);

		
		HBox npsContainer4 = new HBox();
		HBox desContainer4 = new HBox();
		VBox lblContainer4 = new VBox();
		itemDesField4.setMinWidth(480);
		updateBtn4.setOnMouseClicked(e -> {
			
			if(itemPriceField4.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Price must be filled!");
	    		alert.showAndWait();
	    	}
			else if(itemStockField4.getText().isEmpty()) {
				Alert alert1 = new Alert(AlertType.ERROR);
	    		alert1.setContentText("Stock must be filled!");
	    		alert1.showAndWait();
			}
			else if(itemDesField4.getText().isEmpty()) {
				Alert alert2 = new Alert(AlertType.ERROR);
	    		alert2.setContentText("Description must be filled!");
	    		alert2.showAndWait();
			}
			
			try {
				Integer priceCheck = Integer.parseInt(itemPriceField4.getText());
				Integer stockCheck = Integer.parseInt(itemStockField4.getText());
				if(priceCheck <= 0) {
					Alert alert3 = new Alert(AlertType.ERROR);
		    		alert3.setContentText("Price must more than 0!");
		    		alert3.showAndWait();
				}
				else if(stockCheck < 0) {
					Alert alert4 = new Alert(AlertType.ERROR);
		    		alert4.setContentText("Stock must equal or more than 0!");
		    		alert4.showAndWait();
				}
				else {
					value.itemPrice4 = itemPriceField4.getText();
					value.itemStock4 = itemStockField4.getText();
					value.itemDesc4 = itemDesField4.getText();
					
					itemPriceField4.setText(value.itemPrice4);
					itemStockField4.setText(value.itemStock4);
					itemDesField4.setText(value.itemDesc4);
				}
			}
			catch(NumberFormatException o) {
				Alert alert5 = new Alert(AlertType.ERROR);
	    		alert5.setContentText("Price or Stock must be numeric!");
	    		alert5.showAndWait();
			}
			
			
			
		});
		iv4.setOnMouseClicked(e -> {
			Imageview4 img4 = new Imageview4();
	        try {
	            img4.start(new Stage());
	        } catch (Exception o) {
	            o.printStackTrace();
	        }
		});
		
		//Item 1
		npsContainer1.getChildren().addAll(itemNameLbl1, itemNameField1, itemPriceLbl1, itemPriceField1, itemStockLbl1, itemStockField1);
		desContainer1.getChildren().addAll(itemDescriptionLbl1, itemDesField1);
		lblContainer1.getChildren().addAll(npsContainer1, desContainer1, updateBtn1);
		npsContainer1.setAlignment(Pos.CENTER);
		desContainer1.setAlignment(Pos.CENTER);

		//Item 2
		npsContainer2.getChildren().addAll(itemNameLbl2, itemNameField2, itemPriceLbl2, itemPriceField2, itemStockLbl2, itemStockField2);
		desContainer2.getChildren().addAll(itemDescriptionLbl2, itemDesField2);
		lblContainer2.getChildren().addAll(npsContainer2, desContainer2, updateBtn2);
		npsContainer2.setAlignment(Pos.CENTER);
		desContainer2.setAlignment(Pos.CENTER);
		
		//Item 3
		npsContainer3.getChildren().addAll(itemNameLbl3, itemNameField3, itemPriceLbl3, itemPriceField3, itemStockLbl3, itemStockField3);
		desContainer3.getChildren().addAll(itemDescriptionLbl3, itemDesField3);
		lblContainer3.getChildren().addAll(npsContainer3, desContainer3, updateBtn3);
		npsContainer3.setAlignment(Pos.CENTER);
		desContainer3.setAlignment(Pos.CENTER);
		
		//Item 4
		npsContainer4.getChildren().addAll(itemNameLbl4, itemNameField4, itemPriceLbl4, itemPriceField4, itemStockLbl4, itemStockField4);
		desContainer4.getChildren().addAll(itemDescriptionLbl4, itemDesField4);
		lblContainer4.getChildren().addAll(npsContainer4, desContainer4, updateBtn4);
		npsContainer4.setAlignment(Pos.CENTER);
		desContainer4.setAlignment(Pos.CENTER);
		bp.getChildren().add(MenuContainer);
		bp.setTop(mb);

		gp.setHgap(20);
		gp.setVgap(20);
		gp.add(iv1, 0, 1);
		gp.add(lblContainer1, 1, 1);
		gp.add(iv2, 0, 2);
		gp.add(lblContainer2, 1, 2);
		gp.add(iv3, 0, 3);
		gp.add(lblContainer3, 1, 3);
		gp.add(iv4, 0, 4);
		gp.add(lblContainer4, 1, 4);

		bp.setCenter(gp);
		BorderPane.setAlignment(gp, Pos.CENTER);
		adminPage = new Scene(bp, 900, 700);
		
		
		
	}
	
	public String getItemDesc1() {
		return itemDesc1;
	}
	public void setItemDesc1(String itemDesc1) {
		this.itemDesc1 = itemDesc1;
		
	}
	public String getItemDesc2() {
		return itemDesc2;
	}
	public void setItemDesc2(String itemDesc2) {
		this.itemDesc2 = itemDesc2;
	}
	public String getItemDesc3() {
		return itemDesc3;
	}
	public void setItemDesc3(String itemDesc3) {
		this.itemDesc3 = itemDesc3;
	}
	public String getItemDesc4() {
		return itemDesc4;
	}
	public void setItemDesc4(String itemDesc4) {
		this.itemDesc4 = itemDesc4;
	}
	public String getItemStock1() {
		return itemStock1;
	}
	public void setItemStock1(String itemStock1) {
		this.itemStock1 = itemStock1;
	}
	public String getItemStock2() {
		return itemStock2;
	}
	public void setItemStock2(String itemStock2) {
		this.itemStock2 = itemStock2;
	}
	public String getItemStock3() {
		return itemStock3;
	}
	public void setItemStock3(String itemStock3) {
		this.itemStock3 = itemStock3;
	}
	public String getItemStock4() {
		return itemStock4;
	}
	public void setItemStock4(String itemStock4) {
		this.itemStock4 = itemStock4;
	}
	public String getItemPrice1() {
		return itemPrice1;
	}
	public void setItemPrice1(String itemPrice1) {
		this.itemPrice1 = itemPrice1;
	}
	public String getItemPrice2() {
		return itemPrice2;
	}
	public void setItemPrice2(String itemPrice2) {
		this.itemPrice2 = itemPrice2;
	}
	public String getItemPrice3() {
		return itemPrice3;
	}
	public void setItemPrice3(String itemPrice3) {
		this.itemPrice3 = itemPrice3;
	}
	public String getItemPrice4() {
		return itemPrice4;
	}
	public void setItemPrice4(String itemPrice4) {
		this.itemPrice4 = itemPrice4;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		this.arg0 = arg0;
		adminPage();
		getItemDesc1();
		arg0.setScene(adminPage);
	    arg0.setTitle("ADMIN");
	    Image icon = new Image("file:src/assets/logo.png");
		arg0.getIcons().add(icon);
	    arg0.show();
		
	}

}
