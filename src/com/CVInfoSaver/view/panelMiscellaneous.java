package com.CVInfoSaver.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelMiscellaneous extends JPanel{
	
	private JLabel lblSemester = new JLabel();
	private JLabel lblMiscDate = new JLabel();
	private JLabel lblMiscDescription = new JLabel();
	
	public panelMiscellaneous(String semester,String date, String description)
	{
		lblSemester.setText(semester);
		lblMiscDate.setText(date);
		lblMiscDescription.setText(description);
		
		this.setLayout(new GridLayout(0, 2, 2, 2));
		
		this.add(new JLabel("Semester: "));
		this.add(lblSemester);
		this.add(new JLabel("Date: "));
		this.add(lblMiscDate);
		this.add(new JLabel("Description: "));
		this.add(lblMiscDescription);
		
//		this.addMouseListener(new StudentFocusListner());
		
	}
	
	public String getSemester() {
		return lblSemester.getText();
	}
	
	public String getMiscDate() {
		return lblMiscDate.getText();
	}
	
	public String getMiscDescription() {
		return lblMiscDescription.getText();
	}
	
	
}
