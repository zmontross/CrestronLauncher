package com.zdm.crestronLauncher.main;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public class ProgramProfile extends Button{
	
	private static final double DEFAULT_SIZE = 50.0;

	private String filePathExe = null;
	private String filePathIcon = null;
	private Image icon;
	
	public ProgramProfile(String filePathExe, String filePathIcon){
		
		this.filePathExe = filePathExe;
		this.filePathIcon = filePathIcon; //"file:D:/Users/Zachary/Documents/_ZDM_Programming/CrestronLauncher/res/smpwin.png";
		
		this.icon = new Image(this.filePathIcon, DEFAULT_SIZE, DEFAULT_SIZE, true, false);
		
		this.setPrefSize(icon.getWidth(), icon.getHeight());
		this.setBackground(new Background(new BackgroundImage(icon, null, null, null, null)));
		
		this.setOnAction(e -> {
			/**
			 * The following try/catch block was face-lifted from AvaJava.com in the example program 'RuntimeExecTest1.java'.
			 * URL: http://www.avajava.com/tutorials/lessons/how-do-i-run-another-application-from-java.html?page=1
			 * */
			try {
				System.out.println("Opening notepad");
				Runtime runTime = Runtime.getRuntime();
				runTime.exec(this.filePathExe);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	} // END
	
	public static double getDefaultIconSize(){
		return DEFAULT_SIZE;
	} // END
	
	/**
	 * If I were to push this further I'd probably make some sort of "setTarget()" method, and allow for rearranging and nice-looking GUI effects.
	 * I don't need that, so I'm hard-coding it all.
	 * */
	
} // END