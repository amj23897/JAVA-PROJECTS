package com.CVInfoSaver.control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.CVInfoSaver.view.*;


public class InternshipFocusListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		CVInfoSaverGUI gui = new CVInfoSaverGUI();
		gui.setTabSelected(6);
		panelInternship selectedpanel = (panelInternship)e.getSource();
		
		gui.getTxtInternshipOrganisationName().setText(selectedpanel.getOrganisationName());
		gui.getTxtInternshipPeriod().setText(selectedpanel.getInternshipPeriod());
		gui.getTxtInternshipDescription().setText(selectedpanel.getInternshipDescription());
		gui.getCmbbxAchievementSemester().setSelectedIndex(Integer.parseInt(selectedpanel.getSemester()));
		
		gui.getBtnSubmitInternshipDetails().setText("Edit Details");
		
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
