package main;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class User extends Application {
	BorderPane bp;
	GridPane gp;
	VBox container;
	Scene WelcomePage, CACPage;
	Stage arg0;
	Boolean isPlaying = false;
	Admin value = new Admin();
	
	public void WelcomePage() {
		// TODO Auto-generated constructor stub
		bp = new BorderPane();
		gp = new GridPane();
		Text welcome = new Text("Welcome To LEGHO!");
		welcome.setStyle("-fx-font-size: 44; -fx-font-weight: bold;");
		Button continueBtn = new Button("CONTINUE>>");
		container = new VBox();
		File file = new File("src/assets/legovid.mp4");
		Media media = new Media(file.toURI().toString());
		MediaPlayer mp = new MediaPlayer(media);
		MediaView mv = new MediaView(mp);
		mv.setFitWidth(300);
		mv.setFitHeight(300);
		mp.play();
		mp.setCycleCount(MediaPlayer.INDEFINITE);

		Menu menu = new Menu("Menu");
		MenuItem logout = new MenuItem("Logout");
		MenuItem viewLego = new MenuItem("View Lego");
		MenuBar mb = new MenuBar();
		VBox MenuContainer = new VBox();
		menu.getItems().addAll(viewLego, logout);
		mb.getMenus().addAll(menu);
		MenuContainer.getChildren().add(mb);

		bp.setTop(mb);
		continueBtn.setStyle("-fx-background-color: #404040; -fx-text-fill: white; -fx-font-size: 14;");
		logout.setOnAction(e -> {
			Main loginPage = new Main();
			try {
				loginPage.start(arg0);

				mp.stop();
			}
			catch(Exception o) {
				o.printStackTrace();
			}	
		});
		viewLego.setOnAction(e -> {
			CACPage();
			mp.stop();
		});
		continueBtn.setOnAction(e -> {
			CACPage();
			mp.stop();
		});

		container.getChildren().addAll(welcome, mv, continueBtn);
		container.setAlignment(Pos.CENTER);
		VBox.setMargin(mv, new Insets(20, 0, 0, 0));
		VBox.setMargin(continueBtn, new Insets(20, 0, 0, -200));
		bp.setCenter(container);


		WelcomePage = new Scene(bp, 700, 700);
	}
	
	public void CACPage() {
		bp = new BorderPane();
		ScrollPane sp = new ScrollPane();
		Pane itemPane = new Pane();
		ScrollPane cartPane = new ScrollPane();
		File file = new File("src/assets/lofi.mp3");
		Media audio = new Media(file.toURI().toString());
		MediaPlayer audioPlayer = new MediaPlayer(audio);

		audioPlayer.play();
		audioPlayer.setCycleCount(MediaPlayer.INDEFINITE);

		Menu menu = new Menu("Menu");
		MenuItem logout = new MenuItem("Logout");
		MenuItem viewLego = new MenuItem("View Lego");
		MenuBar mb = new MenuBar();
		VBox MenuContainer = new VBox();
		menu.getItems().addAll(viewLego, logout);
		mb.getMenus().addAll(menu);
		MenuContainer.getChildren().add(mb);


		logout.setOnAction(e -> {
			Main loginPage = new Main();
			try {
				loginPage.start(arg0);

				audioPlayer.stop();
			}
			catch(Exception o) {
				o.printStackTrace();
			}	
		});
		viewLego.setOnAction(e -> {
			CACPage();
		});
		
		//Component
		Text title = new Text("Happy Shopping");
		VBox products = new VBox();
		HBox products_atas = new HBox();
		HBox products_bawah = new HBox();

		VBox vPane = new VBox();
		
		//item 1
		Text name1 = new Text("Name: Ironman Hulkbuster");
		Text price1 = new Text("Price: ");
		Text price1value = new Text(value.getItemPrice1());

		Text stock1 = new Text("Stock: ");
		Text stock1value = new Text(value.getItemStock1());
		Text desc1 = new Text("Description: ");
		Text desc1value = new Text(value.getItemDesc1());
		HBox price1box = new HBox();
		HBox stock1box = new HBox();
		HBox desc1box = new HBox();
		VBox item1box = new VBox();
		price1box.getChildren().addAll(price1, price1value);
		stock1box.getChildren().addAll(stock1, stock1value);
		desc1box.getChildren().addAll(desc1, desc1value);
		ImageView iv1 = new ImageView(new Image(getClass().getResourceAsStream("/assets/lego5.png")));
		iv1.setFitWidth(100);
		iv1.setFitHeight(100);
		item1box.getChildren().addAll(iv1, name1, price1box, stock1box, desc1box);
		//item 2
		Text name2 = new Text("Name: Hogwarts Icons - Collectors' Edition");
		Text price2 = new Text("Price: ");
		Text price2value = new Text(value.getItemPrice2());
		Text stock2 = new Text("Stock: ");
		Text stock2value = new Text(value.getItemStock2());
		Text desc2 = new Text("Description: ");
		Text desc2value = new Text(value.getItemDesc2());
		HBox price2box = new HBox();
		HBox stock2box = new HBox();
		HBox desc2box = new HBox();
		VBox item2box = new VBox();
		price2box.getChildren().addAll(price2, price2value);
		stock2box.getChildren().addAll(stock2, stock2value);
		desc2box.getChildren().addAll(desc2, desc2value);
		ImageView iv2 = new ImageView(new Image(getClass().getResourceAsStream("/assets/lego2.png")));
		iv2.setFitWidth(100);
		iv2.setFitHeight(100);
		item2box.getChildren().addAll(iv2, name2, price2box, stock2box, desc2box);
		//item 3
		Text name3 = new Text("Name: Mickey Mouse");
		Text price3 = new Text("Price: ");
		Text price3value = new Text(value.getItemPrice3());
		Text stock3 = new Text("Stock: ");
		Text stock3value = new Text(value.getItemStock3());
		Text desc3 = new Text("Description: ");
		Text desc3value = new Text(value.getItemDesc3());

		HBox price3box = new HBox();
		HBox stock3box = new HBox();
		HBox desc3box = new HBox();
		VBox item3box = new VBox();
		price3box.getChildren().addAll(price3, price3value);
		stock3box.getChildren().addAll(stock3, stock3value);
		desc3box.getChildren().addAll(desc3, desc3value);
		ImageView iv3 = new ImageView(new Image(getClass().getResourceAsStream("/assets/lego3.png")));
		iv3.setFitWidth(100);
		iv3.setFitHeight(100);
		item3box.getChildren().addAll(iv3, name3, price3box, stock3box, desc3box);
		//item 4
		Text name4 = new Text("Name: Eiffel Tower");
		Text price4 = new Text("Price: ");
		Text price4value = new Text(value.getItemPrice4());
		Text stock4 = new Text("Stock: ");
		Text stock4value = new Text(value.getItemStock4());
		Text desc4 = new Text("Description: ");
		Text desc4value = new Text(value.getItemDesc4());
		HBox price4box = new HBox();
		HBox stock4box = new HBox();
		HBox desc4box = new HBox();
		VBox item4box = new VBox();
		price4box.getChildren().addAll(price4, price4value);
		stock4box.getChildren().addAll(stock4, stock4value);
		desc4box.getChildren().addAll(desc4, desc4value);
		ImageView iv4 = new ImageView(new Image(getClass().getResourceAsStream("/assets/lego4.png")));
		iv4.setFitWidth(100);
		iv4.setFitHeight(100);
		item4box.getChildren().addAll(iv4, name4, price4box, stock4box, desc4box);
		
		//layout item
		products_atas.getChildren().addAll(item1box, item2box);
		products_bawah.getChildren().addAll(item3box, item4box);
		products_bawah.setSpacing(100);
		products.getChildren().addAll(products_atas, products_bawah);
		itemPane.getChildren().add(products);
		products.setAlignment(Pos.CENTER);
		sp.setContent(itemPane);
		sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	    sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	    cartPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	    //layout pane 
	    Text paneTitle = new Text("Your Cart");
	    Button buyBtn = new Button("Buy");
	    Button clearCart = new Button("Clear Cart");
	    paneTitle.setStyle("-fx-font-size: 24;");
	    HBox btnPane = new HBox();
	    btnPane.getChildren().addAll(buyBtn, clearCart);
	    btnPane.setAlignment(Pos.CENTER);
	    VBox cartPaneContainer = new VBox();
	    cartPaneContainer.getChildren().addAll(paneTitle, cartPane, btnPane);
	    cartPane.setMinHeight(450);
	    btnPane.setSpacing(10);
	    buyBtn.setMinWidth(120);
	    clearCart.setMinWidth(120);
	    cartPaneContainer.setAlignment(Pos.CENTER);
	    VBox.setVgrow(cartPaneContainer, Priority.ALWAYS);
	    SplitPane container = new SplitPane(sp, cartPaneContainer);  
	    VBox.setMargin(container, new Insets(10));
	    container.setMinHeight(470);
	    vPane.getChildren().addAll(title, container);
	    vPane.setAlignment(Pos.TOP_CENTER);
	    bp.setCenter(vPane);
	    bp.setTop(MenuContainer);
	    cartPane.setPrefSize(800, 800);
	    cartPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    //Drag and Drop
	    iv1.setOnDragDetected(e -> {
	    	if(Integer.parseInt(stock1value.getText()) == 0) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Out of Stock!");
	    		alert.showAndWait(); 
	    	}
	    	 Dragboard db = iv1.startDragAndDrop(TransferMode.MOVE);
	    	 ClipboardContent clipboard = new ClipboardContent();	  
	    	 clipboard.putImage(iv1.getImage());
	    	 clipboard.putString("item 1");
	    	 db.setContent(clipboard);
	    	 db.setDragView(iv1.getImage());
	    	 e.consume();
	    });
	    iv2.setOnDragDetected(e -> {
	    	if(Integer.parseInt(stock2value.getText()) == 0) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Out of Stock!");
	    		alert.showAndWait(); 
	    	}
	    	Dragboard db = iv2.startDragAndDrop(TransferMode.MOVE);
	    	ClipboardContent clipboard = new ClipboardContent();
	    	clipboard.putImage(iv2.getImage());
	    	clipboard.putString("item 2");
	    	db.setContent(clipboard);
	    	db.setDragView(iv2.getImage());
	    	e.consume();

	    });
	    iv3.setOnDragDetected(e -> {
	    	if(Integer.parseInt(stock3value.getText()) == 0) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Out of Stock!");
	    		alert.showAndWait(); 
	    	}
	    	Dragboard db = iv3.startDragAndDrop(TransferMode.MOVE);
	    	ClipboardContent clipboard = new ClipboardContent();
	    	clipboard.putImage(iv3.getImage());
	    	clipboard.putString("item 3");
	    	db.setContent(clipboard);
	    	db.setDragView(iv3.getImage());
	    	e.consume();
	    });
	    iv4.setOnDragDetected(e -> {
	    	if(Integer.parseInt(stock4value.getText()) == 0) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Out of Stock!");
	    		alert.showAndWait(); 
	    	}
	    	Dragboard db = iv4.startDragAndDrop(TransferMode.MOVE);
	    	ClipboardContent clipboard = new ClipboardContent();
	    	clipboard.putImage(iv4.getImage());
	    	clipboard.putString("item 4");
	    	db.setContent(clipboard);
	    	db.setDragView(iv4.getImage());
	    	e.consume();
	    });
	    cartPane.setOnDragOver(e -> {
	    	e.acceptTransferModes(TransferMode.MOVE);
	    	e.consume();
	    });
	    Map<String, Integer> intialStockValue = new HashMap<>();
	    intialStockValue.put("itemStock1", Integer.parseInt(value.itemStock1));
	    intialStockValue.put("itemStock2", Integer.parseInt(value.itemStock2));
	    intialStockValue.put("itemStock3", Integer.parseInt(value.itemStock3));
	    intialStockValue.put("itemStock4", Integer.parseInt(value.itemStock4));
	    cartPane.setOnDragDropped(e -> {
	        Dragboard db = e.getDragboard();
	        if (db.hasString()) {
	            String draggedItem = db.getString();
	            Image droppedImage = null;

	            if (draggedItem.equals("item 1") && Integer.parseInt(stock1value.getText()) > 0) {
	                int newItemStock1 = Integer.parseInt(value.itemStock1) - 1;
	                value.itemStock1 = String.valueOf(newItemStock1);
	                droppedImage = db.getImage();
	                stock1value.setText(String.valueOf(newItemStock1));
	            } else if (draggedItem.equals("item 2") && Integer.parseInt(stock2value.getText()) > 0) {
	                int newItemStock2 = Integer.parseInt(value.itemStock2) - 1;
	                value.itemStock2 = String.valueOf(newItemStock2);
	                droppedImage = db.getImage();
	                stock2value.setText(String.valueOf(newItemStock2));
	            } else if (draggedItem.equals("item 3") && Integer.parseInt(stock3value.getText()) > 0) {
	                int newItemStock3 = Integer.parseInt(value.itemStock3) - 1;
	                value.itemStock3 = String.valueOf(newItemStock3);
	                droppedImage = db.getImage();
	                stock3value.setText(String.valueOf(newItemStock3));
	            } else if (draggedItem.equals("item 4") && Integer.parseInt(stock4value.getText()) > 0) {
	                int newItemStock4 = Integer.parseInt(value.itemStock4) - 1;
	                value.itemStock4 = String.valueOf(newItemStock4);
	                droppedImage = db.getImage();
	                stock4value.setText(String.valueOf(newItemStock4));
	            }

	            if (droppedImage != null) {
	                ImageView newImageCart = new ImageView(droppedImage);
	                newImageCart.setFitWidth(100);
	                newImageCart.setFitHeight(100);
	                TilePane cartItems = (TilePane) cartPane.getContent();
	                if (cartItems == null) {
	                    cartItems = new TilePane();
	                    cartPane.setContent(cartItems);
	                    cartItems.setPrefColumns(7); // Number of columns
	                    cartItems.setPadding(new Insets(10, 25, 0, 25));
	                    
	                }
	                cartItems.getChildren().add(newImageCart);
	                e.setDropCompleted(true);
	            }
	        }

	        e.consume();
	    });
	    buyBtn.setOnMouseClicked(e -> {
	    	if(cartPane.getContent() == null) {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("No items is purchased!");
	    		alert.showAndWait(); 
	    	}
	    	else {
	    		int newItemStock1 = Integer.parseInt(stock1value.getText());
	    		value.itemStock1 = String.valueOf(newItemStock1);
	    		int newItemStock2 = Integer.parseInt(stock2value.getText());
	    		value.itemStock2 = String.valueOf(newItemStock2);
	    		int newItemStock3 = Integer.parseInt(stock3value.getText());
	    		value.itemStock3 = String.valueOf(newItemStock3);
	    		int newItemStock4 = Integer.parseInt(stock4value.getText());
	    		value.itemStock4 = String.valueOf(newItemStock4);
	    		cartPane.setContent(null);
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setContentText("Purchase Succesfull ^V^, TERIMAGAJIH!");
	    		alert.showAndWait(); 
	    	}
	    	
	    });
	    clearCart.setOnMouseClicked(e -> {
	    	if(cartPane.getContent() != null) {
	    		value.itemStock1 = String.valueOf(intialStockValue.get("itemStock1"));
	    		value.itemStock2 = String.valueOf(intialStockValue.get("itemStock2"));
	    		value.itemStock3 = String.valueOf(intialStockValue.get("itemStock3"));
	    		value.itemStock4 = String.valueOf(intialStockValue.get("itemStock4"));
	    		stock1value.setText(value.itemStock1);
	    		stock2value.setText(value.itemStock2);
	    		stock3value.setText(value.itemStock3);
	    		stock4value.setText(value.itemStock4);
	    		cartPane.setContent(null);
	    	}	
	    });
	    //image view
	    iv1.setOnMouseClicked(e -> {
			Imageview1 img1 = new Imageview1();
	        try {
	            img1.start(new Stage());
	        } catch (Exception o) {
	            o.printStackTrace();
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
	    iv3.setOnMouseClicked(e -> {
			Imageview3 img3 = new Imageview3();
	        try {
	            img3.start(new Stage());
	        } catch (Exception o) {
	            o.printStackTrace();
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
		// Scene
	    CACPage = new Scene(bp, 700, 600);
	    arg0.setScene(CACPage);
	    arg0.setTitle("USER");
	    Image icon = new Image("file:src/assets/logo.png");
		arg0.getIcons().add(icon);
	    arg0.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		this.arg0 = arg0;
		WelcomePage();
		arg0.setScene(WelcomePage);
	    arg0.setTitle("USER");
	    Image icon = new Image("file:src/assets/logo.png");
		arg0.getIcons().add(icon);
	    arg0.show();
	}

}
