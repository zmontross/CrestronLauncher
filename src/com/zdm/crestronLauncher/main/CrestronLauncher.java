package com.zdm.crestronLauncher.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Zachary D. Montross
 * 
 * Created:
 * 		2016-01-30
 * 
 * Description:
 * 		I recently downloaded Crestron softwares to my Desktop computer for some occasional use. Key word, occasional.
 * 		The purpose of this program is to provide a small JavaFX GUI to act as a launcher for these programs.
 * 		In this way I will have only one custom-made shortcut on my desktop for three or four different programs.
 * 
 * 
 * */


public class CrestronLauncher extends Application{

	Stage window;
	Scene scene;
	
	ProgramProfileCollection ppc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	} // END


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = new Stage();
		window = primaryStage;
		
		ppc = new ProgramProfileCollection();
		ppc.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
		ppc.setOnMouseExited(e ->{
			if(ppc.wasShotcutClicked()){
				window.close();
			}
		});
		
		scene = new Scene(ppc);
		scene.setFill(Color.GRAY);
		
		window.setScene(scene);
		window.setTitle("Crestron Apps Launcher");
		window.setMinHeight(ProgramProfileCollection.getDefaultSpacing() * 3);
		window.setResizable(false);
		window.show();
	} // END
	
	
}
