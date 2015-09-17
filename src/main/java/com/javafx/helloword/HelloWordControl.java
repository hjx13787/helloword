package com.javafx.helloword;

import java.awt.Dialog;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.inject.Inject;

import io.advantageous.guicefx.LoadedBy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
@LoadedBy("HelloWord.fxml")
public class HelloWordControl implements Initializable {
	@FXML
	VBox v;
	@FXML
	MenuItem delete;
	
	@FXML
	MenuItem open;
	
	@FXML
	MenuItem close;
	@FXML
	TextArea text;
	@FXML TableView<CardUser> tableView;
//	@Inject
//	LoginController loginController;
	@Inject
	MessageController msg;
	
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("init");
		initTableBind();
	}
	private void initTableBind() {
		 ((TableColumn)tableView.getColumns().get(0)).setCellValueFactory(new PropertyValueFactory<CardUser,String>("identifier"));
		 ((TableColumn)tableView.getColumns().get(1)).setCellValueFactory(new PropertyValueFactory<CardUser,String>("name"));
		 tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	public void onDelete(){
		TableViewSelectionModel<CardUser> selectionModel = tableView.getSelectionModel();
		ObservableList<CardUser> selectedItems = selectionModel.getSelectedItems();
		CardUser cardUser = selectedItems.get(0);
		boolean confim = msg.confim("提示", "是否删除用户"+cardUser);
		if (confim) {
			onClose();
		}
	}
	public VBox getV() {
		return v;
	}
	
	public void onOpen(){
//		openfile();
		tableView.getVisibleLeafColumn(0);
		text.appendText("open\n");
		ObservableList<CardUser> items = tableView.getItems();
		if (items==null) {
			items=FXCollections.observableArrayList();
		}
		for (int i = 0; i < 100; i++) {
			CardUser c = new CardUser();
			c.setIdentifier("a"+i);
			c.setName("aaa");
			items.add(c);
		}
		tableView.setItems(items);
	}
	private void openfile() {
		FileChooser f=new FileChooser();
//		f.setSelectedExtensionFilter(new ExtensionFilter("txt"));
		File showOpenDialog = f.showOpenDialog(new Stage());
		System.out.println(showOpenDialog);
	}
	
	public void onClose(){
		text.clear();
		text.appendText("close\n");
		ObservableList<CardUser> fxDevices = FXCollections.observableArrayList();
		tableView.setItems(fxDevices);
	}
}
