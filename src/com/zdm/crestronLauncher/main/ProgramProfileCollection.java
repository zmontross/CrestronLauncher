package com.zdm.crestronLauncher.main;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;


public class ProgramProfileCollection extends HBox{

	private static final double DEFAULT_SPACING = 50.0;
	
	private static final String SIMPL_EXE = "V:\\Crestron\\Simpl\\smpwin.exe";
	private static final String SIMPL_IMG = "file:res/smpwin.png";
	
	private static final String SPLUS_EXE = "V:\\Crestron\\Simpl\\splus.exe"; //S3_SPIs.exe";
	private static final String SPLUS_IMG = "file:res/smpwin+.png";
	
	private static final String VTPRO_EXE = "V:\\Crestron\\vt_pro-e\\vtpro.exe";
	private static final String VTPRO_IMG = "file:res/Vtpro-e.png";
	
	private static final String TOOLBOX_EXE = "V:\\Crestron\\Toolbox\\Toolbox.exe";
	private static final String TOOLBOX_IMG = "file:res/Toolbox.png";

	private static final String[][] progs = {{SIMPL_EXE, SIMPL_IMG},
											 {SPLUS_EXE, SPLUS_IMG},
											 {VTPRO_EXE, VTPRO_IMG},
											 {TOOLBOX_EXE, TOOLBOX_IMG}};
	
	private boolean wasClicked = false;
	
	public ProgramProfileCollection() {
		
		for(int i=0; i<4; i++){
			
			System.out.println("Adding " + i + "|0 and "+ i + "|1");
			System.out.println("\t" + progs[i][0]);
			System.out.println("\t" + progs[i][1]);
			ProgramProfile p = new ProgramProfile(progs[i][0], progs[i][1]);
			
			this.getChildren().add(p);
			
			p.setOnAction(e ->{
				try {
					p.shortcut();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				wasClicked = true;
			});
			
		} // for i
		
		this.setPrefWidth((ProgramProfile.getDefaultIconSize() + DEFAULT_SPACING)* 4);
		this.setPrefHeight(((Region) this.getChildren().get(0)).getPrefHeight());
		
		this.setSpacing(DEFAULT_SPACING);
		
		this.setAlignment(Pos.CENTER);
		
	} // END
	
	
	public static double getDefaultSpacing(){
		return DEFAULT_SPACING;
	} // END
	
	public boolean wasShotcutClicked(){
		return wasClicked;
	} // END
	
} // END
