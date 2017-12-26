package com.CVInfoSaver.control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.CVInfoSaver.view.*;


public class WorkshopFocusListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		CVInfoSaverGUI gui = new CVInfoSaverGUI();
				
		gui.setTabSelected(4);
		panelWorkshop selectedpanel = (panelWorkshop)e.getSource();
		
		gui.getCmbbxWorkshopSemester().setSelectedIndex(Integer.parseInt(selectedpanel.getSemester()));
		gui.getTxtWorkshopTitle().setText(selectedpanel.getWorkshopTitle());
		gui.getTxtWorkshopOrganizer().setText(selectedpanel.getWorkshopOrganizer());
		gui.getTxtWorkshopTeacher().setText(selectedpanel.getWorkshopTeacher());
		gui.getTxtWorkshopDescription().setText(selectedpanel.getWorkshopDescription());
		if(selectedpanel.getCertified().equalsIgnoreCase("Yes"))
			gui.getChckbxAwardedCertified().setSelected(true);
		else
			gui.getChckbxAwardedCertified().setSelected(false);
				
		gui.getBtnSubmitWorkshopDetails().setText("Edit Details");
		
				
				
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
