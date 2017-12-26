package com.CVInfoSaver.control;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import com.CVInfoSaver.view.*;
//import com.EmployeeManagement.View.PanelEmployeeRecord;
//import com.EmployeeManagement.View.frmEmployee;


public class CourseFocusListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		CVInfoSaverGUI gui = new CVInfoSaverGUI();
		
//		System.out.println("InC");
//		gui.setTabSelected(2);
		
		panelCourse selectedpanel = (panelCourse)e.getSource();
		
		if(selectedpanel.getSemester().equalsIgnoreCase("Semester"))
		{
			
		}
		else
		{
			CVInfoSaverGUI gui = (CVInfoSaverGUI) SwingUtilities.getRoot(selectedpanel);
			
			gui.setTabSelected(2);
			gui.getCmbbxCourseSemester().setSelectedItem(selectedpanel.getSemester());
		    gui.getTxtCourseNo().setText(selectedpanel.getCourseNo());
		    gui.getTxtCourseName().setText(selectedpanel.getCourseName());
		    gui.getTxtCourseDescription().setText(selectedpanel.getCourseDescription());
		    gui.getTxtCourseGrade().setText(selectedpanel.getGrade());
		    
		    gui.getBtnSubmitCourseDetails().setText("Edit Course Details");
		    gui.getBtnDeleteCourseDetails().setEnabled(true);
		    
		    gui.getCmbbxCourseSemester().setEditable(false);
		    gui.getTxtCourseNo().setEditable(false);
		    gui.getTxtCourseName().setEditable(false);
		    gui.getTxtCourseDescription().setEditable(false);
		    gui.getTxtCourseGrade().setEditable(false);
		}    
	    
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		panelCourse selectedpanel = (panelCourse)e.getSource();
		
		selectedpanel.setBackground(Color.yellow);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
panelCourse selectedpanel = (panelCourse)e.getSource();
		
		selectedpanel.setBackground(Color.WHITE);
		
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
