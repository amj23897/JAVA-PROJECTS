
package com.CVInfoSaver.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.CVInfoSaver.control.CVInfoSaverListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.ScrollPaneConstants;

public class CVInfoSaverGUI extends JFrame
{
	private JTabbedPane Inputpanel;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtName;
	private final ButtonGroup buttonGroup_gender = new ButtonGroup();
	private JTextField txtConactNo;
	private JTextField txtEmail;
	private JTextField txtMothersName;
	private JTextField txtFathersName;
	private JTextField txtProjectName;
	private JTextField txtProjectMentorName;
	private JTextField txtProjectDuration;
	private JTextField txtNoOfTeamMembers;
	private JTextField txtWorkshopTeacher;
	private JTextField txtWorkshopTitle;
	private JTextField txtWorkshopOrganizer;
	private JTextField txtInternshipOrganisationName;
	private JTextField txtInternshipPeriod;
	private JTextField txtsscPercentage;
	private JTextField txtsscBoard;
	private JTextField txthscPercentage;
	private JTextField txthscBoard;
	private JTextField txtDegree;
	private JTextField txtCollegeName;
	private JTextField txtcgpaObtained;
	private JTextField txtcgpaTotal;
	private JTextField txtGrade;
	private JTextField txtCourseNo;
	private JTextField txtCourseName;
	private JTextField txtProfessorName;
	private JTextField txtCourseGrade;
	
	
	private JTextArea txtHobbies;
	private JTextArea txtAddress;
	private JTextArea txtCourseDescription;
	private JTextArea txtProjectDescription; 
	private JTextArea txtInternshipDescription;
	private JTextArea txtWorkshopDescription;
	private JTextArea txtAchievementDescription;
	private JTextArea txtMiscDescription;

	private JButton btnSubmitBasicInfo;
	private JButton btnSubmitEducationDetails;
	private JButton btnSubmitCourseDetails;
	private JButton btnDeleteCourseDetails;
	private JButton btnSubmitProjectDetails;
	private JButton btnDeleteProjectDetails;
	private JButton btnSubmitInternshipDetails;
	private JButton btnDeleteInternshipDetails;
	private JButton btnSubmitWorkshopDetails;
	private JButton btnDeleteWorkshopDetails;
	private JButton btnSubmitAchievementDetails;
	private JButton btnDeleteAchievementDetails;
	private JButton btnSubmitMiscDetails;
	private JButton btnDeleteMiscDetails;
	private JButton btnView;
	
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JComboBox cmbbxDate;
	private JComboBox cmbbxMonth;
	private JComboBox cmbbxYear;
	private JComboBox cmbbxsscPassingYear;
	private JComboBox cmbbxhscPassingYear;
	private JComboBox cmbbxCourseSemester;
	private JComboBox cmbbxProjectSemester;
	private JComboBox cmbbxInternshipSemester; 
	private JComboBox cmbbxWorkshopSemester;
	private JComboBox cmbbxWorkshopDate;
	private JComboBox cmbbxWorkshopMonth;
	private JComboBox cmbbxWorkshopYear;
	private JComboBox cmbbxAchievementSemester;
	private JComboBox cmbbxAchievementDate;
	private JComboBox cmbbxAchievementMonth;
	private JComboBox cmbbxAchievementYear;
	private JComboBox cmbbxMiscSemester;
	private JComboBox cmbbxMiscDate;
	private JComboBox cmbbxMiscMonth;
	private JComboBox cmbbxMiscYear;
	
	private JComboBox<String> cmbbxSelectSemesterMIDPNL;
	
	private JCheckBox chckbxCourseStar;
	private JCheckBox chckbxProjectStar;
	private JCheckBox chckbxInternshipStar; 
	private JCheckBox chckbxCertified; 
	private JCheckBox chckbxWorkshopStar;
	private JCheckBox chckbxAchievementStar;
	private JCheckBox chckbxAwardedCertified;
	private JCheckBox chckbxMiscellaneousStar;
	
	private JCheckBox chckbxStarredOnly;
	
	private JRadioButton rdbtnCourse;
	private JRadioButton rdbtnProject;
	private JRadioButton rdbtnWorkshops;
	private JRadioButton rdbtnInternships;
	private JRadioButton rdbtnAchievements;
	private JRadioButton rdbtnMisc;
	
	private JPanel tbEducation;
	private JPanel tbProject;
	private JPanel tbInternships;
	private JPanel tbWorkshops;
	private JPanel tbCourses;
	private JPanel tbAchievements;
	private JPanel tbMisc;
	private JPanel SelectionPanel;
	private JPanel DisplayPanel;
	
	private JLabel lblException;
	
   	
	private JScrollPane scrlDsplayPanel; 
	
   	CVInfoSaverListener cvinfosaverlistener;
   	private JScrollPane scrlDisplayPanel;
   	private JPanel panelParentDisplayPanel;
	
	public CVInfoSaverGUI() {
		setTitle("CV Info Saver");
		setBackground(SystemColor.inactiveCaption);
		getContentPane().setBackground(Color.CYAN);
		getContentPane().setLayout(null);
		
		Inputpanel = new JTabbedPane(JTabbedPane.TOP);
		Inputpanel.setBackground(SystemColor.inactiveCaption);
		Inputpanel.setBounds(10, 11, 813, 242);
		getContentPane().add(Inputpanel);
		
//		JPanel panel_1 = new JPanel();
		//tbBasicInfo.addTab("New tab", null, panel_1, null);
		
//		JLabel lblNewLabel_2 = new JLabel("New label");
//		panel_1.add(lblNewLabel_2);
		
//		JLabel lblNewLabel_1 = new JLabel("New label");
//		panel_1.add(lblNewLabel_1);
		
		JPanel tbBasicInfo = new JPanel();
		tbBasicInfo.setBorder(null);
		tbBasicInfo.setBackground(SystemColor.inactiveCaption);
		Inputpanel.addTab("Basic Info", null, tbBasicInfo, null);
		Inputpanel.setBackgroundAt(0, SystemColor.inactiveCaption);
		tbBasicInfo.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBounds(24, 8, 46, 20);
		tbBasicInfo.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(169, 8, 212, 20);
		tbBasicInfo.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(24, 39, 46, 14);
		tbBasicInfo.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setBackground(SystemColor.inactiveCaption);
		buttonGroup_gender.add(rdbtnMale);
		rdbtnMale.setBounds(169, 35, 55, 23);
		tbBasicInfo.add(rdbtnMale);
		
	    rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(SystemColor.inactiveCaption);
		buttonGroup_gender.add(rdbtnFemale);
		rdbtnFemale.setBounds(229, 35, 59, 23);
		tbBasicInfo.add(rdbtnFemale);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setBounds(24, 66, 77, 14);
		tbBasicInfo.add(lblDateOfBirth);
		
		cmbbxDate = new JComboBox();
		cmbbxDate.setModel(new DefaultComboBoxModel(new String[] {"Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbbxDate.setBounds(169, 65, 55, 20);
		
			
			tbBasicInfo.add(cmbbxDate);
			
			cmbbxMonth = new JComboBox();
			cmbbxMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
			cmbbxMonth.setBounds(239, 65, 77, 20);
			tbBasicInfo.add(cmbbxMonth);
			
	        cmbbxYear = new JComboBox();
			cmbbxYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
			cmbbxYear.setBounds(326, 66, 55, 20);
			tbBasicInfo.add(cmbbxYear);
			
			JLabel lblContactNo = new JLabel("Contact No:");
			lblContactNo.setBounds(447, 11, 77, 14);
			tbBasicInfo.add(lblContactNo);
			
			txtConactNo = new JTextField();
			txtConactNo.setBounds(565, 8, 127, 20);
			tbBasicInfo.add(txtConactNo);
			txtConactNo.setColumns(10);
			
			JLabel lblEmailId = new JLabel("Email Id:");
			lblEmailId.setBounds(447, 39, 46, 14);
			tbBasicInfo.add(lblEmailId);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(565, 36, 158, 20);
			tbBasicInfo.add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblAddress = new JLabel("Address:");
			lblAddress.setBounds(447, 66, 46, 14);
			tbBasicInfo.add(lblAddress);
			
			JLabel lblHobbies = new JLabel("Hobbies:");
			lblHobbies.setBounds(24, 91, 46, 14);
			tbBasicInfo.add(lblHobbies);
			
			txtMothersName = new JTextField();
			txtMothersName.setBounds(169, 146, 212, 20);
			tbBasicInfo.add(txtMothersName);
			txtMothersName.setColumns(10);
			
			txtFathersName = new JTextField();
			txtFathersName.setBounds(169, 177, 212, 20);
			tbBasicInfo.add(txtFathersName);
			txtFathersName.setColumns(10);
			
			JLabel lblMothersName = new JLabel("Mother's Name:");
			lblMothersName.setBounds(24, 149, 77, 14);
			tbBasicInfo.add(lblMothersName);
			
			JLabel lblFathersName = new JLabel("Father's Name:");
			lblFathersName.setBounds(24, 180, 77, 14);
			tbBasicInfo.add(lblFathersName);
			
			btnSubmitBasicInfo = new JButton("Submit Basic Info");
			btnSubmitBasicInfo.setBounds(596, 145, 130, 23);
			tbBasicInfo.add(btnSubmitBasicInfo);
			
			JScrollPane scrlHobbies = new JScrollPane();
			scrlHobbies.setBounds(169, 96, 212, 39);
			tbBasicInfo.add(scrlHobbies);
			
			txtHobbies = new JTextArea();
			scrlHobbies.setViewportView(txtHobbies);
			
			JScrollPane scrlAddress = new JScrollPane();
			scrlAddress.setBounds(565, 66, 189, 68);
			tbBasicInfo.add(scrlAddress);
			
		    txtAddress = new JTextArea();
			scrlAddress.setViewportView(txtAddress);
		
		tbEducation = new JPanel();
		tbEducation.setBackground(SystemColor.inactiveCaption);
//		Inputpanel.addTab("Education", null, tbEducation, null);
		tbEducation.setLayout(null);
		tbEducation.setLayout(null);
		
		JLabel lblSSC = new JLabel("S.S.C");
		lblSSC.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSSC.setForeground(Color.RED);
		lblSSC.setBounds(10, 11, 46, 14);
		tbEducation.add(lblSSC);
		
		JLabel lblsscPercentage = new JLabel("Percentage:");
		lblsscPercentage.setBounds(10, 36, 67, 14);
		tbEducation.add(lblsscPercentage);
		
		txtsscPercentage = new JTextField();
		txtsscPercentage.setBounds(75, 33, 86, 20);
		tbEducation.add(txtsscPercentage);
		txtsscPercentage.setColumns(10);
		
		JLabel lblsscBoard = new JLabel("Board:");
		lblsscBoard.setBounds(200, 36, 32, 14);
		tbEducation.add(lblsscBoard);
		
		txtsscBoard = new JTextField();
		txtsscBoard.setBounds(240, 33, 190, 20);
		tbEducation.add(txtsscBoard);
		txtsscBoard.setColumns(10);
		
		JLabel lblsscPassingYear = new JLabel("Year Of Passing:");
		lblsscPassingYear.setBounds(475, 36, 80, 14);
		tbEducation.add(lblsscPassingYear);
		
		cmbbxsscPassingYear = new JComboBox();
		cmbbxsscPassingYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cmbbxsscPassingYear.setBounds(565, 33, 55, 20);
		tbEducation.add(cmbbxsscPassingYear);
		
		JLabel lblHSC = new JLabel("H.S.C");
		lblHSC.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHSC.setForeground(Color.RED);
		lblHSC.setBounds(10, 70, 46, 14);
		tbEducation.add(lblHSC);
		
		JLabel lblhscPercentage = new JLabel("Percentage:");
		lblhscPercentage.setBounds(10, 98, 67, 14);
		tbEducation.add(lblhscPercentage);
		
		txthscPercentage = new JTextField();
		txthscPercentage.setColumns(10);
		txthscPercentage.setBounds(75, 95, 86, 20);
		tbEducation.add(txthscPercentage);
		
		JLabel lblhscBoard = new JLabel("Board:");
		lblhscBoard.setBounds(200, 95, 32, 14);
		tbEducation.add(lblhscBoard);
		
		txthscBoard = new JTextField();
		txthscBoard.setColumns(10);
		txthscBoard.setBounds(240, 92, 190, 20);
		tbEducation.add(txthscBoard);
		
		JLabel lblhscPassingYear = new JLabel("Year Of Passing:");
		lblhscPassingYear.setBounds(475, 95, 80, 14);
		tbEducation.add(lblhscPassingYear);
		
		cmbbxhscPassingYear = new JComboBox();
		cmbbxhscPassingYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cmbbxhscPassingYear.setBounds(565, 92, 55, 20);
		tbEducation.add(cmbbxhscPassingYear);
		
		JLabel lblUG = new JLabel("UG");
		lblUG.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUG.setForeground(Color.RED);
		lblUG.setBounds(10, 124, 67, 20);
		tbEducation.add(lblUG);
		
		JLabel lblDegree = new JLabel("Degree:");
		lblDegree.setBounds(10, 155, 46, 14);
		tbEducation.add(lblDegree);
		
		txtDegree = new JTextField();
		txtDegree.setBounds(75, 152, 86, 20);
		tbEducation.add(txtDegree);
		txtDegree.setColumns(10);
		
		JLabel lblCollegeName = new JLabel("College Name:");
		lblCollegeName.setBounds(200, 155, 80, 14);
		tbEducation.add(lblCollegeName);
		
		txtCollegeName = new JTextField();
		txtCollegeName.setBounds(282, 152, 148, 20);
		tbEducation.add(txtCollegeName);
		txtCollegeName.setColumns(10);
		
		JLabel lblcgpa = new JLabel("CGPA:");
		lblcgpa.setBounds(475, 155, 46, 14);
		tbEducation.add(lblcgpa);
		
		txtcgpaObtained = new JTextField();
		txtcgpaObtained.setBounds(514, 152, 46, 20);
		tbEducation.add(txtcgpaObtained);
		txtcgpaObtained.setColumns(10);
		
		txtcgpaTotal = new JTextField();
		txtcgpaTotal.setColumns(10);
		txtcgpaTotal.setBounds(574, 152, 46, 20);
		tbEducation.add(txtcgpaTotal);
		
		JLabel lblcgpaOutOf = new JLabel("/");
		lblcgpaOutOf.setBounds(565, 155, 13, 14);
		tbEducation.add(lblcgpaOutOf);
		
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setBounds(650, 155, 38, 14);
		tbEducation.add(lblGrade);
		
		txtGrade = new JTextField();
		txtGrade.setBounds(693, 152, 55, 20);
		tbEducation.add(txtGrade);
		txtGrade.setColumns(10);
		
		btnSubmitEducationDetails = new JButton("Submit Education Details");
		btnSubmitEducationDetails.setBounds(282, 183, 181, 23);
		tbEducation.add(btnSubmitEducationDetails);
		
	    tbCourses = new JPanel();
		tbCourses.setBackground(SystemColor.inactiveCaption);
//		Inputpanel.addTab("Courses", null, tbCourses, null);
		tbCourses.setLayout(null);
		
		JLabel lblCourseSemester = new JLabel("SEMESTER:");
		lblCourseSemester.setBounds(39, 14, 87, 14);
		tbCourses.add(lblCourseSemester);
		
		cmbbxCourseSemester = new JComboBox();
		cmbbxCourseSemester.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbbxCourseSemester.setBounds(163, 11, 105, 20);
		tbCourses.add(cmbbxCourseSemester);
		
		JLabel lblCourseNo = new JLabel("Course No.:");
		lblCourseNo.setBounds(10, 39, 151, 14);
		tbCourses.add(lblCourseNo);
		
		txtCourseNo = new JTextField();
		txtCourseNo.setBounds(173, 36, 112, 20);
		tbCourses.add(txtCourseNo);
		txtCourseNo.setColumns(10);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(10, 77, 151, 14);
		tbCourses.add(lblCourseName);
		
		txtCourseName = new JTextField();
		txtCourseName.setBounds(173, 74, 112, 20);
		tbCourses.add(txtCourseName);
		txtCourseName.setColumns(10);
		
		JLabel lblProfessorName = new JLabel("Professor Name:");
		lblProfessorName.setBounds(10, 113, 151, 14);
		tbCourses.add(lblProfessorName);
		
		txtProfessorName = new JTextField();
		txtProfessorName.setBounds(173, 110, 112, 20);
		tbCourses.add(txtProfessorName);
		txtProfessorName.setColumns(10);
		
		JLabel lblCourseGrade = new JLabel("Grade:");
		lblCourseGrade.setBounds(10, 150, 151, 14);
		tbCourses.add(lblCourseGrade);
		
		txtCourseGrade = new JTextField();
		txtCourseGrade.setBounds(173, 147, 112, 20);
		tbCourses.add(txtCourseGrade);
		txtCourseGrade.setColumns(10);
		
		JLabel lblCourseDescription = new JLabel("Course Description:");
		lblCourseDescription.setBounds(333, 39, 146, 14);
		tbCourses.add(lblCourseDescription);
		
		btnSubmitCourseDetails = new JButton("Submit Course Details");
		btnSubmitCourseDetails.setBounds(498, 146, 188, 23);
		tbCourses.add(btnSubmitCourseDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(498, 34, 190, 93);
		tbCourses.add(scrollPane);
		
		txtCourseDescription = new JTextArea();
		scrollPane.setViewportView(txtCourseDescription);
		
		chckbxCourseStar = new JCheckBox("Star");
		chckbxCourseStar.setBackground(SystemColor.inactiveCaption);
		chckbxCourseStar.setBounds(422, 146, 87, 23);
		tbCourses.add(chckbxCourseStar);
		
		btnDeleteCourseDetails = new JButton("Delete Course details");
		btnDeleteCourseDetails.setEnabled(false);
		btnDeleteCourseDetails.setBounds(540, 180, 146, 23);
		tbCourses.add(btnDeleteCourseDetails);
		
		tbProject = new JPanel();
		tbProject.setBackground(SystemColor.inactiveCaption);
	//	Inputpanel.addTab("Project", null, tbProject, null);
		tbProject.setLayout(null);
		
		JLabel lblProjectSemester = new JLabel("SEMESTER:");
		lblProjectSemester.setBounds(258, 11, 58, 14);
		tbProject.add(lblProjectSemester);
		
		cmbbxProjectSemester = new JComboBox();
		cmbbxProjectSemester.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbbxProjectSemester.setBounds(326, 8, 105, 20);
		tbProject.add(cmbbxProjectSemester);
		
		JLabel lblProjectName = new JLabel("Project  Name:");
		lblProjectName.setBounds(21, 53, 83, 14);
		tbProject.add(lblProjectName);
		
		txtProjectName = new JTextField();
		txtProjectName.setBounds(149, 50, 182, 20);
		tbProject.add(txtProjectName);
		txtProjectName.setColumns(10);
		
		JLabel lblProjectMentorName = new JLabel("Project  Mentor Name:");
		lblProjectMentorName.setBounds(21, 91, 108, 14);
		tbProject.add(lblProjectMentorName);
		
		txtProjectMentorName = new JTextField();
		txtProjectMentorName.setBounds(149, 88, 182, 20);
		tbProject.add(txtProjectMentorName);
		txtProjectMentorName.setColumns(10);
		
		JLabel lblProjectDuration = new JLabel("Project Duration:");
		lblProjectDuration.setBounds(21, 139, 88, 14);
		tbProject.add(lblProjectDuration);
		
		txtProjectDuration = new JTextField();
		txtProjectDuration.setBounds(149, 136, 182, 20);
		tbProject.add(txtProjectDuration);
		txtProjectDuration.setColumns(10);
		
		JLabel lblProjectDescription = new JLabel("Project  Description:");
		lblProjectDescription.setBounds(403, 53, 98, 14);
		tbProject.add(lblProjectDescription);
		
		btnSubmitProjectDetails = new JButton("Submit Project Details");
		btnSubmitProjectDetails.setBounds(595, 150, 142, 23);
		tbProject.add(btnSubmitProjectDetails);
		
		JScrollPane scrlProjectDescription = new JScrollPane();
		scrlProjectDescription.setBounds(518, 53, 219, 86);
		tbProject.add(scrlProjectDescription);
		
		txtProjectDescription = new JTextArea();
		scrlProjectDescription.setViewportView(txtProjectDescription);
		
		JLabel lblNoOfTeamMembers = new JLabel("No. Of Team Members:");
		lblNoOfTeamMembers.setBounds(21, 166, 121, 14);
		tbProject.add(lblNoOfTeamMembers);
		
		txtNoOfTeamMembers = new JTextField();
		txtNoOfTeamMembers.setBounds(149, 167, 86, 20);
		tbProject.add(txtNoOfTeamMembers);
		txtNoOfTeamMembers.setColumns(10);
		
		chckbxProjectStar = new JCheckBox("Star");
		chckbxProjectStar.setBackground(SystemColor.inactiveCaption);
		chckbxProjectStar.setBounds(518, 150, 71, 23);
		tbProject.add(chckbxProjectStar);
		
		btnDeleteProjectDetails = new JButton("Delete Project Details");
		btnDeleteProjectDetails.setEnabled(false);
		btnDeleteProjectDetails.setBounds(595, 184, 142, 23);
		tbProject.add(btnDeleteProjectDetails);
		
		
		
		tbInternships = new JPanel();
		tbInternships.setBackground(SystemColor.inactiveCaption);
		//Inputpanel.addTab("Internships", null, tbInternships, null);
		tbInternships.setLayout(null);
		
		JLabel lblInternshipOrganisationName = new JLabel("Organisation Name:");
		lblInternshipOrganisationName.setBounds(30, 39, 100, 14);
		tbInternships.add(lblInternshipOrganisationName);
		
		txtInternshipOrganisationName = new JTextField();
		txtInternshipOrganisationName.setBounds(160, 36, 242, 20);
		tbInternships.add(txtInternshipOrganisationName);
		txtInternshipOrganisationName.setColumns(10);
		
		JLabel lblInternshipPeriod = new JLabel("Internship Period:");
		lblInternshipPeriod.setBounds(30, 70, 100, 14);
		tbInternships.add(lblInternshipPeriod);
		
		txtInternshipPeriod = new JTextField();
		txtInternshipPeriod.setBounds(160, 67, 242, 20);
		tbInternships.add(txtInternshipPeriod);
		txtInternshipPeriod.setColumns(10);
		
		JLabel lblInternshipSemester = new JLabel("SEMESTER:");
		lblInternshipSemester.setBounds(70, 14, 58, 14);
		tbInternships.add(lblInternshipSemester);
		
		cmbbxInternshipSemester = new JComboBox();
		cmbbxInternshipSemester.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbbxInternshipSemester.setBounds(138, 11, 105, 20);
		tbInternships.add(cmbbxInternshipSemester);
		
		JLabel lblInternshipDescription = new JLabel("Internship Description:");
		lblInternshipDescription.setBounds(30, 95, 124, 14);
		tbInternships.add(lblInternshipDescription);
		
		JScrollPane scrlInternshipDescription = new JScrollPane();
		scrlInternshipDescription.setBounds(160, 98, 242, 64);
		tbInternships.add(scrlInternshipDescription);
		
		txtInternshipDescription = new JTextArea();
		scrlInternshipDescription.setViewportView(txtInternshipDescription);
		
		btnSubmitInternshipDetails = new JButton("Submit Internship Details");
		btnSubmitInternshipDetails.setBounds(231, 172, 171, 23);
		tbInternships.add(btnSubmitInternshipDetails);
		
		 chckbxInternshipStar = new JCheckBox("Star");
		chckbxInternshipStar.setBackground(SystemColor.inactiveCaption);
		chckbxInternshipStar.setBounds(160, 172, 65, 23);
		tbInternships.add(chckbxInternshipStar);
		
		btnDeleteInternshipDetails = new JButton("Delete Internship Details");
		btnDeleteInternshipDetails.setEnabled(false);
		btnDeleteInternshipDetails.setBounds(422, 172, 161, 23);
		tbInternships.add(btnDeleteInternshipDetails);
		
		tbWorkshops = new JPanel();
		tbWorkshops.setBackground(SystemColor.inactiveCaption);
		//Inputpanel.addTab("Workshops", null, tbWorkshops, null);
		tbWorkshops.setLayout(null);
		
		JLabel lblWorkshopSemester = new JLabel("SEMESTER:");
		lblWorkshopSemester.setBounds(208, 14, 58, 14);
		tbWorkshops.add(lblWorkshopSemester);
		
		cmbbxWorkshopSemester = new JComboBox();
		cmbbxWorkshopSemester.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbbxWorkshopSemester.setBounds(276, 11, 105, 20);
		tbWorkshops.add(cmbbxWorkshopSemester);
		
		JLabel lblWorkshopTitle = new JLabel("Workshop Title:");
		lblWorkshopTitle.setBounds(29, 50, 119, 14);
		tbWorkshops.add(lblWorkshopTitle);
		
		JLabel lblWorkshopTeacher = new JLabel("Workshop Teacher:");
		lblWorkshopTeacher.setBounds(29, 75, 119, 14);
		tbWorkshops.add(lblWorkshopTeacher);
		
		JLabel lblWorkshopOrganizer = new JLabel("Workshop Organizer:");
		lblWorkshopOrganizer.setBounds(29, 100, 119, 14);
		tbWorkshops.add(lblWorkshopOrganizer);
		
		JLabel lblWorkshopDate = new JLabel("Workshop Date:");
		lblWorkshopDate.setBounds(29, 125, 119, 14);
		tbWorkshops.add(lblWorkshopDate);
		
		txtWorkshopTeacher = new JTextField();
		txtWorkshopTeacher.setBounds(158, 72, 158, 20);
		tbWorkshops.add(txtWorkshopTeacher);
		txtWorkshopTeacher.setColumns(10);
		
		txtWorkshopTitle = new JTextField();
		txtWorkshopTitle.setColumns(10);
		txtWorkshopTitle.setBounds(158, 47, 158, 20);
		tbWorkshops.add(txtWorkshopTitle);
		
		txtWorkshopOrganizer = new JTextField();
		txtWorkshopOrganizer.setColumns(10);
		txtWorkshopOrganizer.setBounds(158, 97, 158, 20);
		tbWorkshops.add(txtWorkshopOrganizer);
		
		cmbbxWorkshopDate = new JComboBox();
		cmbbxWorkshopDate.setModel(new DefaultComboBoxModel(new String[] {"Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbbxWorkshopDate.setBounds(158, 125, 48, 20);
		tbWorkshops.add(cmbbxWorkshopDate);
		
		cmbbxWorkshopMonth = new JComboBox();
		cmbbxWorkshopMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cmbbxWorkshopMonth.setBounds(212, 125, 77, 20);
		tbWorkshops.add(cmbbxWorkshopMonth);
		
		cmbbxWorkshopYear = new JComboBox();
		cmbbxWorkshopYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cmbbxWorkshopYear.setBounds(297, 125, 55, 20);
		tbWorkshops.add(cmbbxWorkshopYear);
		
		JLabel lblWorkshopDescription = new JLabel("Workshop Description:");
		lblWorkshopDescription.setBounds(399, 50, 119, 14);
		tbWorkshops.add(lblWorkshopDescription);
		
		JScrollPane scrlWorkshopDesciption = new JScrollPane();
		scrlWorkshopDesciption.setBounds(528, 45, 196, 69);
		tbWorkshops.add(scrlWorkshopDesciption);
		
		txtWorkshopDescription = new JTextArea();
		scrlWorkshopDesciption.setViewportView(txtWorkshopDescription);
		
		chckbxCertified = new JCheckBox("Certified");
		chckbxCertified.setBackground(SystemColor.inactiveCaption);
		chckbxCertified.setBounds(29, 152, 140, 23);
		tbWorkshops.add(chckbxCertified);
		
		btnSubmitWorkshopDetails = new JButton("Submit Workshop Details");
		btnSubmitWorkshopDetails.setBounds(555, 151, 169, 23);
		tbWorkshops.add(btnSubmitWorkshopDetails);
		
		chckbxWorkshopStar = new JCheckBox("Star");
		chckbxWorkshopStar.setBackground(SystemColor.inactiveCaption);
		chckbxWorkshopStar.setBounds(501, 152, 48, 23);
		tbWorkshops.add(chckbxWorkshopStar);
		
		btnDeleteWorkshopDetails = new JButton("Delete Workshop Details");
		btnDeleteWorkshopDetails.setEnabled(false);
		btnDeleteWorkshopDetails.setBounds(555, 180, 169, 23);
		tbWorkshops.add(btnDeleteWorkshopDetails);
		
	    tbAchievements = new JPanel();
		tbAchievements.setBackground(SystemColor.inactiveCaption);
		//Inputpanel.addTab("Achievements\r\n", null, tbAchievements, null);
		tbAchievements.setLayout(null);
		
		JLabel label = new JLabel("SEMESTER:");
		label.setBounds(64, 14, 58, 14);
		tbAchievements.add(label);
		
		cmbbxAchievementSemester = new JComboBox();
		cmbbxAchievementSemester.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbbxAchievementSemester.setBounds(132, 11, 105, 20);
		tbAchievements.add(cmbbxAchievementSemester);
		
		JLabel lblAchievementDescription = new JLabel("Achievements Description:");
		lblAchievementDescription.setBounds(26, 107, 142, 14);
		tbAchievements.add(lblAchievementDescription);
		
		JLabel lblAchievementDate = new JLabel("Achievement Date:");
		lblAchievementDate.setBounds(26, 55, 119, 14);
		tbAchievements.add(lblAchievementDate);
		
		cmbbxAchievementDate = new JComboBox();
		cmbbxAchievementDate.setModel(new DefaultComboBoxModel(new String[] {"Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbbxAchievementDate.setBounds(132, 52, 48, 20);
		tbAchievements.add(cmbbxAchievementDate);
		
		cmbbxAchievementMonth = new JComboBox();
		cmbbxAchievementMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cmbbxAchievementMonth.setBounds(190, 52, 77, 20);
		tbAchievements.add(cmbbxAchievementMonth);
		
		cmbbxAchievementYear = new JComboBox();
		cmbbxAchievementYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cmbbxAchievementYear.setBounds(277, 52, 55, 20);
		tbAchievements.add(cmbbxAchievementYear);
		
		JScrollPane scrlAchievemtsDescription = new JScrollPane();
		scrlAchievemtsDescription.setBounds(165, 102, 184, 62);
		tbAchievements.add(scrlAchievemtsDescription);
		
		txtAchievementDescription = new JTextArea();
		scrlAchievemtsDescription.setViewportView(txtAchievementDescription);
		
		btnSubmitAchievementDetails = new JButton("Submit Achievement Details");
		btnSubmitAchievementDetails.setBounds(175, 171, 178, 23);
		tbAchievements.add(btnSubmitAchievementDetails);
		
		chckbxAchievementStar = new JCheckBox("Star");
		chckbxAchievementStar.setBackground(SystemColor.inactiveCaption);
		chckbxAchievementStar.setBounds(97, 141, 48, 23);
		tbAchievements.add(chckbxAchievementStar);
		
		chckbxAwardedCertified = new JCheckBox("Awarded/Certified");
		chckbxAwardedCertified.setBackground(SystemColor.inactiveCaption);
		chckbxAwardedCertified.setBounds(42, 171, 126, 23);
		tbAchievements.add(chckbxAwardedCertified);
		
		btnDeleteAchievementDetails = new JButton("Delete Achievement Details");
		btnDeleteAchievementDetails.setEnabled(false);
		btnDeleteAchievementDetails.setBounds(365, 171, 178, 23);
		tbAchievements.add(btnDeleteAchievementDetails);
		
		tbMisc = new JPanel();
		tbMisc.setBackground(SystemColor.inactiveCaption);
//		Inputpanel.addTab("Miscellaneous", null, tbMisc, null);
		tbMisc.setLayout(null);
		
		JLabel lblMiscSemester = new JLabel("SEMESTER:");
		lblMiscSemester.setBounds(44, 14, 58, 14);
		tbMisc.add(lblMiscSemester);
		
		cmbbxMiscSemester = new JComboBox();
		cmbbxMiscSemester.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbbxMiscSemester.setBounds(112, 11, 105, 20);
		tbMisc.add(cmbbxMiscSemester);
		
		JLabel lblMiscDate = new JLabel("Date:");
		lblMiscDate.setBounds(44, 53, 46, 14);
		tbMisc.add(lblMiscDate);
		
		cmbbxMiscDate = new JComboBox();
		cmbbxMiscDate.setModel(new DefaultComboBoxModel(new String[] {"Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbbxMiscDate.setBounds(112, 47, 48, 20);
		tbMisc.add(cmbbxMiscDate);
		
		cmbbxMiscMonth = new JComboBox();
		cmbbxMiscMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cmbbxMiscMonth.setBounds(166, 47, 77, 20);
		tbMisc.add(cmbbxMiscMonth);
		
		cmbbxMiscYear = new JComboBox();
		cmbbxMiscYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cmbbxMiscYear.setBounds(251, 47, 55, 20);
		tbMisc.add(cmbbxMiscYear);
		
		JLabel lblMiscDescription = new JLabel("Description:");
		lblMiscDescription.setBounds(44, 87, 69, 14);
		tbMisc.add(lblMiscDescription);
		
		JScrollPane scrlOtherDescription = new JScrollPane();
		scrlOtherDescription.setBounds(112, 82, 197, 66);
		tbMisc.add(scrlOtherDescription);
		
		txtMiscDescription = new JTextArea();
		scrlOtherDescription.setViewportView(txtMiscDescription);
		
		btnSubmitMiscDetails = new JButton("Submit Details");
		btnSubmitMiscDetails.setBounds(193, 161, 113, 23);
		tbMisc.add(btnSubmitMiscDetails);
		
		chckbxMiscellaneousStar = new JCheckBox("Star");
		chckbxMiscellaneousStar.setBackground(SystemColor.inactiveCaption);
		chckbxMiscellaneousStar.setBounds(141, 161, 46, 23);
		tbMisc.add(chckbxMiscellaneousStar);
		
		btnDeleteMiscDetails = new JButton("Delete Details");
		btnDeleteMiscDetails.setEnabled(false);
		btnDeleteMiscDetails.setBounds(319, 161, 123, 23);
		tbMisc.add(btnDeleteMiscDetails);
		
		SelectionPanel = new JPanel();
		SelectionPanel.setBounds(10, 318, 813, 88);
		SelectionPanel.setBackground(SystemColor.inactiveCaption);
//		getContentPane().add(SelectionPanel);
		SelectionPanel.setLayout(null);
		
		setCmbbxSelectSemesterMIDPNL(new JComboBox());
		getCmbbxSelectSemesterMIDPNL().setModel(new DefaultComboBoxModel(new String[] {"All", "None", "1", "2", "3", "4", "5", "6", "7", "8"}));
		//SelectSemester.setModel(new DefaultComboBoxModel(new String[] {"Semester-1", "Semester-2", "Semester-3", "Semester-4", "Semester-5", "Semester-6", "Semester-7", "Semester-8"}));
		getCmbbxSelectSemesterMIDPNL().setBounds(30, 41, 105, 20);
		
		
		SelectionPanel.add(getCmbbxSelectSemesterMIDPNL());
		
		JLabel lblSemesterMIDPNL = new JLabel("SEMESTER:");
		lblSemesterMIDPNL.setBounds(31, 14, 104, 14);
		SelectionPanel.add(lblSemesterMIDPNL);
		
		setRdbtnCourse(new JRadioButton("Courses"));
		getRdbtnCourse().setBackground(SystemColor.inactiveCaption);
		buttonGroup.add(getRdbtnCourse());
		getRdbtnCourse().setBounds(184, 10, 105, 23);
		SelectionPanel.add(getRdbtnCourse());
		
		setRdbtnProject(new JRadioButton("Projects"));
		getRdbtnProject().setBackground(SystemColor.inactiveCaption);
		buttonGroup.add(getRdbtnProject());
		getRdbtnProject().setBounds(343, 10, 105, 23);
		SelectionPanel.add(getRdbtnProject());
		
		setRdbtnWorkshops(new JRadioButton("Workshops"));
		getRdbtnWorkshops().setBackground(SystemColor.inactiveCaption);
		buttonGroup.add(getRdbtnWorkshops());
		getRdbtnWorkshops().setBounds(470, 10, 105, 23);
		SelectionPanel.add(getRdbtnWorkshops());
		
		setRdbtnInternships(new JRadioButton("Internships"));
		getRdbtnInternships().setBackground(SystemColor.inactiveCaption);
		buttonGroup.add(getRdbtnInternships());
		getRdbtnInternships().setBounds(184, 56, 121, 23);
		SelectionPanel.add(getRdbtnInternships());
		
		setRdbtnAchievements(new JRadioButton("Achievements"));
		buttonGroup.add(getRdbtnAchievements());
		getRdbtnAchievements().setBackground(SystemColor.inactiveCaption);
		getRdbtnAchievements().setBounds(339, 56, 109, 23);
		SelectionPanel.add(getRdbtnAchievements());
		
		btnView = new JButton("View");
		btnView.setEnabled(false);
		btnView.setBounds(707, 40, 81, 23);
		SelectionPanel.add(btnView);
		
		setRdbtnMisc(new JRadioButton("Misc"));
		buttonGroup.add(getRdbtnMisc());
		getRdbtnMisc().setBackground(SystemColor.inactiveCaption);
		getRdbtnMisc().setBounds(470, 56, 105, 23);
		SelectionPanel.add(getRdbtnMisc());
		
		setChckbxStarredOnly(new JCheckBox("Starred Only"));
		getChckbxStarredOnly().setBounds(579, 40, 109, 23);
		SelectionPanel.add(getChckbxStarredOnly());
		getChckbxStarredOnly().setBackground(SystemColor.inactiveCaption);
		/*chkbxStarredOnly.setIcon(new ImageIcon("C:\\Users\\HP\\workspace\\CVInfoSaver\\rsz_starwhite.png"));
		chkbxStarredOnly.setSelectedIcon(new ImageIcon("rsz_starwhite.png"));*/
		
	/*	scrlDsplayPanel = new JScrollPane();
		scrlDsplayPanel.setBounds(10, 387, 813, 242);
		getContentPane().add(scrlDsplayPanel);
	*/	
		
		panelParentDisplayPanel = new JPanel();
		panelParentDisplayPanel.setBounds(10, 419, 820, 280);
//		getContentPane().add(panelParentDisplayPanel);
		panelParentDisplayPanel.setLayout(null);
		
		scrlDisplayPanel = new JScrollPane();
		scrlDisplayPanel.setBounds(0, 0, 820, 280);
		panelParentDisplayPanel.add(scrlDisplayPanel);
		scrlDisplayPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrlDisplayPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		DisplayPanel = new JPanel();
		scrlDisplayPanel.setViewportView(DisplayPanel);
//		scrlDsplayPanel.setViewportView(DisplayPanel);
		DisplayPanel.setBorder(null);
		DisplayPanel.setBackground(SystemColor.inactiveCaption);
		DisplayPanel.setLayout(null);
		DisplayPanel.setLayout(new GridLayout(0, 1, 2, 15));
		
		lblException = new JLabel("");
		lblException.setHorizontalAlignment(SwingConstants.CENTER);
		lblException.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblException.setForeground(Color.RED);
		lblException.setBounds(20, 266, 788, 39);
		getContentPane().add(lblException);
		
		cvinfosaverlistener = new CVInfoSaverListener(this);
		btnSubmitBasicInfo.addActionListener(cvinfosaverlistener);
		btnSubmitEducationDetails.addActionListener(cvinfosaverlistener);
		btnSubmitCourseDetails.addActionListener(cvinfosaverlistener);
		btnDeleteCourseDetails.addActionListener(cvinfosaverlistener);
		btnSubmitProjectDetails.addActionListener(cvinfosaverlistener);
		btnDeleteProjectDetails.addActionListener(cvinfosaverlistener);
		btnSubmitInternshipDetails.addActionListener(cvinfosaverlistener);
		btnDeleteInternshipDetails.addActionListener(cvinfosaverlistener);
		btnSubmitWorkshopDetails.addActionListener(cvinfosaverlistener);
		btnDeleteWorkshopDetails.addActionListener(cvinfosaverlistener);
		btnSubmitAchievementDetails.addActionListener(cvinfosaverlistener);
		btnDeleteAchievementDetails.addActionListener(cvinfosaverlistener);
		btnSubmitMiscDetails.addActionListener(cvinfosaverlistener);
		btnDeleteMiscDetails.addActionListener(cvinfosaverlistener);
		btnView.addActionListener(cvinfosaverlistener);
		
		rdbtnCourse.addActionListener(cvinfosaverlistener);
		rdbtnProject.addActionListener(cvinfosaverlistener);
		rdbtnInternships.addActionListener(cvinfosaverlistener);
		rdbtnWorkshops.addActionListener(cvinfosaverlistener);
		rdbtnAchievements.addActionListener(cvinfosaverlistener);
		rdbtnMisc.addActionListener(cvinfosaverlistener);
		
	
	}
	public void clearBasicInfo()
	{
		txtName.setText("");
		rdbtnMale.setSelected(true);
		rdbtnFemale.setSelected(false);
		cmbbxDate.setSelectedIndex(0);
	    cmbbxMonth.setSelectedIndex(0);
	    cmbbxYear.setSelectedIndex(0);
	    txtMothersName.setText("");
		txtFathersName.setText("");
	    txtHobbies.setText("");
		txtConactNo.setText("");
		txtEmail.setText("");
		txtAddress.setText("");
	
	}
	public void clearEducation()
	{
		txtsscPercentage.setText("");
		txtsscBoard.setText("");
	    cmbbxsscPassingYear.setSelectedIndex(0);
	    txthscPercentage.setText("");
		txthscBoard.setText("");
	    cmbbxhscPassingYear.setSelectedIndex(0);
	    txtDegree.setText("");
	    txtCollegeName.setText("");
	    txtcgpaObtained.setText("");
	    txtcgpaTotal.setText("");
	    txtGrade.setText("");
	
		
	}
	public void clearCourse()
	{
		cmbbxCourseSemester.setSelectedIndex(0);
		txtCourseNo.setText("");
		txtCourseName.setText("");
		txtProfessorName.setText("");
		txtCourseGrade.setText("");
		txtCourseDescription.setText("");
		chckbxCourseStar.setSelected(false);
		
	}
	public void clearProject()
	{
		cmbbxProjectSemester.setSelectedIndex(0);
		txtProjectName.setText("");
		txtProjectMentorName.setText("");
		txtProjectDuration.setText("");
		txtNoOfTeamMembers.setText("");
		txtProjectDescription.setText("");
		chckbxProjectStar.setSelected(false);
		
	}
	public void clearInternship()
	{
		cmbbxInternshipSemester.setSelectedIndex(0);
		txtInternshipOrganisationName.setText("");
		txtInternshipPeriod.setText("");
		txtInternshipDescription.setText("");
		chckbxInternshipStar.setSelected(false); 
	}
	public void clearWorkshops()
	{
		cmbbxWorkshopSemester.setSelectedIndex(0);
		txtWorkshopTitle.setText("");
		txtWorkshopTeacher.setText("");
		txtWorkshopOrganizer.setText("");
		cmbbxWorkshopDate.setSelectedIndex(0);
		cmbbxWorkshopMonth.setSelectedIndex(0);
		cmbbxWorkshopYear.setSelectedIndex(0);
		txtWorkshopDescription.setText("");
		chckbxCertified.setSelected(false);; 
	    chckbxWorkshopStar.setSelected(false);;
		
	}
	public void clearAchievement()
	{
		cmbbxAchievementSemester.setSelectedIndex(0);
		cmbbxAchievementDate.setSelectedIndex(0);
		cmbbxAchievementMonth.setSelectedIndex(0);
		cmbbxAchievementYear.setSelectedIndex(0);
		txtAchievementDescription.setText("");
		chckbxAchievementStar.setSelected(false);
		chckbxAwardedCertified.setSelected(false);
	
	}
	public void clearMiscellaneous()
	{
        cmbbxMiscSemester.setSelectedIndex(0);
        cmbbxMiscDate.setSelectedIndex(0);
        cmbbxMiscMonth.setSelectedIndex(0);
        cmbbxMiscYear.setSelectedIndex(0);
        txtMiscDescription.setText("");
        chckbxMiscellaneousStar.setSelected(false);
	}
	
	public void addEducationTab()
	{
		Inputpanel.addTab("Education", null, tbEducation, null);
		Inputpanel.setSelectedIndex(1);
	}
	
	public void addCVDataTabs()
	{
		getContentPane().add(SelectionPanel);
		Inputpanel.addTab("Courses", null, tbCourses, null);
		Inputpanel.addTab("Project", null, tbProject, null);
		Inputpanel.addTab("Internships", null, tbInternships, null);
		Inputpanel.addTab("Workshops", null, tbWorkshops, null);
		Inputpanel.addTab("Achievements\r\n", null, tbAchievements, null);
		Inputpanel.addTab("Miscellaneous", null, tbMisc, null);
//		getContentPane().add(scrlDsplayPanel);
		getContentPane().add(panelParentDisplayPanel);
		Inputpanel.setSelectedIndex(2);	
	}
	
	public JCheckBox getChckbxStarredOnly() {
		return chckbxStarredOnly;
	}
	public void setChckbxStarredOnly(JCheckBox chckbxStarredOnly) {
		this.chckbxStarredOnly = chckbxStarredOnly;
	}
	public JComboBox<String> getCmbbxSelectSemesterMIDPNL() {
		return cmbbxSelectSemesterMIDPNL;
	}
	public void setCmbbxSelectSemesterMIDPNL(JComboBox<String> cmbbxSelectSemesterMIDPNL) {
		this.cmbbxSelectSemesterMIDPNL = cmbbxSelectSemesterMIDPNL;
	}
	public JRadioButton getRdbtnCourse() {
		return rdbtnCourse;
	}
	public void setRdbtnCourse(JRadioButton rdbtnAcademic) {
		this.rdbtnCourse = rdbtnAcademic;
	}
	public JRadioButton getRdbtnProject() {
		return rdbtnProject;
	}
	public void setRdbtnProject(JRadioButton rdbtnProject) {
		this.rdbtnProject = rdbtnProject;
	}
	public JRadioButton getRdbtnWorkshops() {
		return rdbtnWorkshops;
	}
	public void setRdbtnWorkshops(JRadioButton rdbtnWorkshops) {
		this.rdbtnWorkshops = rdbtnWorkshops;
	}
	public JRadioButton getRdbtnInternships() {
		return rdbtnInternships;
	}
	public void setRdbtnInternships(JRadioButton rdbtnInternships) {
		this.rdbtnInternships = rdbtnInternships;
	}
	public JRadioButton getRdbtnAchievements() {
		return rdbtnAchievements;
	}
	public void setRdbtnAchievements(JRadioButton rdbtnAchievements) {
		this.rdbtnAchievements = rdbtnAchievements;
	}
	public JRadioButton getRdbtnMisc() {
		return rdbtnMisc;
	}
	public void setRdbtnMisc(JRadioButton rdbtnMisc) {
		this.rdbtnMisc = rdbtnMisc;
	}
	public JTabbedPane getInputpanel() {
		return Inputpanel;
	}
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	public JTextField getTxtName() {
		return txtName;
	}
	public ButtonGroup getButtonGroup_gender() {
		return buttonGroup_gender;
	}
	public JTextField getTxtConactNo() {
		return txtConactNo;
	}
	public JTextField getTxtEmail() {
		return txtEmail;
	}
	public JTextField getTxtMothersName() {
		return txtMothersName;
	}
	public JTextField getTxtFathersName() {
		return txtFathersName;
	}
	public JTextField getTxtProjectName() {
		return txtProjectName;
	}
	public JTextField getTxtProjectMentorName() {
		return txtProjectMentorName;
	}
	public JTextField getTxtProjectDuration() {
		return txtProjectDuration;
	}
	public JTextField getTxtNoOfTeamMembers() {
		return txtNoOfTeamMembers;
	}
	public JTextField getTxtWorkshopTeacher() {
		return txtWorkshopTeacher;
	}
	public JTextField getTxtWorkshopTitle() {
		return txtWorkshopTitle;
	}
	public JTextField getTxtWorkshopOrganizer() {
		return txtWorkshopOrganizer;
	}
	public JTextField getTxtInternshipOrganisationName() {
		return txtInternshipOrganisationName;
	}
	public JTextField getTxtInternshipPeriod() {
		return txtInternshipPeriod;
	}
	public JTextField getTxtsscPercentage() {
		return txtsscPercentage;
	}
	public JTextField getTxtsscBoard() {
		return txtsscBoard;
	}
	public JTextField getTxthscPercentage() {
		return txthscPercentage;
	}
	public JTextField getTxthscBoard() {
		return txthscBoard;
	}
	public JTextField getTxtDegree() {
		return txtDegree;
	}
	public JTextField getTxtCollegeName() {
		return txtCollegeName;
	}
	public JTextField getTxtcgpaObtained() {
		return txtcgpaObtained;
	}
	public JTextField getTxtcgpaTotal() {
		return txtcgpaTotal;
	}
	public JTextField getTxtGrade() {
		return txtGrade;
	}
	public JTextField getTxtCourseNo() {
		return txtCourseNo;
	}
	public JTextField getTxtCourseName() {
		return txtCourseName;
	}
	public JTextField getTxtProfessorName() {
		return txtProfessorName;
	}
	public JTextField getTxtCourseGrade() {
		return txtCourseGrade;
	}
	public JTextArea getTxtHobbies() {
		return txtHobbies;
	}
	public JTextArea getTxtAddress() {
		return txtAddress;
	}
	public JTextArea getTxtCourseDescription() {
		return txtCourseDescription;
	}
	public JTextArea getTxtProjectDescription() {
		return txtProjectDescription;
	}
	public JTextArea getTxtInternshipDescription() {
		return txtInternshipDescription;
	}
	public JTextArea getTxtWorkshopDescription() {
		return txtWorkshopDescription;
	}
	public JTextArea getTxtAchievementDescription() {
		return txtAchievementDescription;
	}
	public JTextArea getTxtMiscDescription() {
		return txtMiscDescription;
	}
	public JButton getBtnSubmitBasicInfo() {
		return btnSubmitBasicInfo;
	}
	public JButton getBtnSubmitEducationDetails() {
		return btnSubmitEducationDetails;
	}
	public JButton getBtnSubmitCourseDetails() {
		return btnSubmitCourseDetails;
	}
	public JButton getBtnDeleteCourseDetails() {
		return btnDeleteCourseDetails;
	}
	public JButton getBtnSubmitProjectDetails() {
		return btnSubmitProjectDetails;
	}
	public JButton getBtnDeleteProjectDetails() {
		return btnDeleteProjectDetails;
	}
	public JButton getBtnSubmitInternshipDetails() {
		return btnSubmitInternshipDetails;
	}
	public JButton getBtnDeleteInternshipDetails() {
		return btnDeleteInternshipDetails;
	}
	public JButton getBtnSubmitWorkshopDetails() {
		return btnSubmitWorkshopDetails;
	}
	public JButton getBtnDeleteWorkshopDetails() {
		return btnDeleteWorkshopDetails;
	}
	public JButton getBtnSubmitAchievementDetails() {
		return btnSubmitAchievementDetails;
	}
	public JButton getBtnDeleteAchievementDetails() {
		return btnDeleteAchievementDetails;
	}
	public JButton getBtnSubmitMiscDetails() {
		return btnSubmitMiscDetails;
	}
	public JButton getBtnDeleteMiscDetails() {
		return btnDeleteMiscDetails;
	}
	public JButton getBtnView() {
		return btnView;
	}
	public JRadioButton getRdbtnMale() {
		return rdbtnMale;
	}
	public JRadioButton getRdbtnFemale() {
		return rdbtnFemale;
	}
	public JComboBox getCmbbxDate() {
		return cmbbxDate;
	}
	public JComboBox getCmbbxMonth() {
		return cmbbxMonth;
	}
	public JComboBox getCmbbxYear() {
		return cmbbxYear;
	}
	public JComboBox getCmbbxsscPassingYear() {
		return cmbbxsscPassingYear;
	}
	public JComboBox getCmbbxhscPassingYear() {
		return cmbbxhscPassingYear;
	}
	public JComboBox getCmbbxCourseSemester() {
		return cmbbxCourseSemester;
	}
	public JComboBox getCmbbxProjectSemester() {
		return cmbbxProjectSemester;
	}
	public JComboBox getCmbbxInternshipSemester() {
		return cmbbxInternshipSemester;
	}
	public JComboBox getCmbbxWorkshopSemester() {
		return cmbbxWorkshopSemester;
	}
	public JComboBox getCmbbxWorkshopDate() {
		return cmbbxWorkshopDate;
	}
	public JComboBox getCmbbxWorkshopMonth() {
		return cmbbxWorkshopMonth;
	}
	public JComboBox getCmbbxWorkshopYear() {
		return cmbbxWorkshopYear;
	}
	public JComboBox getCmbbxAchievementSemester() {
		return cmbbxAchievementSemester;
	}
	public JComboBox getCmbbxAchievementDate() {
		return cmbbxAchievementDate;
	}
	public JComboBox getCmbbxAchievementMonth() {
		return cmbbxAchievementMonth;
	}
	public JComboBox getCmbbxAchievementYear() {
		return cmbbxAchievementYear;
	}
	public JComboBox getCmbbxMiscSemester() {
		return cmbbxMiscSemester;
	}
	public JComboBox getCmbbxMiscDate() {
		return cmbbxMiscDate;
	}
	public JComboBox getCmbbxMiscMonth() {
		return cmbbxMiscMonth;
	}
	public JComboBox getCmbbxMiscYear() {
		return cmbbxMiscYear;
	}
	public JCheckBox getChckbxCourseStar() {
		return chckbxCourseStar;
	}
	public JCheckBox getChckbxProjectStar() {
		return chckbxProjectStar;
	}
	public JCheckBox getChckbxInternshipStar() {
		return chckbxInternshipStar;
	}
	public JCheckBox getChckbxCertified() {
		return chckbxCertified;
	}
	public JCheckBox getChckbxWorkshopStar() {
		return chckbxWorkshopStar;
	}
	public JCheckBox getChckbxAchievementStar() {
		return chckbxAchievementStar;
	}
	public JCheckBox getChckbxAwardedCertified() {
		return chckbxAwardedCertified;
	}
	public JCheckBox getChckbxMiscellaneousStar() {
		return chckbxMiscellaneousStar;
	}
	public JPanel getTbEducation() {
		return tbEducation;
	}
	public JPanel getTbProject() {
		return tbProject;
	}
	public JPanel getTbInternships() {
		return tbInternships;
	}
	public JPanel getTbWorkshops() {
		return tbWorkshops;
	}
	public JPanel getTbCourses() {
		return tbCourses;
	}
	public JPanel getTbAchievements() {
		return tbAchievements;
	}
	public JPanel getTbMisc() {
		return tbMisc;
	}
	public JPanel getSelectionPanel() {
		return SelectionPanel;
	}
	public JScrollPane getScrlDsplayPanel() {
		return scrlDsplayPanel;
	}
	public JLabel getLblException() {
		return lblException;
	}
	
	public JPanel getDisplayPanel() {
		return DisplayPanel;
	}
	public void setTabSelected(int i)
	{
		Inputpanel.setSelectedIndex(i);
	}
}
