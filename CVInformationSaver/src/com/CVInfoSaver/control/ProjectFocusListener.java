package com.CVInfoSaver.control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.CVInfoSaver.view.*;


public class ProjectFocusListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		CVInfoSaverGUI gui = new CVInfoSaverGUI();
		 gui.setTabSelected(3);
		 panelProject selectedpanel = (panelProject)e.getSource();
		 gui.getCmbbxProjectSemester().setSelectedIndex(Integer.parseInt(selectedpanel.getSemester()));
		 gui.getTxtProjectName().setText(selectedpanel.getProjectName());
		 gui.getTxtProjectMentorName().setText(selectedpanel.getMentorName());
		 gui.getTxtProjectDuration().setText(selectedpanel.getProjectDuration());
		 gui.getTxtNoOfTeamMembers().setText(selectedpanel.getNoOfTeamMembers());
		 gui.getTxtProjectDescription().setText(selectedpanel.getProjectDescription());
		
		 gui.getBtnSubmitProjectDetails().setText("Edit Details");
		 
		
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
