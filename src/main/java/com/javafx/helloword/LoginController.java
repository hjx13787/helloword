package com.javafx.helloword;

import javafx.fxml.FXML;
import io.advantageous.guicefx.LoadedBy;
import javafx.event.ActionEvent;

import javafx.scene.control.MenuItem;

import javafx.scene.control.TextArea;

import javafx.scene.layout.VBox;

import javafx.scene.control.TableView;

@LoadedBy("Login.fxml")
public class LoginController {
	@FXML
	private VBox v;
	public VBox getV() {
		return v;
	}
	@FXML
	private MenuItem open;
	@FXML
	private MenuItem close;
	@FXML
	private MenuItem delete;
	@FXML
	private TextArea text;
	@FXML
	private TableView tableView;

	// Event Listener on MenuItem[#open].onAction
	@FXML
	public void onOpen(ActionEvent event) {
		
	}


	@FXML
	public void onClose(ActionEvent event) {
		
	}
	// Event Listener on MenuItem[#delete].onAction
	@FXML
	public void onDelete(ActionEvent event) {
		
	}
}
