package com.CVInfoSaver.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelInternship extends JPanel{

	private JLabel lblSemester = new JLabel();
	private JLabel lblOrganisationName = new JLabel();
	private JLabel lblInternshipPeriod = new JLabel();	
	private JLabel lblInternshipDescription = new JLabel();
	
	public panelInternship(String semester,String name, String period, String description)
	{
		lblSemester.setText(semester);
		lblOrganisationName.setText(name);
		lblInternshipPeriod.setText(period);
		lblInternshipDescription.setText(description);
		
		
		this.setLayout(new GridLayout(0, 2, 2, 2));
		
		this.add(new JLabel("Semester: "));
		this.add(lblSemester);
		this.add(new JLabel("Organisation Name: "));
		this.add(lblOrganisationName);
		this.add(new JLabel("Internship Period: "));
		this.add(lblInternshipPeriod);
		this.add(new JLabel("Description: "));
		this.add(lblInternshipDescription);
		
//		this.addMouseListener(new StudentFocusListner());
		
	}
	
	public String getSemester() {
		return lblSemester.getText();
	}
	
	public String getOrganisationName() {
		return lblOrganisationName.getText();
	}
	
	public String getInternshipPeriod() {
		return lblInternshipPeriod.getText();
	}
	
	public String getInternshipDescription() {
		return lblInternshipDescription.getText();
	}
	
	

	
	
}
