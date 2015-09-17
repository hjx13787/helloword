package com.javafx.helloword;



import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloWord extends Application{
	
	private HelloWordControl control;
	
	@Override
	public void init() throws Exception {
		Injector injector = Guice.createInjector(new DongluServerJavafxModule());
        control = injector.getInstance(HelloWordControl.class);
	}
	@Override
	public void start(Stage stage) {
		try {
			Scene scene = new Scene(control.getV(),600,400);
			stage.setScene(scene);
			stage.setTitle("JavaFX记事本");  
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HelloWord.launch(args);
	}
}
