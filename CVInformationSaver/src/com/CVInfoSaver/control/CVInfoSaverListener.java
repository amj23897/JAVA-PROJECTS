package com.CVInfoSaver.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.CVInfoSaver.Exception.NoStudentException;
import com.CVInfoSaver.Model.Achievement;
import com.CVInfoSaver.Model.AchievementList;
import com.CVInfoSaver.Model.CVData;
import com.CVInfoSaver.Model.Course;
import com.CVInfoSaver.Model.CourseList;
import com.CVInfoSaver.Model.Education;
import com.CVInfoSaver.Model.Internship;
import com.CVInfoSaver.Model.InternshipList;
import com.CVInfoSaver.Model.Miscellaneous;
import com.CVInfoSaver.Model.MiscellaneousList;
import com.CVInfoSaver.Model.Project;
import com.CVInfoSaver.Model.ProjectList;
import com.CVInfoSaver.Model.Student;
import com.CVInfoSaver.Model.Workshop;
import com.CVInfoSaver.Model.WorkshopList;
import com.CVInfoSaver.view.CVInfoSaverGUI;
import com.CVInfoSaver.view.panelCourse;
//import com.EmployeeManagement.Model.Employee;
//import com.EmployeeManagement.Model.EmployeeList;
//import com.EmployeeManagement.View.PanelEmployeeRecord;

public class CVInfoSaverListener implements ActionListener{

	CVInfoSaverGUI gui;
	Student student = null;
	private String string;
//	Education edu;
	
	public CVInfoSaverListener(CVInfoSaverGUI gui)
	{
		this.gui = gui;
		try
		{
			Student s = new Student();
			student  = 	s.fetch();
			System.out.println(s.getStudentName());
			gui.getTxtName().setText(student.getStudentName());
			if(student.getGender().equalsIgnoreCase("Male"))
			{
				gui.getRdbtnMale().setEnabled(true);
			}
			else
			{
				gui.getRdbtnFemale().setEnabled(false);
			}
			int day = 0;
			String month="",year="";
			String str = student.getStudentDateOfBirth();
			if(str.charAt(1)=='-')
			{
				day = str.charAt(0)-48;
				int i;
				for(i=2;str.charAt(i)!='-';i++)
					month =month+str.charAt(i); 
				year =str.substring(i+1);
			}
			else if(str.charAt(2)=='-')
			{
				System.out.println("asd");
				day = Integer.parseInt(str.substring(0,2));
				int i;
				for(i=3;str.charAt(i)!='-';i++)
					month =month+str.charAt(i); 
				year =str.substring(i+1);
			}
			System.out.println(day);
			
			gui.getCmbbxDate().setSelectedItem(Integer.toString(day));
			gui.getCmbbxMonth().setSelectedItem(month);
			gui.getCmbbxYear().setSelectedItem(year);
			
			gui.getTxtConactNo().setText(student.getStudentContactNo());
			gui.getTxtAddress().setText(student.getStudentAddress());
			gui.getTxtEmail().setText(student.getStudentEmailId());
			gui.getTxtHobbies().setText(student.getStudentHobbies());
			gui.getTxtFathersName().setText(student.getFatherName());
			gui.getTxtMothersName().setText(student.getMotherName());
			gui.getBtnSubmitBasicInfo().setText("Edit Basic Info");
			gui.getTxtName().setEditable(false);
			if(gui.getRdbtnMale().isSelected())
			{
				gui.getRdbtnFemale().setEnabled(false);
			}
			else
			{
				gui.getRdbtnMale().setEnabled(false);
			}
			gui.getCmbbxAchievementDate().setEnabled(false);
			gui.getCmbbxAchievementMonth().setEnabled(false);
			gui.getCmbbxAchievementYear().setEnabled(false);
			gui.getTxtHobbies().setEditable(false);
			gui.getTxtFathersName().setEditable(false);
			gui.getTxtMothersName().setEditable(false);
			gui.getTxtConactNo().setEditable(false);
			gui.getTxtEmail().setEditable(false);
			gui.getTxtAddress().setEditable(false);
			gui.addEducationTab();
			gui.addCVDataTabs();
			
			Education e = new Education();
			e = e.fetch();
			gui.getTxtsscBoard().setText(e.getSscBoard());
			gui.getTxtsscPercentage().setText(Float.toString(e.getSscPercentage()));
			gui.getCmbbxsscPassingYear().setSelectedItem(e.getSscPassingYear());
			gui.getTxthscBoard().setText(e.getHscBoard());
			gui.getTxthscPercentage().setText(Float.toString(e.getHscPercentage()));
			gui.getCmbbxhscPassingYear().setSelectedItem(e.getHscPassingYear());
			gui.getTxtGrade().setText(e.getGrade());
			gui.getTxtDegree().setText(e.getCollegeName());
			gui.getTxtCollegeName().setText(e.getCollegeName());
			gui.getTxtcgpaObtained().setText(Float.toString(e.getCgpaObtained()));
			gui.getTxtcgpaTotal().setText(Float.toString(e.getCgpaTot()));
			gui.getBtnSubmitEducationDetails().setText("Edit Education Details");
			gui.getTxtsscBoard().setEditable(false);
			gui.getTxtsscPercentage().setEditable(false);
			gui.getCmbbxsscPassingYear().setEditable(false);
			gui.getTxthscBoard().setEditable(false);
			gui.getTxthscPercentage().setEditable(false);
			gui.getCmbbxhscPassingYear().setEditable(false);
			gui.getTxtGrade().setEditable(false);
			gui.getTxtcgpaObtained().setEditable(false);
			gui.getTxtcgpaTotal().setEditable(false);
			gui.getTxtCollegeName().setEditable(false);
			gui.getTxtDegree().setEditable(false);
			
			
//			gui.getTxtsscBoard().setText(student.getOverallEducation);
			
		}
		catch(NoStudentException err)
		{
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayRecords()
	{
		if(gui.getChckbxStarredOnly().isSelected())
		{
			if(gui.getCmbbxSelectSemesterMIDPNL().getSelectedIndex() == 0)
			{
				if(gui.getRdbtnCourse().isSelected())
				{
					ArrayList<panelCourse>CourseRecords = new ArrayList();
					CourseRecords.add(new panelCourse("Semester", "Subject No", "Subject Name","Prof. Name", "Grade", "Description"));
					
					try
					{
						CourseList list = new CourseList();		
						ArrayList<Course> records = list.fetchRecords(true);
						for(Course course: records)
						{
							CourseRecords.add(new panelCourse( course.getSemester()==0?"None":Integer.toString(course.getSemester()) , course.getCourseNo(), course.getCourseName(),
									course.getCourseProf(),course.getCourseGrade(),course.getCourseDescription()));
						}
						gui.getDisplayPanel().removeAll();
						
						for(panelCourse course: CourseRecords)
							gui.getDisplayPanel().add(course);
						
//						gui.getScrlDsplayPanel() = new JScrollPane();
//						scrlDsplayPanel.setBounds(10, 387, 813, 242);
//						getContentPane().add(scrlDsplayPanel);
						
						
						
//						gddScrlDisplayPanel();
//						gui.add(gui.getDisplayPanel());
						gui.repaint();
						gui.validate();
						
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
				else if(gui.getRdbtnProject().isSelected())
				{
					
				}
				else if(gui.getRdbtnWorkshops().isSelected())
				{
					
				}
				else if(gui.getRdbtnInternships().isSelected())
				{
					
				}
				else if(gui.getRdbtnAchievements().isSelected())
				{
					
				}
				else if(gui.getRdbtnMisc().isSelected())
				{
					
				}
				else
				{
					
				}
					
			}
			else
			{
				if(gui.getRdbtnCourse().isSelected())
				{
					ArrayList<panelCourse>CourseRecords = new ArrayList();
					CourseRecords.add(new panelCourse("Semester", "Subject No", "Subject Name","Prof. Name", "Grade", "Description"));
					
					try
					{
						CourseList list = new CourseList();		
						ArrayList<Course> records = list.fetchRecords((gui.getCmbbxSelectSemesterMIDPNL().getSelectedIndex()-1),true);
						for(Course course: records)
						{
							CourseRecords.add(new panelCourse( course.getSemester()==0?"None":Integer.toString(course.getSemester()) , course.getCourseNo(), course.getCourseName(),
									course.getCourseProf(),course.getCourseGrade(),course.getCourseDescription()));
						}
						gui.getDisplayPanel().removeAll();
						
						for(panelCourse course: CourseRecords)
							gui.getDisplayPanel().add(course);
						
//						gui.getScrlDsplayPanel() = new JScrollPane();
//						scrlDsplayPanel.setBounds(10, 387, 813, 242);
//						getContentPane().add(scrlDsplayPanel);
						
						
//						gui.addScrlDisplayPanel();
//						gui.add(gui.getDisplayPanel());
						gui.repaint();
						gui.validate();
						
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
			}
		}
		else
		{
			if(gui.getCmbbxSelectSemesterMIDPNL().getSelectedIndex() == 0)
			{
				if(gui.getRdbtnCourse().isSelected())
				{
					ArrayList<panelCourse>CourseRecords = new ArrayList();
					CourseRecords.add(new panelCourse("Semester", "Subject No", "Subject Name","Prof. Name", "Grade", "Description"));
					
					try
					{
						CourseList list = new CourseList();		
						ArrayList<Course> records = list.fetchRecords(false);
						for(Course course: records)
						{
							CourseRecords.add(new panelCourse( course.getSemester()==0?"None":Integer.toString(course.getSemester()) , course.getCourseNo(), course.getCourseName(),
									course.getCourseProf(),course.getCourseGrade(),course.getCourseDescription()));
						}
						gui.getDisplayPanel().removeAll();
						
						for(panelCourse course: CourseRecords)
							gui.getDisplayPanel().add(course);
						
//						gui.getScrlDsplayPanel() = new JScrollPane();
//						scrlDsplayPanel.setBounds(10, 387, 813, 242);
//						getContentPane().add(scrlDsplayPanel);
						
						
//						gui.addScrlDisplayPanel();
//						gui.add(gui.getDisplayPanel());
						gui.repaint();
						gui.validate();
						
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
			}
			else
			{
				if(gui.getRdbtnCourse().isSelected())
				{
					ArrayList<panelCourse>CourseRecords = new ArrayList();
					CourseRecords.add(new panelCourse("Semester", "Subject No", "Subject Name","Prof. Name", "Grade", "Description"));
					
					try
					{
						CourseList list = new CourseList();		
						ArrayList<Course> records = list.fetchRecords((gui.getCmbbxSelectSemesterMIDPNL().getSelectedIndex()-1),false);
						for(Course course: records)
						{
							CourseRecords.add(new panelCourse( course.getSemester()==0?"None":Integer.toString(course.getSemester()) , course.getCourseNo(), course.getCourseName(),
									course.getCourseProf(),course.getCourseGrade(),course.getCourseDescription()));
						}
						gui.getDisplayPanel().removeAll();
						
						for(panelCourse course: CourseRecords)
							gui.getDisplayPanel().add(course);
						
//						gui.getScrlDsplayPanel() = new JScrollPane();
//						scrlDsplayPanel.setBounds(10, 387, 813, 242);
//						getContentPane().add(scrlDsplayPanel);
						
						
//						gui.addScrlDisplayPanel();
//						gui.add(gui.getDisplayPanel());
						gui.repaint();
						gui.validate();
						
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
			}
		}
	}
	
	//name gender contact add dob
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == gui.getBtnSubmitBasicInfo())
		{
			
			/*if(gui.getTxtName().getText().equals("") || gui.getTxtConactNo().getText().equals("") || gui.getTxtAddress().getText().equals("") || gui.getCmbbxDate().getSelectedIndex() == 0 ||
					gui.getCmbbxMonth().getSelectedIndex() == 0 ||
					gui.getCmbbxYear().getSelectedIndex() == 0)
			{
				gui.getLblException().setText("Fill Required Fields! (Name, DOB, Address, Contact Number)");
			}
			else
			{*/
				if(gui.getBtnSubmitBasicInfo().getText().equalsIgnoreCase("Submit Basic Info"))
				{
					if(gui.getTxtName().getText().equals("") || gui.getTxtConactNo().getText().equals("") || gui.getTxtAddress().getText().equals("") || gui.getCmbbxDate().getSelectedIndex() == 0 ||
							gui.getCmbbxMonth().getSelectedIndex() == 0 ||
							gui.getCmbbxYear().getSelectedIndex() == 0)
					{
						gui.getLblException().setText("Fill Required Fields! (Name, DOB, Address, Contact Number)");
					}
					else
					{
						student = new Student();
						student.setStudentName(gui.getTxtName().getText());
						if(gui.getRdbtnMale().isSelected())
						{
							student.setGender(gui.getRdbtnMale().getText());
						}
						else
						{
							student.setGender(gui.getRdbtnFemale().getText());
						}
						student.setStudentDateOfBirth(gui.getCmbbxDate().getSelectedItem() +"-" + gui.getCmbbxMonth().getSelectedItem() +"-"+
						gui.getCmbbxYear().getSelectedItem());
						student.setStudentHobbies(gui.getTxtHobbies().getText());
						student.setFatherName(gui.getTxtFathersName().getText());
						student.setMotherName(gui.getTxtMothersName().getText());
						student.setStudentContactNo(gui.getTxtConactNo().getText());
						student.setStudentEmailId(gui.getTxtEmail().getText());
						student.setStudentAddress(gui.getTxtAddress().getText());
						try 
						{
							student.save();
							gui.getBtnSubmitBasicInfo().setText("Edit Basic Info");
							gui.getTxtName().setEditable(false);
							if(gui.getRdbtnMale().isSelected())
							{
								gui.getRdbtnFemale().setEnabled(false);
							}
							else
							{
								gui.getRdbtnMale().setEnabled(false);
							}
							gui.getCmbbxAchievementDate().setEnabled(false);
							gui.getCmbbxAchievementMonth().setEnabled(false);
							gui.getCmbbxAchievementYear().setEnabled(false);
							gui.getTxtHobbies().setEditable(false);
							gui.getTxtFathersName().setEditable(false);
							gui.getTxtMothersName().setEditable(false);
							gui.getTxtConactNo().setEditable(false);
							gui.getTxtEmail().setEditable(false);
							gui.getTxtAddress().setEditable(false);
							gui.addEducationTab();
							gui.getLblException().setText("Basic Info Saved Successfully!");
						} 
						catch (SQLException err)
						{
						
							err.printStackTrace();
						}
						catch (Exception err)
						{
						
							err.printStackTrace();
						}
					}	
				}
				else if(gui.getBtnSubmitBasicInfo().getText().equalsIgnoreCase("Edit Basic Info"))
				{
					gui.getLblException().setText("");
					gui.getTxtName().setEditable(true);
					if(gui.getRdbtnMale().isSelected())
					{
						gui.getRdbtnFemale().setEnabled(true);
					}
					else
					{
						gui.getRdbtnMale().setEnabled(true);
					}
					gui.getCmbbxAchievementDate().setEnabled(true);
					gui.getCmbbxAchievementMonth().setEnabled(true);
					gui.getCmbbxAchievementYear().setEnabled(true);
					gui.getTxtHobbies().setEditable(true);
					gui.getTxtFathersName().setEditable(true);
					gui.getTxtMothersName().setEditable(true);
					gui.getTxtConactNo().setEditable(true);
					gui.getTxtEmail().setEditable(true);
					gui.getTxtAddress().setEditable(true);
					gui.getBtnSubmitBasicInfo().setText("Apply");
					string = gui.getTxtConactNo().getText();
				}
				else if(gui.getBtnSubmitBasicInfo().getText().equalsIgnoreCase("Apply"))
				{
					if(gui.getTxtName().getText().equals("") || gui.getTxtConactNo().getText().equals("") || gui.getTxtAddress().getText().equals("") || gui.getCmbbxDate().getSelectedIndex() == 0 ||
							gui.getCmbbxMonth().getSelectedIndex() == 0 ||
							gui.getCmbbxYear().getSelectedIndex() == 0)
					{
						gui.getLblException().setText("Fill Required Fields! (Name, DOB, Address, Contact Number)");
					}
					else
					{
						student.setStudentName(gui.getTxtName().getText());
						if(gui.getRdbtnMale().isSelected())
						{
							student.setGender(gui.getRdbtnMale().getText());
						}
						else
						{
							student.setGender(gui.getRdbtnFemale().getText());
						}
						student.setStudentDateOfBirth(gui.getCmbbxDate().getSelectedItem() +"-" + gui.getCmbbxMonth().getSelectedItem() +"-"+
						gui.getCmbbxYear().getSelectedItem());
						student.setStudentHobbies(gui.getTxtHobbies().getText());
						student.setFatherName(gui.getTxtFathersName().getText());
						student.setMotherName(gui.getTxtMothersName().getText());
						student.setStudentContactNo(gui.getTxtConactNo().getText());
						student.setStudentEmailId(gui.getTxtEmail().getText());
						student.setStudentAddress(gui.getTxtAddress().getText());
						
						try 
						{
							student.update(string);
							gui.getBtnSubmitBasicInfo().setText("Edit Basic Info");
							gui.getLblException().setText("Edited Successfully!!");
							string = null;
						} 
						catch (SQLException  err)
						{
							
							err.printStackTrace();
						}
						catch ( Exception err)
						{
							
							err.printStackTrace();
						}
					}
					
				}
				
				gui.repaint();
				gui.validate();
			}
		
		
		else if(e.getSource() == gui.getBtnSubmitEducationDetails())
		{
			if(gui.getBtnSubmitEducationDetails().getText().equalsIgnoreCase("Submit Education Details"))
			{
				if(gui.getTxtsscPercentage().getText().equalsIgnoreCase("") || 
						gui.getTxthscPercentage().getText().equalsIgnoreCase("") ||
						gui.getTxtsscBoard().getText().equalsIgnoreCase("") ||
						gui.getTxthscBoard().getText().equalsIgnoreCase("") ||
						gui.getCmbbxhscPassingYear().getSelectedIndex() == 0 ||
						gui.getCmbbxsscPassingYear().getSelectedIndex() == 0 ||
						gui.getTxtDegree().getText().equalsIgnoreCase("") ||
//						gui.getTxtcgpaObtained().getText().equalsIgnoreCase("") ||
						gui.getTxtcgpaTotal().getText().equalsIgnoreCase("") ||
						gui.getTxtCollegeName().getText().equalsIgnoreCase("") 
//						gui.getTxtGrade().getText().equalsIgnoreCase("") 
						)
				{
					gui.getLblException().setText("Fill cumpolsory Fields!");
				}
				else
				{
					Education edu = new Education();
					student.setOverallEducation(edu);
					student.setStudentName(gui.getTxtName().getText());
					edu.setSscBoard(gui.getTxtsscBoard().getText());
					edu.setSscPassingYear(Integer.parseInt((String) gui.getCmbbxsscPassingYear().getSelectedItem()));
					edu.setSscPercentage(Float.parseFloat(gui.getTxtsscPercentage().getText()));
					edu.setHscBoard(gui.getTxthscBoard().getText());
					edu.setHscPassingYear(Integer.parseInt((String) gui.getCmbbxhscPassingYear().getSelectedItem()));
					edu.setHscPercentage(Float.parseFloat(gui.getTxthscPercentage().getText()));
					edu.setCollegeName(gui.getTxtCollegeName().getText());
					edu.setDegree(gui.getTxtDegree().getText());
					edu.setCgpaObtained(Float.parseFloat(gui.getTxtcgpaObtained().getText()));
					edu.setCgpaTot(Float.parseFloat(gui.getTxtcgpaTotal().getText()));
					edu.setGrade(gui.getTxtGrade().getText());
					try 
					{
						edu.save();
						gui.getBtnSubmitEducationDetails().setText("Edit Education Details");
						gui.getTxtsscBoard().setEditable(false);
						gui.getTxtsscPercentage().setEditable(false);
						gui.getCmbbxsscPassingYear().setEditable(false);
						gui.getTxthscBoard().setEditable(false);
						gui.getTxthscPercentage().setEditable(false);
						gui.getCmbbxhscPassingYear().setEditable(false);
						gui.getTxtGrade().setEditable(false);
						gui.getTxtcgpaObtained().setEditable(false);
						gui.getTxtcgpaTotal().setEditable(false);
						gui.getTxtCollegeName().setEditable(false);
						gui.getTxtDegree().setEditable(false);
						gui.addCVDataTabs();
						gui.getLblException().setText("Education Details Saved Successfully!");
					} 
					catch (SQLException err)
					{
					
						err.printStackTrace();
					}
					catch (Exception err)
					{
					
						err.printStackTrace();
					}
				}	
			}
			else if(gui.getBtnSubmitEducationDetails().getText().equalsIgnoreCase("Edit Education Details"))
			{
				gui.getLblException().setText("");
				
				gui.getTxtsscBoard().setEditable(true);
				gui.getTxtsscPercentage().setEditable(true);
				gui.getCmbbxsscPassingYear().setEditable(true);
				gui.getTxthscBoard().setEditable(true);
				gui.getTxthscPercentage().setEditable(true);
				gui.getCmbbxhscPassingYear().setEditable(true);
				gui.getTxtGrade().setEditable(true);
				gui.getTxtcgpaObtained().setEditable(true);
				gui.getTxtcgpaTotal().setEditable(true);
				gui.getTxtCollegeName().setEditable(true);
				gui.getTxtDegree().setEditable(true);
				gui.getBtnSubmitEducationDetails().setText("Apply");
				string = gui.getTxtCollegeName().getText();
			}
			else if(gui.getBtnSubmitEducationDetails().getText().equalsIgnoreCase("Apply"))
			{
				if(gui.getTxtsscPercentage().getText().equalsIgnoreCase("") || 
						gui.getTxthscPercentage().getText().equalsIgnoreCase("") ||
						gui.getTxtsscBoard().getText().equalsIgnoreCase("") ||
						gui.getTxthscBoard().getText().equalsIgnoreCase("") ||
						gui.getCmbbxhscPassingYear().getSelectedIndex() == 0 ||
						gui.getCmbbxsscPassingYear().getSelectedIndex() == 0 ||
						gui.getTxtDegree().getText().equalsIgnoreCase("") ||
//						gui.getTxtcgpaObtained().getText().equalsIgnoreCase("") ||
						gui.getTxtcgpaTotal().getText().equalsIgnoreCase("") ||
						gui.getTxtCollegeName().getText().equalsIgnoreCase("") 
//						gui.getTxtGrade().getText().equalsIgnoreCase("") 
						)
				{
					gui.getLblException().setText("Fill cumpolsory Fields!");
				}
				else
				{
					student.getOverallEducation().setSscBoard(gui.getTxtsscBoard().getText());
					student.getOverallEducation().setSscPassingYear(Integer.parseInt((String) gui.getCmbbxsscPassingYear().getSelectedItem()));
					student.getOverallEducation().setSscPercentage(Float.parseFloat(gui.getTxtsscPercentage().getText()));
					student.getOverallEducation().setHscBoard(gui.getTxthscBoard().getText());
					student.getOverallEducation().setHscPassingYear(Integer.parseInt((String) gui.getCmbbxhscPassingYear().getSelectedItem()));
					student.getOverallEducation().setHscPercentage(Float.parseFloat(gui.getTxthscPercentage().getText()));
					student.getOverallEducation().setCollegeName(gui.getTxtCollegeName().getText());
					student.getOverallEducation().setDegree(gui.getTxtDegree().getText());
					student.getOverallEducation().setCgpaObtained(Float.parseFloat(gui.getTxtcgpaObtained().getText()));
					student.getOverallEducation().setCgpaTot(Float.parseFloat(gui.getTxtcgpaTotal().getText()));
					student.getOverallEducation().setGrade(gui.getTxtGrade().getText());
					
					try 
					{
						student.getOverallEducation().update(string);
						gui.getBtnSubmitEducationDetails().setText("Edit Education Details");
						gui.getLblException().setText("Edited Successfully!!");
						string = null;
					} 
					catch (SQLException  err)
					{
						
						err.printStackTrace();
					}
					catch ( Exception err)
					{
						
						err.printStackTrace();
					}
				}
				
			}
		
			gui.addCVDataTabs();
			gui.repaint();
			gui.validate();
		}
		
		else if(e.getSource() == gui.getBtnSubmitCourseDetails())//to store data when submit button is clicked for courses
		{
			/*if(gui.getTxtCourseName().getText().equals("") || gui.getTxtCourseNo().getText().equals("") || gui.getTxtProfessorName().getText().equals("") )
			{
				gui.getLblException().setText("Fill Required Fields! (Course Number,Name, Prof. Name)");
			}
			else
			{*/
				if(gui.getBtnSubmitCourseDetails().getText().equalsIgnoreCase("Submit Course Details"))
				{
					if(gui.getTxtCourseName().getText().equals("") || gui.getTxtCourseNo().getText().equals("") || gui.getTxtProfessorName().getText().equals("") )
					{
						gui.getLblException().setText("Fill Required Fields! (Course Number,Name, Prof. Name)");
					}
					else
					{
						CVData newCourse ;
						newCourse = student.getDataCourse();
						newCourse.setSemester(gui.getCmbbxCourseSemester().getSelectedIndex());
						((Course) newCourse).setCourseNo(gui.getTxtCourseNo().getText());
						((Course) newCourse).setCourseName(gui.getTxtCourseName().getText());
						((Course) newCourse).setCourseProf(gui.getTxtProfessorName().getText());
						((Course) newCourse).setCourseGrade(gui.getTxtCourseGrade().getText());
						((Course) newCourse).setCourseDescription(gui.getTxtCourseDescription().getText());
						if(gui.getChckbxCourseStar().isSelected())
							newCourse.markStar();
						try
						{
							CourseList list = new CourseList();
							list.addRecord(newCourse);
							
							gui.clearCourse();
							gui.getLblException().setText("Course Added Successfully!");
						}
						catch(SQLException err)
						{
							err.printStackTrace();
						}
						catch(Exception err)
						{
							err.printStackTrace();
						}
					}
				}
				else if(gui.getBtnSubmitCourseDetails().getText().equalsIgnoreCase("Edit Course Details"))
				{
					
					gui.getLblException().setText("");
					 
					    gui.getCmbbxCourseSemester().setEditable(true);
					    gui.getTxtCourseNo().setEditable(true);
					    gui.getTxtCourseName().setEditable(true);
					    gui.getTxtCourseDescription().setEditable(true);
					    gui.getTxtCourseGrade().setEditable(true);
					    string = gui.getTxtCourseNo().getText();
					    gui.getBtnSubmitCourseDetails().setText("Apply");
					    
				}
				else if(gui.getBtnSubmitCourseDetails().getText().equalsIgnoreCase("Edit Course Details"))
				{
					CVData newCourse ;
					newCourse = student.getDataCourse();
					newCourse.setSemester(gui.getCmbbxCourseSemester().getSelectedIndex());
					((Course) newCourse).setCourseNo(gui.getTxtCourseNo().getText());
					((Course) newCourse).setCourseName(gui.getTxtCourseName().getText());
					((Course) newCourse).setCourseProf(gui.getTxtProfessorName().getText());
					((Course) newCourse).setCourseGrade(gui.getTxtCourseGrade().getText());
					((Course) newCourse).setCourseDescription(gui.getTxtCourseDescription().getText());
					if(gui.getChckbxCourseStar().isSelected())
						newCourse.markStar();
					try
					{
						CourseList list = new CourseList();
						list.updateRecord(newCourse,string);
						
						gui.clearCourse();
						gui.getLblException().setText("Course Updated Successfully!");
						gui.getBtnSubmitCourseDetails().setText("Submit Course Details");
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
				else if(gui.getBtnSubmitCourseDetails().getText().equalsIgnoreCase("Apply"))
				{
					if(gui.getTxtCourseName().getText().equals("") || gui.getTxtCourseNo().getText().equals("") || gui.getTxtProfessorName().getText().equals("") )
					{
						gui.getLblException().setText("Fill Required Fields! (Course Number,Name, Prof. Name)!");
					}
					else
					{
						CVData newCourse ;
						newCourse = student.getDataCourse();
						newCourse.setSemester(gui.getCmbbxCourseSemester().getSelectedIndex());
						((Course) newCourse).setCourseNo(gui.getTxtCourseNo().getText());
						((Course) newCourse).setCourseName(gui.getTxtCourseName().getText());
						((Course) newCourse).setCourseProf(gui.getTxtProfessorName().getText());
						((Course) newCourse).setCourseGrade(gui.getTxtCourseGrade().getText());
						((Course) newCourse).setCourseDescription(gui.getTxtCourseDescription().getText());
						if(gui.getChckbxCourseStar().isSelected())
							newCourse.markStar();
						try
						{
							CourseList list = new CourseList();
							list.updateRecord(newCourse,string);
							
							gui.clearCourse();
							gui.getLblException().setText("Course Updated Successfully!");
						}
						catch(SQLException err)
						{
							err.printStackTrace();
						}
						catch(Exception err)
						{
							err.printStackTrace();
						}
					}
				}
			
		}
		else if(e.getSource() == gui.getBtnDeleteCourseDetails())
		{
			CourseList  crsList = new CourseList();
			int del =JOptionPane.showConfirmDialog(null,"Confirm Delete?", "",JOptionPane.YES_NO_OPTION);
			//0means yes
			if(del==0)
			{
				try 
				{
					crsList.deleteRecord(gui.getTxtMiscDescription().getText());
					gui.getLblException().setText("Record Deleted Successfuly");
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
			}
		}
		else if(e.getSource() == gui.getBtnSubmitProjectDetails())
		{
			if(gui.getTxtProjectName().getText().equals("") || gui.getTxtProjectDuration().getText().equals("") || gui.getTxtNoOfTeamMembers().getText().equals("") )
			{
				gui.getLblException().setText("Fill Required Fields! (Project Name,Duration,No. of team members)");
			}
			else
			{
				if(gui.getBtnSubmitProjectDetails().getText().equalsIgnoreCase("Submit Project Details"));
				{
					CVData newProject ;
					newProject = student.getDataProject();
					newProject.setSemester(gui.getCmbbxProjectSemester().getSelectedIndex());
					((Project) newProject).setProjectTitle(gui.getTxtProjectName().getText());
					((Project) newProject).setProjectMentor(gui.getTxtProjectMentorName().getText());
					((Project) newProject).setProjectDuration(gui.getTxtProjectDuration().getText());
					((Project) newProject).setNoOfTeamMembers(Integer.parseInt(gui.getTxtNoOfTeamMembers().getText()));
					((Project) newProject).setProjectDescription(gui.getTxtProjectDescription().getText());
					if(gui.getChckbxProjectStar().isSelected())
						newProject.markStar();
					try
					{
						ProjectList list = new ProjectList();
						list.addRecord(newProject);
						gui.clearProject();
						gui.getLblException().setText("Project Data Added Successfully!");
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
			}
		}
		else if(e.getSource() == gui.getBtnDeleteProjectDetails())
		{
			ProjectList  prjList = new ProjectList();
			int del =JOptionPane.showConfirmDialog(null,"Confirm Delete?", "",JOptionPane.YES_NO_OPTION);
			//0means yes
			if(del==0)
			{
				try 
				{
					prjList.deleteRecord(gui.getTxtMiscDescription().getText());
					gui.getLblException().setText("Record Deleted Successfuly");
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
			}
		}
		else if(e.getSource() == gui.getBtnSubmitInternshipDetails())
		{
			if(gui.getTxtInternshipOrganisationName().getText().equals("") || gui.getTxtInternshipPeriod().getText().equals("") || gui.getTxtInternshipDescription().getText().equals("") )
			{
				gui.getLblException().setText("Fill Required Fields! (Organization Name,Internship Period, Description)");
			}
			else
			{
				if(gui.getBtnSubmitInternshipDetails().getText().equalsIgnoreCase("Submit Internship Details"));
				{
					CVData newInternship ;
					newInternship = student.getDataInternship();
					newInternship.setSemester(gui.getCmbbxInternshipSemester().getSelectedIndex());
					((Internship) newInternship).setOrganizationName(gui.getTxtInternshipOrganisationName().getText());
					((Internship) newInternship).setInternshipPeriod(gui.getTxtInternshipPeriod().getText());
					((Internship) newInternship).setInternshipDescription(gui.getTxtInternshipDescription().getText());
					if(gui.getChckbxInternshipStar().isSelected())
						newInternship.markStar();
					try
					{
						InternshipList list = new InternshipList();
						list.addRecord(newInternship);
						gui.clearInternship();
						gui.getLblException().setText("Internship Data Added Successfully!");
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
			}
		}
		else if(e.getSource() == gui.getBtnDeleteInternshipDetails())
		{
			InternshipList  intshpList = new InternshipList();
			int del =JOptionPane.showConfirmDialog(null,"Confirm Delete?", "",JOptionPane.YES_NO_OPTION);
			//0means yes
			if(del==0)
			{
				try 
				{
					intshpList.deleteRecord(gui.getTxtMiscDescription().getText());
					gui.getLblException().setText("Record Deleted Successfuly");
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
			}
		}
		else if(e.getSource() == gui.getBtnSubmitWorkshopDetails())
		{
			if(gui.getTxtWorkshopOrganizer().getText().equals("") || gui.getTxtWorkshopTitle().getText().equals("") || gui.getTxtWorkshopTeacher().getText().equals("") )
			{
				gui.getLblException().setText("Fill Required Fields! (Workshop Title,Teacher,Organization)");
			}
			else
			{
				if(gui.getBtnSubmitWorkshopDetails().getText().equalsIgnoreCase("Submit Workshop Details"));
				{
					CVData newWorkshop ;
					newWorkshop = student.getDataWorkshop();
					newWorkshop.setSemester(gui.getCmbbxWorkshopSemester().getSelectedIndex());
					((Workshop) newWorkshop).setWorkshopTitle(gui.getTxtWorkshopTitle().getText());
					((Workshop) newWorkshop).setWorkshopTeacher(gui.getTxtWorkshopTeacher().getText());
					((Workshop) newWorkshop).setWorkshopOrganizer(gui.getTxtWorkshopOrganizer().getText());
					((Workshop) newWorkshop).setWorkshopDate(gui.getCmbbxWorkshopDate().getSelectedItem() +"-" + gui.getCmbbxWorkshopMonth().getSelectedItem() +"-"+
							gui.getCmbbxWorkshopYear().getSelectedItem());
					((Workshop) newWorkshop).setWorkshopDescription(gui.getTxtWorkshopDescription().getText());
					((Workshop) newWorkshop).setCertified(gui.getChckbxCertified().isSelected()?true:false);
					if(gui.getChckbxWorkshopStar().isSelected())
						newWorkshop.markStar();
					try
					{
						WorkshopList list = new WorkshopList();
						list.addRecord(newWorkshop);
						gui.clearWorkshops();
						gui.getLblException().setText("Workshop Data Added Successfully!");
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
			}
		}
		else if(e.getSource() == gui.getBtnDeleteWorkshopDetails())
		{
			WorkshopList  wshpList = new WorkshopList();
			int del =JOptionPane.showConfirmDialog(null,"Confirm Delete?", "",JOptionPane.YES_NO_OPTION);
			//0means yes
			if(del==0)
			{
				try 
				{
					wshpList.deleteRecord(gui.getTxtWorkshopTitle().getText());
					gui.getLblException().setText("Record Deleted Successfuly");
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
			}
		}
		else if(e.getSource() == gui.getBtnSubmitAchievementDetails())
		{
			if(gui.getTxtAchievementDescription().getText().equals("") )
			{
				gui.getLblException().setText("Fill Required Fields! (Achievement Description)");
			}
			else
			{
				if(gui.getBtnSubmitAchievementDetails().getText().equalsIgnoreCase("Submit Achievement Details"));
				{
					CVData newAchievement ;
					newAchievement = student.getDataAchievement();
					newAchievement.setSemester(gui.getCmbbxAchievementSemester().getSelectedIndex());
					((Achievement) newAchievement).setAchievementDate(gui.getTxtAchievementDescription().getText());
					((Achievement) newAchievement).setAchievementDescription(gui.getTxtAchievementDescription().getText());
					((Achievement) newAchievement).setCertifiedORAwarded(gui.getChckbxAwardedCertified().isSelected()?true:false);
					if(gui.getChckbxAchievementStar().isSelected())
						newAchievement.markStar();
					try
					{
						AchievementList list = new AchievementList();
						list.addRecord(newAchievement);
						gui.clearAchievement();
						gui.getLblException().setText("Achievement Data Added Successfully!");
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
			}
		}
		else if(e.getSource() == gui.getBtnDeleteAchievementDetails())
		{
			AchievementList  achList = new AchievementList();
			int del =JOptionPane.showConfirmDialog(null,"Confirm Delete?", "",JOptionPane.YES_NO_OPTION);
			//0means yes
			if(del==0)
			{
				try 
				{
					achList.deleteRecord(gui.getTxtAchievementDescription().getText());
					gui.getLblException().setText("Record Deleted Successfuly");
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
			}
		}
		else if(e.getSource() == gui.getBtnSubmitMiscDetails())
		{
			if(gui.getTxtMiscDescription().getText().equals("") || gui.getCmbbxMiscDate().getSelectedIndex() == 0 || gui.getCmbbxMiscMonth().getSelectedIndex() == 0 || gui.getCmbbxMiscYear().getSelectedIndex() == 0 )
			{
				gui.getLblException().setText("Fill Required Fields! (Description,Date)");
			}
			else
			{
				if(gui.getBtnSubmitMiscDetails().getText().equalsIgnoreCase("Submit Details"));
				{
					CVData newMisc ;
					newMisc = student.getDataMiscellaneous();
					newMisc.setSemester(gui.getCmbbxMiscSemester().getSelectedIndex());
					((Miscellaneous) newMisc).setDate(gui.getCmbbxWorkshopDate().getSelectedItem() +"-" + gui.getCmbbxWorkshopMonth().getSelectedItem() +"-"+
							gui.getCmbbxWorkshopYear().getSelectedItem());
					((Miscellaneous) newMisc).setDescription(gui.getTxtMiscDescription().getText());
				
					if(gui.getChckbxMiscellaneousStar().isSelected())
						newMisc.markStar();
					try
					{
						MiscellaneousList list = new MiscellaneousList();
						list.addRecord(newMisc);
						gui.clearMiscellaneous();
						gui.getLblException().setText("Miscellaneous Data Added Successfully!");
					}
					catch(SQLException err)
					{
						err.printStackTrace();
					}
					catch(Exception err)
					{
						err.printStackTrace();
					}
				}
			}
		}
		else if(e.getSource() == gui.getBtnDeleteMiscDetails())
		{
			MiscellaneousList  miscList = new MiscellaneousList();
			int del =JOptionPane.showConfirmDialog(null,"Confirm Delete?", "",JOptionPane.YES_NO_OPTION);
			//0means yes
			if(del==0)
			{
				try 
				{
					miscList.deleteRecord(gui.getTxtMiscDescription().getText());
					gui.getLblException().setText("Record Deleted Successfuly");
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
			}
		}
		
		else if(e.getSource() == gui.getBtnView())
		{
			this.displayRecords();
			gui.repaint();
			gui.validate();
		}
		
		else if(e.getSource() == gui.getRdbtnCourse() || e.getSource() == gui.getRdbtnProject() || e.getSource() == gui.getRdbtnInternships()
				 || e.getSource() == gui.getRdbtnWorkshops() || e.getSource() == gui.getRdbtnAchievements() || e.getSource() == gui.getRdbtnMisc())
		{
			gui.getBtnView().setEnabled(true);
		}
	}

	

}
