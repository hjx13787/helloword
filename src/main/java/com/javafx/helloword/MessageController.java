package com.javafx.helloword;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import io.advantageous.guicefx.LoadedBy;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

@LoadedBy("Login.fxml")
public class MessageController {
	@FXML
	private VBox v;
	@FXML
	private Button ok;
	@FXML
	private Button canel;
	@FXML
	private Label message;
	
	boolean confim=false;

	Scene scene;
	Stage stage;
	@FXML
	public void onOk(ActionEvent event) {
		confim=true;
		if (stage!=null) {
			stage.close();
		}
	}
	
	@FXML
	public void onCanel(ActionEvent event) {
		confim=false;
		if (stage!=null) {
			stage.close();
		}
	}

	public Label getMessage() {
		return message;
	}

	public void setMessage(Label message) {
		this.message = message;
	}

	public VBox getV() {
		return v;
	}
	
	public boolean confim(String title,String msg){
		confim=false;
		stage = new Stage();
		this.message.setText(msg);
		if (scene==null) {
			scene = new Scene(v);
		}
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.showAndWait();
		return confim;
	}
}
