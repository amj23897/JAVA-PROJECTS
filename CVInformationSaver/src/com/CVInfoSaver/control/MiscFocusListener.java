package com.CVInfoSaver.control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.CVInfoSaver.view.*;

public class MiscFocusListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		CVInfoSaverGUI gui = new CVInfoSaverGUI();
		gui.setTabSelected(3);
		panelMiscellaneous selectedpanel = (panelMiscellaneous)e.getSource();
		
		gui.getCmbbxMiscSemester().setSelectedIndex(Integer.parseInt(selectedpanel.getSemester()));
		gui.getTxtMiscDescription().setText(selectedpanel.getMiscDescription());
		
		gui.getBtnSubmitMiscDetails().setText("Edit Detail");
		
		
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
