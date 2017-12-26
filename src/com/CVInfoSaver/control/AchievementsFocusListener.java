package com.CVInfoSaver.control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.CVInfoSaver.view.*;


public class AchievementsFocusListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		CVInfoSaverGUI gui = new CVInfoSaverGUI();
		 gui.setTabSelected(5);
		System.out.println("in");
		 panelAchievement selectedpanel = (panelAchievement) e.getSource();
		 gui.getCmbbxAchievementSemester().setSelectedIndex(Integer.parseInt(selectedpanel.getSemester()));
		 
		 gui.getTxtAchievementDescription().setText(selectedpanel.getAchievementDescription());
		 
		 gui.getBtnSubmitAchievementDetails().setText("Edit Details");
		 
		 
		 
		gui.repaint();
		gui.revalidate();
		 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
