package com.CVInfoSaver;

import com.CVInfoSaver.view.CVInfoSaverGUI;

public class Main 
{
	public static void main(String[] agrs)
	{
		CVInfoSaverGUI gui = new CVInfoSaverGUI();
		gui.setSize(860,800);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}
}